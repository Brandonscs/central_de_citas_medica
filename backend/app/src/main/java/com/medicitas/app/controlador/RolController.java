package com.medicitas.app.controlador;

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

import com.medicitas.app.modelo.Rol;
import com.medicitas.app.repositorio.RolRepository;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }

    @GetMapping("/{id}")
    public Rol obtenerRolPorId(@PathVariable Long id) {
        Optional<Rol> rol = rolRepository.findById(id);
        return rol.orElse(null);
    }

    @PostMapping
    public Rol crearRol(@RequestBody Rol rol) {
        rol.setFechaCreacion(new java.util.Date());
        return rolRepository.save(rol);
    }

    @PutMapping("/{id}")
    public Rol actualizarRol(@PathVariable Long id, @RequestBody Rol rol) {
        Optional<Rol> optionalRol = rolRepository.findById(id);
        if (optionalRol.isPresent()) {
            Rol existente = optionalRol.get();
            existente.setNombre(rol.getNombre());
            existente.setDescripcion(rol.getDescripcion());
            existente.setActivo(rol.isActivo());
            return rolRepository.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarRol(@PathVariable Long id) {
        rolRepository.deleteById(id);
    }

    @GetMapping("/buscar")
    public Rol buscarRolPorNombre(@RequestParam String nombre) {
        return rolRepository.findByNombre(nombre);
    }
}