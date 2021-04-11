package com.abcompany.service;

import java.util.Collection;

import com.abcompany.model.Grado;

public interface GradoService {

	public abstract Collection<Grado> findAll();
	public abstract Grado findById(Integer id_grado);
	public abstract void insertar(Grado grado);
	public abstract void eliminar(Integer id_grado);
}
