package com.spring.henallux.dataAccess.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="fournisseur")
public class FournisseurEntity {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="nom")
	private String nom;
	@Column(name="adresse")
	private String adresse;
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="fournisseurEntity")
	private Collection<ArticleEntity> articles;
	
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<ArticleEntity> getArticles() {
		return articles;
	}
	public void setArticles(Collection<ArticleEntity> articles) {
		this.articles = articles;
	}	
}
