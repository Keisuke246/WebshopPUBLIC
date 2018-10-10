package com.spring.henallux.dataAccess.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.henallux.dataAccess.entity.ArticleEntity;
import com.spring.henallux.dataAccess.entity.CommandeEntity;

@Repository
@Transactional
public interface CommandeRepository extends JpaRepository<CommandeEntity, Integer>  {
	public CommandeEntity findByBitcoinAddress(@Param("bitcoinAddress")String bitcoinAddress);
	public ArrayList<CommandeEntity> findByUtilisateurEntityId(@Param("idUtilisateur")Integer idutilisateur);
}
