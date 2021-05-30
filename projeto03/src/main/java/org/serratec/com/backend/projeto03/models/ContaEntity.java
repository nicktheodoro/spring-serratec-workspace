package org.serratec.com.backend.projeto03.models;

public class ContaEntity {
	private Integer id;
	private String numero;
	private String titular;
	private Double saldo;

	public ContaEntity(Integer id, String numero, String titular, Double saldo) {
		super();
		this.id = id;
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

}
