package com.example.proyectoapi.mapper;

import com.example.proyectoapi.dto.EmpresaDTO;
import com.example.proyectoapi.model.Empresa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmpresaMapper {

    public EmpresaDTO toDto(Empresa empresa) {
        if (empresa == null) return null;

        EmpresaDTO dto = new EmpresaDTO();
        dto.setId(empresa.getIdEmpresa());
        dto.setNombre(empresa.getNombre());
        dto.setCif(empresa.getCif());

        return dto;
    }
}
