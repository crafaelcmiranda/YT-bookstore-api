package com.rafaelmiranda.bookstore.resource.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter 
@NoArgsConstructor 
public class ValidationError extends StandardError{
	private List<FieldMessage> errors = new ArrayList<FieldMessage>();
	
	public void addErrors(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}


	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}
}
