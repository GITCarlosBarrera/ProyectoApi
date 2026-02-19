package com.example.proyectoapi.mapper;

import com.example.proyectoapi.dto.SeguroDTO;
import com.example.proyectoapi.dto.SeguroDTOParaVehiculo;
import com.example.proyectoapi.model.Seguro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeguroMapper {
    private final VehiculoMapper vehiculoMapper;

    public SeguroDTO toDto(Seguro seguro) {
        if (seguro == null) return null;

        SeguroDTO dto = new SeguroDTO();
        dto.setId(seguro.getIdSeguro());
        dto.setNumeroPoliza(seguro.getNumeroPoliza());
        dto.setCompania(seguro.getCompania());
        dto.setFechaExpiracion(seguro.getFechaExpiracion());
        dto.setVehiculo(vehiculoMapper.toDtoSeguro(seguro.getVehiculo()));

        return dto;
    }

    public SeguroDTOParaVehiculo toDtoVehiculo(Seguro seguro) {
        if (seguro == null) return null;

        SeguroDTOParaVehiculo dto = new SeguroDTOParaVehiculo();
        dto.setNumeroPoliza(seguro.getNumeroPoliza());
        dto.setCompania(seguro.getCompania());

        return dto;
    }
}