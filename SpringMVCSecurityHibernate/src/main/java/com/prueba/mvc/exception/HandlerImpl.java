package com.prueba.mvc.exception;

import org.springframework.stereotype.Component;

@Component
public class HandlerImpl implements IHandler {
	
	@Override
	public ExceptionHandler getExceptionChain(){
		ExceptionHandler constraintViolation = new ConstraintViolationExceptionHandler();
		ExceptionHandler exceptionDefault = new ExeptionDefaultHandler();
		constraintViolation.setNext(exceptionDefault);
		return constraintViolation;
	}

}
