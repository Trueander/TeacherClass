package com.abcompany.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcompany.dao.ClaseDao;
import com.abcompany.model.Clase;

@Service
public class ClaseServiceImpl implements ClaseService {

	@Autowired
	private ClaseDao claseDao;
	
	@Override
	@Transactional(readOnly = false)
	public void save(Clase clase) {
		claseDao.save(clase);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_clase) {
		claseDao.delete(findById(id_clase));
	}

	@Override
	@Transactional
	public Collection<Clase> findAll() {
		return (Collection<Clase>) claseDao.findAll();
	}

	@Override
	@Transactional
	public Clase findById(Integer id_clase) {
		return claseDao.findById(id_clase).orElse(null);
	}

	@Override
	@Transactional
	public boolean isExist(Integer id_clase) {
		return claseDao.existsById(id_clase);
	}

}
