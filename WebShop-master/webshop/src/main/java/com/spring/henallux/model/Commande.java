package com.spring.henallux.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande {
	public final static String ETATATTENTE = "attente";
	public final static String ETATPAYE = "paye";
	public final static String ETATPREPARE = "prepare";
	public final static String ETATLIVRAISON = "livraison";
	public final static String ETATLIVRE = "livre";

	private Integer numero;
	private Date date;
	private String etat;
	private Utilisateur utilisateur;
	private List<Ligne> lignes;
	private String bitcoinAddress;
	private double prixTotal;
	
	public Commande() {lignes = new ArrayList<Ligne>();}
	public Commande(Utilisateur utilisateur){
		this.utilisateur = utilisateur;
		date = new Date();
		etat = ETATATTENTE;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public List<Ligne> getLignes() {
		return lignes;
	}
	public void setLignes(List<Ligne> lignes) {
		this.lignes = lignes;
	}
	public void addLigne(Ligne ligne){
		this.lignes.add(ligne);
	}
	public String getBitcoinAddress() {
		return bitcoinAddress;
	}
	public void setBitcoinAddress(String bitcoinAddress) {
		this.bitcoinAddress = bitcoinAddress;
	}
	public double getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
	
}
