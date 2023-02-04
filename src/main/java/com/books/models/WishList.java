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
@Table(name = "WishList")
public class WishList {
	public WishList(User u, Book b) {
		user = u;
		book = b;
	}

	public WishList() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idWishList")
	private long idWishList;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonBackReference
	@JoinColumn(name = "idUser", nullable = false)
	private User user;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idBook", nullable = false)
	@JsonBackReference("book_wishlist")
	private Book book;
	@Column(name = "dateWishList")
	private Date dateWishList = new Date();

	public long getIdWishList() {
		return idWishList;
	}

	public void setIdWishList(long idWishList) {
		this.idWishList = idWishList;
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

	public Date getDateWishList() {
		return dateWishList;
	}

	public void setDateWishList(Date dateWishList) {
		this.dateWishList = dateWishList;
	}

}
