package com.example.Edutech_Automotora.services;

import java.util.List;

public interface VentaService {
    
    VentaResponse registrarVenta(VentaRequest request);
    
    void cancelarVenta(Long id);
    
    VentaResponse obtenerVentaPorId(Long id);
    
    List<VentaResponse> listarTodasVentas();
    
    List<VentaResponse> buscarVentasPorCliente(Long clienteId);
    
    List<VentaResponse> buscarVentasPorRangoFechas(String fechaInicio, String fechaFin);
    
    double obtenerTotalVentasPorPeriodo(String fechaInicio, String fechaFin);
    
    long contarVentasPorPeriodo(String fechaInicio, String fechaFin);
}