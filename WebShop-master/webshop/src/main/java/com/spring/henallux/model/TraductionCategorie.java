package com.spring.henallux.model;

public class TraductionCategorie {

	private Integer idTraductionCategorie;
	private String nom;
	private Langage langage;
	private Categorie categorie;
	
	public Integer getIdTraductionCategorie() {
		return idTraductionCategorie;
	}
	public void setIdTraductionCategorie(Integer idTraductionCategorie) {
		this.idTraductionCategorie = idTraductionCategorie;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Langage getLangage() {
		return langage;
	}
	public void setLangage(Langage langage) {
		this.langage = langage;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
