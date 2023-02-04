package com.books.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Collections")
public class Collections {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idCollection")
	private long idCollection;
	@Column(name = "nomCollection")
	private String nomCollection;
	@Column(name = "dateCollection")
	private Date dateCollection;
	@ManyToOne
	@JoinColumn(name = "id", nullable = false)
	private User user;

	public long getIdCollection() {
		return idCollection;
	}

	public void setIdCollection(long idCollection) {
		this.idCollection = idCollection;
	}

	public String getNomCollection() {
		return nomCollection;
	}

	public void setNomCollection(String nomCollection) {
		this.nomCollection = nomCollection;
	}

	public Date getDateCollection() {
		return dateCollection;
	}

	public void setDateCollection(Date dateCollection) {
		this.dateCollection = dateCollection;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

}
