package org.serratec.com.backend.projeto03.repositories;

import org.serratec.com.backend.projeto03.models.ContaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<ContaEntity, Long> {

}
