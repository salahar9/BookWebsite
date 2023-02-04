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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
	@ManyToMany(cascade = { CascadeType.MERGE })
	@JsonIgnore
	@JoinTable(name = "GenreBookMapping", joinColumns = @JoinColumn(name = "idGenre"), inverseJoinColumns = @JoinColumn(name = "idBook"))
	private Set<Book> Books = new HashSet<>();
}
