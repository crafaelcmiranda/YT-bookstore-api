package com.rafaelmiranda.bookstore.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class StandardError {
	private Long timestamp;
	private Integer Status;
	private String error;

}
