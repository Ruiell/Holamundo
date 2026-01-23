package com.example.Edutech_Automotora;

import com.example.Edutech_Automotora.controller.ClienteController;
import com.example.Edutech_Automotora.models.entities.Cliente;
import com.example.Edutech_Automotora.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClienteController.class)
@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Mock
    private ClienteRepository clienteRepository;
    
    @Test
    void testGetClienteById() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        cliente.setDni("12345678");
        
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));
        
        mockMvc.perform(get("/api/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Juan"));
    }
}