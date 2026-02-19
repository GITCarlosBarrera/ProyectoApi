package com.example.proyectoapi.controller;


import com.example.proyectoapi.dto.EmpresaDTO;
import com.example.proyectoapi.service.EmpresaService;
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
@RequestMapping("/api/empresa")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaService empresaService;

    @GetMapping
    @Operation(summary = "Obten todas las empresas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de empresas recuperado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public List<EmpresaDTO> obtenerTodasLasEmpresas() {
        return empresaService.obtenerTodasLasEmpresas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obten una empresa por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empresa encontrada correctamente"),
            @ApiResponse(responseCode = "404", description = "No se ha encontrado ninguna empresa con el ID proporcionado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public EmpresaDTO obtenerEmpresaPorId(@PathVariable Long id) {
        return empresaService.obtenerEmpresaPorId(id);
    }
}
