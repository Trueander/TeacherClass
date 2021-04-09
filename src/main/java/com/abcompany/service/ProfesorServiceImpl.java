package com.abcompany.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcompany.dao.ProfesorDao;
import com.abcompany.model.Profesor;

@Service
public class ProfesorServiceImpl implements ProfesorService{
 
	@Autowired
	private ProfesorDao profesorDao;
	
	@Override
	@Transactional(readOnly = false)
	public void save(Profesor profesor) {
		profesorDao.save(profesor);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_profesor) {
		profesorDao.delete(findById(id_profesor));
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Profesor> findAll() {
		return (Collection<Profesor>) profesorDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Profesor findById(Integer id_profesor) {
		return profesorDao.findById(id_profesor).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isExist(Integer id_profesor) {
		return profesorDao.existsById(id_profesor);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Profesor> findByUsername(String username) {
		return profesorDao.findByUsername(username);
	}

}
