package com.medicitas.app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medicitas.app.modelo.RolUsuario;

public interface RolUsuarioRepository extends JpaRepository<RolUsuario, Long> {

	@Query("SELECT ru FROM RolUsuario ru WHERE ru.usuario.id = :idUsuario")
	List<RolUsuario> buscarRolesPorUsuario(Long idUsuario);

	@Query("SELECT ru FROM RolUsuario ru WHERE ru.rol.id = :idRol")
	List<RolUsuario> buscarUsuariosPorRol(Long idRol);
}