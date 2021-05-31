package org.com.serratec.backend.repository;

import org.com.serratec.backend.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
	
}
