package com.example.Edutech_Automotora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Edutech_Automotora.models.entities.Vehiculo;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    
    List<Vehiculo> findByDisponibleTrue();
    
    List<Vehiculo> findByMarca(String marca);
    
    List<Vehiculo> findByModeloContainingIgnoreCase(String modelo);
    
    List<Vehiculo> findByPrecioBetween(Double precioMin, Double precioMax);
    
    List<Vehiculo> findByTipoCombustible(String tipoCombustible);
    
    Optional<Vehiculo> findByPlaca(String placa);
    
    @Query("SELECT v FROM Vehiculo v WHERE v.anio >= :anioMin AND v.anio <= :anioMax")
    List<Vehiculo> findByAnioRange(@Param("anioMin") Integer anioMin, @Param("anioMax") Integer anioMax);
    
    @Query("SELECT v FROM Vehiculo v WHERE v.precio <= :precioMax AND v.disponible = true")
    List<Vehiculo> findVehiculosDisponiblesByPrecioMax(@Param("precioMax") Double precioMax);
    
    long countByDisponibleTrue();
}

