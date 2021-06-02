package org.serratec.com.backend.projeto05.exceptions;

public class EntityNotFound extends Exception {

	private static final long serialVersionUID = -4541661627534201949L;
	private String msg;

	public EntityNotFound() {
		super();
	}

	public EntityNotFound(String message) {
		super(message);
		this.msg = message;
	}

	public String getMsg() {
		return msg;
	}

}
