package com.spring.henallux.dataAccess.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="commande")
public class CommandeEntity {

	@Id
	@GeneratedValue
	@Column(name="numero")
	private Integer numero;
	@Column(name="datecommande")
	private Date date;
	@Column(name="etat")
	private String etat;
	@Column(name="bitcoinaddress")
	private String bitcoinAddress;
	
	@JoinColumn(name="idutilisateur", referencedColumnName="id")
	@ManyToOne
	private UtilisateurEntity utilisateurEntity;
	
	@OneToMany(mappedBy="commandeEntity")
	private Collection<LigneEntity> lignes;
	
	@Column(name="prixtotal")
	private double prixTotal;
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public UtilisateurEntity getUtilisateurEntity() {
		return utilisateurEntity;
	}
	public void setUtilisateurEntity(UtilisateurEntity utilisateurEntity) {
		this.utilisateurEntity = utilisateurEntity;
	}
	public Collection<LigneEntity> getLignes() {
		return lignes;
	}
	public void setLignes(Collection<LigneEntity> lignes) {
		this.lignes = lignes;
	}
	public String getBitcoinAddress() {
		return bitcoinAddress;
	}
	public void setBitcoinAddress(String bitcoinAddress) {
		this.bitcoinAddress = bitcoinAddress;
	}
	public double getPrixTotal() {
		return prixTotal;
	}
	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
	
}
