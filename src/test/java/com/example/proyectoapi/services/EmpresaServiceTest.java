package com.example.proyectoapi.services;

import com.example.proyectoapi.model.Empresa;
import com.example.proyectoapi.model.Vehiculo;
import com.example.proyectoapi.repository.EmpresaRepository;
import com.example.proyectoapi.service.impl.EmpresaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmpresaServiceTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private EmpresaServiceImpl empresaService;

    private Empresa empresaTest;

    @BeforeEach
    void setUp() {
        empresaTest = new Empresa();
        empresaTest.setIdEmpresa(1L);
        empresaTest.setNombre("EmpresaTest");
        empresaTest.setCif("CodigoCIF");
        empresaTest.setVehiculos(new ArrayList<>());
    }

    @Test
    void eliminarEmpresa_Exito_SinVehiculos() {
        Long id = 1L;
        when(empresaRepository.findById(id)).thenReturn(Optional.of(empresaTest));

        empresaService.eliminarEmpresa(id);

        verify(empresaRepository, times(1)).delete(empresaTest);
    }

    @Test
    void eliminarEmpresa_Error_ConVehiculos() {
        Long id = 1L;

        empresaTest.getVehiculos().add(new Vehiculo());
        when(empresaRepository.findById(id)).thenReturn(Optional.of(empresaTest));

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            empresaService.eliminarEmpresa(id);
        });

        assertEquals("No se puede eliminar la empresa con vehiculos asociados.", exception.getMessage());

        verify(empresaRepository, never()).delete(any(Empresa.class));
    }
}
