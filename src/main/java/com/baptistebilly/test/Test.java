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
		Utilisateur u = new Utilisateur("dffdfd","toto@yopmail.com","TEST","marthin");
		System.out.println(user_dao.creerUtilisateur(u, "mother589"));
	}
}
