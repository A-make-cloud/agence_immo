package entites;

public class Employe {
	private int id;
	private String nom;
	private String prenom;
	private String dateE;
	private int id_Agence;
	
	public Employe() {
		
	}
	/*
	public Employe(int id,String nom, String prenom, String dateE, int id_Agence) {
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.dateE=dateE;
		this.id_Agence=id_Agence;
		
	}
	
*/
	public Employe(String nom, String prenom, String dateE, int id_Agence) {
		
		this.nom=nom;
		this.prenom=prenom;
		this.dateE=dateE;
		this.id_Agence=id_Agence;
		
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
	
	public String getDateE() {
		return dateE;
	}
	public void setDateE(String dateE) {
		this.dateE=dateE;
	}
	public int getId_Agence() {
		return id_Agence;
	}
	public void setId_Agence(int id_Agence) {
		this.id_Agence=id_Agence;
	}
	
	public String toString() {
		return "id"+id+"nom="+nom+"prenom="+prenom+"dateE="+ dateE +"id_Agence="+id_Agence+"\n";
	}

}

