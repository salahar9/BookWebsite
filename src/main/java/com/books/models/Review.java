package com.books.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "Review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idReview")
	private long idReview;
	@Column(name = "comm")
	private String commentaire;
	@Column(name = "rating")
	private Double rating;
	@Column(name = "dateReview")
	private Date dateReview = new Date();
	// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
	// property = "idUser")
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idUser", nullable = false)
	private User user;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idBook", nullable = false)
	@JsonIgnore
	private Book book;

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Date getDateReview() {
		return dateReview;
	}

	public void setDateReview(Date dateReview) {
		this.dateReview = dateReview;
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

	public long getIdReview() {
		return idReview;
	}

	public void setIdReview(long idReview) {
		this.idReview = idReview;
	}
}
