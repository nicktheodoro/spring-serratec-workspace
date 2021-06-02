package org.serratec.com.backend.projeto05.repositories;

import java.util.List;

import org.serratec.com.backend.projeto05.models.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

	BookEntity findByTitle(String title);
	
	List<BookEntity> findByOrderByAuthorAsc();
}
