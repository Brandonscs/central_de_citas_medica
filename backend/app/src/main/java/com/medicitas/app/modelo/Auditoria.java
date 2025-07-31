package com.medicitas.app.modelo;

import java.util.Date;

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
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_auditoria")
    private Long id;

    @Column(name = "tabla_afectada")
    private String tablaAfectada;

    @Column(nullable = false)
    private String accion;

    @Column(name = "id_registro")
    private Long idRegistro;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "fecha_accion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAccion;

    @Column(name = "datos_anteriores", columnDefinition = "TEXT")
    private String datosAnteriores;

    @Column(name = "datos_nuevos", columnDefinition = "TEXT")
    private String datosNuevos;


    // Constructor sin ID
    public Auditoria() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Auditoria(String tablaAfectada, String accion, Long idRegistro, Usuario usuario, Date fechaAccion,
			String datosAnteriores, String datosNuevos) {
		super();
		this.tablaAfectada = tablaAfectada;
		this.accion = accion;
		this.idRegistro = idRegistro;
		this.usuario = usuario;
		this.fechaAccion = fechaAccion;
		this.datosAnteriores = datosAnteriores;
		this.datosNuevos = datosNuevos;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTablaAfectada() {
		return tablaAfectada;
	}


	public void setTablaAfectada(String tablaAfectada) {
		this.tablaAfectada = tablaAfectada;
	}


	public String getAccion() {
		return accion;
	}


	public void setAccion(String accion) {
		this.accion = accion;
	}


	public Long getIdRegistro() {
		return idRegistro;
	}


	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Date getFechaAccion() {
		return fechaAccion;
	}


	public void setFechaAccion(Date fechaAccion) {
		this.fechaAccion = fechaAccion;
	}


	public String getDatosAnteriores() {
		return datosAnteriores;
	}


	public void setDatosAnteriores(String datosAnteriores) {
		this.datosAnteriores = datosAnteriores;
	}


	public String getDatosNuevos() {
		return datosNuevos;
	}


	public void setDatosNuevos(String datosNuevos) {
		this.datosNuevos = datosNuevos;
	}
    
    

}