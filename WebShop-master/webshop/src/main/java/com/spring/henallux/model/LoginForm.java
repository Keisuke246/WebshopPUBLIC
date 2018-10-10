package com.spring.henallux.model;

public class LoginForm {

	private String email;
	private String motDePasse;
	
	public LoginForm(){};
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
}
