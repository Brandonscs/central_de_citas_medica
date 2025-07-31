package com.medicitas.app.controlador;

import com.medicitas.app.modelo.Medico;
import com.medicitas.app.repositorio.medicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import com.medicitas.app.modelo.Especialidad;
import com.medicitas.app.modelo.Usuario;
import com.medicitas.app.repositorio.especialidadRepositorio;
import com.medicitas.app.repositorio.UsuarioRepository;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private medicoRepositorio medicoRepository;
    
    @Autowired
    private especialidadRepositorio especialidadRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @GetMapping
    public List<Medico> obtenerTodosLosMedicos() {
        return medicoRepository.findAll();
    }

    @GetMapping("/obtenerMedicoPorId")
    public ResponseEntity<Medico> obtenerMedicoPorId(@RequestParam Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        return medico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/crearMedico")
    public ResponseEntity<?> crearMedico(@RequestBody Medico medicoRequest) {
        
        if (medicoRequest.getIdUsuario() == null || medicoRequest.getIdUsuario().getId() == null) {
            return ResponseEntity.badRequest().body("El ID de usuario es requerido");
        }
        Optional<Usuario> usuarioOp = usuarioRepositorio.findById(medicoRequest.getIdUsuario().getId());
        if (!usuarioOp.isPresent()) {
            return ResponseEntity.badRequest().body("Usuario no encontrado");
        }

        
        if (medicoRequest.getIdEps() == null || medicoRequest.getIdEps().getId() == null) {
            return ResponseEntity.badRequest().body("El ID de EPS es requerido");
        }
        Optional<EPS> epsOp = epsRepository.findById(medicoRequest.getIdEps().getId());
        if (!epsOp.isPresent()) {
            return ResponseEntity.badRequest().body("EPS no encontrada");
        }

        
        if (medicoRequest.getIdEspecialidad() == null || medicoRequest.getIdEspecialidad().getId() == null) {
            return ResponseEntity.badRequest().body("El ID de especialidad es requerido");
        }
        Optional<Especialidad> especialidadOp = especialidadRepository.findById(medicoRequest.getIdEspecialidad().getId());
        if (!especialidadOp.isPresent()) {
            return ResponseEntity.badRequest().body("Especialidad no encontrada");
        }

        
        Medico medico = new Medico();
        medico.setNombre(medicoRequest.getNombre());
        medico.setIdentificacion(medicoRequest.getIdentificacion());
        medico.setTelefono(medicoRequest.getTelefono());
        medico.setCorreo(medicoRequest.getCorreo());
        medico.setUsuario(usuarioOp.get());
        medico.setEps(epsOp.get());
        medico.setEspecialidad(especialidadOp.get());
        medico.setFechaRegistro(new Date());
        medico.setActivo(true);

        Medico medicoGuardado = medicoRepository.save(medico);
        return ResponseEntity.ok(medicoGuardado);
    }

    @PutMapping("/actualizarMedico")
    public ResponseEntity<?> actualizarMedico(@RequestParam Long id, @RequestBody Medico medicoActualizado) {
        return medicoRepository.findById(id)
                .map(medico -> {
                    
                    medico.setNombre(medicoActualizado.getNombre());
                    medico.setIdentificacion(medicoActualizado.getIdentificacion());
                    medico.setTelefono(medicoActualizado.getTelefono());
                    medico.setCorreo(medicoActualizado.getCorreo());
                    
                    
                    if (medicoActualizado.getEps() != null && medicoActualizado.getEps().getId() != null) {
                        epsRepository.findById(medicoActualizado.getEps().getId())
                                     .ifPresent(medico::setEps);
                    }
                    
                    
                    if (medicoActualizado.getIdEspecialidad() != null && medicoActualizado.getIdEspecialidad().getId() != null) {
                        especialidadRepositorio.findById(medicoActualizado.getIdEspecialidad().getId())
                                              .ifPresent(medico::setIdEspecialidad);
                    }
                    
                    
                    if (medicoActualizado.getIdUsuario() != null && medicoActualizado.getIdUsuario().getId() != null) {
                        usuarioRepository.findById(medicoActualizado.getIdUsuario().getId())
                                         .ifPresent(medico::setUsuario);
                    }
                    
                    return ResponseEntity.ok(medicoRepository.save(medico));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminarMedico")
    public ResponseEntity<Void> eliminarMedico(@RequestParam Long id) {
        return medicoRepository.findById(id)
                .map(medico -> {
                    medico.setActivo(false); 
                    medicoRepository.save(medico);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscarPorEPS")
    public List<Medico> buscarPorEPS(@RequestParam Long idEps) {
        return medicoRepository.buscarMedicosPorEPS(idEps);
    }

    @GetMapping("/buscarPorEspecialidad")
    public List<Medico> buscarPorEspecialidad(@RequestParam Long idEspecialidad) {
        return medicoRepository.buscarMedicosPorEspecialidad(idEspecialidad);
    }

    @GetMapping("/buscarPorIdentificacion")
    public ResponseEntity<Medico> buscarPorIdentificacion(@RequestParam String identificacion) {
        return Optional.ofNullable(medicoRepository.buscarMedicosPorIdentificacion(identificacion))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}