package com.medicitas.app.repositorio;

import com.medicitas.app.modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    @Query(value = """ 
            SELECT * FROM cita
            WHERE id_usuario = :idUsuario
            AND id_estado = 1
            ORDER BY fecha_hora DESC
            """, nativeQuery = true)
    List<Cita> buscarCitasPendientesPorUsuario(@Param("idUsuario") Long idUsuario);

    @Query(value = """
            SELECT * FROM cita
            WHERE id_usuario = :idUsuario
            ORDER BY fecha_hora DESC
            LIMIT 1
            """, nativeQuery = true)
    Optional<Cita> buscarUltimaCitaPorUsuario(@Param("idUsuario") Long idUsuario);

    @Query(value = """
            SELECT * FROM cita
            WHERE id_medico = :idMedico
            ORDER BY fecha_hora DESC
            """, nativeQuery = true)
    List<Cita> buscarCitasPorMedico(@Param("idMedico") Long idMedico);

    @Query(value = """
            SELECT * FROM cita
            WHERE id_estado = :idEstado
            ORDER BY fecha_hora DESC
            """, nativeQuery = true)
    List<Cita> buscarCitasPorEstado(@Param("idEstado") Long idEstado);

    @Query(value = """
            SELECT * FROM cita
            WHERE fecha_hora = :fecha
            ORDER BY fecha_hora DESC
            """, nativeQuery = true)
    List<Cita> buscarCitasPorFecha(@Param("fecha") LocalDateTime fecha);
}
