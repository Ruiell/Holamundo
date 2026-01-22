package com.example.Edutech_Automotora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    
    List<Venta> findByClienteId(Long clienteId);
    
    List<Venta> findByFechaVentaBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);
    
    @Query("SELECT v FROM Venta v WHERE v.vehiculo.id = :vehiculoId")
    List<Venta> findByVehiculoId(@Param("vehiculoId") Long vehiculoId);
    
    @Query("SELECT SUM(v.precioFinal) FROM Venta v WHERE v.fechaVenta BETWEEN :fechaInicio AND :fechaFin")
    BigDecimal sumVentasByFecha(@Param("fechaInicio") LocalDateTime fechaInicio, 
                                @Param("fechaFin") LocalDateTime fechaFin);
    
    @Query("SELECT COUNT(v) FROM Venta v WHERE v.fechaVenta BETWEEN :fechaInicio AND :fechaFin")
    long countVentasByFecha(@Param("fechaInicio") LocalDateTime fechaInicio, 
                           @Param("fechaFin") LocalDateTime fechaFin);
}