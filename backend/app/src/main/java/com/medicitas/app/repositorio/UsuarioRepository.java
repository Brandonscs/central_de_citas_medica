package com.medicitas.app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.medicitas.app.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNombreCompletoContainingIgnoreCase(String nombre);

    Usuario findByCorreo(String correo);

    Usuario findByIdentificacion(String identificacion);

    @Query("SELECT u FROM Usuario u WHERE u.activo = true")
    List<Usuario> buscarUsuariosActivos();

}
