package DAO;


import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


import entites.Database;
import entites.User;
import vues.tableau_bord;

public class UserDAO {
	
	private Window frameTableauBord;

	public void save(User obj) {
		System.out.println("user... OK");
			try {
				if(obj.getId() != 0) {
					PreparedStatement ps  = Database.connexion.prepareStatement(
							"UPDATE user set identifiant=?,password=? WHERE id=?");
					ps.setString(1,obj.getIdentifiant());
					ps.setString(2,obj.getPassword());
					ps.setInt(3,obj.getId());
					ps.executeUpdate();
				}else {
					PreparedStatement ps  = Database.connexion.prepareStatement(
							"INSERT INTO user (identifiant,password) VALUES(?,?)");
					ps.setString(1,obj.getIdentifiant());
					ps.setString(2,obj.getPassword());
					ps.executeUpdate();
				}
				System.out.println("user SAVED OK");
				
			} catch (Exception ex) {
	        	ex.printStackTrace();
	        	System.out.println("user SAVED NO");
	        }
		
	}
	
	public User getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"SELECT * FROM user WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				resultat.next();
				
				User u = new User();
					u.setId(resultat.getInt( "id" ));
					u.setIdentifiant(resultat.getString( "identifiant" ));
					u.setPassword(resultat.getString( "password" ));
				
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	
	public ArrayList<User> getAll() {
		ArrayList<User> col = new ArrayList<User>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM user");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					User u = new User();
					u.setId(resultat.getInt( "id" ));
					u.setIdentifiant(resultat.getString( "identifiant" ));
					u.setPassword(resultat.getString( "password" ));
					col.add(u);
				}
				return col;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	public void deleteById(int id) {
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM user WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
	


	public void setTitle(String string) {
		
		
	}

	public void setVisible(boolean b) {
		
		
	}
	
	
}
