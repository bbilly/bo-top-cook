package com.baptistebilly.model;

import javax.persistence.*;


@Table
@Entity
public class Utilisateur {
	
	private Long id;
	private String pseudo;
	private String mail;
	private String nom;
	private String prenom;
	private String ville;
	private String description;
	private String siteWeb;
	private String hobbies;
	private String etat;
	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String pseudo, String mail, String nom, String prenom) {
		this.pseudo = pseudo;
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.etat = "VALIDE";
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSiteWeb() {
		return siteWeb;
	}
	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	

}
