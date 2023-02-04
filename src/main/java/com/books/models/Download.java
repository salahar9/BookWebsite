package com.books.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Download")
public class Download {
	public Download(User u, Book b) {
		user = u;
		book = b;
	}

	public Download() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idDownload")
	private long idDownload;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonBackReference
	@JoinColumn(name = "idUser", nullable = false)
	private User user;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idBook", nullable = false)
	@JsonBackReference("book_downloads")
	private Book book;
	@Column(name = "dateDownload")
	private Date dateDownload = new Date();

	public long getIdDownload() {
		return idDownload;
	}

	public void setIdDownload(long idDownload) {
		this.idDownload = idDownload;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getDateDownload() {
		return dateDownload;
	}

	public void setDateDownload(Date dateDownload) {
		this.dateDownload = dateDownload;
	}

}
