package com.example.proyectoapi.service;

import com.example.proyectoapi.dto.VehiculoDTO;
import com.example.proyectoapi.dto.create.VehiculoCreateDTO;
import com.example.proyectoapi.dto.update.VehiculoUpdateDTO;

import java.util.List;

public interface VehiculoService {
    List<VehiculoDTO> obtenerTodosLosVehiculos();
    VehiculoDTO obtenerVehiculoPorId(Long id);
    VehiculoDTO crearVehiculo(VehiculoCreateDTO dto);
    VehiculoDTO actualizarVehiculo(Long id, VehiculoUpdateDTO dto);
    void eliminarVehiculo(Long id);
}
