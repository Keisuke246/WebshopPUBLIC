package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.henallux.dataAccess.entity.CategorieEntity;
import com.spring.henallux.dataAccess.repository.CategorieRepository;
import com.spring.henallux.dataAccess.repository.TraductionCategorieRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Categorie;

@Service
@Transactional
public class CategorieDAO {

	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private ProviderConverter providerConverter;
	@Autowired
	private TraductionCategorieRepository traductionCategorieRepository;

	
	public ArrayList<Categorie> getCategories(String locale){
		int codeLanguage = 2;
		
		if(locale.equals("en"))
			codeLanguage=1;
		
		List<CategorieEntity> categorieEntities = categorieRepository.findAll();
		ArrayList<Categorie> categories = new ArrayList<Categorie>();
		for(CategorieEntity categorieEntity : categorieEntities){
			Categorie categorie = providerConverter.categorieEntityToCategorieModel(categorieEntity);
			categorie.setLibelle(traductionCategorieRepository.findLibelleCategorieByLangage(categorie.getId(), codeLanguage));
			categories.add(categorie);
		}
		
		
		return categories;
	}
}
