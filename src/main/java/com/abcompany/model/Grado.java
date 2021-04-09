package com.abcompany.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "grados")
public class Grado implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_grado;
	private String nombre;
	
	@OneToMany(mappedBy = "grado",fetch = FetchType.LAZY)
	private Collection<Clase> claseList = new ArrayList<>();
	
	public Grado() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId_grado() {
		return id_grado;
	}


	public void setId_grado(Integer id_grado) {
		this.id_grado = id_grado;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Clase> getClaseList() {
		return claseList;
	}

	public void setClaseList(Collection<Clase> claseList) {
		this.claseList = claseList;
	}





	private static final long serialVersionUID = 1L;

	
}
