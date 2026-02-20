package com.example.proyectoapi.mapper;

import com.example.proyectoapi.dto.VehiculoDTO;
import com.example.proyectoapi.dto.VehiculoDTOParaSeguro;
import com.example.proyectoapi.dto.create.VehiculoCreateDTO;
import com.example.proyectoapi.dto.update.VehiculoUpdateDTO;
import com.example.proyectoapi.model.Empresa;
import com.example.proyectoapi.model.Seguro;
import com.example.proyectoapi.model.Vehiculo;
import com.example.proyectoapi.repository.EmpresaRepository;
import com.example.proyectoapi.repository.SeguroRepository;
import jakarta.transaction.Transactional;
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

    public Vehiculo toEntity(VehiculoCreateDTO dto, EmpresaRepository empresaRepository) {
        if (dto == null) return null;

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMatricula(dto.getMatricula());
        vehiculo.setModelo(dto.getModelo());

        Empresa empresa = empresaRepository.findById(dto.getIdEmpresa())
                .orElseThrow(() -> new RuntimeException("No se encontro la empresa con el id [" + dto.getIdEmpresa() + "]"));
        vehiculo.setEmpresa(empresa);

        if (dto.getSeguro() != null) {
            Seguro seguro = seguroMapper.toEntity(dto.getSeguro());
            vehiculo.setSeguro(seguro);
            seguro.setVehiculo(vehiculo);
        }

        return vehiculo;
    }

    public void updateEntityFromDto(VehiculoUpdateDTO dto, Vehiculo vehiculo, EmpresaRepository empresaRepository) {
        if (dto == null || vehiculo == null) return;

        vehiculo.setMatricula(dto.getMatricula());
        vehiculo.setModelo(dto.getModelo());

        Empresa empresa = empresaRepository.findById(dto.getIdEmpresa())
                .orElseThrow(() -> new RuntimeException("No se encontro la empresa con el id [" + dto.getIdEmpresa() + "]"));
        vehiculo.setEmpresa(empresa);

        vehiculo.setEmpresa(empresa);
    }
}