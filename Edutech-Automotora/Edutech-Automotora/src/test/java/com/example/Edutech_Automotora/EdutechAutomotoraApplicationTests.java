package com.example.Edutech_Automotora;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EdutechAutomotoraApplicationTests {

    @Test
    void contextLoads() {
        // Esta prueba verifica que el contexto de Spring se carga
        assertThat(true).isTrue();
    }
    
    @Test
    void testSumaBasica() {
        // Prueba unitaria simple
        int resultado = 2 + 3;
        assertThat(resultado).isEqualTo(5);
    }
    
    @Test
    void testCadena() {
        String mensaje = "Edutech Automotora";
        assertThat(mensaje).contains("Automotora");
    }
}