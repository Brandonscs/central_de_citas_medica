package com.medicitas.app.modelo;


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

import java.util.Date;

@Entity
@Table(name = "medico")
public class Medico {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    private String identificacion;
    private String telefono;
    private String correo;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario idUsuario;
    
  
    @Column(name = "id_eps")
    private Long idEps;
    
    @ManyToOne
    @JoinColumn(name = "id_especialidad", referencedColumnName = "id" )
    private Especialidad idEspecialidad;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_registro")
    private Date fechaRegistro;
    
    private boolean activo;

    
    
	public Medico(Long id, String nombre, String identificacion, String telefono, String correo, Usuario idUsuario,
			Long idEps, Especialidad idEspecialidad, Date fechaRegistro, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.telefono = telefono;
		this.correo = correo;
		this.idUsuario = idUsuario;
		this.idEps = idEps;
		this.idEspecialidad = idEspecialidad;
		this.fechaRegistro = fechaRegistro;
		this.activo = activo;
	}
	
	

	public Medico() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdEps() {
		return idEps;
	}

	public void setIdEps(Long idEps) {
		this.idEps = idEps;
	}

	public Especialidad getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Especialidad idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
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
