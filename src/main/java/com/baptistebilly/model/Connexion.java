package com.baptistebilly.model;

import javax.persistence.*;

@Table
@Entity
public class Connexion {

	private Long id;
	private String password;
	private String token;
	
	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
