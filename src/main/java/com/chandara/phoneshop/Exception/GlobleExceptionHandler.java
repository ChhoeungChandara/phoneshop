package com.chandara.phoneshop.Exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleExceptionHandler {
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> HandleApiException(ApiException e){
		ErrorRespone errorRespone = new ErrorRespone(e.getHttpStatus(),e.getMessage());
		return ResponseEntity.status(e.getHttpStatus()).body(errorRespone);
	}
}
