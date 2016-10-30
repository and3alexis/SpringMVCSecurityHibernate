/**
 * 
 */
package com.prueba.mvc.generomusical.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prueba.mvc.generomusical.domain.GeneroMusical;

@Repository
public class GeneroMusicalDAOImpl implements GeneroMusicalDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void createGeneroMusical(GeneroMusical generoMusical) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(generoMusical);
	}
	
	@Override
	public void updateGeneroMusical(GeneroMusical generoMusical) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(generoMusical);
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
