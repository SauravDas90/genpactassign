package com.genpact.libraryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.genpact.libraryapp.domain.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

}
