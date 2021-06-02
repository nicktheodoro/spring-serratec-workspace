package org.serratec.com.backend.projeto05.utils;

import org.serratec.com.backend.projeto05.exceptions.BadRequestException;
import org.serratec.com.backend.projeto05.exceptions.EntityNotFound;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	private HttpHeaders header(Exception ex) {
		HttpHeaders header = new HttpHeaders();
		header.add("LIBRARY", "RESTAPI_V1");
		header.add("x-error-msg", ex.getMessage());
		return header;
	}
	
	@ExceptionHandler(EntityNotFound.class)
	public ResponseEntity<String> handleEntityNotFound(EntityNotFound ex) {
		return ResponseEntity.notFound().headers(this.header(ex)).build();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	public String handleEntityNotFound(BadRequestException ex) {
		return ex.getMessage();
	}
	
}
