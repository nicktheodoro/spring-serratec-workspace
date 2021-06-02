package org.serratec.com.backend.projeto05.modelsDto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.serratec.com.backend.projeto05.enums.Gender;

public class BookDto {

	@NotNull
	@Size(min = 5, max = 30)
	private String title;

	@NotNull
	private Gender type;

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

	public Gender getType() {
		return type;
	}

	public void setType(Gender type) {
		this.type = type;
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
