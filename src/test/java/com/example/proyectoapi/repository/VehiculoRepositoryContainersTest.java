package com.example.proyectoapi.repository;

import com.example.proyectoapi.model.Empresa;
import com.example.proyectoapi.model.Seguro;
import com.example.proyectoapi.model.Vehiculo;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@Testcontainers
@TestPropertySource(properties = {"spring.jpa.hibernate.ddl-auto=create-drop"})
public class VehiculoRepositoryContainersTest {

    @Container
    @ServiceConnection
    static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:17.6-alpine");

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void eliminarVehiculo_DebeEliminarSeguroEnCascada() {
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setMatricula("1234-ABC");
        vehiculo.setModelo("Modelo Ejemplo");
        vehiculo.setEmpresa(new Empresa());

        Seguro seguro = new Seguro();
        seguro.setCompania("Compañia Ejemplo");
        seguro.setNumeroPoliza("POL-EJEMPLO");
        seguro.setFechaExpiracion(LocalDate.of(2027, 1, 1));
        vehiculo.setSeguro(seguro);

        Vehiculo guardado = vehiculoRepository.save(vehiculo);
        Long idSeguro = guardado.getSeguro().getIdSeguro();

        vehiculoRepository.delete(guardado);
        vehiculoRepository.flush();
        entityManager.clear();

        assertFalse(vehiculoRepository.findById(guardado.getIdVehiculo()).isPresent());

        Seguro seguroEnBD = entityManager.find(Seguro.class, idSeguro);
        assertNull(seguroEnBD, "El seguro deberia haber sido borrado por la cascada de JPA");
    }
}
