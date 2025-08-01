package com.medicitas.app.repositorio;

import com.medicitas.app.modelo.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface medicoRepositorio extends JpaRepository<Medico, Long> {
    
    @Query(value = "SELECT * FROM Medico WHERE idEspecialidad = :idEspecialidad", nativeQuery=true)
    List<Medico> buscarMedicosPorEspecialidad(@Param("idEspecialidad") Long idEspecialidad);
    
    
    @Query(value = "SELECT * FROM Medico WHERE idEps = :idEps", nativeQuery=true)
    List<Medico> buscarMedicosPorEPS(@Param("idEps") Long idEps);
    
    
    @Query(value = "SELECT * FROM Medico WHERE identificacion = :identificacion", nativeQuery=true)
    Medico buscarMedicosPorIdentificacion(@Param("identificacion") String identificacion);
    
    
    @Query(value = "select * from Medico WHERE activo = true", nativeQuery=true)
    List<Medico> buscarMedicosActivos();
    
    boolean existsByEspecialidadId(@Param ("especialidadId") Long especialidadId);
}
