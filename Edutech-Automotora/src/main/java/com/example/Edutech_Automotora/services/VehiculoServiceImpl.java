package com.example.Edutech_Automotora.services;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Edutech_Automotora.models.entities.Vehiculo;
import com.example.Edutech_Automotora.models.entities.VehiculoRequest;
import com.example.Edutech_Automotora.models.entities.VehiculoResponse;
import com.example.Edutech_Automotora.repositories.VehiculoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class VehiculoServiceImpl implements VehiculoService {
    
    private final VehiculoRepository vehiculoRepository;
    
    @Override
    public VehiculoResponse crearVehiculo(VehiculoRequest request) {
        // Verificar si la placa ya existe
        if (vehiculoRepository.findByPlaca(request.getPlaca()).isPresent()) {
            throw new RuntimeException("Ya existe un vehículo con la placa: " + request.getPlaca());
        }
        
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMarca(request.getPlaca());
        vehiculo.setModelo(request.getModelo());
        vehiculo.setAnio(request.getAnio());
        vehiculo.setColor(request.getColor());
        vehiculo.setPrecio(request.getAnio());
        vehiculo.setKilometraje(request.getKilometraje());
        vehiculo.setTipoCombustible(request.getTipoCombustible());
        vehiculo.setTransmision(request.getTransmision());
        vehiculo.setPuertas(request.getPuertas());
        vehiculo.setDescripcion(request.getDescripcion());
        vehiculo.setPlaca(request.getPlaca());
        vehiculo.setDisponible(true);
        
        Vehiculo saved = vehiculoRepository.save(vehiculo);
        return convertirAResponse(saved);
    }

        private VehiculoResponse convertirAResponse(Vehiculo saved) {
            throw new UnsupportedOperationException("Unimplemented method 'convertirAResponse'");
        }

        @Override
        public VehiculoResponse actualizarVehiculo(Long id, VehiculoRequest request) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'actualizarVehiculo'");
        }

        @Override
        public void eliminarVehiculo(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'eliminarVehiculo'");
        }

        @Override
        public VehiculoResponse obtenerVehiculoPorId(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'obtenerVehiculoPorId'");
        }

        @Override
        public List<VehiculoResponse> listarTodosVehiculos() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'listarTodosVehiculos'");
        }

        @Override
        public List<VehiculoResponse> listarVehiculosDisponibles() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'listarVehiculosDisponibles'");
        }

        @Override
        public List<VehiculoResponse> buscarPorMarca(String marca) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'buscarPorMarca'");
        }

        @Override
        public List<VehiculoResponse> buscarPorModelo(String modelo) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'buscarPorModelo'");
        }

        @Override
        public List<VehiculoResponse> buscarPorRangoPrecio(Double precioMin, Double precioMax) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'buscarPorRangoPrecio'");
        }

        @Override
        public List<VehiculoResponse> buscarPorRangoAnio(Integer anioMin, Integer anioMax) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'buscarPorRangoAnio'");
        }

        @Override
        public long contarVehiculosDisponibles() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'contarVehiculosDisponibles'");
        }

        @Override
        public VehiculoResponse marcarComoVendido(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'marcarComoVendido'");
        }

        @Override
        public VehiculoResponse marcarComoDisponible(Long id) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'marcarComoDisponible'");
        }
    }
    