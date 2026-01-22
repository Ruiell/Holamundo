package com.example.Edutech_Automotora.models.entities;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

import com.example.Edutech_Automotora.controller.Vehiculo;
import com.example.Edutech_Automotora.controller.Venta;

public class VehiculoRequest {

    
    @NotBlank(message = "La marca es obligatoria")
    private String marca;
    
    @NotBlank(message = "El modelo es obligatorio")
    private String modelo;
    
    @NotNull(message = "El año es obligatorio")
    @Min(value = 1900, message = "El año debe ser mayor a 1900")
    @Max(value = 2024, message = "El año no puede ser mayor a 2024")
    private Integer anio;
    
    @NotBlank(message = "El color es obligatorio")
    private String color;
    
    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    private BigDecimal precio;
    
    @NotNull(message = "El kilometraje es obligatorio")
    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Integer kilometraje;
    
    @NotBlank(message = "El tipo de combustible es obligatorio")
    private String tipoCombustible;
    
    @NotBlank(message = "El tipo de transmisión es obligatorio")
    private String transmision;
    
    @NotNull(message = "El número de puertas es obligatorio")
    @Min(value = 2, message = "Debe tener al menos 2 puertas")
    private Integer puertas;
    
    @NotBlank(message = "La placa es obligatoria")
    private String placa;

    public String getModelo() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getModelo'");
    }

    public String getPlaca() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getPlaca'");
    }

    public String getColor() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getColor'");
    }

    public Integer getAnio() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getAnio'");
    }

    public Integer getKilometraje() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getKilometraje'");
    }

    public String getTipoCombustible() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getTipoCombustible'");
    }

    public String getTransmision() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getTransmision'");
    }

    public Integer getPuertas() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getPuertas'");
    }

    public String getDescripcion() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getDescripcion'");
    }

    public Object getClienteId() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getClienteId'");
    }

    public Object getVehiculoId() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getVehiculoId'");
    }

    public Object findById(Object vehiculoId) {
        
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public boolean getDisponible() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getDisponible'");
    }

    public void save(Venta vehiculo) {
     
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public Object getPrecioVenta() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getPrecioVenta'");
    }

    public Object getDescuento() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getDescuento'");
    }

    public Object getMetodoPago() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getMetodoPago'");
    }

    public Object getObservaciones() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getObservaciones'");
    }

    public Object getVendedorId() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getVendedorId'");
    }

    public void save(Vehiculo vehiculo) {
        
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
