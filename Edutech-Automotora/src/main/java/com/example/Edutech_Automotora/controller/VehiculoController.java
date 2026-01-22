package com.example.Edutech_Automotora.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Edutech_Automotora.models.entities.VehiculoRequest;
import com.example.Edutech_Automotora.models.entities.VehiculoResponse;
import com.example.Edutech_Automotora.services.VehiculoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
@Tag(name = "Vehículos", description = "API para gestión de vehículos")
public class VehiculoController {
    
    private final VehiculoService vehiculoService;
    
    @PostMapping
    @Operation(summary = "Crear un nuevo vehículo")
    public ResponseEntity<VehiculoResponse> crearVehiculo(@Valid @RequestBody VehiculoRequest request) {
        VehiculoResponse response = vehiculoService.crearVehiculo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un vehículo existente")
    public ResponseEntity<VehiculoResponse> actualizarVehiculo(
            @PathVariable Long id,
            @Valid @RequestBody VehiculoRequest request) {
        VehiculoResponse response = vehiculoService.actualizarVehiculo(id, request);
        return ResponseEntity.ok(response);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un vehículo")
    public ResponseEntity<Void> eliminarVehiculo(@PathVariable Long id) {
        vehiculoService.eliminarVehiculo(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener un vehículo por ID")
    public ResponseEntity<VehiculoResponse> obtenerVehiculo(@PathVariable Long id) {
        VehiculoResponse response = vehiculoService.obtenerVehiculoPorId(id);
        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    @Operation(summary = "Listar todos los vehículos")
    public ResponseEntity<List<VehiculoResponse>> listarVehiculos() {
        List<VehiculoResponse> vehiculos = vehiculoService.listarTodosVehiculos();
        return ResponseEntity.ok(vehiculos);
    }
    
    @GetMapping("/disponibles")
    @Operation(summary = "Listar vehículos disponibles")
    public ResponseEntity<List<VehiculoResponse>> listarDisponibles() {
        List<VehiculoResponse> vehiculos = vehiculoService.listarVehiculosDisponibles();
        return ResponseEntity.ok(vehiculos);
    }
    
    @GetMapping("/marca/{marca}")
    @Operation(summary = "Buscar vehículos por marca")
    public ResponseEntity<List<VehiculoResponse>> buscarPorMarca(@PathVariable String marca) {
        List<VehiculoResponse> vehiculos = vehiculoService.buscarPorMarca(marca);
        return ResponseEntity.ok(vehiculos);
    }
    
    @GetMapping("/modelo/{modelo}")
    @Operation(summary = "Buscar vehículos por modelo")
    public ResponseEntity<List<VehiculoResponse>> buscarPorModelo(@PathVariable String modelo) {
        List<VehiculoResponse> vehiculos = vehiculoService.buscarPorModelo(modelo);
        return ResponseEntity.ok(vehiculos);
    }
    
    @GetMapping("/buscar/precio")
    @Operation(summary = "Buscar vehículos por rango de precio")
    public ResponseEntity<List<VehiculoResponse>> buscarPorPrecio(
            @RequestParam Double precioMin,
            @RequestParam Double precioMax) {
        List<VehiculoResponse> vehiculos = vehiculoService.buscarPorRangoPrecio(precioMin, precioMax);
        return ResponseEntity.ok(vehiculos);
    }
    
    @GetMapping("/buscar/anio")
    @Operation(summary = "Buscar vehículos por rango de año")
    public ResponseEntity<List<VehiculoResponse>> buscarPorAnio(
            @RequestParam Integer anioMin,
            @RequestParam Integer anioMax) {
        List<VehiculoResponse> vehiculos = vehiculoService.buscarPorRangoAnio(anioMin, anioMax);
        return ResponseEntity.ok(vehiculos);
    }
    
    @GetMapping("/contar/disponibles")
    @Operation(summary = "Contar vehículos disponibles")
    public ResponseEntity<Map<String, Long>> contarDisponibles() {
        long count = vehiculoService.contarVehiculosDisponibles();
        return ResponseEntity.ok(Map.of("totalDisponibles", count));
    }
    
    @PutMapping("/{id}/vender")
    @Operation(summary = "Marcar vehículo como vendido")
    public ResponseEntity<VehiculoResponse> marcarComoVendido(@PathVariable Long id) {
        VehiculoResponse response = vehiculoService.marcarComoVendido(id);
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("/{id}/disponible")
    @Operation(summary = "Marcar vehículo como disponible")
    public ResponseEntity<VehiculoResponse> marcarComoDisponible(@PathVariable Long id) {
        VehiculoResponse response = vehiculoService.marcarComoDisponible(id);
        return ResponseEntity.ok(response);
    }
}
