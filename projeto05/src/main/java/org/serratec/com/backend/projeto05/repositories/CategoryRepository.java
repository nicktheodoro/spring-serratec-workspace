package org.serratec.com.backend.projeto05.repositories;

import org.serratec.com.backend.projeto05.models.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
