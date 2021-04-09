package com.abcompany.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.abcompany.model.Profesor;


public interface ProfesorDao extends CrudRepository<Profesor, Integer>{

	Optional<Profesor> findByUsername(String username);
	
}
