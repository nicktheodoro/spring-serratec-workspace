package org.serratec.com.backend.projeto05.modelsDto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.serratec.com.backend.projeto05.models.CategoryEntity;

public class BookDto {

	@NotNull
	@Size(min = 5, max = 30)
	private String title;

	@NotNull
	private CategoryEntity category;

	@NotNull
	@Size(min = 10, max = 40)
	private String author;

	@Past
	private LocalDate publishedDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

}
