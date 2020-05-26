package com.uca.capas.parcial2.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;


import com.uca.capas.parcial2.dao.LibroDAO;

@Repository
public class LibroDAOImpl implements LibroDAO{
	@PersistenceContext(unitName = "parcial2")
	private EntityManager entityManager;
	
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb =new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query = entityManager.createNativeQuery(sb.toString(),Libro.class);
		List<Libro> resultset =query.getResultList();
		return resultset;
	}
	
	
	@Override
	@Transactional
	public void save(Libro libro) throws DataAccessException {
		try {
			if (libro.getId_libro()==null) {
				entityManager.persist(libro);
			} else {
					entityManager.merge(libro);
					entityManager.flush();
			}
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
		
		
	
	
}
