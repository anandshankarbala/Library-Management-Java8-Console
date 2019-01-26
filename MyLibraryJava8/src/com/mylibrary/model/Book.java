package com.mylibrary.model;

public class Book {

	private Integer bookId;
	private String title;
	private String author;
	
	public Book(Integer id, String title, String author) {
		this.bookId = id;
		this.title = title;
		this.author = author;
	}
	public Integer getId() {
		return bookId;
	}
	public void setId(Integer id) {
		this.bookId = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "bookId=" + bookId + ", title=" + title + ", author=" + author ;
	}
	
	
}
