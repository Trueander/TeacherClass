package com.abcompany.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcompany.dao.GradoDao;
import com.abcompany.model.Grado;

@Service
public class GradoServiceImpl implements GradoService{

	@Autowired
	private GradoDao gradoDao;
	
	@Override
	@Transactional(readOnly = true)
	public Collection<Grado> findAll() {
		return (Collection<Grado>) gradoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Grado findById(Integer id_grado) {
		return gradoDao.findById(id_grado).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public void insertar(Grado grado) {
		gradoDao.save(grado);
	}
}
