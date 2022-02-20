package DAO;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;

import entites.Agence;
import entites.Database;
import entites.Locataire;

public class LocataireDAO {
	private static String date_naissance;
	 String dc = date_naissance;
	public void save(Locataire obj) {
		try {
			if(obj.getId() != 0) {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"UPDATE locataire set nom=?,prenom=?,date_naissance=?,age=? WHERE id=?");
				ps.setString(1,obj.getNom());
				ps.setString(2,obj.getPrenom());
				ps.setString(3,obj.getDate_naissance());
				ps.setInt(4,obj.getAge());
				ps.setInt(5,obj.getId());
				ps.executeUpdate();
			}else {
			
				PreparedStatement ps  = Database.connexion.prepareStatement(
						//"INSERT INTO locataire (nom,prenom,date_naissance,age) VALUES(?,?,`"+dc+"`,?)");
				
				"INSERT INTO locataire (nom,prenom,date_naissance,age) VALUES(?,?,?,?)");
				ps.setString(1,obj.getNom());
				ps.setString(2,obj.getPrenom());
				ps.setString(3,obj.getDate_naissance());
				ps.setInt(4,obj.getAge());
				ps.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public Locataire getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"SELECT * FROM locataire WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				resultat.next();
				
				Locataire u = new Locataire();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setDate_naissance(resultat.getString( "date_naissance" ));
					u.setAge(resultat.getInt( "age" ));
			
				
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public ArrayList<Locataire> getAll() {
		ArrayList<Locataire> col = new ArrayList<Locataire>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM locataire");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Locataire u = new Locataire();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setDate_naissance(resultat.getString( "date_naissance" ));
					u.setAge(resultat.getInt( "age" ));
				
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
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM locataire WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
	public ArrayList<Locataire> Recherche(String recherche, String colone) {
		

		ArrayList<Locataire> col = new ArrayList<Locataire>();
		try {
			
			ResultSet resultat;
			if(colone.equals("Nom")) {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM locataire WHERE nom WHERE nom like ?)");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM locataire WHERE "+colone+" like ?");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}
			


				

				while(resultat.next()) {
					Locataire u = new Locataire();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setDate_naissance(resultat.getString( "date_naissance" ));
					u.setAge(resultat.getInt( "age" ));
					
					col.add(u);
				}
				return col;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}

}
