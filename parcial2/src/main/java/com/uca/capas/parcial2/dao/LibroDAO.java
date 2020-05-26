package com.uca.capas.parcial2.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.parcial2.domain.Libro;



public interface LibroDAO {
	public List<Libro> findAll() throws DataAccessException;
	//public Estudiante findOne(Integer code) throws DataAccessException;
	//public void insert(Estudiante estudiante) throws DataAccessException;
	public void save(Libro libro) throws DataAccessException;
	//public void delete(Integer codigoEstudiante)throws DataAccessException;

}
