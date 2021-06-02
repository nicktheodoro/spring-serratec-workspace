package org.serratec.com.backend.projeto05.services;

import java.util.List;
import java.util.stream.Collectors;

import org.serratec.com.backend.projeto05.exceptions.EntityNotFound;
import org.serratec.com.backend.projeto05.mapper.BookMapper;
import org.serratec.com.backend.projeto05.models.BookEntity;
import org.serratec.com.backend.projeto05.modelsDto.BookDto;
import org.serratec.com.backend.projeto05.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	@Autowired
	private BookMapper mapper;
	
	public List<BookDto> getAll() {
		return repository.findAll().stream().map(mapper::toDto)
				.collect(Collectors.toList());
	}
	
	public List<BookDto> getOrdenedBy(@Param("type") String type) {
		return repository.findAll(Sort.by(Sort.Direction.ASC, type)).stream().map(mapper::toDto)
				.collect(Collectors.toList());
	}

	public BookDto getById(Long id) throws EntityNotFound {
		return mapper.toDto(repository.findById(id).orElseThrow(() -> new EntityNotFound(id + " não encontrado.")));
	}

	public BookDto create(BookDto dto) {
		repository.save(mapper.toEntity(dto));
		return dto;
	}

	public BookDto update(Long id, BookDto bookUpdate) throws EntityNotFound {
		BookEntity book = mapper.toEntity(this.getById(id));
		book.setAuthor(bookUpdate.getAuthor());
		book.setTitle(bookUpdate.getTitle());
		book.setCategory(bookUpdate.getCategory());

		return mapper.toDto(repository.save(book));
	}

	public String delete(Long id) {
		repository.deleteById(id);

		return "Deletado com sucesso";
	}
}
