package com.baptistebilly.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DAO {
	private String url = "jdbc:mysql://127.0.0.1:3306/cuisine";
	private String username = "root";
	private String password = "";
	private String driver = "com.mysql.jdbc.Driver";
	protected Connection cnx;
	
	public DAO() {
	}
	
	public Connection getConnection()  {
		// retourne une connexion a la base
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			System.err.println("Impossible de charger le driver");
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.exit(1);
		}
		try {
			cnx = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.err.println("Impossible de se connecter à la base");
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(2);
		}
		return cnx;
	}
	
	public void closeConnection(AutoCloseable ressource) {
		if(ressource != null) {
			try {
				ressource.close();
			} catch(Exception e) {
				System.err.println("Impossible de fermer la ressource");
				e.printStackTrace();
			}
		}
	}
}
