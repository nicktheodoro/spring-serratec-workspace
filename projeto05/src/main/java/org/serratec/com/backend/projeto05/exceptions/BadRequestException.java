package org.serratec.com.backend.projeto05.exceptions;

public class BadRequestException extends Exception {

	private static final long serialVersionUID = 1172492811636147622L;
	private String msg;
	
	public BadRequestException() {
		super();
	}

	public BadRequestException(String message) {
		super(message);
		this.msg = message;
	}

	public String getMsg() {
		return msg;
	}

}
