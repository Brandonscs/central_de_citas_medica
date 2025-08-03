package com.medicitas.app.controlador;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medicitas.app.modelo.RolUsuario;
import com.medicitas.app.repositorio.RolUsuarioRepository;

@RestController
@RequestMapping("/rol-usuario")
public class RolUsuarioController {
	
	@Autowired
    private RolUsuarioRepository rolUsuarioRepository;

    @GetMapping("/listarRolUsuario")
    public List<RolUsuario> obtenerTodos() {
        return rolUsuarioRepository.findAll();
    }

    @PostMapping("/asignarRol")
    public RolUsuario asignarRol(@RequestBody RolUsuario rolUsuario) {
        if (rolUsuario.getFechaAsignacion() == null) {
            rolUsuario.setFechaAsignacion(new Date());
        }
        return rolUsuarioRepository.save(rolUsuario);
    }

    @DeleteMapping("/eliminarRolUsuario")
    public void eliminarRolDeUsuario(@RequestParam("idRolUsuario") Long idRolUsuario) {
        rolUsuarioRepository.deleteById(idRolUsuario);
    }

    @GetMapping("/buscarPorUsuario")
    public List<RolUsuario> buscarPorUsuario(@RequestParam("idUsuario") Long idUsuario) {
        return rolUsuarioRepository.buscarRolesPorUsuario(idUsuario);
    }

    @GetMapping("/buscarPorRol")
    public List<RolUsuario> buscarPorRol(@RequestParam("idRol") Long idRol) {
        return rolUsuarioRepository.buscarUsuariosPorRol(idRol);
    }
}

