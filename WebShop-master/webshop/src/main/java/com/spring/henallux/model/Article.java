package com.spring.henallux.model;

import java.util.Date;

public class Article {

	private Integer id;
	private String libelle;
	private String description;
	private Double prix;
	private Integer quantiteStock;
	private Fournisseur fournisseur;
	private Promotion promotion;
	private Categorie categorie;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrix() {
		return getPrixPromotion();
	}
	public Double getPrixBase(){
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getQuantiteStock() {
		return quantiteStock;
	}

	public void setQuantiteStock(Integer quantiteStock) {
		this.quantiteStock = quantiteStock;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isPromotionValid(){
		if(getPromotion() == null)
			return false;
		
		Date now = new Date();
		if(promotion.getDateDebut().before(now)){
			if(promotion.getDateFin().after(now)){
				return true;		
			}
		}
		return false;
	}
	public double getPrixPromotion(){
		double price = prix;
		if(isPromotionValid())
			price *= 1 - (promotion.getPourcPromo() / 100);
		return price;
	}
}
	
