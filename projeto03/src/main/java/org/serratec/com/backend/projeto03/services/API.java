package org.serratec.com.backend.projeto03.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.com.backend.projeto03.exceptions.ContaNotFound;
import org.serratec.com.backend.projeto03.models.ContaEntity;
import org.springframework.stereotype.Service;

@Service
public class API {

	List<ContaEntity> contas = new ArrayList<>();

	public List<ContaEntity> getAll() {
		return this.contas;
	}

	public ContaEntity getConta(Integer id) throws ContaNotFound {
		return this.getById(id);
	}

	public ContaEntity create(ContaEntity conta) throws ContaNotFound {
		if(contas.contains(conta)) {
			return null;
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
		
		if(this.getById(id) != null) {
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
}
