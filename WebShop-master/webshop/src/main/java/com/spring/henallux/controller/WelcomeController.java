package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CategorieDAO;
import com.spring.henallux.dataAccess.dao.PromotionDAO;
import com.spring.henallux.dataAccess.dao.UtilisateurDAO;
import com.spring.henallux.model.LoginForm;
import com.spring.henallux.model.Utilisateur;
import com.spring.henallux.service.CryptageMotDePasse;

@Controller
@RequestMapping(value="/welcome")
@SessionAttributes({WelcomeController.CURRENTUSER, WelcomeController.NBARTICLESTOTAL})
public class WelcomeController {
	
	protected static final String CURRENTUSER = "currentUser";
	protected static final String NBARTICLESTOTAL = "nbArticlesTotal";
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	@Autowired
	private CategorieDAO categorieDAO;
	@Autowired
	private PromotionDAO promotionDAO;
	
	@ModelAttribute(CURRENTUSER)
	public Utilisateur user()
	{
		return new Utilisateur();
	}
	
	@ModelAttribute(NBARTICLESTOTAL)
	public Integer getNbArticlesTotal(){
		return new Integer(0);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model,Locale locale, @ModelAttribute(CURRENTUSER)Utilisateur currentUser) {
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		model.addAttribute("promotionsActuelles",promotionDAO.getPromotionsActuelles());
		model.addAttribute("currentPage", "welcome");
		return "integrated:welcome";
	}
	@RequestMapping(method=RequestMethod.GET, value="/contact")
	public String contact(Model model,Locale locale, @ModelAttribute(CURRENTUSER)Utilisateur currentUser) {
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		model.addAttribute("currentPage", "contact");
		return "integrated:contact";
	}
}
