package entites;

public class Proprietaire {
	private int id;
	private String nom;
	private String prenom;
	private String ville;
	private String dateP;

	
	public Proprietaire() {
		
	}
	
	public Proprietaire(int id,String nom, String prenom,String ville, String dateP) {
		this.id=id;
		this.nom=nom;
		this.prenom=prenom;
		this.ville=ville;
		this.dateP=dateP;
	
		
	}
	
	public Proprietaire(String nom, String prenom,String ville, String dateP) {
	
		this.nom=nom;
		this.prenom=prenom;
		this.ville=ville;
		this.dateP=dateP;
	
		
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
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville=ville;
	}
	
	public String getDateP() {
		return dateP;
	}
	public void setDateP(String dateP) {
		this.dateP=dateP;
	}

	
	public String toString() {
		return "id"+id+"nom="+nom+"prenom="+prenom+"ville="+ville+"dateP="+ dateP +"\n";
	}

}


