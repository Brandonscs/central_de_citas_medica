package com.medicitas.app.controlador;

import com.medicitas.app.modelo.Cita;
import com.medicitas.app.modelo.Notificacion;
import com.medicitas.app.modelo.Usuario;
import com.medicitas.app.repositorio.CitaRepository;
import com.medicitas.app.repositorio.NotificacionRepository;
import com.medicitas.app.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notificacion/")
@CrossOrigin(origins = "http://localhost:4200/")
public class NotificacionController {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/obtenerTodasLasNotificaciones")
    public List<Notificacion> obtenerTodasLasNotificaciones() {

        List<Notificacion> listaNotificaciones = this.notificacionRepository.findAll();

        return listaNotificaciones;
    }

    @GetMapping("/obtenerNotificacionPorId")
    public Optional<Notificacion> obtenerNotificacionPorId(@RequestParam("idNotifcacion") Long idNotificacion) {

        Optional<Notificacion> notificacion = this.notificacionRepository.findById(idNotificacion);

        if (notificacion.isPresent()) {
            return notificacion;
        } else {
            return Optional.empty();
        }
    }

    @PostMapping("/crearNotificacion")
    public Optional<Notificacion> crearNotificacion(@RequestBody Notificacion notificacionP) {

        Optional<Cita> citaOp = this.citaRepository.findById(notificacionP.getIdCita().getId());
        Optional<Usuario> usuarioOp = this.usuarioRepository.findById(notificacionP.getIdUsuario().getId());

        if (citaOp.isPresent() && usuarioOp.isPresent()) {

            Cita cita = citaOp.get();
            Usuario usuario = usuarioOp.get();

            notificacionP.setIdCita(cita);
            notificacionP.setIdUsuario(usuario);
        }

        Optional<Notificacion> notificacion = Optional.of(this.notificacionRepository.save(notificacionP));

        if (notificacion.isPresent()) {
            return notificacion;
        } else {
            return Optional.empty();
        }
    }

    @GetMapping("/buscarNotificacionesPorUsuario")
    List<Notificacion> buscarNotificacionesPorUsuario(@RequestParam("idUsuario") Long idUsuario) {

        List<Notificacion> listaNotificaciones = this.notificacionRepository.buscarNotificacionesPorUsuario(idUsuario);

        return listaNotificaciones;
    }

    @GetMapping("/buscarNotificacionesPorCita")
    List<Notificacion> buscarNotificacionesPorCita(@RequestParam("idCita") Long idCita) {

        List<Notificacion> listaNotificacion = this.notificacionRepository.buscarNotificacionesPorCita(idCita);

        return listaNotificacion;
    }

    @GetMapping("/buscarNotificacionesPorTipo")
    List<Notificacion> buscarNotificacionesPorTipo(@RequestParam("tipo") String tipo) {

        List<Notificacion> listaNotificacion = this.notificacionRepository.buscarNotificacionesPorTipo(tipo);

        return listaNotificacion;
    }
}
