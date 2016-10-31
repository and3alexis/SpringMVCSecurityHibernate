package com.prueba.mvc.exception;

public class ExeptionDefaultHandler implements ExceptionHandler{
	
	
	@Override
	public String proccess(Object object){
		return "message.generomusical.messageAlert.error";
	}

	@Override
	public void setNext(ExceptionHandler next) {
	}

}
