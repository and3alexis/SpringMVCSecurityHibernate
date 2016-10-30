package com.prueba.mvc.generomusical.service;

import java.util.List;

import com.prueba.mvc.generomusical.domain.GeneroMusical;

public interface GeneroMusicalService {
	
	GeneroMusical createGeneroMusical(GeneroMusical generoMusical);

	GeneroMusical updateGeneroMusical(GeneroMusical generoMusical);

	List<GeneroMusical> listGenerosMusicales();

	void removeGeneroMusical(int id);

	GeneroMusical getGeneroMusicalById(int id);

	void deleteAllGenerosMusicales();

}
