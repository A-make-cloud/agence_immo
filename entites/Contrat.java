package entites;

public class Contrat {
	private int id;
	private int numero;
	private String dateC;
	private int id_Locataire;
	private int id_Proprietaire;
	private int id_Agence;
	private int id_Logement;

	
	public Contrat() {
		
	}
	

	
	public Contrat(int id, int numero, String dateC,int id_Locataire,int id_Proprietaire,int id_Agence,int id_Logement) {
		this.id=id;
		this.numero=numero;
		this.dateC=dateC;
		this.id_Locataire=id_Locataire;
		this.id_Proprietaire=id_Proprietaire;
		this.id_Agence=id_Agence;
		this.id_Logement=id_Logement;
	
		
	}
	
	public Contrat(int numero, String dateC,int id_Locataire,int id_Proprietaire,int id_Agence,int id_Logement) {
	
		this.numero=numero;
		this.dateC=dateC;
		this.id_Locataire=id_Locataire;
		this.id_Proprietaire=id_Proprietaire;
		this.id_Agence=id_Agence;
		this.id_Logement=id_Logement;
	
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}

	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero=numero;
	}
	
	public String getDateC() {
		return dateC;
	}
	public void setDateC(String dateC) {
		this.dateC=dateC;
	}
	public int getId_Locataire() {
		return id_Locataire;
	}
	public void setId_Locataire(int id_Locataire) {
		this.id_Locataire=id_Locataire;
	}
	public int getId_Proprietaire() {
		return id_Proprietaire;
	}
	public void setId_Proprietaire(int id_Proprietaire) {
		this.id_Proprietaire=id_Proprietaire;
	}
	
	public int getId_Agence() {
		return id_Agence;
	}
	public void setId_Agence(int id_Agence) {
		this.id_Agence=id_Agence;
	}
	public int getId_Logement() {
		return id_Logement;
	}
	public void setId_Logement(int id_Logement) {
		this.id_Logement=id_Logement;
	}
	
	public String toString() {
		return "id"+id+"numero="+numero+"dateC="+ dateC+"id_Locataire="+id_Locataire+"id_Proprietaire="+id_Proprietaire +"id_Agence="+id_Agence+"id_Logement="+id_Logement+"\n";
	}



	

}



