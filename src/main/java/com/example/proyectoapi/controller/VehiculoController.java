package com.example.proyectoapi.controller;

import com.example.proyectoapi.dto.SeguroDTO;
import com.example.proyectoapi.dto.VehiculoDTO;
import com.example.proyectoapi.service.SeguroService;
import com.example.proyectoapi.service.VehiculoService;
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
@RequestMapping("/api/vehiculo")
@RequiredArgsConstructor
public class VehiculoController {
    private final VehiculoService vehiculoService;

    @GetMapping
    @Operation(summary = "Obten todos los vehiculos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de vehiculos recuperado correctamente"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public List<VehiculoDTO> obtenerTodosLosVehiculos() {
        return vehiculoService.obtenerTodosLosVehiculos();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obten un vehiculo por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehiculo encontrado correctamente"),
            @ApiResponse(responseCode = "404", description = "No se ha encontrado ningun vehiculo con el ID proporcionado"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public VehiculoDTO obtenerVehiculoPorId(@PathVariable Long id) {
        return vehiculoService.obtenerVehiculoPorId(id);
    }
}
