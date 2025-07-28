package com.medicitas.app.modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "cita")
public class Cita {
    @Id
    @Column(name = "idCita")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne()
    //@JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @Column(name = "idUsuario")
    private Long idUsuario;

    //@ManyToOne()
    //@JoinColumn(name = "idMedico", referencedColumnName = "idMedico")
    @Column(name = "idMedico")
    private Long idMedico;

    //@ManyToOne()
    //@JoinColumn(name = "idEps", referencedColumnName = "idEps")
    @Column(name = "idEps")
    private Long idEps;

    @ManyToOne()
    @JoinColumn(name = "idEstado", referencedColumnName = "idEstado")
    private EstadoCita idEstado;

    @Column(name = "fechaHora")
    private LocalDateTime fechaHora;

    @Column(name = "numeroAutorizacion")
    private String numeroAutorizacion;

    @Column(name = "observaciones")
    private String observaciones;

    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fechaActualizacion")
    private LocalDateTime fechaActualizacion;

    public Cita(Long idMedico, Long idEps, EstadoCita idEstado, LocalDateTime fechaHora, String numeroAutorizacion, String observaciones, LocalDateTime fechaCreacion, LocalDateTime fechaActualizacion) {
        this.idMedico = idMedico;
        this.idEps = idEps;
        this.idEstado = idEstado;
        this.fechaHora = fechaHora;
        this.numeroAutorizacion = numeroAutorizacion;
        this.observaciones = observaciones;
        this.fechaCreacion = fechaCreacion;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Cita() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public Long getIdEps() {
        return idEps;
    }

    public void setIdEps(Long idEps) {
        this.idEps = idEps;
    }

    public EstadoCita getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(EstadoCita idEstado) {
        this.idEstado = idEstado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    public void setNumeroAutorizacion(String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}
