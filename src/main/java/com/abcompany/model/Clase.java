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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clases")
public class Clase implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_clase;

	private String nombre;

	private Integer puntosClase;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_profesor", nullable = false)
	private Profesor profesor;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "estudiante_clase", joinColumns = @JoinColumn(name = "id_clase"), inverseJoinColumns = @JoinColumn(name = "id_estudiante"))
	private Set<Estudiante> estudianteList = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grado", nullable = false)
	private Grado grado;

	@OneToMany(mappedBy = "clase", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Collection<Premio> premioList = new ArrayList<Premio>();

	public Clase() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId_clase() {
		return id_clase;
	}

	public void setId_clase(Integer id_clase) {
		this.id_clase = id_clase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Set<Estudiante> getEstudianteList() {
		return estudianteList;
	}

	public void setEstudianteList(Set<Estudiante> estudianteList) {
		this.estudianteList = estudianteList;
	}

	public Integer getPuntosClase() {
		return puntosClase;
	}

	public void setPuntosClase(Integer puntosClase) {
		this.puntosClase = puntosClase;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Collection<Premio> getPremioList() {
		return premioList;
	}

	public void setPremioList(Collection<Premio> premioList) {
		this.premioList = premioList;
	}

	private static final long serialVersionUID = 1L;
}
