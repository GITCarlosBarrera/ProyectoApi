package com.example.proyectoapi.controller;

import com.example.proyectoapi.dto.EmpresaDTO;
import com.example.proyectoapi.dto.SeguroDTO;
import com.example.proyectoapi.service.SeguroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/seguro")
@RequiredArgsConstructor
public class SeguroController {
    private final SeguroService seguroService;

    @GetMapping
    @Operation(summary = "Obten todos los seguros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de seguros recuperado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public List<SeguroDTO> obtenerTodosLosSeguros() {
        return seguroService.obtenerTodasLasSeguros();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obten un seguro por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Seguro encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "No se ha encontrado ningun seguro con el ID proporcionado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public SeguroDTO obtenerSeguroPorId(@PathVariable Long id) {
        return seguroService.obtenerSeguroPorId(id);
    }
}
