package com.prueba.mvc.exception;

public interface ExceptionHandler {

	String proccess(Object object);

	void setNext(ExceptionHandler next);

}
