package com.genpact.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genpact.libraryapp.domain.Books;

public interface BooksRepository extends JpaRepository<Books, String> {
}
