/**
 * 
 */
package com.prueba.mvc.generomusical.dao;

import java.util.List;

import com.prueba.mvc.generomusical.domain.GeneroMusical;

public interface GeneroMusicalDAO {

	void createGeneroMusical(GeneroMusical generoMusical);

	void updateGeneroMusical(GeneroMusical generoMusical);

	List<GeneroMusical> listGenerosMusicales();

	void removeGeneroMusical(int id);

	GeneroMusical getGeneroMusicalById(int id);

	void deleteAllGenerosMusicales();

}
