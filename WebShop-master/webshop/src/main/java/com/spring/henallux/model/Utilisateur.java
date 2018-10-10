package com.spring.henallux.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Utilisateur {

	private Integer id;
	@NotEmpty
	@Size(min=3, max=50)
	private String nom;
	@NotEmpty
	@Size(min=3, max=50)
	private String prenom;
	@Size(min=0, max=10)
	private String telephone;
	@NotEmpty
	@Size(min=3, max=50)
	@Email
	private String email;
	@NotEmpty
	@Size(min=3, max=50)
	private String motDePasse;
	@NotEmpty
	@Size(min=3, max=50)
	private String confirmationMotDePasse;
	@NotEmpty
	@Size(min=3, max=50)
	private String rue;
	@Min(1)
	@Max(999)
	@NotNull
	private Integer numeroRue;
	@Min(0)
	@Max(50)
	private Integer etage;
	@NotEmpty
	@Size(min=3, max=50)
	private String localite;
	@Min(100)
	@Max(9999)
	@NotNull
	private Integer codePostal;
	@NotEmpty
	@Size(min=3, max=50)
	private String pays;
	
	private boolean inscrit;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getConfirmationMotDePasse() {
		return confirmationMotDePasse;
	}
	public void setConfirmationMotDePasse(String confirmationMotDePasse) {
		this.confirmationMotDePasse = confirmationMotDePasse;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public Integer getNumeroRue() {
		return numeroRue;
	}
	public void setNumeroRue(Integer numeroRue) {
		this.numeroRue = numeroRue;
	}
	public Integer getEtage() {
		return etage;
	}
	public void setEtage(Integer etage) {
		this.etage = etage;
	}
	public String getLocalite() {
		return localite;
	}
	public void setLocalite(String localite) {
		this.localite = localite;
	}
	public Integer getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public boolean isInscrit() {
		return inscrit;
	}
	public void setInscrit(boolean inscrit) {
		this.inscrit = inscrit;
	}
	
}
