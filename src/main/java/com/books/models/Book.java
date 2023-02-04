package com.books.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idBook")
	private long id;
	@Column(name = "nomLivre")
	private String nomLivre;
	@Column(name = "nomAuteur")
	private String nomAuteur;
	@Column(name = "edition")
	private int edition;
	@Column(name = "maisonEdition")
	private String maisonEdition;
	@Column(name = "pathPdf")
	private String pathPdf;
	@Column(name = "pathEpub")
	private String pathEpub;
	@ManyToMany(mappedBy = "Books", cascade = { CascadeType.MERGE })
	private Set<Genre> genres;
	@OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
	// @JsonManagedReference("book_wishlist")
	private Set<WishList> wishlist;
	@OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
	// @JsonManagedReference("book_downloads")
	private Set<Download> downloads;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomLivre() {
		return nomLivre;
	}

	public void setNomLivre(String nomLivre) {
		this.nomLivre = nomLivre;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getMaisonEdition() {
		return maisonEdition;
	}

	public void setMaisonEdition(String maisonEdition) {
		this.maisonEdition = maisonEdition;
	}

	public String getPathPdf() {
		return pathPdf;
	}

	public void setPathPdf(String pathPdf) {
		this.pathPdf = pathPdf;
	}

	public String getPathEpub() {
		return pathEpub;
	}

	public void setPathEpub(String pathEpub) {
		this.pathEpub = pathEpub;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		genres = genres;
	}

	public Set<WishList> getWishlist() {
		return wishlist;
	}

	public void setWishlist(Set<WishList> wishlist) {
		this.wishlist = wishlist;
	}

	public Set<Download> getDownloads() {
		return downloads;
	}

	public void setDownloads(Set<Download> downloads) {
		this.downloads = downloads;
	}

}
