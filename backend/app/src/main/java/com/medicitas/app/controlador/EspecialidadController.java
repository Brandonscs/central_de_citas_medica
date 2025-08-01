package com.medicitas.app.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medicitas.app.modelo.Especialidad;
import com.medicitas.app.repositorio.especialidadRepositorio;
import com.medicitas.app.repositorio.medicoRepositorio;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

	@Autowired
    private  especialidadRepositorio especialidadRepository;
	
	@Autowired
    private  medicoRepositorio medicoRepository;

    

    @GetMapping
    public List<Especialidad> obtenerTodasLasEspecialidades() {
        return especialidadRepository.findAll();
    }

    @GetMapping("/obtenerEspecialidadPorId")
    public ResponseEntity<Especialidad> obtenerEspecialidadPorId(@RequestParam Long id) {
        Optional<Especialidad> especialidad = especialidadRepository.findById(id);
        return especialidad.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/crearEspecialidad")
    public ResponseEntity<?> crearEspecialidad(@RequestBody Especialidad especialidadRequest) {
       
        if (especialidadRepository.existsByNombre(especialidadRequest.getNombre())) {
            return ResponseEntity.badRequest().body("Ya existe una especialidad con ese nombre");
        }
        
        Especialidad especialidad = new Especialidad();
        especialidad.setNombre(especialidadRequest.getNombre());
        especialidad.setDescripcion(especialidadRequest.getDescripcion());
        especialidad.setActivo(true);
        
        Especialidad especialidadGuardada = especialidadRepository.save(especialidad);
        return ResponseEntity.ok(especialidadGuardada);
    }

    @PutMapping("/actualizarEspecialidad")
    public ResponseEntity<?> actualizarEspecialidad(@RequestParam Long id, 
                                                  @RequestBody Especialidad especialidadRequest) {
        return especialidadRepository.findById(id)
                .map(especialidadExistente -> {
                    
                    if (!especialidadExistente.getNombre().equals(especialidadRequest.getNombre())) {
                        if (especialidadRepository.existsByNombre(especialidadRequest.getNombre())) {
                            return ResponseEntity.badRequest().body("Ya existe una especialidad con ese nombre");
                        }
                    }
                    
                    especialidadExistente.setNombre(especialidadRequest.getNombre());
                    especialidadExistente.setDescripcion(especialidadRequest.getDescripcion());
                    return ResponseEntity.ok(especialidadRepository.save(especialidadExistente));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminarEspecialidad")
    public ResponseEntity<?> eliminarEspecialidad(@RequestParam Long id) {
        return especialidadRepository.findById(id)
                .map(especialidad -> {
                    
                    if (medicoRepository.existsByEspecialidadId(id)) {
                        return ResponseEntity.badRequest().body("No se puede eliminar: hay médicos asociados a esta especialidad");
                    }
                    
                    
                    especialidad.setActivo(false);
                    especialidadRepository.save(especialidad);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/buscarPorNombre")
    public ResponseEntity<Especialidad> buscarPorNombre(@RequestParam String nombre) {
        Especialidad especialidad = especialidadRepository.buscarEspecialidadPorNombre(nombre);
        if (especialidad != null) {
            return ResponseEntity.ok(especialidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarEspecialidadesActivas")
    public List<Especialidad> buscarEspecialidadesActivas() {
        return especialidadRepository.buscarEspecialidadesActivas();
    }
}
