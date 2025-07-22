package com.medicitas.app.modelo;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "rol_usuario")
public class RolUsuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "id_rol", nullable = false)
    private Long idRol;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_asignacion")
    private Date fechaAsignacion;

    @Column(nullable = false)
    private boolean activo;

    @Column(name = "asignado_por")
    private Long asignadoPor;

	public RolUsuario() {
		super();
		// TODO Auto-generated constructor stub
		this.fechaAsignacion = new Date();
        this.activo = true;
	}

	public RolUsuario(Long idUsuario, Long idRol, Date fechaAsignacion, boolean activo, Long asignadoPor) {
		super();
		this.idUsuario = idUsuario;
		this.idRol = idRol;
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

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
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

	public Long getAsignadoPor() {
		return asignadoPor;
	}

	public void setAsignadoPor(Long asignadoPor) {
		this.asignadoPor = asignadoPor;
	}
    
	
    
}
