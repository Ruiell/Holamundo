package com.example.Edutech_Automotora.models.entities;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

@Data
public class VentaRequest {
    
    @NotNull(message = "El ID del vehículo es obligatorio")
    private Long vehiculoId;
    
    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;
    
    @NotNull(message = "El precio de venta es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor a 0")
    private BigDecimal precioVenta;
    
    @DecimalMin(value = "0.0", message = "El descuento no puede ser negativo")
    private BigDecimal descuento = BigDecimal.ZERO;
    
    @NotBlank(message = "El método de pago es obligatorio")
    private String metodoPago;
    
    private String observaciones;
    
    private Long vendedorId;
}
