package org.serratec.com.backend.projeto05.mapper;

import org.serratec.com.backend.projeto05.models.BookEntity;
import org.serratec.com.backend.projeto05.modelsDto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

	public BookEntity toEntity(BookDto dto) {
		BookEntity entity = new BookEntity();
		entity.setAuthor(dto.getAuthor());
		entity.setTitle(dto.getTitle());
		entity.setType(dto.getType());
		entity.setPublishedDate(dto.getPublishedDate());

		return entity;
	}

	public BookDto toDto(BookEntity book) {
		BookDto dto = new BookDto();
		dto.setAuthor(book.getAuthor());
		dto.setTitle(book.getTitle());
		dto.setType(book.getType());
		dto.setPublishedDate(book.getPublishedDate());

		return dto;
	}
}
