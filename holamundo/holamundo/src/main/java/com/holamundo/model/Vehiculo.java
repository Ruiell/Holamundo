package com.holamundo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String patente;
    private String marca;
    private String modelo;
    private Integer año;
    
    // Constructor vacío
    public Vehiculo() {}
    
    // Constructor con parámetros
    public Vehiculo(String patente, String marca, String modelo, Integer año) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
    }
    
    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getPatente() { return patente; }
    public void setPatente(String patente) { this.patente = patente; }
    
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    
    public Integer getAño() { return año; }
    public void setAño(Integer año) { this.año = año; }
}