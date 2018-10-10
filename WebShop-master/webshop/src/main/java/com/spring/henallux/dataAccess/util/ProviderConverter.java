package com.spring.henallux.dataAccess.util;

import org.springframework.stereotype.Component;

import com.spring.henallux.dataAccess.entity.ArticleEntity;
import com.spring.henallux.dataAccess.entity.CategorieEntity;
import com.spring.henallux.dataAccess.entity.CommandeEntity;
import com.spring.henallux.dataAccess.entity.LigneEntity;
import com.spring.henallux.dataAccess.entity.PromotionEntity;
import com.spring.henallux.dataAccess.entity.UtilisateurEntity;
import com.spring.henallux.model.Article;
import com.spring.henallux.model.Categorie;
import com.spring.henallux.model.Commande;
import com.spring.henallux.model.Ligne;
import com.spring.henallux.model.Promotion;
import com.spring.henallux.model.Utilisateur;

@Component
public class ProviderConverter {

	public String utilisateurEntityToUtilisateur(UtilisateurEntity entity){
		return entity.getNom();
	}
	public String utilisateurToUtilisateurEntity(Utilisateur user){
		return user.getNom();
	}
	public String utilisateurEntityEmailToUtilisateurEmail(UtilisateurEntity entity){
		return entity.getEmail();
	}
	public String utilisateurEmailToUtilisateurEntityEmail(Utilisateur user){
		return user.getEmail();
	}
	public UtilisateurEntity userModelToUserEntity(Utilisateur user){
		UtilisateurEntity entity = new UtilisateurEntity();
		entity.setId(user.getId());
		entity.setNom(user.getNom());
		entity.setPrenom(user.getPrenom());
		entity.setTelephone(user.getTelephone());
		entity.setEmail(user.getEmail());
		entity.setCodePostal(user.getCodePostal());
		entity.setEtage(user.getEtage());
		entity.setLocalite(user.getLocalite());
		entity.setMotDePasse(user.getMotDePasse());
		entity.setNumeroRue(user.getNumeroRue());
		entity.setRue(user.getRue());
		entity.setPays(user.getPays());
		return entity;
	}
	public Utilisateur userEntityToUserModel(UtilisateurEntity utilisateurEntity){
		Utilisateur user = new Utilisateur();
		user.setId(utilisateurEntity.getId());
		user.setNom(utilisateurEntity.getNom());
		user.setPrenom(utilisateurEntity.getPrenom());
		user.setTelephone(utilisateurEntity.getTelephone());
		user.setEmail(utilisateurEntity.getEmail());
		user.setCodePostal(utilisateurEntity.getCodePostal());
		user.setEtage(utilisateurEntity.getEtage());
		user.setLocalite(utilisateurEntity.getLocalite());
		user.setMotDePasse(utilisateurEntity.getMotDePasse());
		user.setNumeroRue(utilisateurEntity.getNumeroRue());
		user.setRue(utilisateurEntity.getRue());
		user.setPays(utilisateurEntity.getPays());
		return user;
	}
	public Categorie categorieEntityToCategorieModel(CategorieEntity categorieEntity) {
		Categorie categorie = new Categorie();
		categorie.setId(categorieEntity.getId());
		categorie.setLibelle(categorieEntity.getLibelle());
		return categorie;
	}
	public Article articleEntityToArticleModel(ArticleEntity articleEntity) {
		Article article = new Article();
		article.setId(articleEntity.getId());
		article.setPrix(articleEntity.getPrix());
		article.setQuantiteStock(articleEntity.getQuantiteStock());
		article.setLibelle(articleEntity.getLibelle());
		article.setDescription(articleEntity.getDescription());
		article.setCategorie(categorieEntityToCategorieModel(articleEntity.getCategorieEntity()));
		if(articleEntity.getPromotionEntity() != null)
			article.setPromotion(promotionEntityToPromotionModel(articleEntity.getPromotionEntity()));
		return article;
	}
	//Ne remplis que l'id car on en a besoin qu'à la création d'une commande
	public ArticleEntity articleModelToArticleEntity(Article articleEntity){
		ArticleEntity entity = new ArticleEntity();
		entity.setId(articleEntity.getId());
		return entity;
	}
	public Promotion promotionEntityToPromotionModel(PromotionEntity promotionEntity) {
		Promotion promotion = new Promotion();
		promotion.setId(promotionEntity.getId());
		promotion.setNom(promotionEntity.getNom());
		promotion.setPourcPromo(promotionEntity.getPourcPromo());
		promotion.setDateDebut(promotionEntity.getDateDebut());
		promotion.setDateFin(promotionEntity.getDateFin());
		return promotion;
	}
	public Commande commandeEntityToCommandeModel(CommandeEntity commande){
		Commande model = new Commande();
		model.setDate(commande.getDate());
		model.setEtat(commande.getEtat());
		model.setNumero(commande.getNumero());
		model.setBitcoinAddress(commande.getBitcoinAddress());
		model.setUtilisateur(userEntityToUserModel(commande.getUtilisateurEntity()));
		model.setPrixTotal(commande.getPrixTotal());
		if(commande.getLignes() != null){
			for(LigneEntity le: commande.getLignes()){
				model.addLigne(ligneEntityToLigneModel(le, model));
			}
		}
		return model;
	}
	public CommandeEntity commandeModelToCommandeEntity(Commande commande){
		CommandeEntity entity = new CommandeEntity();
		entity.setDate(commande.getDate());
		entity.setEtat(commande.getEtat());
		entity.setNumero(commande.getNumero());
		entity.setBitcoinAddress(commande.getBitcoinAddress());
		entity.setUtilisateurEntity(userModelToUserEntity(commande.getUtilisateur()));
		entity.setPrixTotal(commande.getPrixTotal());
		return entity;
	}
	public LigneEntity ligneModelToLigneEntity(Ligne ligne){
		LigneEntity entity = new LigneEntity();
		entity.setArticleEntity(new ArticleEntity(ligne.getArticle().getId()));
		entity.setPrixArticle(ligne.getPrixArticle());
		entity.setQuantite(ligne.getQuantite());
		
		return entity;
	}
	public Ligne ligneEntityToLigneModel(LigneEntity ligne, Commande commande){
		Ligne model = new Ligne();
		model.setArticle(articleEntityToArticleModel(ligne.getArticleEntity()));
		model.setCommande(commande);
		model.setNumero(ligne.getNumero());
		model.setPrixArticle(ligne.getPrixArticle());
		model.setQuantite(ligne.getQuantite());
		return model;
	}
}
