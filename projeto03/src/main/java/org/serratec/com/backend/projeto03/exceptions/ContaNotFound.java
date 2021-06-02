package org.serratec.com.backend.projeto03.exceptions;

public class ContaNotFound extends Exception {

	private static final long serialVersionUID = 1L;

	public ContaNotFound() {
		super();
	}

	public ContaNotFound(String message) {
		super(message);
	}

	public ContaNotFound(Throwable cause) {
		super(cause);
	}

}
