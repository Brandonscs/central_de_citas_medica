package com.medicitas.app.controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medicitas.app.modelo.Auditoria;
import com.medicitas.app.modelo.Usuario;
import com.medicitas.app.repositorio.AuditoriaRepository;
import com.medicitas.app.repositorio.UsuarioRepository;

@RestController
@RequestMapping("/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/listar")
    public List<Auditoria> obtenerTodasLasAuditorias() {
        return auditoriaRepository.findAll();
    }

    @GetMapping("/buscarPorId")
    public Auditoria obtenerAuditoriaPorId(@RequestParam("idAuditoria") Long idAuditoria) {
        Optional<Auditoria> auditoria = auditoriaRepository.findById(idAuditoria);
        return auditoria.orElse(null);
    }

    @PostMapping("/crear")
    public Auditoria crearAuditoria(@RequestParam("idUsuario") Long idUsuario, @RequestBody Auditoria auditoria) {

        Optional<Usuario> usuario = usuarioRepository.findById(idUsuario);
        if (usuario.isPresent()) {
            auditoria.setUsuario(usuario.get());
            auditoria.setFechaAccion(new Date());
            return auditoriaRepository.save(auditoria);
        } else {
            return null;
        }
    }

    @GetMapping("/buscarPorTabla")
    public List<Auditoria> buscarAuditoriaPorTabla(@RequestParam("tabla") String tabla) {
        return auditoriaRepository.buscarAuditoriaPorTabla(tabla);
    }

    @GetMapping("/buscarPorUsuario")
    public List<Auditoria> buscarAuditoriaPorUsuario(@RequestParam("idUsuario") Long idUsuario) {
        return auditoriaRepository.buscarAuditoriaPorUsuario(idUsuario);
    }

    @GetMapping("/buscarPorAccion")
    public List<Auditoria> buscarAuditoriaPorAccion(@RequestParam("accion") String accion) {
        return auditoriaRepository.buscarAuditoriaPorAccion(accion);
    }
    
    @GetMapping("/buscarPorFecha")
    public List<Auditoria> buscarPorFecha(@RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date fechaInicio = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date fechaFin = calendar.getTime();

        return auditoriaRepository.buscarAuditoriaPorRangoFecha(fechaInicio, fechaFin);
    }
    
    
}