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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private long id;

	@Column(name = "lname")
	private String lname;
	@Column(name = "fname")
	private String fname;
	@JsonIgnore
	@Column(name = "password")
	private String password;
	@Column(name = "username")
	private String username;
	@Column(name = "role")
	private String role;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@OneToMany(mappedBy = "user")
	private Set<Collections> Collections = new HashSet<>();
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private Set<BookClubUsers> bookclubs;
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private Set<WishList> wishlist;
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private Set<Download> downloads;
	// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
	// property = "idReview")
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private Set<Review> reviews;

	public Set<Collections> getCollections() {
		return Collections;
	}

	public void setCollections(Set<Collections> collections) {
		Collections = collections;
	}

	public Set<BookClubUsers> getBookclubs() {
		return bookclubs;
	}

	public void setBookclubs(Set<BookClubUsers> bookclubs) {
		this.bookclubs = bookclubs;
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

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

}
