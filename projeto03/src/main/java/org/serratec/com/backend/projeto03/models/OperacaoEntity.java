package org.serratec.com.backend.projeto03.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="OPERACAO")
public class OperacaoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="TIPO_OPR", nullable = false)
	private Tipo tipo;
	
	@Column(name="VALOR", nullable = false)
	private Double valor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		if (Tipo.valueOf(tipo) == Tipo.CREDITO) {
			this.tipo = Tipo.CREDITO;
		}
		
		if (Tipo.valueOf(tipo) == Tipo.DEBITO) {
			this.tipo = Tipo.DEBITO;
		}
		
		if (Tipo.valueOf(tipo) == Tipo.DEPOSITO) {
			this.tipo = Tipo.DEPOSITO;
		}
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
