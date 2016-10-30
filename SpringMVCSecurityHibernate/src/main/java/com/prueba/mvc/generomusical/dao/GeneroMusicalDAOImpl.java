/**
 * 
 */
package com.prueba.mvc.generomusical.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prueba.mvc.generomusical.domain.GeneroMusical;

@Repository
public class GeneroMusicalDAOImpl implements GeneroMusicalDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(GeneroMusicalDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createGeneroMusical(GeneroMusical generoMusical) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(generoMusical);
		logger.info("Genero Musical saved successfuly, Genero Musical Details = " + generoMusical);
	}
	
	@Override
	public void updateGeneroMusical(GeneroMusical generoMusical) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(generoMusical);
		logger.info("Genero Musical updated successfully, Genero Musical Details = " + generoMusical);
	}
	
	@Override
	public GeneroMusical getGeneroMusicalById(int id) {
		Session session = this.sessionFactory.getCurrentSession();	
		GeneroMusical current_generoMusical = (GeneroMusical) session.get(GeneroMusical.class, new Integer(id));
		return current_generoMusical;
	}
	
	@Override
	public void removeGeneroMusical(int id) {
		GeneroMusical generoMusical = getGeneroMusicalById(id);
		if(null != generoMusical){
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(generoMusical);
		}
		logger.info("Person deleted successfully, person details = " + generoMusical);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<GeneroMusical> listGenerosMusicales() {
		Session session = this.sessionFactory.getCurrentSession();
		List<GeneroMusical> generoMusicalList = session.createQuery("from GeneroMusical").list();
		return generoMusicalList;
	}
	
	@Override
	public void deleteAllGenerosMusicales() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete GeneroMusical");
		query.executeUpdate();
	}


}
