package com.medicitas.app.controlador;

import com.medicitas.app.modelo.Cita;
import com.medicitas.app.repositorio.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cita/")
@CrossOrigin(origins = "http://localhost:4200/")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    @GetMapping("/buscarCitasPendientesPorUsuario")
    public List<Cita> buscarCitasPendientesPorUsuario(@RequestParam("idUsuario") Long idUsuario) {

        List<Cita> listaCitas = this.citaRepository.buscarCitasPendientesPorUsuario(idUsuario);

        return  listaCitas;
    }

    @GetMapping("/buscarUltimaCitaPorUsuario")
    public Optional<Cita> buscarUltimaCitaPorUsuario(@RequestParam("idUsuario") Long idUsuario) {

        Optional<Cita> cita = this.citaRepository.buscarUltimaCitaPorUsuario(idUsuario);

        if (cita != null) {
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
