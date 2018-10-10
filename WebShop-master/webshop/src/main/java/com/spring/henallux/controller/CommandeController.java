package com.spring.henallux.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.henallux.dataAccess.dao.CategorieDAO;
import com.spring.henallux.dataAccess.dao.CommandeDAO;
import com.spring.henallux.model.Commande;
import com.spring.henallux.model.Utilisateur;

@Controller
@RequestMapping(value="/commande")
@SessionAttributes("currentUser")
public class CommandeController {


	@Autowired
	private CategorieDAO categorieDAO;
	@Autowired
	private CommandeDAO commandeDAO;
	
	@ModelAttribute("currentUser")
	public Utilisateur user()
	{
		return new Utilisateur();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String listeCommandes(Model model, @ModelAttribute("currentUser")Utilisateur user, Locale locale){
		if(!user.isInscrit()){
			return "redirect:/connexion";
		}
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		ArrayList<Commande> lc = commandeDAO.getCommandesByUser(user);
		model.addAttribute("currentOrders", lc);
		return "integrated:commandes";
	}
	@RequestMapping(method=RequestMethod.GET, value="/{idCommande}")
	public String detailCommande(Model model, @ModelAttribute("currentUser")Utilisateur user, @PathVariable Integer idCommande, Locale locale){
		if(!user.isInscrit()){
			return "redirect:/connexion";
		}
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		
		Commande comm = commandeDAO.getCommandeById(idCommande);
		
		if(comm.getUtilisateur().getId() != user.getId())
			return "redirect:/welcome";
		
		model.addAttribute("order", comm);
		
		return "integrated:detailsCommande";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/payer/{idCommande}")
	public String payerCommande(Model model, @ModelAttribute("currentUser")Utilisateur user, @PathVariable Integer idCommande, Locale locale){
		if(!user.isInscrit()){
			return "redirect:/connexion";
		}
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		Commande comm = commandeDAO.getCommandeById(idCommande);
		if(comm.getUtilisateur().getId() != user.getId())
			return "redirect:/welcome";
		
		if(!comm.getEtat().equals(Commande.ETATATTENTE))
			return "redirect:/commande/" + idCommande;
		
		model.addAttribute("order", comm);
		return "integrated:payment";
	}
}