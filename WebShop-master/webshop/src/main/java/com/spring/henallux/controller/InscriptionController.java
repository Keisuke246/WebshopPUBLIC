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
import com.spring.henallux.model.Utilisateur;

@Controller
@RequestMapping(value="/inscription")
@SessionAttributes({"currentuser"})
public class InscriptionController {
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	
	@Autowired
	private CategorieDAO categorieDAO;

	@RequestMapping(method=RequestMethod.GET)
	public String home(Model model, @ModelAttribute(value="currentUser")Utilisateur currentUser, Locale locale) {
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		return "integrated:inscription";
	}
	@RequestMapping(method=RequestMethod.POST, value="/send")
	public String register(Model model,@ModelAttribute(value="currentUser")@Valid Utilisateur currentUser,final BindingResult errors,Locale locale){
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		if(!errors.hasErrors()){
			if(utilisateurDAO.getUtilisateurByEmail(currentUser.getEmail()) != null){
				errors.rejectValue("email", "registered.email");
				return "integrated:inscription";
			}
			currentUser = utilisateurDAO.sauvegarderUtilisateur(currentUser);
			return "redirect:/welcome";
		}
		else{
			if(!currentUser.getConfirmationMotDePasse().equals(currentUser.getMotDePasse()))
				errors.rejectValue("confirmationMotDePasse", "notmatch.password");
			return "integrated:inscription";
		}
	}
	@RequestMapping(method=RequestMethod.GET, value="/send")
	public String registerBis(Model model,@ModelAttribute(value="currentUser")@Valid Utilisateur currentUser,final BindingResult errors,Locale locale){
		return "redirect:/inscription";
	}
}
