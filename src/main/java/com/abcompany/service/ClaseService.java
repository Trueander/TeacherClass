package com.abcompany.service;

import java.util.Collection;

import com.abcompany.model.Clase;

public interface ClaseService {
	
	public abstract void save(Clase clase);
	public abstract void delete(Integer id_clase);
	
	public abstract Collection<Clase> findAll();
	public abstract Clase findById(Integer id_clase);
	public abstract boolean isExist(Integer id_clase);
}
