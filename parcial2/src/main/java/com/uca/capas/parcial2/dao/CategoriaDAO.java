package com.uca.capas.parcial2.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.Categoria;
import com.uca.capas.parcial2.domain.Libro;



public interface CategoriaDAO {
	public List<Categoria> findAll() throws DataAccessException;
	public Categoria findOne(Integer code) throws DataAccessException;
	public void save(Categoria categoria) throws DataAccessException;

}
