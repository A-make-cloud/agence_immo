package entites;

public class Litige {
	private int id;
	private String motif;
	private int numero;
	private String dateL;
	private int id_Locataire;
	private int id_Contrat;

	
	public Litige() {
		
	}
	
	public Litige(int id,String motif, int numero, String dateL,int id_Locataire,int id_Contrat) {
		super();
		this.id=id;
		this.motif=motif;
		this.numero=numero;
		this.dateL=dateL;
		this.id_Locataire=id_Locataire;
		this.id_Contrat=id_Contrat;
	
		
	}
	public Litige(String motif, int numero, String dateL,int id_Locataire,int id_Contrat) {
		super();
		this.motif=motif;
		this.numero=numero;
		this.dateL=dateL;
		this.id_Locataire=id_Locataire;
		this.id_Contrat=id_Contrat;
	
		
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif=motif;
	}
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero=numero;
	}
	
	public String getDateL() {
		return dateL;
	}
	public void setDateL(String dateL) {
		this.dateL=dateL;
	}
	public int getId_Locataire() {
		return id_Locataire;
	}
	public void setId_Locataire(int id_Locataire) {
		this.id_Locataire=id_Locataire;
	}
	public int getId_Contrat() {
		return id_Contrat;
	}
	public void setId_Contrat(int id_Contrat) {
		this.id_Contrat=id_Contrat;
	}
	
	
	public String toString() {
		return "id"+id+"motif="+motif+"numero="+numero+"dateL="+ dateL+"id_Locataire="+id_Locataire+"id_Contrat="+id_Contrat +"\n";
	}

}



