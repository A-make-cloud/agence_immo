package entites;

public class Agence {
	private int id;
	private String nom;
	private String adresse;

	
	public Agence() {
		
	}
	
	public Agence(int id,String nom, String adresse) {
		this.id=id;
		this.nom=nom;
		this.adresse=adresse;
			
	}
	
	public Agence(String nom, String adresse) {
		
		this.nom=nom;
		this.adresse=adresse;
			
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse=adresse;
	}
	
	
	
	public String toString() {
		return "id"+id+"nom="+nom+"adresse="+adresse+"\n";
	}

}
