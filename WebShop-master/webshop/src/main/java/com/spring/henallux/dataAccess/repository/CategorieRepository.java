package com.spring.henallux.dataAccess.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.CategorieEntity;
@Repository
@Transactional
public interface CategorieRepository extends JpaRepository<CategorieEntity, Integer> {

}
