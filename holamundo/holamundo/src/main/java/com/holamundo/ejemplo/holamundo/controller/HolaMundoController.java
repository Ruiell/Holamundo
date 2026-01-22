package com.holamundo.ejemplo.holamundo.controller;

import com.holamundo.ejemplo.holamundo.repository.VehiculoRepository;
import com.holamundo.model.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HolaMundoController {
    
    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    @GetMapping("/hola")
    public String holaMundo() {
        return "¡Sistema Automotora funcionando! 🚗";
    }
    
    // CRUD de Vehículos
    
    // 1. Crear vehículo
    @PostMapping("/vehiculos")
    public Vehiculo crearVehiculo(@RequestBody Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
    
    // 2. Obtener todos los vehículos
    @GetMapping("/vehiculos")
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculoRepository.findAll();
    }
    
    // 3. Obtener vehículo por ID
    @GetMapping("/vehiculos/{id}")
    public Vehiculo obtenerVehiculo(@PathVariable Long id) {
        return vehiculoRepository.findById(id).orElse(null);
    }
    
    // 4. Actualizar vehículo
    @PutMapping("/vehiculos/{id}")
    public Vehiculo actualizarVehiculo(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
        vehiculo.setId(id);
        return vehiculoRepository.save(vehiculo);
    }
    
    // 5. Eliminar vehículo
    @DeleteMapping("/vehiculos/{id}")
    public String eliminarVehiculo(@PathVariable Long id) {
        vehiculoRepository.deleteById(id);
        return "Vehículo eliminado: " + id;
    }
    
    // Ruta de prueba BD
    @GetMapping("/testbd")
    public String testBD() {
        long cantidad = vehiculoRepository.count();
        return "Conexión a BD OK. Vehículos en sistema: " + cantidad;
    }
}