package com.spring.henallux.dataAccess.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.TraductionCategorieEntity;

@Repository
@Transactional
public interface TraductionCategorieRepository extends JpaRepository<TraductionCategorieEntity, Integer>{
	String REQUEST = "select t.nom from TraductionCategorieEntity t where t.categorieEntity.id = :idcat and t.langageEntity.id = :idlang";
	
	@Query(REQUEST)
	public String findLibelleCategorieByLangage(@Param("idcat") Integer idcat, @Param("idlang")Integer idlang);
}
