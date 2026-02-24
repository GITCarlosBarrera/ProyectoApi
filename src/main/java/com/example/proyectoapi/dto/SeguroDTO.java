package com.example.proyectoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeguroDTO {
    private Long id;
    private String numeroPoliza;
    private String compania;
    private LocalDate fechaExpiracion;
    private VehiculoDTOParaSeguro vehiculo;
}
