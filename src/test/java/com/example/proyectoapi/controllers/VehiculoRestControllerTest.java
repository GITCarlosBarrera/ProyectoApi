package com.example.proyectoapi.controllers;

import com.example.proyectoapi.controller.VehiculoController;
import com.example.proyectoapi.dto.VehiculoDTO;
import com.example.proyectoapi.dto.create.SeguroCreateDTO;
import com.example.proyectoapi.dto.create.VehiculoCreateDTO;
import com.example.proyectoapi.service.VehiculoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(VehiculoController.class)
public class VehiculoRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VehiculoService vehiculoService;

    @Autowired
    private ObjectMapper objectMapper;

    private VehiculoCreateDTO vehiculoCreateDTO;
    private VehiculoDTO vehiculoResponseDTO;

    @BeforeEach
    void setUp() {
        SeguroCreateDTO seguroDTO = new SeguroCreateDTO();
        seguroDTO.setCompania("Controller Test");
        seguroDTO.setNumeroPoliza("POL-TEST");
        seguroDTO.setFechaExpiracion(LocalDate.of(2027,1,1));

        vehiculoCreateDTO = new VehiculoCreateDTO();
        vehiculoCreateDTO.setIdEmpresa(1L);
        vehiculoCreateDTO.setMatricula("1234-TEST");
        vehiculoCreateDTO.setModelo("Modelo Test");
        vehiculoCreateDTO.setSeguro(seguroDTO);

        vehiculoResponseDTO = new VehiculoDTO();
        vehiculoResponseDTO.setIdVehiculo(1L);
        vehiculoResponseDTO.setMatricula("1234-TEST");
        vehiculoResponseDTO.setModelo("Modelo Test");
    }

    @Test
    void crearVehiculoYSeguro_Exito() throws Exception {
        when(vehiculoService.crearVehiculo(any(VehiculoCreateDTO.class))).thenReturn(vehiculoResponseDTO);

        mockMvc.perform(post("/api/vehiculo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vehiculoCreateDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.idVehiculo").value(1L))
                .andExpect(jsonPath("$.matricula").value("1234-TEST"))
                .andExpect(jsonPath("$.modelo").value("Modelo Test"));

        verify(vehiculoService).crearVehiculo(any(VehiculoCreateDTO.class));
    }
}
