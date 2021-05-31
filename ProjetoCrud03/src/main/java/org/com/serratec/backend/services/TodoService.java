package org.com.serratec.backend.services;

import java.util.List;

import org.com.serratec.backend.entity.TodoEntity;
import org.com.serratec.backend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

	@Autowired
	TodoRepository repository;
	
	public List<TodoEntity> getAll() {
		return repository.findAll();
	}
	
	public TodoEntity getById(Long id) {
		return repository.findById(id).get();
	}
	
	public TodoEntity create(TodoEntity todo) {
		return repository.save(todo);
	}
	
	public TodoEntity update(Long id, TodoEntity todo) {
		TodoEntity todoEntity = getById(id);
		
		if (todo.getName() != null) {
			todoEntity.setName(todo.getName());
		}
		
		if (todo.getDescription() != null) {
			todoEntity.setDescription(todo.getDescription());
		}
		
		return repository.save(todoEntity);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
