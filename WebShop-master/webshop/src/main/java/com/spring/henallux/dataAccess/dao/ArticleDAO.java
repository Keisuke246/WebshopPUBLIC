package com.spring.henallux.dataAccess.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.henallux.dataAccess.entity.ArticleEntity;
import com.spring.henallux.dataAccess.repository.ArticleRepository;
import com.spring.henallux.dataAccess.util.ProviderConverter;
import com.spring.henallux.model.Article;

@Service
@Transactional
public class ArticleDAO {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ProviderConverter providerConverter;
	
	public ArrayList<Article>getArticlesByCategorie(Integer idCat){
		ArrayList<ArticleEntity> articleEntities = articleRepository.findByCategorieEntityId(idCat);
		ArrayList<Article> articles = new ArrayList<Article>();
		
		for(ArticleEntity articleEntity : articleEntities){
			Article article = providerConverter.articleEntityToArticleModel(articleEntity);
			articles.add(article);
		}
		return articles;
	}
	public ArrayList<Article>getAllArticles(){
		List<ArticleEntity> articleEntities = articleRepository.findAll();
		ArrayList<Article> articles = new ArrayList<Article>();
		
		for(ArticleEntity articleEntity : articleEntities){
			Article article = providerConverter.articleEntityToArticleModel(articleEntity);
			articles.add(article);
		}
		return articles;
	}
	public Article getOneArticle(Integer idArt){
		Article article = new Article();
		ArticleEntity articleEntity = articleRepository.findOne(idArt);
		article = providerConverter.articleEntityToArticleModel(articleEntity);
		return article;
	}
	public ArrayList<Article> getArticlesByPromotion(Integer idPromo){
		List<ArticleEntity> articleEntities = articleRepository.findByPromotionEntityId(idPromo);
		ArrayList<Article> articles = new ArrayList<Article>();
		
		for(ArticleEntity articleEntity : articleEntities){
			Article article = providerConverter.articleEntityToArticleModel(articleEntity);
			articles.add(article);
		}
		return articles;
	}
	
}
