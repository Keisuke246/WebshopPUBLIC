package com.spring.henallux.dataAccess.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorie")
public class CategorieEntity {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="nom")
	private String libelle;
	
	@OneToMany(mappedBy="categorieEntity")
	private Collection<TraductionCategorieEntity> traductionCategories;
	@OneToMany(mappedBy="categorieEntity")
	private Collection<ArticleEntity> articles;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Collection<TraductionCategorieEntity> getTraductionCategories() {
		return traductionCategories;
	}
	public void setTraductionCategories(Collection<TraductionCategorieEntity> traductionCategories) {
		this.traductionCategories = traductionCategories;
	}
	public Collection<ArticleEntity> getArticles() {
		return articles;
	}
	public void setArticles(Collection<ArticleEntity> articles) {
		this.articles = articles;
	}
}
