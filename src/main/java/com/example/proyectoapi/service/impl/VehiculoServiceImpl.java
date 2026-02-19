package com.example.proyectoapi.service.impl;

import com.example.proyectoapi.dto.VehiculoDTO;
import com.example.proyectoapi.service.VehiculoService;

import java.util.List;

public class VehiculoServiceImpl implements VehiculoService {
    @Override
    public List<VehiculoDTO> obtenerTodosLosVehiculos() {
        return List.of();
    }

    @Override
    public VehiculoDTO obtenerVehiculoPorId(Long id) {
        return null;
    }

    @Override
    public VehiculoDTO crearVehiculo() {
        return null;
    }

    @Override
    public VehiculoDTO actualizarVehiculo(Long id) {
        return null;
    }

    @Override
    public void eliminarVehiculo(Long id) {

    }
}
