package com.medicitas.app.repositorio;

import com.medicitas.app.modelo.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EstadoCitaRepository extends JpaRepository<EstadoCita, Long> {

    @Query(value = """
            SELECT * FROM estado_cita 
            WHERE nombre = :nombre""", nativeQuery = true)
    Optional<EstadoCita> buscarEstadoPorNombre(@Param("nombre") String nombre);

}
