package com.medicitas.app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medicitas.app.modelo.EPS;

public interface EpsRepository extends JpaRepository<EPS, Long> {

    EPS findByNit(String nit);

    @Query("SELECT e FROM EPS e WHERE e.activo = true")
    List<EPS> buscarEPSActivas();
}

