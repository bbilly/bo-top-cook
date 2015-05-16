package com.baptistebilly.model;

import javax.persistence.*;

@Table
@Entity
public class Recette {
	
	private Long id;
	private String titre;
	private int tempsPreparation;
	private int tempsCuisson;
	private String preparation;
	private String remarque;
	private int difficulte;
	private String motsCles;
	
	

}
