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

import com.medicitas.app.modelo.Usuario;
import com.medicitas.app.repositorio.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/listarUsuarios")
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/obtenerUsuarioPorId")
    public Usuario obtenerUsuarioPorId(@RequestParam("idUsuario") Long idUsuario) {
        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        return usuario.orElse(null);
    }

    @PostMapping("/crearUsuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/actualizarUsuario")
    public Usuario actualizarUsuario(@RequestParam("idUsuario") Long idUsuario, @RequestBody Usuario usuario) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(idUsuario);
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

    @DeleteMapping("/eliminarUsuario")
    public void eliminarUsuario(@RequestParam("idUsuario") Long idUsuario) {
        usuarioRepository.deleteById(idUsuario);
    }

    @GetMapping("/buscarPorNombre")
    public List<Usuario> buscarUsuarioPorNombre(@RequestParam String nombre) {
        return usuarioRepository.findByNombreCompletoContainingIgnoreCase(nombre);
    }

    @GetMapping("/buscarPorCorreo")
    public Usuario buscarUsuarioPorCorreo(@RequestParam String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    @GetMapping("/buscarPorIdentificacion")
    public Usuario buscarUsuarioPorIdentificacion(@RequestParam String identificacion) {
        return usuarioRepository.findByIdentificacion(identificacion);
    }

    @GetMapping("/listarActivos")
    public List<Usuario> buscarUsuariosActivos() {
        return usuarioRepository.buscarUsuariosActivos();
    }
}
