package org.serratec.com.backend.crudToDo.controllers;

import java.util.List;

import org.serratec.com.backend.crudToDo.models.ToDoEntity;
import org.serratec.com.backend.crudToDo.services.ToDoService;
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
@RequestMapping("/todo")
public class TodoController {
	
	@Autowired
	ToDoService service;
	

	@PostMapping
	public ResponseEntity<ToDoEntity> create(@RequestBody ToDoEntity toDo) {
		return  new ResponseEntity<ToDoEntity>(service.create(toDo), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ToDoEntity>> realAll() {
		return new ResponseEntity<List<ToDoEntity>>(service.readAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ToDoEntity> readId(@PathVariable Integer id) {
		return new ResponseEntity<ToDoEntity>(service.readId(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ToDoEntity> delete(@PathVariable Integer id) {
		return new ResponseEntity<ToDoEntity>(service.delete(id), HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<List<ToDoEntity>> update(@RequestBody ToDoEntity toDo, @PathVariable Integer id) {
		return new ResponseEntity<List<ToDoEntity>>(service.update(toDo, id), HttpStatus.ACCEPTED);
	}
}
