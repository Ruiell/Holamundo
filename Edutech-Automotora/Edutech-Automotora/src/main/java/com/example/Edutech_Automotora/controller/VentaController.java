package com.example.Edutech_Automotora.controller;

import com.example.Edutech_Automotora.models.entities.VehiculoRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.management.loading.ClassLoaderRepository;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
@Tag(name = "Ventas", description = "API para gestión de ventas")
public class VentaController {
    
    private final VentaRepository ventaRepository;
    private final VehiculoRequest vehiculoRepository;
    private final ClassLoaderRepository clienteRepository;
    
    @PostMapping
    @Operation(summary = "Registrar una nueva venta")
    public ResponseEntity<Venta> registrarVenta(@RequestBody VehiculoRequest request) {
        // Verificar que el vehículo existe y está disponible
        Venta vehiculo = ((Optional<Venta>) vehiculoRepository.findById(request.getVehiculoId()))
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado"));
        
        if (!vehiculo.getDisponible()) {
            throw new RuntimeException("El vehículo no está disponible para la venta");
        }
        
        // Verificar que el cliente existe
        Venta cliente = ((Optional<Venta>) ((VehiculoRequest) clienteRepository).findById(request.getClienteId()))
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        
        // Calcular precio final
        BigDecimal precioFinal = ((BigDecimal) request.getPrecioVenta())
                .subtract(request.getDescuento() != null ? (BigDecimal) request.getDescuento() : BigDecimal.ZERO);
        
        // Crear la venta
        Venta venta = new Venta();
        venta.setVehiculo(vehiculo);
        venta.setCliente(cliente);
        venta.setPrecioVenta(request.getPrecioVenta());
        venta.setDescuento(request.getDescuento());
        venta.setPrecioFinal(precioFinal);
        venta.setMetodoPago(request.getMetodoPago());
        venta.setObservaciones(request.getObservaciones());
        venta.setVendedorId(request.getVendedorId());
        venta.setEstado("COMPLETADA");
        
        // Marcar vehículo como no disponible
        vehiculo.setDisponible(false);
        vehiculoRepository.save(vehiculo);
        
        Venta saved = ventaRepository.save(venta);
        return ResponseEntity.ok(saved);
    }
    
    @GetMapping
    @Operation(summary = "Listar todas las ventas")
    public ResponseEntity<List<Venta>> listarVentas() {
        List<Venta> ventas = ventaRepository.findAll();
        return ResponseEntity.ok(ventas);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener venta por ID")
    public ResponseEntity<Venta> obtenerVenta(@PathVariable Long id) {
        return ((Optional<Venta>) ventaRepository.findById(id))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/cliente/{clienteId}")
    @Operation(summary = "Buscar ventas por cliente")
    public ResponseEntity<List<Venta>> buscarPorCliente(@PathVariable Long clienteId) {
        List<Venta> ventas = (List<Venta>) ventaRepository.findById(clienteId);
        return ResponseEntity.ok(ventas);
    }
    
    @GetMapping("/estadisticas")
    @Operation(summary = "Obtener estadísticas de ventas")
    public ResponseEntity<String> obtenerEstadisticas() {
        long totalVentas = ventaRepository.count();
        return ResponseEntity.ok("Total de ventas registradas: " + totalVentas);
    }
    
    @PutMapping("/{id}/cancelar")
    @Operation(summary = "Cancelar una venta")
    public ResponseEntity<Venta> cancelarVenta(@PathVariable Long id) {
        Optional<Venta> venta = Optional.empty();
        Venta ventaEntity = venta.orElseThrow(() -> new RuntimeException("Venta no encontrada"));
        
        // Marcar venta como cancelada
        ventaEntity.setEstado("CANCELADA");
        
        // Marcar vehículo como disponible nuevamente
        Vehiculo vehiculo = ventaEntity.getVehiculo();
        vehiculo.setDisponible(true);
        vehiculoRepository.save(vehiculo);
        
        Venta updated = ventaRepository.save(ventaEntity);
        return ResponseEntity.ok(updated);
    }
}