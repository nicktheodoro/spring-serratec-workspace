package org.serratec.com.backend.projeto03.exceptions;

public class SaldoInsuficiente extends Exception {

	private static final long serialVersionUID = 7041036303286316887L;

	public SaldoInsuficiente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaldoInsuficiente(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SaldoInsuficiente(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SaldoInsuficiente(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SaldoInsuficiente(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
