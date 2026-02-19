package com.example.proyectoapi.service;

import com.example.proyectoapi.dto.SeguroDTO;

import java.util.List;

public interface SeguroService {
    List<SeguroDTO> obtenerTodasLasSeguros();
    SeguroDTO obtenerSeguroPorId(Long id);
}
