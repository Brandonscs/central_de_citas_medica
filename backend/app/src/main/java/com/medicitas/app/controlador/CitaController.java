package com.medicitas.app.controlador;

import com.medicitas.app.modelo.Cita;
import com.medicitas.app.modelo.EstadoCita;
import com.medicitas.app.repositorio.CitaRepository;
import com.medicitas.app.repositorio.EstadoCitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cita/")
@CrossOrigin(origins = "http://localhost:4200/")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private EstadoCitaRepository estadoCitaRepository;

    @GetMapping("/obtenerTodasLasCitas")
    public List<Cita> obtenerTodasLasCitas() {

        List<Cita> listaCita = this.citaRepository.findAll();

        return listaCita;
    }

    @GetMapping("/obtenerCitaPorId")
    public Optional<Cita> obtenerCitaPorId(@RequestParam("idCita") Long idCita) {

        Optional<Cita> cita = this.citaRepository.findById(idCita);

        if (cita.isPresent()) {
            return cita;
        } else {
            return Optional.empty();
        }
    }

    @PostMapping("/crearCita")
    public Optional<Cita> crearCita(@RequestBody Cita citaP) {

        Optional<EstadoCita> estadoCitaOp = this.estadoCitaRepository.findById(citaP.getIdEstado().getId());

        if (estadoCitaOp.isPresent()) {

            EstadoCita estadoCita = estadoCitaOp.get();

            citaP.setIdEstado(estadoCita);
        }

        Optional<Cita> cita = Optional.of(this.citaRepository.save(citaP));

        if (cita.isPresent()){

            return cita;
        } else {
            return Optional.empty();
        }
    }

    @GetMapping("/buscarCitasPendientesPorUsuario")
    public List<Cita> buscarCitasPendientesPorUsuario(@RequestParam("idUsuario") Long idUsuario) {

        List<Cita> listaCitas = this.citaRepository.buscarCitasPendientesPorUsuario(idUsuario);

        return  listaCitas;
    }

    @GetMapping("/buscarUltimaCitaPorUsuario")
    public Optional<Cita> buscarUltimaCitaPorUsuario(@RequestParam("idUsuario") Long idUsuario) {

        Optional<Cita> cita = this.citaRepository.buscarUltimaCitaPorUsuario(idUsuario);

        if (cita.isPresent()) {
            return cita;
        } else {
            return Optional.empty();
        }
    }

    @GetMapping ("/buscarCitasPorMedico")
    public List<Cita> buscarCitasPorMedico(@RequestParam("idMedico") Long idMedico) {

        List<Cita> listaCitas = this.citaRepository.buscarCitasPorMedico(idMedico);

        return listaCitas;
    }

    @GetMapping ("/buscarCitasPorEstado")
    public List<Cita> buscarCitasPorEstado(@RequestParam("idEstado") Long idEstado) {

        List<Cita> listaCitas = this.citaRepository.buscarCitasPorEstado(idEstado);

        return listaCitas;
    }

    @GetMapping("/buscarCitasPorFecha")
    public List<Cita> buscarCitasPorFecha(@RequestParam("fecha") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime fecha) {

        List<Cita> listaCitas = this.citaRepository.buscarCitasPorFecha(fecha);
        
        return listaCitas;
    }
}
