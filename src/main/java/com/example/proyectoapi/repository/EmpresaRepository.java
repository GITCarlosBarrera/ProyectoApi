package com.example.proyectoapi.repository;

import com.example.proyectoapi.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
