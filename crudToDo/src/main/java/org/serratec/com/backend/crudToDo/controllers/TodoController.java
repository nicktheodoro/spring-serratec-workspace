package org.serratec.com.backend.crudToDo.controllers;

import java.util.List;

import org.serratec.com.backend.crudToDo.models.ToDoEntity;
import org.serratec.com.backend.crudToDo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
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
	public void create(@RequestBody ToDoEntity toDo) {
		service.create(toDo);
	}
	
	@GetMapping
	public List<ToDoEntity> realAll() {
		return service.readAll();
	}
	
	@GetMapping("/{id}")
	public ToDoEntity readId(@PathVariable Integer id) {
		return service.readId(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	@PutMapping("/{id}")
	public void update(@RequestBody ToDoEntity toDo, @PathVariable Integer id) {
		service.update(toDo, id);
	}
}
