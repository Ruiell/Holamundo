package com.example.Edutech_Automotora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Edutech_Automotora.models.entities.Cliente;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    Optional<Cliente> findByDni(String dni);
    
    Optional<Cliente> findByEmail(String email);
    
    List<Cliente> findByEsVipTrue();
    
    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')) OR LOWER(c.apellido) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Cliente> findByNombreOrApellidoContaining(String nombre);
    
    boolean existsByDni(String dni);
    
    boolean existsByEmail(String email);
}