package org.serratec.backend.projeto02.services;

import java.util.Arrays;
import java.util.List;

import org.serratec.backend.projeto02.models.TodoEntity;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
	public List<TodoEntity> create() {
		return Arrays.asList(new TodoEntity(1, "Ir ao mercado", "AMANHÃ DE MANHÃ"),
				new TodoEntity(2, "Reunião as 16 horas", "Reunião com beltrano"));

	}
}
