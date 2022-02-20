package entites;

public class Reparation {
	private int id;
	private String type;
	
	private int numero;
	private float prix;
	private String dateR;
	private int id_Litige;

	
	public Reparation() {
		
	}
	
	public Reparation(int id,String type,  int numero,float prix,String dateR, int id_Litige) {
		this.id=id;
		this.type=type;
		this.numero=numero;
		this.prix=prix;
		this.dateR=dateR;
		this.id_Litige=id_Litige;
	
		
	}
	
	public Reparation(String type, int numero, float prix,String dateR, int id_Litige) {
	
		this.type=type;
		this.numero=numero;
		this.prix=prix;
		this.dateR=dateR;
		this.id_Litige=id_Litige;
	
		
	}
	



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero=numero;
	}
	
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix=prix;
	}
	

	public String getDateR() {
		return dateR;
	}
	public void setDateR(String dateR) {
		this.dateR=dateR;
	}
	public int getId_Litige() {
		return id_Litige;
	}
	public void setId_Litige(int id_Litige) {
		this.id_Litige = id_Litige;
	}

	
	public String toString() {
		return "id"+id+"type="+type+"numero="+ numero+"prix="+prix +"dateR="+dateR + "id_Litige=" + id_Litige +"\n";
	}

}


