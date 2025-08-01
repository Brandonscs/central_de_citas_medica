package com.medicitas.app.controlador;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medicitas.app.repositorio.CitaRepository;
import com.medicitas.app.repositorio.disponibilidadRepositorio;
import com.medicitas.app.repositorio.medicoRepositorio;
import com.medicitas.app.modelo.Disponibilidad;
import com.medicitas.app.modelo.Medico;

@RestController
@RequestMapping("/disponibilidad")
public class DisponibilidadController {
	
	 @Autowired
	    private disponibilidadRepositorio disponibilidadRepository;
	    
	    @Autowired
	    private medicoRepositorio medicoRepository;

	    @GetMapping("/obtenerTodasLasDisponibilidades")
	    public List<Disponibilidad> obtenerTodasLasDisponibilidades() {
	        return disponibilidadRepository.findAll();
	    }

	    @GetMapping("/obtenerDisponibilidadPorId")
	    public ResponseEntity<Disponibilidad> obtenerDisponibilidadPorId(@RequestParam Long id) {
	        Optional<Disponibilidad> disponibilidad = disponibilidadRepository.findById(id);
	        return disponibilidad.map(ResponseEntity::ok)
	                            .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PostMapping("/crearDisponibilidad")
	    public ResponseEntity<?> crearDisponibilidad(@RequestBody Disponibilidad disponibilidadRequest) {
	       
	        if (disponibilidadRequest.getMedico() == null || disponibilidadRequest.getMedico().getId() == null) {
	            return ResponseEntity.badRequest().body("El ID de médico es requerido");
	        }
	        Optional<Medico> medicoOp = medicoRepository.findById(disponibilidadRequest.getMedico().getId());
	        if (!medicoOp.isPresent()) {
	            return ResponseEntity.badRequest().body("Médico no encontrado");
	        }
	        
	        
	        if (disponibilidadRequest.getHoraFin().before(disponibilidadRequest.getHoraInicio())) {
	            return ResponseEntity.badRequest().body("La hora de fin debe ser posterior a la hora de inicio");
	        }
	        
	        
	        Disponibilidad disponibilidad = new Disponibilidad();
	        disponibilidad.setMedico(medicoOp.get());
	        disponibilidad.setFecha(disponibilidadRequest.getFecha());
	        disponibilidad.setHoraInicio(disponibilidadRequest.getHoraInicio());
	        disponibilidad.setHoraFin(disponibilidadRequest.getHoraFin());
	        disponibilidad.setDisponible(disponibilidadRequest.isDisponible());
	        disponibilidad.setObservaciones(disponibilidadRequest.getObservaciones());
	        
	        Disponibilidad guardada = disponibilidadRepository.save(disponibilidad);
	        return ResponseEntity.ok(guardada);
	    }

	    @PutMapping("/actualizarDisponibilidad")
	    public ResponseEntity<?> actualizarDisponibilidad(@RequestParam Long id, 
	                                                     @RequestBody Disponibilidad disponibilidadRequest) {
	        return disponibilidadRepository.findById(id)
	                .map(disponibilidad -> {
	                    
	                    if (disponibilidadRequest.getHoraFin().before(disponibilidadRequest.getHoraInicio())) {
	                        return ResponseEntity.badRequest().body("La hora de fin debe ser posterior a la hora de inicio");
	                    }
	                    
	                    
	                    if (disponibilidadRequest.getMedico() != null && disponibilidadRequest.getMedico().getId() != null) {
	                        Optional<Medico> medicoOp = medicoRepository.findById(disponibilidadRequest.getMedico().getId());
	                        medicoOp.ifPresent(disponibilidad::setMedico);
	                    }
	                    
	                    disponibilidad.setFecha(disponibilidadRequest.getFecha());
	                    disponibilidad.setHoraInicio(disponibilidadRequest.getHoraInicio());
	                    disponibilidad.setHoraFin(disponibilidadRequest.getHoraFin());
	                    disponibilidad.setDisponible(disponibilidadRequest.isDisponible());
	                    disponibilidad.setObservaciones(disponibilidadRequest.getObservaciones());
	                    
	                    return ResponseEntity.ok(disponibilidadRepository.save(disponibilidad));
	                })
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @DeleteMapping("/eliminarDisponibilidad")
	    public ResponseEntity<?> eliminarDisponibilidad(@RequestParam Long id) {
	        return disponibilidadRepository.findById(id)
	                .map(disponibilidad -> {
	                   
	      	                    
	                    disponibilidadRepository.delete(disponibilidad);
	                    return ResponseEntity.ok().build();
	                })
	                .orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @GetMapping("/buscarPorMedico")
	    public List<Disponibilidad> buscarPorMedico(@RequestParam Long idMedico) {
	        return disponibilidadRepository.buscarDisponibilidadPorMedico(idMedico);
	    }

	    @GetMapping("/buscarPorFecha")
	    public List<Disponibilidad> buscarPorFecha(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
	        return disponibilidadRepository.buscarDisponibilidadPorFecha(fecha);
	    }

	    @GetMapping("/buscarPorMedicoYFecha")
	    public List<Disponibilidad> buscarPorMedicoYFecha(@RequestParam Long idMedico, 
	                                                     @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha) {
	        return disponibilidadRepository.buscarDisponibilidadPorMedicoYFecha(idMedico, fecha);
	    }
}
