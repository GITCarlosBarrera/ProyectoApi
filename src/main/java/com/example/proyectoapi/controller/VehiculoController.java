package com.example.proyectoapi.controller;

import com.example.proyectoapi.dto.VehiculoDTO;
import com.example.proyectoapi.dto.create.VehiculoCreateDTO;
import com.example.proyectoapi.dto.update.VehiculoUpdateDTO;
import com.example.proyectoapi.model.Vehiculo;
import com.example.proyectoapi.service.VehiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping
    @Operation(summary = "Crea un nuevo vehiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vehiculo creado con éxito"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos (error de validación)"),
            @ApiResponse(responseCode = "404", description = "La empresa asignada al vehiculo no existe"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<VehiculoDTO> crearVehiculo(@Valid @RequestBody VehiculoCreateDTO dto) {
        VehiculoDTO vehiculoCreado = vehiculoService.crearVehiculo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehiculoCreado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Modifica los datos de un vehiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehiculo actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "ID no encontrado o datos de empresa no válidos"),
            @ApiResponse(responseCode = "400", description = "Error en los datos enviados"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<VehiculoDTO> actualizarVehiculo(@PathVariable Long id, @Valid @RequestBody VehiculoUpdateDTO dto) {
        VehiculoDTO vehiculoActualizado = vehiculoService.actualizarVehiculo(id, dto);
        return ResponseEntity.ok(vehiculoActualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un vehiculo por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Vehiculo eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "El vehiculo con ese ID no existe"),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })
    public ResponseEntity<Void> eliminarVehiculo(@PathVariable Long id) {
        vehiculoService.eliminarVehiculo(id);
        return ResponseEntity.noContent().build();
    }
}
