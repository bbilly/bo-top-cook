package com.baptistebilly.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.baptistebilly.model.Utilisateur;



public class UtilisateurDAO extends DAO {

	public UtilisateurDAO() {
		super();
	}
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
	
	public boolean ajouterUtilisateur(Utilisateur u) throws SQLException {
		Connection conn = this.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("INSERT INTO Utilisateur(pseudo,password,mail,nom,prenom,isAdmin,etat) values(?,?,?,?,?,0,'ATTENTE')");
			ps.setString(1, u.getPseudo());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getMail());
			ps.setString(4, u.getNom());
			ps.setString(5, u.getPrenom());
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
}
