package org.serratec.com.backend.crudToDo.execeptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsController {
	
	@ExceptionHandler(ToDoNotFoundException.class)
	public ResponseEntity<String> tratandoException(ToDoNotFoundException exception) {
		return ResponseEntity.notFound()
								.header("x-error-msg", exception.getMessage())
								.build();
	}
}
