package com.example.proyectoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoDTOParaSeguro {
    private String matricula;
    private String modelo;
}
