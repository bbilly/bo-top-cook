package com.baptistebilly.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javassist.convert.Transformer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jasypt.util.password.StrongPasswordEncryptor;

import com.baptistebilly.model.Connexion;
import com.baptistebilly.model.Utilisateur;
import com.baptistebilly.util.HibernateUtil;
import com.baptistebilly.util.SessionIdentifierGenerator;



public class UtilisateurDAO {

	public UtilisateurDAO() {
	}
	
	private Session session = HibernateUtil.getSessionFactory().openSession();

	public Utilisateur getUser(Long id) {
		Query query = session.createQuery("FROM Utilisateur WHERE id = :id");
		query.setParameter("id", id);
		return (Utilisateur) query.uniqueResult();
	}
	
	
		
	public boolean creerUtilisateur(Utilisateur u, String password) {
		Query query = session.createSQLQuery("SELECT count(*) FROM utilisateur WHERE pseudo = :pseudo OR mail=:mail ");
		query.setString("pseudo", u.getPseudo());
		query.setString("mail", u.getMail());
		Integer count = ((BigInteger) query.uniqueResult()).intValue();
		
		//si login ou adresse mail n'existe pas déja en BDD
		if( count == 0 ) {
	        session.beginTransaction();
	        session.save(u);
	        	        
	        //cryptage du mot de passe
	        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			String encryptedPassword = passwordEncryptor.encryptPassword(password);
			Query query2 = session.createSQLQuery("INSERT into connexion(id,password,token) VALUES(:id,:password,'') ");
			query2.setParameter("id", u.getId());
			query2.setParameter("password", encryptedPassword);
			query2.executeUpdate();
			
			//on commit la transaction
			session.getTransaction().commit();
	        return true;
		}
		else {
			return false;
		}
	}
	
	public boolean modifierUtilisateur(Utilisateur u) {
		Transaction tx = session.beginTransaction();
		session.update(u);
		tx.commit();
		session.close();
		return true;
	}
	
	public Connexion connexion(String identifiant, String password) {
		Query query = session.createSQLQuery("SELECT c.* FROM connexion c, utilisateur u WHERE u.id=c.id and (u.mail = :mail OR u.pseudo = :pseudo) ").addEntity("connexion",Connexion.class);
		query.setParameter("mail", identifiant);
		query.setParameter("pseudo", identifiant);
		
		if( query.uniqueResult() != null) {
			//on recupere l'objet
			Connexion c =(Connexion) query.list().get(0);
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			if(passwordEncryptor.checkPassword( password, c.getPassword() )) {
				SessionIdentifierGenerator a = new SessionIdentifierGenerator();
				session.beginTransaction();
				Query query2 = session.createSQLQuery("UPDATE connexion SET token = :token WHERE id = :id");
				query2.setParameter("token", a.nextSessionId());
				query2.setParameter("id", c.getId());
				query2.executeUpdate();
				session.getTransaction().commit();
				return c;

			}
			else {
				System.out.println("Mot de passe incorrect");
				return null;
			}
		}
		
		return null;
		
	}
	
	public List getPseudos() {
		Query query =  session.createSQLQuery("SELECT pseudo FROM utilisateur");
		List result = query.list();
		return result;
	}
}
