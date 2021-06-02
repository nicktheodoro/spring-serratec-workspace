package org.serratec.com.backend.projeto05.mapper;

import org.serratec.com.backend.projeto05.models.CategoryEntity;
import org.serratec.com.backend.projeto05.modelsDto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

	public CategoryEntity toEntity(CategoryDto dto) {
		CategoryEntity entity = new CategoryEntity();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setBooks(dto.getBooks());

		return entity;
	}

	public CategoryDto toDto(CategoryEntity entity) {
		CategoryDto dto = new CategoryDto();
		dto.setName(entity.getName());
		dto.setDescription(entity.getDescription());
		dto.setBooks(entity.getBooks());

		return dto;
	}
}
