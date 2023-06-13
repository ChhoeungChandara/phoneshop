package com.chandara.phoneshop.exception;
import org.springframework.http.HttpStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ApiException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final HttpStatus status;
	private  final String message;
}
