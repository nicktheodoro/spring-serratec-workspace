package org.serratec.com.backend.projeto05.services;

import java.util.List;

import org.serratec.com.backend.projeto05.exceptions.BadRequestException;
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

	public List<BookEntity> getAll() {
		return repository.findAll();
	}

	public BookEntity getById(Long id) throws EntityNotFound {
		return repository.findById(id).orElseThrow(() -> new EntityNotFound(id + " não encontrado."));
	}
	
	public List<BookEntity> findByOrderByTypeAsc(@Param("type") String type) {
		return repository.findAll(Sort.by(Sort.Direction.ASC, type));
	}

	public BookDto create(BookDto book) throws BadRequestException {
		//this.validateDto(book);
		//return mapper.toDto(repository.save(mapper.toModel(book)));
		repository.save(mapper.toModel(book));
		return book;
	}

	public BookDto update(Long id, BookDto bookUpdate) throws EntityNotFound {
		BookEntity book = this.getById(id);
		book.setAuthor(bookUpdate.getAuthor());
		book.setTitle(bookUpdate.getTitle());
		book.setType(bookUpdate.getType());

		return mapper.toDto(repository.save(book));
	}

	public String delete(Long id) {
		repository.deleteById(id);

		return "Deletado com sucesso";
	}

//	private void validateDto(BookDto dto) throws BadRequestException {
//		BookEntity book = mapper.toModel(dto);
//		BookEntity registeredBook = repository.findByTitle(dto.getTitle());
//
//		if (registeredBook.equals(book)) {
//			throw new BadRequestException("Entidade já cadastrada");
//		}
//	}
}
