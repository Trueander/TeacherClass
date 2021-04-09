package com.abcompany.service;

import java.util.Collection;

import com.abcompany.model.Estudiante;

public interface EstudianteService {

	public abstract void save(Estudiante estudiante);
	public abstract void delete(Integer id_estudiante);
	
	public abstract Collection<Estudiante> findAll();
	public abstract Estudiante findById(Integer id_estudiante);
	public abstract boolean isExist(Integer id_estudiante);
}
