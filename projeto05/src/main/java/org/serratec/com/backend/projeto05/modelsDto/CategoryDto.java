package org.serratec.com.backend.projeto05.modelsDto;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.serratec.com.backend.projeto05.models.BookEntity;

public class CategoryDto {
	
	@NotNull
	private String name;

	@NotNull
	private String description;

	private List<BookEntity> books;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<BookEntity> getBooks() {
		return books;
	}

	public void setBooks(List<BookEntity> books) {
		this.books = books;
	}
}
