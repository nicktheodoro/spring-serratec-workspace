package org.serratec.com.backend.projeto05.mapper;

import org.serratec.com.backend.projeto05.models.BookEntity;
import org.serratec.com.backend.projeto05.modelsDto.BookDto;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

	public BookEntity toModel(BookDto dto) {
		BookEntity book = new BookEntity();

		book.setAuthor(dto.getAuthor());
		book.setTitle(dto.getTitle());
		book.setType(dto.getType());
		book.setPublishedDate(dto.getPublishedDate());

		return book;
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
