package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.ArticleEntity;
import com.spring.henallux.dataAccess.entity.CommandeEntity;
import com.spring.henallux.dataAccess.entity.LigneEntity;
import com.spring.henallux.dataAccess.repository.*;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.*;

@Service
@Transactional
public class CommandeDAO {
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private LigneRepository ligneRepository;
	@Autowired
	private ProviderConverter providerConverter;
	
	public Commande addCommande(Commande commande, List<Ligne> lignes){
		CommandeEntity comEntity = providerConverter.commandeModelToCommandeEntity(commande);

		comEntity = commandeRepository.saveAndFlush(comEntity);
		
		List<LigneEntity> lignesEntity = new ArrayList<LigneEntity>();
		for(Ligne ligne : lignes){
			LigneEntity liEntity = providerConverter.ligneModelToLigneEntity(ligne);
			liEntity.setCommandeEntity(comEntity);
			lignesEntity.add(liEntity);
		}
		
		ligneRepository.save(lignesEntity);
		ligneRepository.flush();
		
		return providerConverter.commandeEntityToCommandeModel(comEntity);
	}
	public ArrayList<Commande> getCommandesByUser(Utilisateur user){
		ArrayList<CommandeEntity> lae = commandeRepository.findByUtilisateurEntityId(user.getId());
		ArrayList<Commande> liste = new ArrayList<Commande>();
		for(CommandeEntity ae : lae){
			liste.add(providerConverter.commandeEntityToCommandeModel(ae));
		}
		return liste;
	}
	public Commande getCommandeById(int id){
		CommandeEntity entity = commandeRepository.getOne(id);
		if(entity == null)
			return null;
		return providerConverter.commandeEntityToCommandeModel(entity);
	}
	public Commande getCommandeByBitcoinAddress(String address){
		CommandeEntity entity = commandeRepository.findByBitcoinAddress(address);
		if(entity == null)
			return null;
		return providerConverter.commandeEntityToCommandeModel(entity);
	}
	public void setEtatCommande(Commande commande){
		CommandeEntity entity = commandeRepository.getOne(commande.getNumero());
		entity.setEtat(commande.getEtat());
		commandeRepository.saveAndFlush(entity);
	}
}