package org.serratec.com.backend.calculadora.models;

public class CalculadoraEntity {
	private double num1;
	private double num2;
	private String opr;

	public CalculadoraEntity(double num1, double num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public String getOpr() {
		return opr;
	}

	public void setOpr(String opr) {
		this.opr = opr;
	}
	
}
