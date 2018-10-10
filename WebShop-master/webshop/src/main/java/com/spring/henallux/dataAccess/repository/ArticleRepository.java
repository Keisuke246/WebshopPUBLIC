package com.spring.henallux.dataAccess.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.ArticleEntity;

@Repository
@Transactional
public interface ArticleRepository extends JpaRepository<ArticleEntity, Integer>{

	//String REQUEST = "select a from ArticleEntity a where a.categorieEntity.id = :idcat"; // Requête SQL pour récupérer les articles d'une catégorie
	
	//@Query(REQUEST)
	public ArrayList<ArticleEntity> findByCategorieEntityId(@Param("idcat")Integer idCat);
	public ArrayList<ArticleEntity> findByPromotionEntityId(@Param("idpromotion")Integer idpromotion);
}
