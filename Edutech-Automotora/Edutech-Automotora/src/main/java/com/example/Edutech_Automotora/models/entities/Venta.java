package com.example.Edutech_Automotora.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
    
    @Column(nullable = false)
    private BigDecimal precioVenta;
    
    @Column(nullable = false)
    private BigDecimal descuento = BigDecimal.ZERO;
    
    @Column(nullable = false)
    private BigDecimal precioFinal;
    
    @Column(nullable = false)
    private String metodoPago; // Efectivo, Tarjeta, Financiamiento
    
    @Column(nullable = false)
    private LocalDateTime fechaVenta = LocalDateTime.now();
    
    @Column(length = 1000)
    private String observaciones;
    
    @Column(nullable = false)
    private String estado = "COMPLETADA"; // COMPLETADA, CANCELADA, PENDIENTE
    
    @Column(name = "vendedor_id")
    private Long vendedorId;
}