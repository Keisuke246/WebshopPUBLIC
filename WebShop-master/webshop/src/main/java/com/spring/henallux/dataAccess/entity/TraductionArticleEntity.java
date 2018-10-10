package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="traductionarticle")
public class TraductionArticleEntity {

	@Id
	@GeneratedValue
	@Column(name="idtraductionarticle")
	private Integer idTraductionArticleEntity;
	@Column(name="description")
	private String description;
	@Column(name="nom")
	private String nom;
	
	@JoinColumn(name="idlangage", referencedColumnName="id")
	@ManyToOne
	private LangageEntity langageEntity;
	@JoinColumn(name="idarticle", referencedColumnName="id")
	@ManyToOne
	private ArticleEntity articleEntity;
	
	public Integer getIdTraductionArticleEntity() {
		return idTraductionArticleEntity;
	}
	public void setIdTraductionArticleEntity(Integer idTraductionArticleEntity) {
		this.idTraductionArticleEntity = idTraductionArticleEntity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
