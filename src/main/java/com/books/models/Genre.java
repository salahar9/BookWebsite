package com.books.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BookGenre")
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idGenre")
	private long id;
	@Column(name = "nomGenre")
	private String nomGenre;
	@ManyToMany(mappedBy = "genres", cascade = { CascadeType.MERGE })
	@JsonIgnore
	private Set<Book> books = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomGenre() {
		return nomGenre;
	}

	public void setNomGenre(String nomGenre) {
		this.nomGenre = nomGenre;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
