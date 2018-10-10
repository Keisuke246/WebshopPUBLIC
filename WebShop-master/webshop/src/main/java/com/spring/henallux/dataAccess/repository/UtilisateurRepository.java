package com.spring.henallux.dataAccess.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.UtilisateurEntity;

@Repository
@Transactional
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Integer> {

	UtilisateurEntity findByEmail(@Param("email") String email);
}
