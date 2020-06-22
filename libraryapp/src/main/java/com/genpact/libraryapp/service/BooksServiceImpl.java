package com.genpact.libraryapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.libraryapp.domain.Books;
import com.genpact.libraryapp.domain.Library;
import com.genpact.libraryapp.dto.BooksDTO;
import com.genpact.libraryapp.repository.BooksRepository;
import com.genpact.libraryapp.repository.LibraryRepository;

@Service("bookService")
public class BooksServiceImpl implements BooksService {
	
	@Autowired
	private BooksRepository bookRepository;		

	@Autowired
	private LibraryRepository libRepository;

	@Override
	public List<Books> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	@Transactional
	public Books addBook(BooksDTO bookDto) {
		Library library= null;
		Optional<Library> lib = libRepository.findById(bookDto.getLibraryId());
		if(lib.isPresent())
			library = lib.get();
		Books bookToBeSaved = bookDto.getBook();
		bookToBeSaved.setLib(library);
		return bookRepository.save(bookToBeSaved);
	}

	@Override
	public Books updateBorrowedDate(Books book) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
