package com.spring.henallux.dataAccess.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.henallux.dataAccess.entity.PromotionEntity;


public interface PromotionRepository extends JpaRepository<PromotionEntity, Integer> {
	
	String VALID_PROMO= "select p from PromotionEntity p "
			+"where p.dateFin > curdate() and p.dateDebut < curdate()";
	
	@Query(VALID_PROMO)
	public ArrayList<PromotionEntity> findAllValidPromoForArticles();
}
