package org.serratec.com.backend.projeto03.controllers;

import java.util.List;

import org.serratec.com.backend.projeto03.exceptions.ContaNotFound;
import org.serratec.com.backend.projeto03.models.ContaEntity;
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
	API api;

	@GetMapping
	public ResponseEntity<List<ContaEntity>> getAll() {
		return new ResponseEntity<List<ContaEntity>>(api.getAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ContaEntity> getConta(@PathVariable Integer id) throws ContaNotFound {
		return new ResponseEntity<ContaEntity>(api.getById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ContaEntity> create(@RequestBody ContaEntity conta) throws ContaNotFound {
		return api.create(conta);
	}

	@PutMapping("/{id}")
	public ContaEntity update(@PathVariable Integer id, @RequestBody ContaEntity conta) throws ContaNotFound {
		return api.update(id, conta);
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) throws ContaNotFound {
		return api.delete(id);
	}
}
