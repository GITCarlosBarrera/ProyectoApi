package com.example.proyectoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDTO {
    private Long idVehiculo;
    private String matricula;
    private String modelo;
    private String nombreEmpresa;
    private EmpresaDTO empresa;
    private String numeroPoliza;
    private String companiaSeguro;
}
