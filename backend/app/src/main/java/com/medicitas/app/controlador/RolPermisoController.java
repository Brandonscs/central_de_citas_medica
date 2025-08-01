package com.example.demo.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelo.RolPermiso;
import com.example.demo.repositorio.RolPermisoRepository;

@RestController
@RequestMapping("/rol-permiso")
public class RolPermisoController {
	
	@Autowired
	private RolPermisoRepository rolPermisoRepository;
	
		
	@GetMapping("/obtenerTodos")
	public List<RolPermiso> obtenerTodos(){
		return this.rolPermisoRepository.findAll();
	}
	
	
	@GetMapping ("/buscarPorRol")
	public List<RolPermiso> buscarPorRol(@RequestParam Long idRol){
        return this.rolPermisoRepository.buscarIdRol(idRol);
    }

	@GetMapping("/buscarPorPermiso")
	public List<RolPermiso> buscarPorPermiso(@RequestParam Long idPermiso){
        return this.rolPermisoRepository.buscarPermiso(idPermiso);
    }
	
	@PostMapping("/asignarPermiso")
	public RolPermiso asignarPermiso(@RequestBody RolPermiso rolPermiso) {
        return this.rolPermisoRepository.save(rolPermiso);
    }
	
	@PutMapping("/actualizarfAsignacion")
	public RolPermiso actualizarAsignacion(@RequestBody RolPermiso datosActualizados) {
        Optional<RolPermiso> existente = this.rolPermisoRepository.findById(datosActualizados.getId());
        if (existente.isPresent()) {
            RolPermiso rp = existente.get();
            rp.setIdRol(datosActualizados.getIdRol());
            rp.setIdPermiso(datosActualizados.getIdPermiso());
            return this.rolPermisoRepository.save(rp);
        } else {
            throw new RuntimeException("No se encontró el rol-permiso con ID: " + datosActualizados.getId());
        }
    }
	
	@DeleteMapping("/eliminarAsignacion")
	public void eliminarAsignacion(@PathVariable Long id) {
        this.rolPermisoRepository.deleteById(id);
    }
	
}
