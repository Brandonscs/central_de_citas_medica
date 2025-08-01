package com.medicitas.app.repositorio;

import com.medicitas.app.modelo.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface especialidadRepositorio extends JpaRepository<Especialidad, Long> {

   
    @Query(value="SELECT * FROM Especialidad  WHERE nombre = :nombre", nativeQuery=true)
    Especialidad buscarEspecialidadPorNombre(@RequestParam("nombre") String nombre);

    

    @Query(value="SELECT e FROM Especialidad e WHERE e.activo = true", nativeQuery=true)
    List<Especialidad> buscarEspecialidadesActivas();


    boolean existsByNombre(String nombre);

    
    @Query(value="SELECT COUNT(m) > 0 FROM Medico m WHERE m.especialidad.id = :especialidadId", nativeQuery=true)
    
    boolean existsMedicosByEspecialidadId(@RequestParam("especialidadId") Long especialidadId);
}
