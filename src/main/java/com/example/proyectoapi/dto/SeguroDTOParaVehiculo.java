package com.example.proyectoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeguroDTOParaVehiculo {
    private String numeroPoliza;
    private String compania;
}
