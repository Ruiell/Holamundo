package com.example.Edutech_Automotora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
    title = "Edutech Automotora API",
    version = "1.0",
    description = "API para sistema de gestión de automotora educativa"
))
public class EdutechAutomotoraApplication {
    public static void main(String[] args) {
        SpringApplication.run(EdutechAutomotoraApplication.class, args);
        System.out.println (" Edutech Automotora iniciado correctamente!");
    }
}