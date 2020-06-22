/**
 * 
 */
package com.genpact.libraryapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author saurav.das
 *
 */

@Entity
@Table(name = "library")
public class Library implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3599495726728231087L;

	@Id
	@Column(name = "library_id")
	private Integer libraryId;

	@Column(name = "library_name")
	private String libraryName;

	@Column(name = "library_address")
	private String libraryAddress;	
	

	public Integer getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(Integer libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryAddress() {
		return libraryAddress;
	}

	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}


	@JsonManagedReference
	@OneToMany(mappedBy = "lib", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Books> books = new ArrayList<>();

	public void addBook(Books book) {
		books.add(book);
		book.setLib(this);
	}

	public void removebook(Books book) {
		books.remove(book);
		book.setLib(null);
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

}
