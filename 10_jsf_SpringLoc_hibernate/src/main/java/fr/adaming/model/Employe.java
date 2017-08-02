package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table (name="employes")
public class Employe implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_e")
	private int id;
	@Column(name="nom_e")
	private String nom;
	@Column(name="prenom_e")
	private String prenom;
	@Column(name="salaire_e")
	private  double salaire;
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employe(int id, String nom, String prenom, double salaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}
	
	public Employe(String nom, String prenom, double salaire) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	
	
}
