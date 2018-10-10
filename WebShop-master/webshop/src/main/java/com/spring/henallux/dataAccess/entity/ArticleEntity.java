package com.spring.henallux.dataAccess.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="article")
public class ArticleEntity {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="prix")
	private Double prix;
	@Column(name="stock")
	private Integer quantiteStock;
	@Column(name="libelle")
	private String libelle;
	@Column(name="description")
	private String description;
	
	@JoinColumn(name="idfournisseur", referencedColumnName="id")
	@ManyToOne
	private FournisseurEntity fournisseurEntity;
	@JoinColumn(name="idpromotion", referencedColumnName="id")
	@ManyToOne
	private PromotionEntity promotionEntity;
	@JoinColumn(name="idcategorie", referencedColumnName="id")
	@ManyToOne
	private CategorieEntity categorieEntity;
	
	@OneToMany(mappedBy="articleEntity")
	private Collection<LigneEntity> lignes;

	public ArticleEntity(){}
	public ArticleEntity(Integer id){
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Integer getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantiteStock(Integer quantiteStock) {
		this.quantiteStock = quantiteStock;
	}
	public FournisseurEntity getFournisseurEntity() {
		return fournisseurEntity;
	}
	public void setFournisseurEntity(FournisseurEntity fournisseurEntity) {
		this.fournisseurEntity = fournisseurEntity;
	}
	public PromotionEntity getPromotionEntity() {
		return promotionEntity;
	}
	public void setPromotionEntity(PromotionEntity promotionEntity) {
		this.promotionEntity = promotionEntity;
	}
	public CategorieEntity getCategorieEntity() {
		return categorieEntity;
	}
	public void setCategorieEntity(CategorieEntity categorieEntity) {
		this.categorieEntity = categorieEntity;
	}
	public Collection<LigneEntity> getLignes() {
		return lignes;
	}
	public void setLignes(Collection<LigneEntity> lignes) {
		this.lignes = lignes;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
