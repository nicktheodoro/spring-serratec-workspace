package org.serratec.com.backend.crudToDo.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.com.backend.crudToDo.models.ToDoEntity;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	List<ToDoEntity> lista = new ArrayList<>();

	public ToDoEntity create(ToDoEntity toDo) {
		if(this.getByID(toDo.getId()) == null) {
			lista.add(toDo);
			return toDo;
		}
		
		return null;
	}

	public List<ToDoEntity> readAll() {
		return lista;
	}

	public ToDoEntity readId(Integer id) {
		if(this.getByID(id) != null) {
			return this.getByID(id);
		}
		
		return null;
	}

	public ToDoEntity delete(Integer id) {
		if(this.getByID(id) != null) {
			lista.remove(this.getByID(id));
			return this.getByID(id);
		}
		
		return null;
	}

	public List<ToDoEntity> update(ToDoEntity toDo, Integer id) {

		ToDoEntity updateToDo = this.getByID(id);
		if (updateToDo != null) {
			updateToDo.setNome(toDo.getNome());
			updateToDo.setDescricao(toDo.getDescricao());
			lista.set(lista.indexOf(updateToDo), updateToDo);
		}
		return this.readAll();
	}

	public ToDoEntity getByID(Integer id) {
		for (ToDoEntity toDoEntity : lista) {
			if (id == toDoEntity.getId()) {
				return toDoEntity;
			}
		}
		return null;
	}

}
