package com.spring.henallux.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CategorieDAO;
import com.spring.henallux.dataAccess.dao.UtilisateurDAO;
import com.spring.henallux.model.LoginForm;
import com.spring.henallux.model.Utilisateur;
import com.spring.henallux.service.CryptageMotDePasse;

@Controller
@RequestMapping(value="/connexion")
@SessionAttributes("currentUser")
public class ConnexionController {
	protected static final String NBARTICLESTOTAL = "nbArticlesTotal";
	
	@Autowired
	private CategorieDAO categorieDAO;
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	
	@ModelAttribute("currentUser")
	public Utilisateur user()
	{
		return new Utilisateur();
	}

	@ModelAttribute(NBARTICLESTOTAL)
	public Integer getNbArticlesTotal(){
		return new Integer(0);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model,Locale locale, @ModelAttribute("currentUser")Utilisateur currentUser) {
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		model.addAttribute("loginForm", new LoginForm());
		return "integrated:connexion";
	}
	@RequestMapping(method=RequestMethod.POST, value="/send")
	public String login(Model model,@ModelAttribute(value="currentUser") Utilisateur currentUser, Locale locale,@ModelAttribute(value="loginForm") LoginForm loginForm,final BindingResult errors){
		Utilisateur utilisateur = utilisateurDAO.getUtilisateurByEmail(loginForm.getEmail());
		if(utilisateur == null)
			errors.rejectValue("email", "email.notfound");
		else{
			if(!CryptageMotDePasse.getMotDePasseCrypte(loginForm.getMotDePasse()).equals(utilisateur.getMotDePasse()))
					errors.rejectValue("motDePasse", "wrong.password");
			else {
				utilisateur.setInscrit(true);
				currentUser = utilisateur;
				model.addAttribute("currentUser", currentUser);
				return "redirect:/welcome";
			}
		}
			
		return "integrated:connexion";
	}
	@RequestMapping(method=RequestMethod.GET, value="/send")
	public String loginBis(Model model,@ModelAttribute(value="currentUser") Utilisateur currentUser, Locale locale,@ModelAttribute(value="loginForm") LoginForm loginForm,final BindingResult errors){
		return "redirect:/connexion";
	}
	@RequestMapping(method=RequestMethod.GET, value="/deconnexion")
	public String logout(Model model,Locale locale, @ModelAttribute("currentUser")Utilisateur currentUser) {
		currentUser = new Utilisateur();
		model.addAttribute("currentUser", currentUser);
		
		return "redirect:/welcome";
	}
}
