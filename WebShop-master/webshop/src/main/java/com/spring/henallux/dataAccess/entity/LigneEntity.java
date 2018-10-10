package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ligne")
public class LigneEntity {

	@Id
	@GeneratedValue
	@Column(name="numero")
	private Integer numero;
	@Column(name="quantite")
	private Integer quantite;
	@Column(name="prixarticle")
	private Double prixArticle;
	
	@JoinColumn(name="idarticle", referencedColumnName="id")
	@ManyToOne
	private ArticleEntity articleEntity;
	@JoinColumn(name="numcommande", referencedColumnName="numero")
	@ManyToOne
	private CommandeEntity commandeEntity;
	
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
	public ArticleEntity getArticleEntity() {
		return articleEntity;
	}
	public void setArticleEntity(ArticleEntity articleEntity) {
		this.articleEntity = articleEntity;
	}
	public CommandeEntity getCommandeEntity() {
		return commandeEntity;
	}
	public void setCommandeEntity(CommandeEntity commandeEntity) {
		this.commandeEntity = commandeEntity;
	}
}
