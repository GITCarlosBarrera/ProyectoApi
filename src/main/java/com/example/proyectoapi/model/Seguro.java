package com.example.proyectoapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "seguro")
public class Seguro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_seguro")
    private Long idSeguro;

    @Column(name = "numero_poliza", unique = true, nullable = false)
    private String numeroPoliza;

    private String compania;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_expiracion")
    private LocalDate fechaExpiracion;

    @OneToOne
    @JoinColumn(name = "id_vehiculo", unique = true)
    private Vehiculo vehiculo;
}
