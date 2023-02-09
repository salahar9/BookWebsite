package com.books.DTOs;

public class ReviewInsert {

	private String commentaire;

	private Double rating;

	private Long book;

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

	public Long getBook() {
		return book;
	}

	public void setBook(Long book) {
		this.book = book;
	}
}
