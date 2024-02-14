package com.chandara.phoneshop.Exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String resourceName,Long id) {
		super(HttpStatus.NOT_FOUND,String.format("%s with id = %d not found",resourceName,id));
	}
}
