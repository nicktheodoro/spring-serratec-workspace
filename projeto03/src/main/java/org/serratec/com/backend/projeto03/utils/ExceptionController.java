package org.serratec.com.backend.projeto03.utils;

import org.serratec.com.backend.projeto03.exceptions.ContaNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

		@ExceptionHandler(ContaNotFound.class)
		public ResponseEntity<String> tratarNotFound(ContaNotFound exception) {
			return ResponseEntity.notFound()
									.header("x-error-msg", exception.getMessage())
									.build();
		}
}
