package DAO;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;


import entites.Database;
import entites.Reparation;
import entites.Technicien;

public class TechnicienDAO {

	public void save(Technicien obj) {
		System.out.println("techn ok.....");
		try {
			if(obj.getId() != 0) {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"UPDATE Technicien set nom=?,prenom=?,specialite=?,id_Agence=? WHERE id=?");
				ps.setString(1,obj.getNom());
				ps.setString(2,obj.getPrenom());
				ps.setString(3,obj.getSpecialite());
				ps.setInt(4,obj.getId_Agence());
				ps.setInt(5,obj.getId());
				ps.executeUpdate();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"INSERT INTO Technicien (nom,prenom,specialite,id_Agence) VALUES(?,?,?,?)");
				ps.setString(1,obj.getNom());
				ps.setString(2,obj.getPrenom());
				ps.setString(3,obj.getSpecialite());
				ps.setInt(4,obj.getId_Agence());
				ps.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public Technicien getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"SELECT * FROM technicien WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				resultat.next();
				
				Technicien u = new Technicien();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setSpecialite(resultat.getString( "specialite" ));
					u.setId_Agence(resultat.getInt( "id_Agence" ));
			
				
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public ArrayList<Technicien> getAll() {
		ArrayList<Technicien> col = new ArrayList<Technicien>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM technicien");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Technicien u = new Technicien();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setSpecialite(resultat.getString( "specialite" ));
					u.setId_Agence(resultat.getInt( "id_Agence" ));
				
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
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM technicien WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
	public ArrayList<Technicien> Recherche(String recherche, String colone) {
	
		
		ArrayList<Technicien> col = new ArrayList<Technicien>();
		try {
			
			ResultSet resultat;
			if(colone.equals("Nom")) {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM technicien WHERE nom WHERE nom like ?)");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM technicien WHERE "+colone+" like ?");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}
			

				while(resultat.next()) {
					Technicien u = new Technicien();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setSpecialite(resultat.getString( "specialite" ));
					u.setId_Agence(resultat.getInt( "id_Agence" ));
				
					col.add(u);
				}
				return col;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}

}
