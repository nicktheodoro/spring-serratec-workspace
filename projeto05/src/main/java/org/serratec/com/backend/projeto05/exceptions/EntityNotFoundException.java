package org.serratec.com.backend.projeto05.exceptions;

public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = -4541661627534201949L;
	private String msg;

	public EntityNotFoundException() {
		super();
	}

	public EntityNotFoundException(String message) {
		super(message);
		this.msg = message;
	}

	public String getMsg() {
		return msg;
	}

}
