package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.PromotionEntity;
import com.spring.henallux.dataAccess.repository.PromotionRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Promotion;

@Service
@Transactional
public class PromotionDAO {
	@Autowired
	private PromotionRepository promotionRepository;
	@Autowired
	private ProviderConverter providerConverter;

	public ArrayList<Promotion> getPromotionsActuelles(){
		ArrayList<Promotion> promotions = new ArrayList<Promotion>();
		List<PromotionEntity> promotionEntities = promotionRepository.findAllValidPromoForArticles();
		
		for(PromotionEntity promotionEntity : promotionEntities){
			Promotion promotion = providerConverter.promotionEntityToPromotionModel(promotionEntity);
			promotions.add(promotion);
		}
		return promotions;
	}
	public ArrayList<Promotion> getAllPromotions(){
		ArrayList<Promotion> promotions = new ArrayList<Promotion>();
		List<PromotionEntity> promotionEntities = promotionRepository.findAll();
	
		for(PromotionEntity promotionEntity : promotionEntities){
			Promotion promotion = providerConverter.promotionEntityToPromotionModel(promotionEntity);
			promotions.add(promotion);
		}
		return promotions;
	}
	public Promotion getOne(Integer id){
		PromotionEntity ent = promotionRepository.getOne(id);
		if(ent == null)
			return null;
		return providerConverter.promotionEntityToPromotionModel(ent);
	}
}
