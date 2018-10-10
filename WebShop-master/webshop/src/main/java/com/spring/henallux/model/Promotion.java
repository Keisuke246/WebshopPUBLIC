package com.spring.henallux.model;

import java.util.Date;

public class Promotion {

	private Integer id;
	private Date dateDebut;
	private Date dateFin;
	private Double pourcPromo;
	private String nom;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Double getPourcPromo() {
		return pourcPromo;
	}

	public void setPourcPromo(Double pourcPromo) {
		this.pourcPromo = pourcPromo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
