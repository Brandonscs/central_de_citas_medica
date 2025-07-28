package com.medicitas.app.controlador;

import com.medicitas.app.modelo.EstadoCita;
import com.medicitas.app.repositorio.EstadoCitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estado-cita/")
@CrossOrigin(origins = "http://localhost:4200/")
public class EstadoCitaController {

    @Autowired
    private EstadoCitaRepository estadoCitaRepository;

    @GetMapping("/obtenerTodos")
    public List<EstadoCita> obtenerTodos() {

        List<EstadoCita> listaEstdadoCita = this.estadoCitaRepository.findAll();

        return listaEstdadoCita;
    }

    @GetMapping("/obtenerPorId")
    public Optional<EstadoCita> obtenerPorId(@RequestParam("idEstado") Long idEstado) {

        Optional<EstadoCita> estadoCita = this.estadoCitaRepository.findById(idEstado);

        if (estadoCita.isPresent()) {
            return estadoCita;
        } else {
            return Optional.empty();
        }
    }

    @PostMapping("/crear")
    public Optional<EstadoCita> crear(@RequestBody EstadoCita estado) {

        Optional<EstadoCita> estadoCita = Optional.of(this.estadoCitaRepository.save(estado));

        if (estadoCita.isPresent()) {
            return estadoCita;
        } else {
            return Optional.empty();
        }

    }

    @PutMapping("/actualizar")
    public Optional<EstadoCita> actualizar(@RequestParam("idEstado") Long idEstado,
                                           @RequestParam("nombre") String nombre,
                                           @RequestParam("descripcion") String descripcion) {

        Optional<EstadoCita> estadoCitaOp = this.estadoCitaRepository.findById(idEstado);

        if (estadoCitaOp.isPresent()) {
            EstadoCita estadoCita = estadoCitaOp.get();
            estadoCita.setNombre(nombre);
            estadoCita.setDescripcion(descripcion);

            this.estadoCitaRepository.save(estadoCita);

            return Optional.of(estadoCita);
        } else {
            return Optional.empty();
        }
    }

    @GetMapping("/buscarEstadoPorNombre")
    public Optional<EstadoCita> buscarEstadoPorNombre(@RequestParam("nombre") String nombre) {

        Optional<EstadoCita> estadoCita = this.estadoCitaRepository.buscarEstadoPorNombre(nombre);

        if (estadoCita.isPresent()) {
            return estadoCita;
        } else {
            return Optional.empty();
        }
    }
}
