package com.medicitas.app.repositorio;

import com.medicitas.app.modelo.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    @Query(value = """ 
            SELECT * FROM cita
            WHERE id_usuario = :idUsuario
            AND id_estado = 1
            ORDER BY fecha_hora DESC
            """, nativeQuery = true)
    List<Cita> buscarCitasPendientesPorUsuario(Long idUsuario);

    @Query(value = """
            SELECT * FROM cita
            WHERE id_usuario = :idUsuario
            ORDER BY fecha_hora DESC
            LIMIT 1
            """, nativeQuery = true)
    Cita buscarUltimaCitaPorUsuario(Long idUsuario);

    @Query(value = """
            SELECT * FROM cita
            WHERE id_medico = :idMedico
            ORDER BY fecha_hora DESC
            """, nativeQuery = true)
    List<Cita> buscarCitasPorMedico(Long idMedico);

    @Query(value = """
            SELECT * FROM cita
            WHERE id_estado = :estado
            ORDER BY fecha_hora DESC
            """, nativeQuery = true)
    List<Cita> buscarCitasPorEstado(String estado);

    @Query(value = """
            SELECT * FROM cita
            WHERE fecha_hora = :fecha
            ORDER BY fecha_hora DESC
            """, nativeQuery = true)
    List<Cita> buscarCitasPorFecha(LocalDateTime fecha);
}
