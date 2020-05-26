package com.uca.capas.parcial2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.parcial2.dao.CategoriaDAO;
import com.uca.capas.parcial2.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	@Autowired
	CategoriaDAO categoriaDAO;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDAO.findAll();
	}
	
	@Override
	public Categoria findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDAO.findOne(code);
	}
	
	@Override
	@Transactional
	public void save(Categoria categoria) throws DataAccessException {
		categoriaDAO.save(categoria);
		
	}

}
