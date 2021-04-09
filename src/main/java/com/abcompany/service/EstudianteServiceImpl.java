package com.abcompany.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcompany.dao.EstudianteDao;
import com.abcompany.model.Estudiante;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteDao estudianteDao;
	
	@Override
	@Transactional(readOnly = false)
	public void save(Estudiante estudiante) {
		estudianteDao.save(estudiante);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_estudiante) {
		estudianteDao.delete(findById(id_estudiante));
	}

	@Override
	@Transactional
	public Collection<Estudiante> findAll() {
		return (Collection<Estudiante>) estudianteDao.findAll();
	}

	@Override
	@Transactional
	public Estudiante findById(Integer id_estudiante) {
		return estudianteDao.findById(id_estudiante).orElse(null);
	}

	@Override
	@Transactional
	public boolean isExist(Integer id_estudiante) {
		return estudianteDao.existsById(id_estudiante);
	}

}
