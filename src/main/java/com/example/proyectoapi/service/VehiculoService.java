package com.example.proyectoapi.service;

import com.example.proyectoapi.dto.VehiculoDTO;

import java.util.List;

public interface VehiculoService {
    List<VehiculoDTO> obtenerTodosLosVehiculos();
    VehiculoDTO obtenerVehiculoPorId(Long id);
    VehiculoDTO crearVehiculo(/*TODO: VehiculoCreateDTO dto*/);
    VehiculoDTO actualizarVehiculo(Long id /*TODO: VehiculoUpdateDTO dto*/);
    void eliminarVehiculo(Long id);
}
