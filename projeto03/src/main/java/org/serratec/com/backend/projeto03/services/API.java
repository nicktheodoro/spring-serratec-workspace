package org.serratec.com.backend.projeto03.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.com.backend.projeto03.exceptions.ContaNotFound;
import org.serratec.com.backend.projeto03.exceptions.RepeatId;
import org.serratec.com.backend.projeto03.exceptions.SaldoInsuficiente;
import org.serratec.com.backend.projeto03.models.ContaEntity;
import org.serratec.com.backend.projeto03.models.OperacaoEntity;
import org.springframework.stereotype.Service;

@Service
public class API {

	List<ContaEntity> contas = new ArrayList<>();

	public List<ContaEntity> getAll() {
		return this.contas;
	}

	public ContaEntity getConta(Integer id) throws ContaNotFound {
		if (this.getById(id) != null) {
			return this.getById(id);
		}

		throw new ContaNotFound("Id não encontrado");
	}

	public ContaEntity create(ContaEntity conta) throws RepeatId {

		for (ContaEntity contaEntity : contas) {
			if (conta.getId() == contaEntity.getId()) {
				throw new RepeatId("Id já existente, operação inválida.");
			}
		}

		contas.add(conta);
		return conta;

	}

	public ContaEntity update(Integer id, ContaEntity conta) throws ContaNotFound {
		ContaEntity updateConta = this.getById(id);

		if (updateConta != null) {
			if (conta.getNumero() != null) {
				updateConta.setNumero(conta.getNumero());
			}
			if (conta.getTitular() != null) {
				updateConta.setTitular(conta.getTitular());
			}

			contas.set(contas.indexOf(updateConta), updateConta);
			return updateConta;
		}

		throw new ContaNotFound("Id não encontrado");
	}

	public String delete(Integer id) throws ContaNotFound {

		if (this.getById(id) != null) {
			contas.remove(this.getById(id));
			return "Conta deletada com sucesso";
		}

		throw new ContaNotFound("Id não encontrado");
	}

	public ContaEntity getById(Integer id) throws ContaNotFound {
		for (ContaEntity contaEntity : contas) {
			if (id == contaEntity.getId()) {
				return contaEntity;
			}
		}

		throw new ContaNotFound("Id não encontrado");
	}

	public OperacaoEntity operacao(Integer id, OperacaoEntity operacao) throws ContaNotFound, SaldoInsuficiente {

		ContaEntity c = this.getById(id);

		switch (operacao.getTipo()) {
		case DEBITO:
			if (operacao.getValor() <= c.getSaldo()) {
				c.setSaldo(c.getSaldo() - operacao.getValor());
				return operacao;
			}

			throw new SaldoInsuficiente("Impossível realizar o saque, saldo insuficiente!");

		case CREDITO:
			c.setSaldo(c.getSaldo() - operacao.getValor());
			return operacao;

		case DEPOSITO:
			c.setSaldo(c.getSaldo() + operacao.getValor());
			return operacao;

		default:
			return null;
		}
	
	}
	
}
