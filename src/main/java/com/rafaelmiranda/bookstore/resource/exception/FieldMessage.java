package com.rafaelmiranda.bookstore.resource.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter	 
@NoArgsConstructor 
public class FieldMessage extends StandardError{
	private String fieldMessage;
	private String error;
	
	public FieldMessage(String fieldMessage, String error) {
		this.fieldMessage = fieldMessage;
		this.error = error;
	}

	
	
}
