package com.medicitas.app.modelo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "rol")
public class Rol {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    private boolean activo;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @OneToMany(mappedBy = "rol")
    @JsonManagedReference("rol-rolUsuario")
    private List<RolUsuario> rolUsuarios;
    
   
    
	public Rol() {
		super();
		this.fechaCreacion = new Date();
        this.activo = true;
		// TODO Auto-generated constructor stub
	}

	public Rol(String nombre, String descripcion, List<RolUsuario> rolUsuarios) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.rolUsuarios = rolUsuarios;
		this.fechaCreacion = new Date();
        this.activo = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<RolUsuario> getRolUsuarios() {
		return rolUsuarios;
	}

	public void setRolUsuarios(List<RolUsuario> rolUsuarios) {
		this.rolUsuarios = rolUsuarios;
	}
	
	
}
