package com.abcompany.service;

import java.util.Collection;


import com.abcompany.model.Premio;


public interface PremioService {

	public abstract void save(Premio premio);
	public abstract void delete(Integer id_premio);
	
	public abstract Collection<Premio> findAll();
	public abstract Premio findById(Integer id_premio);
}
