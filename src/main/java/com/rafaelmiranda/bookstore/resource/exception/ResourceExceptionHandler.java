package com.rafaelmiranda.bookstore.resource.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rafaelmiranda.bookstore.exception.DataIntegrityViolationException;
import com.rafaelmiranda.bookstore.exception.ObjectNotFoundException;



@ControllerAdvice
public class ResourceExceptionHandler {

	/*Classe para manipular exceptions*/
	
	@ExceptionHandler(ObjectNotFoundException.class)
	private ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	private ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	private ResponseEntity<StandardError> methodArgumentNotValidException(MethodArgumentNotValidException e, ServletRequest request) {
		ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Erro na valiadação dos campos");
		
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			error.addErrors(f.getField(), f.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
