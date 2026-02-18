package com.example.proyectoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeguroDTO {
    private Long id;
    private Long numeroPoliza;
    private String compania;
    private Date fechaExpiracion;
    private VehiculoSeguroDTO vehiculo;
}
