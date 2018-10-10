package com.spring.henallux.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.ArticleDAO;
import com.spring.henallux.dataAccess.dao.CategorieDAO;
import com.spring.henallux.model.Article;
import com.spring.henallux.model.Utilisateur;


@Controller
@RequestMapping(value="/boutique")
public class BoutiqueController {
	@Autowired
	private CategorieDAO categorieDAO;
	@Autowired
	private ArticleDAO articleDAO;

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, Locale locale) {
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		model.addAttribute("articles", articleDAO.getAllArticles());
		model.addAttribute("currentPage", "boutique");
		return "integrated:boutique";
	}
	@RequestMapping(method=RequestMethod.GET, value="/categorie/{idArticle}")
	public String produitsCategorie(Model model, Locale locale,
	@PathVariable Integer idArticle)
	{
		model.addAttribute("idcategorie", idArticle);
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		model.addAttribute("articles", articleDAO.getArticlesByCategorie(idArticle));
		model.addAttribute("currentPage", "categorie");
		return "integrated:categories";
	}
	@RequestMapping(method=RequestMethod.GET, value="/{idArticle}")
	public String detailsProduit(Model model, Locale locale,
	@PathVariable Integer idArticle)
	{
		Article art = articleDAO.getOneArticle(idArticle);
		if(art == null){
			return "redirect:/boutique";
		}
		
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		model.addAttribute("article", art);
		return "integrated:detailsArticle";
	}
}
