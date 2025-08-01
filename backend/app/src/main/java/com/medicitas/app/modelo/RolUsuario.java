package com.medicitas.app.modelo;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "rol_usuario")
public class RolUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonBackReference("usuario-rol")
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JsonBackReference("rol-rolUsuario")
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_asignacion", updatable = false)
    private Date fechaAsignacion;

    @Column(nullable = false)
    private boolean activo;

    @ManyToOne
    @JsonBackReference("asignador-rol")
    @JoinColumn(name = "asignado_por")
    private Usuario asignadoPor;
    

    public RolUsuario() {
        this.fechaAsignacion = new Date();
        this.activo = true;
    }

    public RolUsuario(Usuario usuario, Rol rol, Date fechaAsignacion, boolean activo, Usuario asignadoPor) {
        this.usuario = usuario;
        this.rol = rol;
        this.fechaAsignacion = fechaAsignacion != null ? fechaAsignacion : new Date();
        this.activo = activo;
        this.asignadoPor = asignadoPor;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Usuario getAsignadoPor() {
		return asignadoPor;
	}

	public void setAsignadoPor(Usuario asignadoPor) {
		this.asignadoPor = asignadoPor;
	}

	
}