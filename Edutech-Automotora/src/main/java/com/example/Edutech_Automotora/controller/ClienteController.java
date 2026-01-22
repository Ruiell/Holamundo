package com.example.Edutech_Automotora.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Edutech_Automotora.models.entities.Cliente;
import com.example.Edutech_Automotora.repositories.ClienteRepository;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
@Tag(name = "Clientes", description = "API para gestión de clientes")
public class ClienteController {
    
    private final ClienteRepository clienteRepository;
    
    @PostMapping
    @Operation(summary = "Crear un nuevo cliente")
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        // Validar DNI único
        if (clienteRepository.existsByDni(cliente.getDni())) {
            return ResponseEntity.badRequest().body(null);
        }
        
        // Validar email único
        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            return ResponseEntity.badRequest().body(null);
        }
        
        Cliente saved = clienteRepository.save(cliente);
        return ResponseEntity.ok(saved);
    }
    
    @GetMapping
    @Operation(summary = "Listar todos los clientes")
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener cliente por ID")
    public ResponseEntity<Cliente> obtenerCliente(@PathVariable Long id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/dni/{dni}")
    @Operation(summary = "Buscar cliente por DNI")
    public ResponseEntity<Cliente> buscarPorDni(@PathVariable String dni) {
        return clienteRepository.findByDni(dni)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/buscar")
    @Operation(summary = "Buscar clientes por nombre o apellido")
    public ResponseEntity<List<Cliente>> buscarPorNombre(@RequestParam String nombre) {
        List<Cliente> clientes = clienteRepository.findByNombreOrApellidoContaining(nombre);
        return ResponseEntity.ok(clientes);
    }
    
    @GetMapping("/vip")
    @Operation(summary = "Listar clientes VIP")
    public ResponseEntity<List<Cliente>> listarVip() {
        List<Cliente> clientes = clienteRepository.findByEsVipTrue();
        return ResponseEntity.ok(clientes);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar cliente")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        cliente.setId(id);
        Cliente updated = clienteRepository.save(cliente);
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cliente")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        if (!clienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        
        clienteRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}