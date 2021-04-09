package com.abcompany.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abcompany.dao.PremioDao;
import com.abcompany.model.Premio;


@Service
public class PremioServiceImpl implements PremioService{

	@Autowired
	private PremioDao premioDao;
	
	@Override
	@Transactional
	public Collection<Premio> findAll() {
		return (Collection<Premio>) premioDao.findAll();
	}

	@Override
	@Transactional
	public Premio findById(Integer id_premio) {
		return premioDao.findById(id_premio).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public void save(Premio premio) {
		premioDao.save(premio);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Integer id_premio) {
		premioDao.delete(findById(id_premio));
	}

}
