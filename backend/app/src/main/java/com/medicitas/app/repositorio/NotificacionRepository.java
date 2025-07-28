package com.medicitas.app.repositorio;

import com.medicitas.app.modelo.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    @Query(value = """
                SELECT * FROM notificacion
                WHERE id_usuario = :idUsuario
                ORDER BY fecha_envio DESC""", nativeQuery = true)
    List<Notificacion> buscarNotificacionesPorUsuario(@Param("idUsuario") Long idUsuario);

    @Query(value = """
                SELECT * FROM notificacion
                WHERE id_cita = :idCita
                ORDER BY fecha_envio DESC""", nativeQuery = true)
    List<Notificacion> buscarNotificacionesPorCita(@Param("idCita") Long idCita);

    @Query(value = """
                SELECT * FROM notificacion
                WHERE tipo = :tipo
                ORDER BY fecha_envio DESC""", nativeQuery = true)
    List<Notificacion> buscarNotificacionesPorTipo(@Param("tipo") String tipo);


}
