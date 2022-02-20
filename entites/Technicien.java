package entites;

public class Technicien {
	private int id;
	private String nom;
	private String prenom;
	private String specialite;
	private int id_Agence;
	
	public Technicien() {
		
	}
	
	public Technicien(int id,String nom, String prenom, String specialite, int id_Agence) {
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.specialite=specialite;
		this.id_Agence=id_Agence;
		
	}
	
	public Technicien(String nom, String prenom, String specialite, int id_Agence) {
	
		this.nom=nom;
		this.prenom=prenom;
		this.specialite=specialite;
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
	
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite=specialite;
	}
	public int getId_Agence() {
		return id_Agence;
	}
	public void setId_Agence(int id_Agence) {
		this.id_Agence=id_Agence;
	}
	
	public String toString() {
		return "id"+id+"nom="+nom+"prenom="+prenom+"specialite="+ specialite +"id_Agence="+id_Agence+"\n";
	}

}
