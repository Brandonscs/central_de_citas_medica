//package com.example.demo.repositorio;

package com.medicitas.app.repositorio;


import java.util.List;

import com.medicitas.app.modelo.Permiso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.example.demo.modelo.Permiso;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long>{
	
	@Query(value="""
			select*from permiso where activo = true""", nativeQuery=true)
	public List<Permiso> buscarPermisosActivos();
	
	@Query(value= """
			select*from permiso where nombre = :nombre """, nativeQuery=true)
	public List<Permiso> buscarPermisoPorNombre(@Param("nombre") String nombre); 
}
