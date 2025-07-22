package com.medicitas.app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medicitas.app.modelo.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

    Rol findByNombre(String nombre);

    @Query("SELECT r FROM Rol r WHERE r.activo = true")
    List<Rol> buscarRolesActivos();
}
