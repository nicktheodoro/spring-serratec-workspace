package org.serratec.com.backend.projeto05.controllers;

import java.util.List;

import javax.validation.Valid;

import org.serratec.com.backend.projeto05.exceptions.EntityNotFound;
import org.serratec.com.backend.projeto05.modelsDto.CategoryDto;
import org.serratec.com.backend.projeto05.services.CategoryService;
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
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAll() {
		return new ResponseEntity<List<CategoryDto>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getById(@PathVariable Long id) throws EntityNotFound {
		return new ResponseEntity<CategoryDto>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CategoryDto> create(@Valid@RequestBody CategoryDto dto) {
		return new ResponseEntity<CategoryDto>(service.create(dto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> update(@PathVariable Long id, @RequestBody CategoryDto dto) throws EntityNotFound {
		return new ResponseEntity<CategoryDto>(service.update(id, dto), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return new ResponseEntity<String>(service.delete(id), HttpStatus.NO_CONTENT);
	}
}
