package com.example.Edutech_Automotora.models.entities;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class VehiculoResponse {
    private Long id;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private BigDecimal precio;
    private Integer kilometraje;
    private String tipoCombustible;
    private String transmision;
    private Integer puertas;
    private Boolean disponible;
    private String descripcion;
    private String placa;
    private LocalDateTime fechaIngreso;
}