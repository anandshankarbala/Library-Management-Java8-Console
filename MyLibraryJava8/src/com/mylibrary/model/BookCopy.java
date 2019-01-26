package com.mylibrary.model;

import java.util.Date;

public class BookCopy {

	private Integer bookId;
	private Integer customerId;
	private Date dueDate;
	public BookCopy(Integer bookId, Integer customerId, Date dueDate) {
		super();
		this.bookId = bookId;
		this.customerId = customerId;
		this.dueDate = dueDate;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "BookCopy [bookId=" + bookId + ", customerId=" + customerId + ", dueDate=" + dueDate + "]";
	}
	
}
