package com.example.proyectoapi.mapper;

import com.example.proyectoapi.dto.VehiculoDTO;
import com.example.proyectoapi.dto.VehiculoDTOParaSeguro;
import com.example.proyectoapi.model.Vehiculo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehiculoMapper {
    private final EmpresaMapper empresaMapper;
    private final SeguroMapper seguroMapper;

    public VehiculoDTO toDto(Vehiculo vehiculo) {
        if (vehiculo == null) return null;

        VehiculoDTO dto = new VehiculoDTO();
        dto.setIdVehiculo(vehiculo.getIdVehiculo());
        dto.setMatricula(vehiculo.getMatricula());
        dto.setModelo(vehiculo.getModelo());
        dto.setEmpresa(empresaMapper.toDto(vehiculo.getEmpresa()));
        dto.setSeguro(seguroMapper.toDtoVehiculo(vehiculo.getSeguro()));

        return dto;
    }

    public VehiculoDTOParaSeguro toDtoSeguro(Vehiculo vehiculo) {
        if (vehiculo == null) return null;

        VehiculoDTOParaSeguro dto = new VehiculoDTOParaSeguro();
        dto.setMatricula(vehiculo.getMatricula());
        dto.setModelo(vehiculo.getModelo());

        return dto;
    }
}