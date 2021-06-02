package org.serratec.com.backend.projeto05.services;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.com.backend.projeto05.exceptions.EntityNotFound;
import org.serratec.com.backend.projeto05.mapper.CategoryMapper;
import org.serratec.com.backend.projeto05.models.CategoryEntity;
import org.serratec.com.backend.projeto05.modelsDto.CategoryDto;
import org.serratec.com.backend.projeto05.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository;

	@Autowired
	CategoryMapper mapper;

	public List<CategoryDto> getAll() {
		return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
	}

	public CategoryDto getById(Long id) throws EntityNotFound {
		return mapper.toDto(repository.findById(id).orElseThrow(() -> new EntityNotFound(id + " não encontrado.")));
	}

	public CategoryDto create(CategoryDto category) {
		repository.save(mapper.toEntity(category));
		return category;
	}

	public CategoryDto update(Long id, CategoryDto category) throws EntityNotFound {
		CategoryEntity entity = mapper.toEntity(this.getById(id));
		entity.setName(category.getName());
		entity.setDescription(category.getDescription());

		return mapper.toDto(repository.save(entity));
	}

	public String delete(Long id) {
		repository.deleteById(id);
		return "Deletado com sucesso";
	}

}
