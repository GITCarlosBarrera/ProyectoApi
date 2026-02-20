package com.example.proyectoapi.dto.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehiculoUpdateDTO {
    @NotNull(message = "El id de la empresa no puede estar vacio")
    private Long idEmpresa;

    @NotBlank(message = "La matricula no puede estar vacia")
    private String matricula;

    @NotBlank(message = "El modelo no puede estar vacio")
    private String modelo;
}
