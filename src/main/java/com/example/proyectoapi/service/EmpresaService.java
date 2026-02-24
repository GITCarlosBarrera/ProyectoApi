package com.example.proyectoapi.service;

import com.example.proyectoapi.dto.EmpresaDTO;

import java.util.List;

public interface EmpresaService {
    List<EmpresaDTO> obtenerTodasLasEmpresas();
    EmpresaDTO obtenerEmpresaPorId(Long id);
    void eliminarEmpresa(Long id);
}
