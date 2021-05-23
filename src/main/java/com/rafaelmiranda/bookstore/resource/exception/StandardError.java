package com.rafaelmiranda.bookstore.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data 
@SuperBuilder
@NoArgsConstructor 
@AllArgsConstructor
public class StandardError {
	private Long timestamp;
	private Integer status;
	private String error;

}
