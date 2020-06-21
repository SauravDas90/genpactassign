package com.genpact.libraryapp.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.genpact.libraryapp.domain.Books;
import com.genpact.libraryapp.domain.Library;
import com.genpact.libraryapp.dto.BooksDTO;
import com.genpact.libraryapp.service.BooksService;
import com.genpact.libraryapp.service.LibraryService;

@RestController
public class LibraryController {

	@Autowired
	@Qualifier("bookService")
	BooksService bookService;

	@Autowired
	@Qualifier("libService")
	LibraryService libraryService;

	@RequestMapping(method = RequestMethod.GET, value = "/books")
	public List<Books> getbooks() {
		List<Books> book = new ArrayList<>();
		bookService.getAllBooks();
		return book;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/libraries")
	public ResponseEntity<List<Library>> getLibs() {
		return ResponseEntity.ok(libraryService.getAllLibraries());
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/addbook")
	public ResponseEntity<Books> savebooks(@RequestBody BooksDTO bookDto) {
		return ResponseEntity.ok(bookService.addBook(bookDto));

	}
}
