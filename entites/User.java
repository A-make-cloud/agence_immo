package entites;

public class User {
	private int id;
	private String identifiant;
	private String password;
	
	public User() {

	}
	

	
	public User(int id,String identifiant, String password) {
		this.id=id;
		this.identifiant = identifiant;
		this.password = password;
	}
	
	public User(String identifiant, String password) {
		this.identifiant = identifiant;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String toString() {
		return "id:" + id + "\t\tidentifiant:" + identifiant + "\t\tpassword:" + password+"\n" ;
	}

	
}

