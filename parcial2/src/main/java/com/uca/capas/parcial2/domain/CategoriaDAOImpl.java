package com.uca.capas.parcial2.domain;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.parcial2.dao.CategoriaDAO;



@Repository
public class CategoriaDAOImpl implements CategoriaDAO {
	@PersistenceContext(unitName = "parcial2")
	private EntityManager entityManager;
	
	
	
	@Override
	public List<Categoria> findAll() throws DataAccessException  {
		StringBuffer sb =new StringBuffer();
		sb.append("select * from public.cat_categoria");
		Query query = entityManager.createNativeQuery(sb.toString(),Categoria.class);
		List<Categoria> resultset =query.getResultList();
		return resultset;
	}
@Override
	public Categoria findOne(Integer code) throws DataAccessException {
	Categoria categoria= entityManager.find(Categoria.class,code);
	
	return categoria;
		
}


@Override
@Transactional
public void save(Categoria categoria) throws DataAccessException {
	try {
		if (categoria.getId_categoria()==null) {
			entityManager.persist(categoria);
		} else {
				entityManager.merge(categoria);
				entityManager.flush();
		}
		
	} catch (Throwable e) {
		e.printStackTrace();
	}
	
}
	


}
