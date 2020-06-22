package com.genpact.libraryapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.genpact.libraryapp.domain.Library;
import com.genpact.libraryapp.repository.LibraryRepository;

@Service("libService")
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private LibraryRepository libRepository;

	@Override
	public List<Library> getAllLibraries() {
		return libRepository.findAll();
	}

}
