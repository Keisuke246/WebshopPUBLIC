package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="typearticle")
public class TypeArticleCategorieEntity {

	@Id
	@GeneratedValue
	@Column(name="idtypearticlecategorie")
	private Integer idTypeArticleCategorie;
	
	@JoinColumn(name="idcategorie", referencedColumnName="id")
	@ManyToOne
	private CategorieEntity categorieEntity;
	@JoinColumn(name="idarticle", referencedColumnName="id")
	@ManyToOne
	private ArticleEntity articleEntity;
	
	public CategorieEntity getCategorieEntity() {
		return categorieEntity;
	}
	public void setCategorieEntity(CategorieEntity categorieEntity) {
		this.categorieEntity = categorieEntity;
	}
	public ArticleEntity getArticleEntity() {
		return articleEntity;
	}
	public void setArticleEntity(ArticleEntity articleEntity) {
		this.articleEntity = articleEntity;
	}
	public Integer getIdTypeArticleCategorie() {
		return idTypeArticleCategorie;
	}
	public void setIdTypeArticleCategorie(Integer idTypeArticleCategorie) {
		this.idTypeArticleCategorie = idTypeArticleCategorie;
	}
}
