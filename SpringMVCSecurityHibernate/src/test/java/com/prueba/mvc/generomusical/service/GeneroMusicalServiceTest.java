package com.prueba.mvc.generomusical.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prueba.mvc.generomusical.domain.GeneroMusical;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:servlet-context.xml"})
public class GeneroMusicalServiceTest {
	
	@Autowired
	private GeneroMusicalService generoMusicalService;

	@Test
	public void testCreateGeneroMusical() {
		GeneroMusical generoMusical = getNewGeneroMusical();
		generoMusical = generoMusicalService.createGeneroMusical(generoMusical);
		assertNotNull(generoMusical.getId());
	}
	
	private GeneroMusical getNewGeneroMusical(){
		GeneroMusical generoMusical = new GeneroMusical();
		generoMusical.setNombre("Clasica");
		generoMusical.setHistoria("Origenes Los siglos XVII y XVIII fueron el periodo formativo de la música clasica y vieron nacer la opera y el oratorio, la sonata, el concierto y la sinfonia. Los italianos fueron los primeros en desarrollar estos generos, pero les siguieron pronto los alemanes, austriacos e ingleses. La musica clasica surgio tomando elementos de otras tradiciones musicales occidentales, tanto liturgicas como seculares, por caso la musica de la Antigua Grecia o la Musica de la Antigua Roma (sobre todo por sus contribuciones teoricas), o la musica de la Iglesia catolica (principalmente el canto gregoriano). Los hitos que definieron su rumbo, fue el descubrimiento y posterior desarrollo de la polifonia, asi como el posterior desarrollo de la armonia, la revolucion musical conocida como el Ars nova y la evolucion de la notacion musical, ademas del estudio de la estetica musical.");
		return generoMusical;
	}

	@Test
	public void testUpdateGeneroMusical() {
		GeneroMusical generoMusical = getNewGeneroMusical();
		generoMusical = generoMusicalService.createGeneroMusical(generoMusical);
		generoMusical.setNombre("Jazz");
		generoMusical = generoMusicalService.updateGeneroMusical(generoMusical);
		assertNotSame("Clasica", generoMusical.getNombre());
	}

	@Test
	public void testListGenerosMusicales() {
		GeneroMusical generoMusical = getNewGeneroMusical();
		generoMusical = generoMusicalService.createGeneroMusical(generoMusical);
		List<GeneroMusical> generoMusicalList = generoMusicalService.listGenerosMusicales();
		assertTrue(generoMusicalList.size() > 0);
	}

	@Test
	public void testRemoveGeneroMusical() {
		GeneroMusical generoMusical = getNewGeneroMusical();
		generoMusical = generoMusicalService.createGeneroMusical(generoMusical);
		generoMusicalService.removeGeneroMusical(generoMusical.getId());
		generoMusical = generoMusicalService.getGeneroMusicalById(generoMusical.getId());
		assertNull(generoMusical);
	}

	@Test
	public void testGetGeneroMusicalById() {
		GeneroMusical generoMusical = getNewGeneroMusical();
		generoMusical = generoMusicalService.createGeneroMusical(generoMusical);
		generoMusical = generoMusicalService.getGeneroMusicalById(generoMusical.getId());
		assertNotNull(generoMusical);
	}
	
	@After
    public void tearDown() {
		generoMusicalService.deleteAllGenerosMusicales();
    }

}
