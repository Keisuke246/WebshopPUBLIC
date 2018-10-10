package com.spring.henallux.dataAccess.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="promotion")
public class PromotionEntity {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="datedebut")
	private Date dateDebut;
	@Column(name="datefin")
	private Date dateFin;
	@Column(name="pourcpromo")
	private Double pourcPromo;
	@Column(name="nom")
	private String nom;
	
	@OneToMany(mappedBy="promotionEntity")
	private Collection<ArticleEntity> articles;

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

	public Collection<ArticleEntity> getArticles() {
		return articles;
	}

	public void setArticles(Collection<ArticleEntity> articles) {
		this.articles = articles;
	}
}
