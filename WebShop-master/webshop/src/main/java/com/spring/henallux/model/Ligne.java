package com.spring.henallux.model;

public class Ligne {

	private Integer numero;
	private Integer quantite;
	private Double prixArticle;
	private Article article;
	private Commande commande;
	
	public Ligne(){}
	public Ligne(Commande com, Article art, Double prix, Integer qte){
		commande = com;
		article = art;
		prixArticle = prix;
		quantite= qte;
	}
	

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Double getPrixArticle() {
		return prixArticle;
	}

	public void setPrixArticle(Double prixArticle) {
		this.prixArticle = prixArticle;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
}
