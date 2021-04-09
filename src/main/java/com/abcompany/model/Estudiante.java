package com.abcompany.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="estudiantes")
public class Estudiante implements Serializable, Comparable<Estudiante>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_estudiante;
	private String nombre;
	private String apellido;
	private String foto = "/imagenes/monsters/";
	private Integer puntosTotal = 0;
	private Integer puntosFavor = 0;
	private Integer puntosContra = 0;
	
	@ManyToMany(mappedBy = "estudianteList", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Clase> claseList = new HashSet<>();
	
	@OneToMany(mappedBy = "estudiante",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Premio> premioList= new ArrayList<>();
	
	public Estudiante() {}

	public Integer getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(Integer id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Set<Clase> getClaseList() {
		return claseList;
	}
	public void setClaseList(Set<Clase> claseList) {
		this.claseList = claseList;
	}
	
	public Integer getPuntosFavor() {
		return puntosFavor;
	}

	public void setPuntosFavor(Integer puntosFavor) {
		this.puntosFavor = puntosFavor;
	}

	public Integer getPuntosContra() {
		return puntosContra;
	}

	public void setPuntosContra(Integer puntosContra) {
		this.puntosContra = puntosContra;
	}



	public Integer getPuntosTotal() {
		return puntosTotal;
	}


	public void setPuntosTotal(Integer puntosTotal) {
		this.puntosTotal = puntosTotal;
	}

	

	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Collection<Premio> getPremioList() {
		return premioList;
	}


	public void setPremioList(Collection<Premio> premioList) {
		this.premioList = premioList;
	}



	private static final long serialVersionUID = 1L;

	@Override
	public int compareTo(Estudiante o) {
		
		return id_estudiante.compareTo(o.getId_estudiante());
	}
	
}
