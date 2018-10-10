package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.UtilisateurEntity;
import com.spring.henallux.dataAccess.repository.UtilisateurRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Utilisateur;
import com.spring.henallux.service.CryptageMotDePasse;

@Service
@Transactional
public class UtilisateurDAO {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private ProviderConverter providerConverter;
	/*@Autowired
	private SessionFactory sessionFactory;*/
	
	public ArrayList<String> getEmails(){
		List<UtilisateurEntity> utilisateurEntities = utilisateurRepository.findAll();
		ArrayList<String> emails = new ArrayList<String>();
		for(UtilisateurEntity entity : utilisateurEntities){
			String email = providerConverter.utilisateurEntityEmailToUtilisateurEmail(entity);
			emails.add(email);
		}
		return emails;
	}
	public ArrayList<Utilisateur> getUtilisateurs(){
		List<UtilisateurEntity> utilisateurEntities = utilisateurRepository.findAll();
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		for(UtilisateurEntity entity : utilisateurEntities){
			Utilisateur utilisateur = providerConverter.userEntityToUserModel(entity);
			utilisateurs.add(utilisateur);
		}
		return utilisateurs;
	}
	public Utilisateur getUtilisateurByEmail(String email){
		Utilisateur utilisateur = new Utilisateur();
		UtilisateurEntity utilisateurEntity = utilisateurRepository.findByEmail(email);
		
		if(utilisateurEntity == null)
			return null;
		
		utilisateur = providerConverter.userEntityToUserModel(utilisateurEntity);
		return utilisateur;
	}
	public Utilisateur sauvegarderUtilisateur(Utilisateur utilisateur){
		UtilisateurEntity utilisateurEntity = providerConverter.userModelToUserEntity(utilisateur);
		utilisateurEntity.setMotDePasse(CryptageMotDePasse.getMotDePasseCrypte(utilisateurEntity.getMotDePasse()));
		utilisateurEntity = utilisateurRepository.save(utilisateurEntity);
		return providerConverter.userEntityToUserModel(utilisateurEntity);
	}
	/*public void sauvegarderUtilisateur(Utilisateur utilisateur){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(providerConverter.utilisateurToUtilisateurEntity(utilisateur));
		session.getTransaction().commit();
	}*/
	/*public Utilisateur getUtilisateur(Utilisateur utilisateurlogin)
	{
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Utilisateur utilisateur = new Utilisateur();
		
		Query query = session.getNamedQuery("findUserLogin").setString("email", utilisateurlogin.getEmail()).setString("motDePasse",utilisateurlogin.getMotDePasse());
		UtilisateurEntity userEntity =(UtilisateurEntity)query.uniqueResult();
		utilisateur = providerConverter.userEntityToUserModel(userEntity);
		session.getTransaction().commit();
		return utilisateur;
	}*/
}
