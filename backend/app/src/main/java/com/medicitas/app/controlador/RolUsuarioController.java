package com.medicitas.app.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicitas.app.modelo.RolUsuario;
import com.medicitas.app.repositorio.RolUsuarioRepository;

@RestController
@RequestMapping("/rol-usuario")
public class RolUsuarioController {
	
	@Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    @GetMapping
    public List<RolUsuario> obtenerTodos() {
        return rolUsuarioRepository.findAll();
    }

    @PostMapping
    public RolUsuario asignarRol(@RequestBody RolUsuario rolUsuario) {
        if (rolUsuario.getFechaAsignacion() == null) {
            rolUsuario.setFechaAsignacion(new Date());
        }
        return rolUsuarioRepository.save(rolUsuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarRolDeUsuario(@PathVariable Long id) {
        rolUsuarioRepository.deleteById(id);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<RolUsuario> buscarPorUsuario(@PathVariable Long idUsuario) {
        return rolUsuarioRepository.buscarRolesPorUsuario(idUsuario);
    }

    @GetMapping("/rol/{idRol}")
    public List<RolUsuario> buscarPorRol(@PathVariable Long idRol) {
        return rolUsuarioRepository.buscarUsuariosPorRol(idRol);
    }
}

