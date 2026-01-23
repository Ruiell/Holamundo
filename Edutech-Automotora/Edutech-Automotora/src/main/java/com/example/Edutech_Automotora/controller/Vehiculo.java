package com.example.Edutech_Automotora.controller;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehiculos")
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String marca;
    
    @Column(nullable = false)
    private String modelo;
    
    @Column(nullable = false)
    private Integer anio;
    
    @Column(nullable = false)
    private String color;
    
    @Column(nullable = false)
    private BigDecimal precio;
    
    @Column(nullable = false)
    private Integer kilometraje;
    
    @Column(nullable = false)
    private String tipoCombustible;
    
    @Column(nullable = false)
    private String transmision;
    
    @Column(nullable = false)
    private Integer puertas;
    
    @Column(nullable = false)
    private Boolean disponible = true;
    
    @Column(length = 1000)
    private String descripcion;
    
    @Column(nullable = false, unique = true)
    private String placa;
    
    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso = LocalDateTime.now();
}