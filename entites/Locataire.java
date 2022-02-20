package entites;

import java.sql.Date;

public class Locataire {
	private int id;
	private String nom;
	private String prenom;
	private String date_naissance;
	private int age;
	
	public Locataire() {
		
	}
	
	public Locataire(int id,String nom, String prenom,String date_naissance, int age) {
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.date_naissance=date_naissance;
		this.age=age;
		
	}
	
	public Locataire(String nom, String prenom,String date_naissance, int age) {
	
		this.nom=nom;
		this.prenom=prenom;
		this.date_naissance=date_naissance;
		this.age=age;
		
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom=nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom=prenom;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance=date_naissance;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	
	public String toString() {
		return "id"+id+"nom=" +nom + "prenom="+prenom+"date_naissance="+ date_naissance +"age="+age+"\n";
	}

}
