//package com.example.demo.modelo;

package com.medicitas.app.modelo;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol_permiso")
public class RolPermiso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idRol", referencedColumnName = "id")
	private Rol idRol;
	
	@ManyToOne
	@JoinColumn(name = "idPermiso", referencedColumnName = "id")
	private Permiso idPermiso;
	
	@Column(name = "fechaAsignacion")
	private Date fechaAsignacion;
	
	@Column(name = "activo")
	private boolean activo;

	
	
	public RolPermiso() {
		super();
	}

	
	public RolPermiso(Rol idRol, Permiso idPermiso) {
		super();
		this.idRol = idRol;
		this.idPermiso = idPermiso;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Rol getIdRol() {
		return idRol;
	}


	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}


	public Permiso getIdPermiso() {
		return idPermiso;
	}


	public void setIdPermiso(Permiso idPermiso) {
		this.idPermiso = idPermiso;
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
	
	
	
	

}
