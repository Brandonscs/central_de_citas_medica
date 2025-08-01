package com.medicitas.app.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.medicitas.app.modelo.Disponibilidad;

public interface disponibilidadRepositorio extends JpaRepository<Disponibilidad, Long>  {
	
	@Query(value = "SELECT * FROM Disponibilidad  WHERE id_medico = :idMedico", nativeQuery=true)
    List<Disponibilidad> buscarDisponibilidadPorMedico(@Param("idMedico") Long idMedico);

    @Query(value = "SELECT * FROM Disponibilidad  WHERE fecha = :fecha", nativeQuery=true)
    List<Disponibilidad> buscarDisponibilidadPorFecha(@Param("fecha") Date fecha);

    @Query(value = "SELECT * FROM Disponibilidad  WHERE id_medico = :idMedico AND fecha = :fecha", nativeQuery=true)
    List<Disponibilidad> buscarDisponibilidadPorMedicoYFecha(@Param("idMedico") Long idMedico, 
                                                           @Param("fecha") Date fecha);
}
