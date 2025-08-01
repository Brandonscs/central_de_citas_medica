package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Permiso;
import com.example.demo.modelo.RolPermiso;

@Repository
public interface RolPermisoRepository extends JpaRepository<RolPermiso,Long> {
	
	@Query(value= """
			select * from rol_permiso
			where id_rol = :idRol""", nativeQuery=true)
	public List<RolPermiso> buscarIdRol(@Param("idRol")Long idRol);
	
	@Query(value="""
			select * from rol_permiso 
			where id_Permiso = :idPermiso """, nativeQuery=true)
	public List<RolPermiso> buscarPermiso(@Param("idPermiso")Long idPermiso);
	
	@Query(value="""
			select * from rol_permiso
			where activo = true""", nativeQuery=true)
	public List<RolPermiso> PermisoActivos();
	
	
	
	
	

}
