package com.example.proyectoapi.dto.create;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class SeguroCreateDTO {
    @NotBlank(message = "El numero de la poliza no puede estar vacío")
    private String numeroPoliza;

    @NotBlank(message = "La compañia no puede estar vacía")
    private String compania;

    @NotNull(message = "La fecha de expiración no puede estar vacía")
    @Future(message = "La fecha de expiración no puede ser anterior a la fecha actual")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaExpiracion;
}
