package org.serratec.com.backend.crudToDo.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.com.backend.crudToDo.models.ToDoEntity;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	List<ToDoEntity> Lista = new ArrayList<>();
	
	public void create(ToDoEntity toDo) {
		Lista.add(toDo);
	}
	
	public List<ToDoEntity> readAll() {
		return Lista;
	}
	
	public ToDoEntity readId(Integer id) {
		for (ToDoEntity toDoEntity : Lista) {
			if(id == toDoEntity.getId()) {
				return toDoEntity;
			}
		}
		return null;
	}
	
	public void delete(Integer id) {
		for (ToDoEntity toDoEntity : Lista) {
			if(id == toDoEntity.getId()) {
				Lista.remove(toDoEntity);
				break;
			}
		}
	}
	
	public void update(ToDoEntity toDo, Integer id) {
		for (ToDoEntity toDoEntity : Lista) {
			if(id == toDoEntity.getId()) {
				toDoEntity.setId(toDo.getId());
				toDoEntity.setNome(toDo.getNome());
				toDoEntity.setDescricao(toDo.getDescricao());
				break;
			}
		}
	}
	
}
