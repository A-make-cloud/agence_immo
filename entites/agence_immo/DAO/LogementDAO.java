package DAO;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;

import entites.Agence;
import entites.Database;
import entites.Logement;
import entites.Logement;

public class LogementDAO {

	public void save(Logement obj) {
		try {
			if(obj.getId() != 0) {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"UPDATE logement set ville=?,prix=?,taille=?,etage=?,id_Proprietaire=?,id_Categorie=? WHERE id=?");
				ps.setString(1,obj.getVille());
				ps.setFloat(2,obj.getPrix());
				ps.setInt(3,obj.getTaille());
				ps.setInt(4,obj.getEtage());
				ps.setInt(5,obj.getId_Proprietaire());
				ps.setInt(6,obj.getId_Categorie());
				ps.setInt(7,obj.getId());
				ps.executeUpdate();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"INSERT INTO logement (ville,prix,taille,etage,id_Proprietaire,id_Categorie) VALUES(?,?,?,?,?,?)");
				ps.setString(1,obj.getVille());
				ps.setFloat(2,obj.getPrix());
				ps.setInt(3,obj.getTaille());
				ps.setInt(4,obj.getEtage());
				ps.setInt(5,obj.getId_Proprietaire());
				ps.setInt(6,obj.getId_Categorie());
				ps.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public Logement getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"SELECT * FROM logement WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				resultat.next();
				
				Logement u = new Logement();
					u.setId(resultat.getInt( "id" ));
					u.setVille(resultat.getString( "ville" ));
					u.setPrix(resultat.getFloat( "prix" ));
					u.setTaille(resultat.getInt( "taille" ));
					u.setEtage(resultat.getInt( "etage" ));
					u.setId_Proprietaire(resultat.getInt( "id_Proprietaire" ));
					u.setId_Categorie(resultat.getInt( "id_Categorie" ));
			
				
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public ArrayList<Logement> getAll() {
		ArrayList<Logement> col = new ArrayList<Logement>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM logement");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Logement u = new Logement();
					u.setId(resultat.getInt( "id" ));
					u.setVille(resultat.getString( "ville" ));
					u.setPrix(resultat.getFloat( "prix" ));
					u.setTaille(resultat.getInt( "taille" ));
					u.setEtage(resultat.getInt( "etage" ));
					u.setId_Proprietaire(resultat.getInt( "id_Proprietaire" ));
					u.setId_Categorie(resultat.getInt( "id_Categorie" ));
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
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM logement WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
	public ArrayList<Logement> Recherche(String recherche, String colone) {
		
		ArrayList<Logement> col = new ArrayList<Logement>();
		try {
			
			ResultSet resultat;
			if(colone.equals("Nom")) {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM logement WHERE nom WHERE nom like ?)");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM logement WHERE "+colone+" like ?");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}
			


				

				while(resultat.next()) {
					
					Logement u = new Logement();
					u.setId(resultat.getInt( "id" ));
					u.setVille(resultat.getString( "ville" ));
					u.setPrix(resultat.getFloat( "prix" ));
					u.setTaille(resultat.getInt( "taille" ));
					u.setEtage(resultat.getInt( "etage" ));
					u.setId_Proprietaire(resultat.getInt( "id_Proprietaire" ));
					u.setId_Categorie(resultat.getInt( "id_Categorie" ));
					col.add(u);
					
					
				}
				return col;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
		
	}

}

