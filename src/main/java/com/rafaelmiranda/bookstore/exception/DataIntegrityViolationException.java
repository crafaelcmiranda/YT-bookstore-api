package com.rafaelmiranda.bookstore.exception;

public class DataIntegrityViolationException extends RuntimeException{

	private static final long serialVersionUID = 1964585741283973604L;

	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataIntegrityViolationException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
