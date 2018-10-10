package com.spring.henallux.controller;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;

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
import com.spring.henallux.dataAccess.dao.CommandeDAO;
import com.spring.henallux.model.AddItemForm;
import com.spring.henallux.model.Article;
import com.spring.henallux.model.Commande;
import com.spring.henallux.model.Ligne;
import com.spring.henallux.model.Utilisateur;
import com.spring.henallux.service.BitcoinWallet;

@Controller
@RequestMapping(value="/panier")
@SessionAttributes({PanierController.CURRENTCART, PanierController.NBARTICLESTOTAL, "currentUser"})
public class PanierController {

	protected static final String CURRENTCART = "currentCart";
	protected static final String NBARTICLESTOTAL = "nbArticlesTotal";

	@ModelAttribute(CURRENTCART)
	public HashMap<Integer, Integer> getCurrentCart(){
		return new HashMap<Integer, Integer>();
	}
	
	@ModelAttribute(NBARTICLESTOTAL)
	public Integer getNbArticlesTotal(){
		return new Integer(0);
	}
	@ModelAttribute("currentUser")
	public Utilisateur user()
	{
		return new Utilisateur();
	}
	
	@Autowired
	private CategorieDAO categorieDAO;
	@Autowired
	private ArticleDAO articleDAO;
	@Autowired
	private CommandeDAO commandeDAO;
	@Autowired
	private BitcoinWallet wallet;

	@RequestMapping(method=RequestMethod.GET)
	public String listePanier(Model model, @ModelAttribute(value=CURRENTCART)HashMap<Integer, Integer> cart,@ModelAttribute(value=NBARTICLESTOTAL) Integer nbArticlesTotal, Locale locale){
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));

		HashMap<Article, Integer> articles = new HashMap<Article,Integer>();
		
		int total = 0;
		double cout = 0;
		for (Entry<Integer, Integer> entry: cart.entrySet()) {
			total += entry.getValue();
			Article art = articleDAO.getOneArticle(entry.getKey());

			cout += art.getPrix() * entry.getValue();
			articles.put(art, entry.getValue());
		}
		
		nbArticlesTotal = total;
		model.addAttribute("nbArticlesTotal", nbArticlesTotal);
		model.addAttribute("coutTotal", cout);
		model.addAttribute("articlesPanier", articles);
		
		return "integrated:panier";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/add/{idArticle}/{qty}")
	public String ajoutPanier(Model model, @PathVariable Integer idArticle, @PathVariable Integer qty,  @ModelAttribute(value=CURRENTCART)HashMap<Integer, Integer> cart, @ModelAttribute(value=NBARTICLESTOTAL) Integer nbArticlesTotal, Locale locale){
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		
		if(qty <= 0){
			return "redirect:/panier";
		}
		
		if(cart.containsKey(idArticle))
		{
			Integer val = cart.get(idArticle);
			
			//cart.replace(idArticle, val, val + qty);
		} else {
			cart.put(idArticle, qty);
		}
		
		nbArticlesTotal = calculNbArticles(cart);
		
		return "redirect:/panier";
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/update/{idArticle}/{qty}")
	public String updatePanier(Model model, @PathVariable Integer idArticle, @PathVariable Integer qty,  @ModelAttribute(value=CURRENTCART)HashMap<Integer, Integer> cart, @ModelAttribute(value=NBARTICLESTOTAL) Integer nbArticlesTotal, Locale locale){
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		
		if(qty <= 0){
			return "redirect:/panier";
		}
		
		if(cart.containsKey(idArticle))
		{
			Integer val = cart.get(idArticle);
			
			cart.replace(idArticle, val, qty);
		} else {
			return "redirect:/panier";
		}
		
		nbArticlesTotal = calculNbArticles(cart);
		
		return "redirect:/panier";
	}
	@RequestMapping(method=RequestMethod.GET, value="/delete/{idArticle}")
	public String deletePanier(Model model, @PathVariable Integer idArticle, @ModelAttribute(value=CURRENTCART)HashMap<Integer, Integer> cart, @ModelAttribute(value=NBARTICLESTOTAL) Integer nbArticlesTotal, Locale locale){
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));
		
		if(cart.containsKey(idArticle)){
			cart.remove(idArticle);
		} else {
			return "redirect:/panier";
		}
		
		nbArticlesTotal = calculNbArticles(cart);
		
		return "redirect:/panier";
	}

	@RequestMapping(method=RequestMethod.GET, value="/valider")
	public String validerCommande(Model model, @ModelAttribute(value=CURRENTCART)HashMap<Integer,Integer> cart, @ModelAttribute(value="currentUser")Utilisateur user,  Locale locale){
		if(!user.isInscrit()){
			return "redirect:/connexion/";
		}
		model.addAttribute("categories", categorieDAO.getCategories(locale.getLanguage()));

		if(cart.size() == 0){
			return "redirect:/panier/";
		}
			
		HashMap<Article, Integer> articles = new HashMap<Article,Integer>();
		
		int total = 0;
		double cout = 0;
		for (Entry<Integer, Integer> entry: cart.entrySet()) {
			total += entry.getValue();
			Article art = articleDAO.getOneArticle(entry.getKey());

			cout += art.getPrix() * entry.getValue();
			articles.put(art, entry.getValue());
		}
		
		model.addAttribute("nbArticlesTotal", total);
		model.addAttribute("coutTotal", cout);
		model.addAttribute("articlesPanier", articles);
		
		return "integrated:validation";
	}
	@RequestMapping(method=RequestMethod.GET, value="/commander")
	public String passerCommande(Model model, @ModelAttribute(value=CURRENTCART)HashMap<Integer,Integer> cart, @ModelAttribute(value="currentUser")Utilisateur user){
		if(!user.isInscrit()){
			return "redirect:/connexion/";
		}
		Commande commande = new Commande(user);
		List<Ligne> lignes = new ArrayList<Ligne>();
		double prixTotal = 0;
		for(Entry<Integer, Integer> entry : cart.entrySet()){
			Article article = articleDAO.getOneArticle(entry.getKey());

			double prix = article.getPrix();
			prixTotal += prix * entry.getValue();

			Ligne ligne = new Ligne(commande, article, prix, entry.getValue());
			lignes.add(ligne);
		}
		commande.setPrixTotal(prixTotal);
		commande.setBitcoinAddress(wallet.getNewAddress());

		commande = commandeDAO.addCommande(commande, lignes);
		model.addAttribute(CURRENTCART, new HashMap<Integer, Integer>());
		model.addAttribute(NBARTICLESTOTAL, 0);
		
		return "redirect:/commande/payer/" + commande.getNumero().toString();

	}

	private Integer calculNbArticles(HashMap<Integer, Integer> cart) {
		int total = 0;
		for (Entry<Integer, Integer> entry: cart.entrySet()) {
			total += entry.getValue();
		}
		
		return total;
	}

}
