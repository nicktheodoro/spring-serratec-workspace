package org.serratec.com.backend.projeto03.controllers;

import java.util.List;

import org.serratec.com.backend.projeto03.exceptions.ContaNotFound;
import org.serratec.com.backend.projeto03.exceptions.SaldoInsuficiente;
import org.serratec.com.backend.projeto03.models.ContaEntity;
import org.serratec.com.backend.projeto03.models.OperacaoEntity;
import org.serratec.com.backend.projeto03.services.API;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	API service;

	@GetMapping
	public ResponseEntity<List<ContaEntity>> getAll() {
		return new ResponseEntity<List<ContaEntity>>(service.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{agencia}/{numero}")
	public ResponseEntity<ContaEntity> getConta(@PathVariable String agencia, @PathVariable String numero) throws ContaNotFound {
		return new ResponseEntity<ContaEntity>(service.getOne(agencia, numero), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ContaEntity> create(@RequestBody ContaEntity conta) {
		return new ResponseEntity<ContaEntity>(service.create(conta), HttpStatus.CREATED);
	}

	@PutMapping("/{agencia}/{numero}")
	public ContaEntity update(@PathVariable String agencia, @PathVariable String numero,
			@RequestBody ContaEntity conta) throws ContaNotFound {
		return service.update(agencia, numero, conta);
	}

	@DeleteMapping("/{agencia}/{numero}")
	public ResponseEntity<String> delete(@PathVariable String agencia, @PathVariable String numero) throws ContaNotFound {
		return new ResponseEntity<String>(service.delete(agencia, numero), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/{agencia}/{numero}/operacao")
	public OperacaoEntity operacao(@PathVariable String agencia, @PathVariable String numero,
			@RequestBody OperacaoEntity operacao) throws SaldoInsuficiente, ContaNotFound {
		return service.operacao(agencia, numero, operacao);
	}
}
