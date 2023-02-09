package com.books.DTOs;

import java.util.List;

public class BookInsert {
	private long id;

	private String nomLivre;
	private String nomAuteur;
	private int edition;
	private String maisonEdition;
	private String pathPdf;
	private String pathEpub;
	private List<Long> idGenres;

	public String getNomLivre() {
		return nomLivre;
	}

	public void setNomLivre(String nomLivre) {
		this.nomLivre = nomLivre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<Long> getIdGenres() {
		return idGenres;
	}

	public void setIdGenres(List<Long> idGenres) {
		this.idGenres = idGenres;
	}
}
