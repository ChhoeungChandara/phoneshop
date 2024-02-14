package com.chandara.phoneshop.Exception;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class ApiException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final HttpStatus httpStatus;
	
	private final String message;

}
