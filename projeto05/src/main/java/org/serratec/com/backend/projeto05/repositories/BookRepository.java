package org.serratec.com.backend.projeto05.repositories;

import org.serratec.com.backend.projeto05.models.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
