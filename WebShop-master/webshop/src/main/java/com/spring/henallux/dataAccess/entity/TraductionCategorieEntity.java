package com.spring.henallux.dataAccess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="traductioncategorie")
public class TraductionCategorieEntity {

	@Id
	@GeneratedValue
	@Column(name="idtraductioncategorie")
	private Integer idTraductionCategorieEntity;
	@Column(name="nom")
	private String nom;
	
	@JoinColumn(name="idlangage",referencedColumnName="id")
	@ManyToOne
	private LangageEntity langageEntity;
	@JoinColumn(name="idcategorie",referencedColumnName="id")
	@ManyToOne
	private CategorieEntity categorieEntity;
	
	public Integer getIdTraductionCategorieEntity() {
		return idTraductionCategorieEntity;
	}
	public void setIdTraductionCategorieEntity(Integer idTraductionCategorieEntity) {
		this.idTraductionCategorieEntity = idTraductionCategorieEntity;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public LangageEntity getLangageEntity() {
		return langageEntity;
	}
	public void setLangageEntity(LangageEntity langageEntity) {
		this.langageEntity = langageEntity;
	}
	public CategorieEntity getCategorieEntity() {
		return categorieEntity;
	}
	public void setCategorieEntity(CategorieEntity categorieEntity) {
		this.categorieEntity = categorieEntity;
	}
}
