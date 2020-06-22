package com.genpact.libraryapp.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * @author saurav.das
 *
 */

@Entity
@Table(name = "books")
public class Books implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2104250046738897819L;

	@Id
	@Column(name = "isbn")
	private String isbn;

	@Column(name = "book_title")
	private String bookTitle;

	@Column(name = "publisher")
	private String publisher;
	
	@Column(name = "author")
	private String author;

	@Column(name = "published_year")
	private int published;
	
	@Column(name = "borrowed_date")
	private String borrowedDate;
	
	@Column(name = "due_date")
	private String dueDate;		
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "library",nullable= false)
	private Library lib;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublished() {
		return published;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	public String getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(String borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Library getLib() {
		return lib;
	}

	public void setLib(Library lib) {
		this.lib = lib;
	}

}
