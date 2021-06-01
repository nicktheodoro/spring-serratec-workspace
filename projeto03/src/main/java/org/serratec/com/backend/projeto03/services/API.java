package org.serratec.com.backend.projeto03.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.com.backend.projeto03.exceptions.ContaNotFound;
import org.serratec.com.backend.projeto03.exceptions.SaldoInsuficiente;
import org.serratec.com.backend.projeto03.models.ContaEntity;
import org.serratec.com.backend.projeto03.models.OperacaoEntity;
import org.serratec.com.backend.projeto03.repositories.ContaRepository;
import org.serratec.com.backend.projeto03.repositories.OperacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class API {

	@Autowired
	ContaRepository repository;

	@Autowired
	OperacaoRepository oprRepository;

	public List<ContaEntity> getAll() {
		return repository.findAll();
	}

	public ContaEntity getOne(String agencia, String numero) throws ContaNotFound {
		List<ContaEntity> lista = repository.findAll();

		for (ContaEntity c : lista) {
			if (agencia.equals(c.getAgencia()) && numero.equals(c.getNumero())) {
				return repository.getById(c.getId());
			}
		}

		throw new ContaNotFound("Conta não encontrada");
	}

	public ContaEntity create(ContaEntity conta) {
		return repository.save(conta);
	}

	public ContaEntity update(String agencia, String numero, ContaEntity conta) throws ContaNotFound {
		ContaEntity contaUpdate = this.getOne(agencia, numero);

		if (conta.getAgencia() != null) {
			contaUpdate.setAgencia(conta.getAgencia());
		}

		if (conta.getNumero() != null) {
		}

		if (conta.getTitular() != null) {
			contaUpdate.setTitular(conta.getTitular());
		}

		return repository.save(contaUpdate);
	}

	public String delete(String agencia, String numero) throws ContaNotFound {
		repository.deleteById(this.getOne(agencia, numero).getId());

		return "Conta deletada com sucesso";
	}
	
	public List<OperacaoEntity> extrato(String agencia, String numero) throws ContaNotFound {
		List<OperacaoEntity> listAll = oprRepository.findAll();
		
		ContaEntity c = this.getOne(agencia, numero);
		
		List<OperacaoEntity> list = new ArrayList<>();
		
		for (OperacaoEntity operacaoEntity : listAll) {
			System.out.println(operacaoEntity.getIdConta());
			if (c.getId() == operacaoEntity.getIdConta()) {
				
				list.add(operacaoEntity);
			}
		}
		
		return list;
	}

	public OperacaoEntity operacao(String agencia, String numero, OperacaoEntity operacao)
			throws SaldoInsuficiente, ContaNotFound {
		ContaEntity c = this.getOne(agencia, numero);

		switch (operacao.getTipo()) {
		case DEBITO:
			if (operacao.getValor() <= c.getSaldo()) {
				c.setSaldo(c.getSaldo() - operacao.getValor());
				oprRepository.save(operacao);
				operacao.setIdConta(c.getId());
				oprRepository.save(operacao);
				return operacao;
			}

			throw new SaldoInsuficiente("Impossível realizar o saque, saldo insuficiente!");

		case CREDITO:
			c.setSaldo(c.getSaldo() - operacao.getValor());
			oprRepository.save(operacao);
			operacao.setIdConta(c.getId());
			oprRepository.save(operacao);
			return operacao;

		case DEPOSITO:
			c.setSaldo(c.getSaldo() + operacao.getValor());
			oprRepository.save(operacao);
			operacao.setIdConta(c.getId());
			oprRepository.save(operacao);
			return operacao;

		default:
			return null;
		}

	}
}
