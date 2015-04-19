package com.baptistebilly.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jasypt.util.password.StrongPasswordEncryptor;

import com.baptistebilly.model.Utilisateur;
import com.baptistebilly.util.HibernateUtil;



public class UtilisateurDAO {

	public UtilisateurDAO() {
	}
	
	private Session session = HibernateUtil.getSessionFactory().openSession();
	/*
	public Utilisateur getUser(String login) throws SQLException {
		Utilisateur u = null;
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps =  conn.prepareStatement("SELECT pseudo, password, mail, nom, prenom, etat, isAdmin from utilisateur WHERE pseudo= ?");
			ps.setString(1,login);
			rs = ps.executeQuery();
			while(rs.next()) {
				u = new Utilisateur(rs.getString("pseudo"),rs.getString("password"), rs.getString("mail"), rs.getString("nom"), rs.getString("prenom"), rs.getString("etat"), rs.getBoolean("isAdmin"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur SQL : " + e.getMessage());
			e.printStackTrace();
		} finally {
			this.closeConnection(rs);
			this.closeConnection(ps);
			this.closeConnection(conn);
		}
		return u;
	}
	
	public boolean validerUtilisateur(String pseudo) throws SQLException {
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		try {
			 ps = conn.prepareStatement("UPDATE Utilisateur SET etat='VALIDE' WHERE pseudo=?");
			ps.setString(1, pseudo);
			int res = ps.executeUpdate();
			if(res==0)return true;
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur SQL : " + e.getMessage());
			e.printStackTrace();
			return false;
		} finally {
			this.closeConnection(ps);
			this.closeConnection(conn);
		}
		
	}
	
	*/
	
	public boolean creerUtilisateur(Utilisateur u, String password) {
		Query query = session.createSQLQuery("SELECT count(*) FROM utilisateur WHERE pseudo = :pseudo OR mail=:mail ");
		query.setString("pseudo", u.getPseudo());
		query.setString("mail", u.getMail());
		Integer count = ((BigInteger) query.uniqueResult()).intValue();
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
	
	public List getPseudos() {
		Query query =  session.createSQLQuery("SELECT pseudo FROM utilisateur");
		List result = query.list();
		return result;
	}
}
