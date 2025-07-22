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
@Table(name = "usuario")
public class Usuario {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombreCompleto", nullable = false)
    private String nombreCompleto;

    @Column(name = "identificacion", unique = true, nullable = false)
    private String identificacion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "correo", unique = true, nullable = false)
    private String correo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimiento")
    private Date fechaNacimiento;

    @Column(name = "rh")
    private String rh;

    @Column(name = "password")
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @Column(name = "activo")
    private boolean activo;


	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Usuario(String nombreCompleto, String identificacion, String telefono, String direccion, String correo,
			Date fechaNacimiento, String rh, String password, Date fechaRegistro, boolean activo) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.identificacion = identificacion;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
		this.fechaNacimiento = fechaNacimiento;
		this.rh = rh;
		this.password = password;
		this.fechaRegistro = fechaRegistro;
		this.activo = activo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombreCompleto() {
		return nombreCompleto;
	}


	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	public String getIdentificacion() {
		return identificacion;
	}


	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getRh() {
		return rh;
	}


	public void setRh(String rh) {
		this.rh = rh;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}
    
    
	

}
