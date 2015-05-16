package com.baptistebilly.test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

import com.baptistebilly.dao.UtilisateurDAO;
import com.baptistebilly.model.Utilisateur;

public class Test {
	public static void main(String[] args) {
		UtilisateurDAO user_dao = new UtilisateurDAO();
		//user_dao.creerUtilisateur();
		/*
		String userPassword="toto";
		
		System.out.println(encryptedPassword);
		*/
		//Utilisateur u = new Utilisateur("demo","demo@yopmail.com","DEMO","DEMO");
		//user_dao.creerUtilisateur(u, "demo");
		//user_dao.connexion("demo@yopmail.com", "demo");
		//Utilisateur u = user_dao.getUser((long) 5);
		//System.out.println(u.getMail());
	}
}
