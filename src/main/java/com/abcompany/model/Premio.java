package com.abcompany.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "premios")
public class Premio implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_premio;
	private String nombre_premio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_clase", nullable = false)
	private Clase clase;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estudiante")
	private Estudiante estudiante;
	
	public Premio() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId_premio() {
		return id_premio;
	}



	public void setId_premio(Integer id_premio) {
		this.id_premio = id_premio;
	}



	public String getNombre_premio() {
		return nombre_premio;
	}



	public void setNombre_premio(String nombre_premio) {
		this.nombre_premio = nombre_premio;
	}



	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}



	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}



	private static final long serialVersionUID = 1L;
}
