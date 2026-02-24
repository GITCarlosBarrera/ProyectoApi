package com.example.proyectoapi.service.impl;

import com.example.proyectoapi.dto.EmpresaDTO;
import com.example.proyectoapi.mapper.EmpresaMapper;
import com.example.proyectoapi.model.Empresa;
import com.example.proyectoapi.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements com.example.proyectoapi.service.EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final EmpresaMapper empresaMapper;

    @Override
    public List<EmpresaDTO> obtenerTodasLasEmpresas() {
        List<Empresa> listaEmpresas = empresaRepository.findAll();

        return listaEmpresas.stream()
                .map(empresaMapper::toDto)
                .toList();
    }

    @Override
    public EmpresaDTO obtenerEmpresaPorId(Long id) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Empresa con id [" + id + "] no encontrada"));

        return empresaMapper.toDto(empresa);
    }

    @Override
    @Transactional
    public void eliminarEmpresa(Long id) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("El vehiculo con id [" + id + "] no se ha encontrado"));

        if (empresa.getVehiculos() != null && !empresa.getVehiculos().isEmpty()) {
            throw new IllegalStateException("No se puede eliminar la empresa con vehiculos asociados.");
        }

        empresaRepository.delete(empresa);
    }
}
