package com.medicitas.app.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medicitas.app.modelo.Rol;
import com.medicitas.app.repositorio.RolRepository;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/listarRoles")
    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }

    @GetMapping("/obtenerRolPorId")
    public Rol obtenerRolPorId(@RequestParam("idRol") Long idRol) {
        Optional<Rol> rol = rolRepository.findById(idRol);
        return rol.orElse(null);
    }

    @PostMapping("/crearRol")
    public Rol crearRol(@RequestBody Rol rol) {
        rol.setFechaCreacion(new java.util.Date());
        return rolRepository.save(rol);
    }

    @PutMapping("/actualizarRol")
    public Rol actualizarRol(@RequestParam("idRol") Long idRol, @RequestBody Rol rol) {
        Optional<Rol> optionalRol = rolRepository.findById(idRol);
        if (optionalRol.isPresent()) {
            Rol existente = optionalRol.get();
            existente.setNombre(rol.getNombre());
            existente.setDescripcion(rol.getDescripcion());
            existente.setActivo(rol.isActivo());
            return rolRepository.save(existente);
        }
        return null;
    }

    @DeleteMapping("/eliminarRol")
    public void eliminarRol(@RequestParam("idRol") Long idRol) {
        rolRepository.deleteById(idRol);
    }

    @GetMapping("/buscarPorNombre")
    public Rol buscarRolPorNombre(@RequestParam("nombre") String nombre) {
        return rolRepository.findByNombre(nombre);
    }

    @GetMapping("/listarActivos")
    public List<Rol> buscarRolesActivos() {
        return rolRepository.buscarRolesActivos();
    }
}