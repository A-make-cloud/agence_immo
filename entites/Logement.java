package entites;

public class Logement {
	private int id;
	private String ville;
	private float prix;
	private int taille;
	private int etage;
	private int id_Proprietaire;
	private int id_Categorie;
	
	public Logement() {
		
	}
	
	public Logement(int id,String ville, float prix, int taille,int etage, int id_Proprietaire,int id_Categorie) {
		this.id=id;
		this.ville=ville;
		this.prix=prix;
		this.taille=taille;
		this.etage=etage;
		this.id_Proprietaire=id_Proprietaire;
		this.id_Categorie=id_Categorie;
		
	}
	
	public Logement(String ville, float prix, int taille,int etage, int id_Proprietaire,int id_Categorie) {
		
		this.ville=ville;
		this.prix=prix;
		this.taille=taille;
		this.etage=etage;
		this.id_Proprietaire=id_Proprietaire;
		this.id_Categorie=id_Categorie;
		
	}
	



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville=ville;
	}
	
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix=prix;
	}
	
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille=taille;
	}
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage=etage;
	}
	public int getId_Proprietaire() {
		return id_Proprietaire;
	}
	public void setId_Proprietaire(int id_Proprietaire) {
		this.id_Proprietaire=id_Proprietaire;
	}
	public int getId_Categorie() {
		return id_Proprietaire;
	}
	public void setId_Categorie(int id_Categorie) {
		this.id_Categorie=id_Categorie;
	}
	
	public String toString() {
		return "id"+id+"ville="+ville+"prix="+prix+"taille="+ taille +"etage="+etage+"id_Categorie="+id_Categorie+"id_Proprietaire="+id_Proprietaire+"\n";
	}

}

