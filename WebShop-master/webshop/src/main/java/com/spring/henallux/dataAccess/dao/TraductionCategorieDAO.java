package com.spring.henallux.dataAccess.dao;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.repository.TraductionCategorieRepository;

@Service
@Transactional
public class TraductionCategorieDAO {

	@Autowired
	private TraductionCategorieRepository traductionCategorieRepository;
	
	public String getTraductionsLibelleCategorie(Integer idLang, Integer idCat){
		return traductionCategorieRepository.findLibelleCategorieByLangage(idCat, idLang);
	}
}
