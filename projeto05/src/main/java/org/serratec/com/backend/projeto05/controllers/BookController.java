package org.serratec.com.backend.projeto05.controllers;

import java.util.List;

import org.serratec.com.backend.projeto05.exceptions.BadRequestException;
import org.serratec.com.backend.projeto05.exceptions.EntityNotFound;
import org.serratec.com.backend.projeto05.models.BookEntity;
import org.serratec.com.backend.projeto05.modelsDto.BookDto;
import org.serratec.com.backend.projeto05.services.BookService;
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
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping
	public ResponseEntity<List<BookEntity>> getAll() {
		return new ResponseEntity<List<BookEntity>>(service.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/ordened/{type}")
	ResponseEntity<List<BookEntity>> getByAuthorOrdered(@PathVariable String type) {
		return new ResponseEntity<List<BookEntity>>(service.findByOrderByTypeAsc(type), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookEntity> getById(@PathVariable Long id) throws EntityNotFound {
		return new ResponseEntity<BookEntity>(service.getById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<BookDto> create(@RequestBody BookDto book) throws BadRequestException {
		return new ResponseEntity<BookDto>(service.create(book), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<BookDto> update(@PathVariable Long id, @RequestBody BookDto book) throws EntityNotFound {
		return new ResponseEntity<BookDto>(service.update(id, book), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return new ResponseEntity<String>(service.delete(id), HttpStatus.NO_CONTENT);
	}
}
