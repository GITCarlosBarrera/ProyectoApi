package com.example.proyectoapi.service.impl;

import com.example.proyectoapi.dto.VehiculoDTO;
import com.example.proyectoapi.dto.create.VehiculoCreateDTO;
import com.example.proyectoapi.dto.update.VehiculoUpdateDTO;
import com.example.proyectoapi.mapper.VehiculoMapper;
import com.example.proyectoapi.model.Empresa;
import com.example.proyectoapi.model.Seguro;
import com.example.proyectoapi.model.Vehiculo;
import com.example.proyectoapi.repository.EmpresaRepository;
import com.example.proyectoapi.repository.SeguroRepository;
import com.example.proyectoapi.repository.VehiculoRepository;
import com.example.proyectoapi.service.VehiculoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class VehiculoServiceImpl implements VehiculoService {
    private final VehiculoMapper vehiculoMapper;
    private final EmpresaRepository empresaRepository;
    private final VehiculoRepository vehiculoRepository;

    @Override
    public List<VehiculoDTO> obtenerTodosLosVehiculos() {
        List<Vehiculo> listaVehiculos = vehiculoRepository.findAll();

        return listaVehiculos.stream()
                .map(vehiculoMapper::toDto)
                .toList();
    }

    @Override
    public VehiculoDTO obtenerVehiculoPorId(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Vehiculo con id [" + id + "] no encontrada"));

        return vehiculoMapper.toDto(vehiculo);
    }

    @Override
    @Transactional
    public VehiculoDTO crearVehiculo(VehiculoCreateDTO dto) {
        Vehiculo vehiculo = vehiculoMapper.toEntity(dto, empresaRepository);

        Vehiculo vehiculoGuardado = vehiculoRepository.save(vehiculo);

        return vehiculoMapper.toDto(vehiculoGuardado);
    }

    @Override
    @Transactional
    public VehiculoDTO actualizarVehiculo(Long id, VehiculoUpdateDTO dto) {
        Vehiculo vehiculoExistente = vehiculoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Vehiculo con id [" + id + "] no encontrado"));

        vehiculoMapper.updateEntityFromDto(dto, vehiculoExistente, empresaRepository);

        Vehiculo vehiculoActualizado = vehiculoRepository.save(vehiculoExistente);

        return vehiculoMapper.toDto(vehiculoActualizado);
    }

    @Override
    @Transactional
    public void eliminarVehiculo(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("El vehiculo con id [" + id + "] no se ha encontrado"));

        vehiculoRepository.delete(vehiculo);
    }
}
