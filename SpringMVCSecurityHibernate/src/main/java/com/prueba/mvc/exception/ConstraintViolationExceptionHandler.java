package com.prueba.mvc.exception;

import org.hibernate.exception.ConstraintViolationException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class ConstraintViolationExceptionHandler implements ExceptionHandler{

	private ExceptionHandler next;
	
	@Override
	public String proccess(Object object) {
		if(object instanceof ConstraintViolationException){
			ConstraintViolationException violationException = (ConstraintViolationException) object;
			Throwable throwable = violationException.getCause();
			if(throwable instanceof MySQLIntegrityConstraintViolationException){
				return "message.generomusical.messageAlert.duplicado";
			}
		}
		
		return next.proccess(object);
	}
	
	@Override
	public void setNext(ExceptionHandler next) {
		this.next = next;
	}

}
