package com.spring.henallux.dataAccess.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="langage")
public class LangageEntity {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Column(name="nom")
	private String nom;
	
	@OneToMany(mappedBy="langageEntity")
	private Collection<TraductionCategorieEntity> traductionCategories;
	
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
	public Collection<TraductionCategorieEntity> getTraductionCategories() {
		return traductionCategories;
	}
	public void setTraductionCategories(Collection<TraductionCategorieEntity> traductionCategories) {
		this.traductionCategories = traductionCategories;
	}	
}
