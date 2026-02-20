package com.example.proyectoapi.mapper;

import com.example.proyectoapi.dto.SeguroDTO;
import com.example.proyectoapi.dto.SeguroDTOParaVehiculo;
import com.example.proyectoapi.dto.VehiculoDTOParaSeguro;
import com.example.proyectoapi.dto.create.SeguroCreateDTO;
import com.example.proyectoapi.model.Seguro;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeguroMapper {

    public SeguroDTO toDto(Seguro seguro) {
        if (seguro == null) return null;

        SeguroDTO dto = new SeguroDTO();
        dto.setId(seguro.getIdSeguro());
        dto.setNumeroPoliza(seguro.getNumeroPoliza());
        dto.setCompania(seguro.getCompania());
        dto.setFechaExpiracion(seguro.getFechaExpiracion());

        // Se inserta de forma manual aquí para romper la dependencia circular con VehiculoMapper
        if (seguro.getVehiculo() != null) {
            VehiculoDTOParaSeguro vDto = new VehiculoDTOParaSeguro();
            vDto.setMatricula(seguro.getVehiculo().getMatricula());
            vDto.setModelo(seguro.getVehiculo().getModelo());
            dto.setVehiculo(vDto);
        }

        return dto;
    }

    public SeguroDTOParaVehiculo toDtoVehiculo(Seguro seguro) {
        if (seguro == null) return null;

        SeguroDTOParaVehiculo dto = new SeguroDTOParaVehiculo();
        dto.setNumeroPoliza(seguro.getNumeroPoliza());
        dto.setCompania(seguro.getCompania());

        return dto;
    }

    public Seguro toEntity(SeguroCreateDTO dto) {
        if (dto == null) return null;

        Seguro seguro = new Seguro();
        seguro.setNumeroPoliza(dto.getNumeroPoliza());
        seguro.setCompania(dto.getCompania());
        seguro.setFechaExpiracion(dto.getFechaExpiracion());

        return seguro;
    }
}