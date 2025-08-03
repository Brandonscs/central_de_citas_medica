package com.medicitas.app.controlador;

import java.util.Date;
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

import com.medicitas.app.modelo.EPS;
import com.medicitas.app.repositorio.EpsRepository;

@RestController
@RequestMapping("/eps")
public class EPSController {

    @Autowired
    private EpsRepository epsRepository;

    @GetMapping("/listarEPS")
    public List<EPS> obtenerTodasLasEPS() {
        return epsRepository.findAll();
    }

    @GetMapping("/buscarPorId")
    public EPS obtenerEPSPorId(@RequestParam Long id) {
        return epsRepository.findById(id).orElse(null);
    }

    @PostMapping("/crearEPS")
    public EPS crearEPS(@RequestBody EPS eps) {
        eps.setFechaCreacion(new Date());
        eps.setActivo(true);
        return epsRepository.save(eps);
    }

    @PutMapping("/actualizarEPS")
    public EPS actualizarEPS(@RequestParam Long id, @RequestBody EPS epsActualizada) {
        Optional<EPS> epsExistente = epsRepository.findById(id);
        if (epsExistente.isPresent()) {
            EPS eps = epsExistente.get();
            eps.setNombre(epsActualizada.getNombre());
            eps.setNit(epsActualizada.getNit());
            eps.setTelefono(epsActualizada.getTelefono());
            eps.setDireccion(epsActualizada.getDireccion());
            eps.setEmail(epsActualizada.getEmail());
            eps.setActivo(epsActualizada.isActivo());
            return epsRepository.save(eps);
        } else {
            return null;
        }
    }

    @DeleteMapping("/eliminarEPS")
    public void eliminarEPS(@RequestParam Long id) {
        epsRepository.deleteById(id);
    }

    @GetMapping("/buscarPorNit")
    public EPS buscarEPSPorCodigo(@RequestParam String nit) {
        return epsRepository.findByNit(nit);
    }

    @GetMapping("/listarEPSActivas")
    public List<EPS> obtenerEPSActivas() {
        return epsRepository.buscarEPSActivas();
    }
}
