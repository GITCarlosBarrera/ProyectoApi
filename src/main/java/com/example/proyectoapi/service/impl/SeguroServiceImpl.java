package com.example.proyectoapi.service.impl;

import com.example.proyectoapi.dto.SeguroDTO;
import com.example.proyectoapi.mapper.SeguroMapper;
import com.example.proyectoapi.model.Seguro;
import com.example.proyectoapi.repository.SeguroRepository;
import com.example.proyectoapi.service.SeguroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SeguroServiceImpl implements SeguroService {
    private final SeguroRepository seguroRepository;
    private final SeguroMapper seguroMapper;

    @Override
    public List<SeguroDTO> obtenerTodasLasSeguros() {
        List<Seguro> listaSeguros = seguroRepository.findAll();

        return listaSeguros.stream()
                .map(seguroMapper::toDto)
                .toList();
    }

    @Override
    public SeguroDTO obtenerSeguroPorId(Long id) {
        Seguro seguro = seguroRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Seguro con id [" + id + "] no encontrada"));

        return seguroMapper.toDto(seguro);
    }
}
