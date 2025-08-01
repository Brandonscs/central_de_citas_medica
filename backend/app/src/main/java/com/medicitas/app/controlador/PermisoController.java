package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.Permiso;
import com.example.demo.repositorio.PermisoRepository;

@RestController
@RequestMapping("/permiso")
public class PermisoController {
	
	@Autowired
	private PermisoRepository permisoRepository;
	
 
	@GetMapping("/obtenerTodosLosPermisos")
	public List<Permiso> obtenerTodosLosPermisos(){
		return this.permisoRepository.findAll();
	}
	
	@GetMapping("/buscarPermiso")
	public Permiso obtenerPermisoPorId(@RequestParam Long id) {
		return this.permisoRepository.findById(id).orElse(null);
	}
	
	@PostMapping("/creaePermiso")
	public Permiso crearPermiso(@RequestBody Permiso permiso) {
		return this.permisoRepository.save(permiso);
	}
	
	@DeleteMapping("/eliminarPermiso")
	public void eliminarPermiso(@PathVariable Long id) {
		this.permisoRepository.deleteById(id);
	}
}
