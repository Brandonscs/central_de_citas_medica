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

import com.medicitas.app.modelo.Usuario;
import com.medicitas.app.repositorio.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario existente = optionalUsuario.get();
            existente.setNombreCompleto(usuario.getNombreCompleto());
            existente.setIdentificacion(usuario.getIdentificacion());
            existente.setTelefono(usuario.getTelefono());
            existente.setDireccion(usuario.getDireccion());
            existente.setCorreo(usuario.getCorreo());
            existente.setFechaNacimiento(usuario.getFechaNacimiento());
            existente.setRh(usuario.getRh());
            existente.setPassword(usuario.getPassword());
            existente.setFechaRegistro(usuario.getFechaRegistro());
            existente.setActivo(usuario.isActivo());
            return usuarioRepository.save(existente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

    @GetMapping("/buscar")
    public List<Usuario> buscarUsuarioPorNombre(@RequestParam String nombre) {
        return usuarioRepository.findByNombreCompletoContainingIgnoreCase(nombre);
    }

    @GetMapping("/correo/{correo}")
    public Usuario buscarUsuarioPorCorreo(@PathVariable String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @GetMapping("/identificacion/{identificacion}")
    public Usuario buscarUsuarioPorIdentificacion(@PathVariable String identificacion) {
        return usuarioRepository.findByIdentificacion(identificacion);
    }

    @GetMapping("/activos")
    public List<Usuario> buscarUsuariosActivos() {
        return usuarioRepository.buscarUsuariosActivos();
    }
}
