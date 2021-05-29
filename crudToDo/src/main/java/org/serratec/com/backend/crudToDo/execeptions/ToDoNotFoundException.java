package org.serratec.com.backend.crudToDo.execeptions;

public class ToDoNotFoundException extends Exception {
	
	private static final long serialVersionUID = -7094854885875158230L;

	public ToDoNotFoundException() {
		super();
	}

	public ToDoNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ToDoNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ToDoNotFoundException(String message) {
		super(message);
	}

	public ToDoNotFoundException(Throwable cause) {
		super(cause);
	}
		
}
