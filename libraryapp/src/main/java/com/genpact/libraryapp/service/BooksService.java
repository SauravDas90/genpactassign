package com.genpact.libraryapp.service;

import java.util.List;

import com.genpact.libraryapp.domain.Books;
import com.genpact.libraryapp.dto.BooksDTO;

public interface BooksService {
	
	public List<Books> getAllBooks();
	
	public Books addBook(BooksDTO bookDto);
	
	public Books updateBorrowedDate(Books book);	
	
}
