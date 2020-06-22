package com.genpact.libraryapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.genpact.libraryapp.domain.Books;

@NotNull(message="Boook Dto is empty, data ca't be added")
public class BooksDTO {

	@NotNull(message="book can't be null")
	private Books book;
	@Min(value=1,message="library id cant be null")
	private int libraryId;
	
	public Books getBook() {
		return book;
	}
	public void setBook(Books book) {
		this.book = book;
	}
	public int getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}
	
	
}
