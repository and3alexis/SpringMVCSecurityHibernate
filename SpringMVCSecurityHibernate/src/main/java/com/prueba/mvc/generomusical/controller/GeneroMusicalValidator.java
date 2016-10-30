package com.prueba.mvc.generomusical.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.prueba.mvc.generomusical.domain.GeneroMusical;

@Component
public class GeneroMusicalValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return GeneroMusical.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "message.generomusical.error.validator.generomusical.nombre");
		
		GeneroMusical generoMusical = (GeneroMusical) target;
		
		if(generoMusical != null){
			if(generoMusical.getNombre() != null && generoMusical.getNombre().length() > 50){
				errors.rejectValue("nombre", "message.generomusical.error.validator.generomusical.nombre.tamanio");
			}
		}
	}

}
