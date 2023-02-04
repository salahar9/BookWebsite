package com.books.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "BookClub")
public class BookClub {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idBookClub")
	private long idBookClub;
	@Column(name = "nomBookClub")
	private String nomBookClub;
	@CreatedDate
	@Column(name = "dateBookClub")
	private Date dateBookClub = new Date();
//	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "soldiers")
//	private List<Medal> medals;
	@OneToMany(mappedBy = "bookclub", cascade = { CascadeType.PERSIST })
	@JsonBackReference
	private Set<BookClubUsers> bookclubs = new HashSet<>();

	public long getIdBookClub() {
		return idBookClub;
	}

	public void setIdBookClub(long idBookClub) {
		this.idBookClub = idBookClub;
	}

	public String getNomBookClub() {
		return nomBookClub;
	}

	public void setNomBookClub(String nomBookClub) {
		this.nomBookClub = nomBookClub;
	}

	public Date getDateBookClub() {
		return dateBookClub;
	}

	public void setDateBookClub(Date dateBookClub) {
		this.dateBookClub = dateBookClub;
	}

	public Set<BookClubUsers> getBookclubs() {
		return bookclubs;
	}

	public void setBookclubs(Set<BookClubUsers> bookclubs) {
		this.bookclubs = bookclubs;
	}

}
