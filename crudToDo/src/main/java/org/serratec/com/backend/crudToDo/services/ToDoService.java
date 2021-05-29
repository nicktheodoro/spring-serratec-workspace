package org.serratec.com.backend.crudToDo.services;

import java.util.ArrayList;
import java.util.List;

import org.serratec.com.backend.crudToDo.execeptions.ToDoNotFoundException;
import org.serratec.com.backend.crudToDo.models.ToDoEntity;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	List<ToDoEntity> lista = new ArrayList<>();

	public ToDoEntity create(ToDoEntity toDo) {
		if (this.getByID(toDo.getId()) == null) {
			lista.add(toDo);
			return toDo;
		}

		return null;
	}

	public List<ToDoEntity> readAll() {
		return lista;
	}

	public ToDoEntity readId(Integer id) throws ToDoNotFoundException {
		if (this.getByID(id) != null) {
			return this.getByID(id);
		}

		throw new ToDoNotFoundException("Não foi possível encontrar esse id" + id);
	}

	public String delete(Integer id) throws ToDoNotFoundException {
		if (this.getByID(id) != null) {
			lista.remove(this.getByID(id));
			return "Deletado com sucesso";
		}

		throw new ToDoNotFoundException("Não foi possível encontrar esse id" + id);
	}

	public ToDoEntity update(ToDoEntity toDo, Integer id) throws ToDoNotFoundException {
		ToDoEntity updateToDo = this.getByID(id);

		if (updateToDo != null) {
			if (toDo.getNome() != null) {
				updateToDo.setNome(toDo.getNome());
			}
			if (toDo.getDescricao() != null) {
				updateToDo.setDescricao(toDo.getDescricao());
			}

			lista.set(lista.indexOf(updateToDo), updateToDo);
			return updateToDo;
		}

		throw new ToDoNotFoundException("Não foi possível encontrar esse id" + id);
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
