package com.spring.henallux.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

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
import com.spring.henallux.dataAccess.dao.PromotionDAO;
import com.spring.henallux.model.Promotion;
import com.spring.henallux.model.Utilisateur;

@Controller
@RequestMapping(value="/promotions")
@SessionAttributes("currentUser")
public class PromotionsController {

	@Autowired
	private CategorieDAO categorieDAO;
	@Autowired
	private PromotionDAO promotionDAO;
	@Autowired
	private ArticleDAO articleDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, @ModelAttribute(value="currentUser")Utilisateur currentUser, Locale locale) {
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		model.addAttribute("promotions", promotionDAO.getAllPromotions());
		model.addAttribute("currentPage", "promotions");
		return "integrated:promotions";
	}
	@RequestMapping(method=RequestMethod.GET, value="/{idPromo}")
	public String getArticles(Model model, @ModelAttribute(value="currentUser")Utilisateur currentUser,@PathVariable Integer idPromo, Locale locale) {
		Promotion promo = promotionDAO.getOne(idPromo);
		if(promo == null)
			return "redirect:/promotions";
		
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		model.addAttribute("articles", articleDAO.getArticlesByPromotion(idPromo));
		model.addAttribute("currentPage", "promotions");
		model.addAttribute("pageTitle", promo.getNom());
		return "integrated:boutique";
	}
}
