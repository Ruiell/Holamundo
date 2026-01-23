package com.example.Edutech_Automotora.services;

import java.util.List;

import com.example.Edutech_Automotora.models.entities.VehiculoRequest;
import com.example.Edutech_Automotora.models.entities.VehiculoResponse;

public interface VehiculoService {
    
    VehiculoResponse crearVehiculo(VehiculoRequest request);
    
    VehiculoResponse actualizarVehiculo(Long id, VehiculoRequest request);
    
    void eliminarVehiculo(Long id);
    
    VehiculoResponse obtenerVehiculoPorId(Long id);
    
    List<VehiculoResponse> listarTodosVehiculos();
    
    List<VehiculoResponse> listarVehiculosDisponibles();
    
    List<VehiculoResponse> buscarPorMarca(String marca);
    
    List<VehiculoResponse> buscarPorModelo(String modelo);
    
    List<VehiculoResponse> buscarPorRangoPrecio(Double precioMin, Double precioMax);
    
    List<VehiculoResponse> buscarPorRangoAnio(Integer anioMin, Integer anioMax);
    
    long contarVehiculosDisponibles();
    
    VehiculoResponse marcarComoVendido(Long id);
    
    VehiculoResponse marcarComoDisponible(Long id);
}
