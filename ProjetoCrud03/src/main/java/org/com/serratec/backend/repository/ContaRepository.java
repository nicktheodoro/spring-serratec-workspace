package org.com.serratec.backend.repository;

import org.com.serratec.backend.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<TodoEntity, Long> {
	
}
