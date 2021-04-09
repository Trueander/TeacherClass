package com.abcompany.service;

import java.util.Collection;
import java.util.Optional;

import com.abcompany.model.Profesor;


public interface ProfesorService {

	
	public abstract void save(Profesor profesor);
	public abstract void delete(Integer id_profesor);
	Optional<Profesor> findByUsername(String username);
	
	public abstract Collection<Profesor> findAll();
	public abstract Profesor findById(Integer id_profesor);
	public abstract boolean isExist(Integer id_profesor);
}
