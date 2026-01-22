package com.holamundo.ejemplo.holamundo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {
    
    @GetMapping("/hola")
    public String holaMundo() {
        return "¡Hola Mundo desde Spring Boot! 🚀";
    }
    
    @GetMapping("/test")
    public String test() {
        return "¡Todo funciona perfectamente! ✅";
    }
}