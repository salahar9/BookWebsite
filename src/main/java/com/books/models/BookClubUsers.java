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
@Table(name = "BookClubUsers")
public class BookClubUsers {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idBookclubusers")
	private long idBookClubUsers;
	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonBackReference
	@JoinColumn(name = "idUser", nullable = false)
	private User user;
	@ManyToOne(cascade = CascadeType.MERGE)

	@JoinColumn(name = "idBookClub", nullable = false)
	private BookClub bookclub;
	@Column(name = "dateBookClub")
	private Date dateBookClub = new Date();

	public long getIdBookClubUsers() {
		return idBookClubUsers;
	}

	public void setIdBookClubUsers(long idBookClubUsers) {
		this.idBookClubUsers = idBookClubUsers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public BookClub getBookclub() {
		return bookclub;
	}

	public void setBookclub(BookClub bookclub) {
		this.bookclub = bookclub;
	}

	public Date getDateBookClub() {
		return dateBookClub;
	}

	public void setDateBookClub(Date dateBookClub) {
		this.dateBookClub = dateBookClub;
	}

	public BookClubUsers() {

	};

	public BookClubUsers(User user, BookClub bookclub) {
		this.user = user;
		this.bookclub = bookclub;
	}

}
