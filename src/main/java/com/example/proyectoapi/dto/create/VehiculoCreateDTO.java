package com.example.proyectoapi.dto.create;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VehiculoCreateDTO {
    @NotBlank(message = "La matricula no puede estar vacia")
    private String matricula;

    @NotBlank(message = "El modelo del coche no puede estar vacio")
    private String modelo;

    @NotNull(message = "El id de la empresa no puede estar vacio")
    private Long idEmpresa;

    @Valid
    @NotNull(message = "El seguro es obligatorio")
    private SeguroCreateDTO seguro;
}
