package DAO;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;

import entites.Agence;
import entites.Database;
import entites.Proprietaire;

public class ProprietaireDAO {

	public void save(Proprietaire obj) {
		System.out.print("proprio modifié");
		try {
			if(obj.getId() != 0) {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"UPDATE Proprietaire set nom=?,prenom=?,ville=?,dateP=? WHERE id=?");
				
				ps.setString(1,obj.getNom());
				ps.setString(2,obj.getPrenom());
				ps.setString(3,obj.getVille());
				ps.setString(4,obj.getDateP());
				ps.setInt(5,obj.getId());
				ps.executeUpdate();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"INSERT INTO Proprietaire (nom,prenom,ville,dateP) VALUES(?,?,?,?)");
				ps.setString(1,obj.getNom());
				ps.setString(2,obj.getPrenom());
				ps.setString(3,obj.getVille());
				ps.setString(4,obj.getDateP());
			
				ps.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public Proprietaire getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"SELECT * FROM Proprietaire WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				resultat.next();
				
				Proprietaire u = new Proprietaire();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setVille(resultat.getString( "ville" ));
					u.setDateP(resultat.getString( "dateP" ));
					
			
				
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public ArrayList<Proprietaire> getAll() {
		ArrayList<Proprietaire> col = new ArrayList<Proprietaire>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM proprietaire");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Proprietaire u = new Proprietaire();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setVille(resultat.getString( "ville" ));
					u.setDateP(resultat.getString( "dateP" ));
					
				
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
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM proprietaire WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
	public ArrayList<Proprietaire> Recherche(String recherche, String colone) {
		ArrayList<Proprietaire> col = new ArrayList<Proprietaire>();
		try {
			
			ResultSet resultat;
			if(colone.equals("Nom")) {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM proprietaire WHERE nom WHERE nom like ?)");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM proprietaire WHERE "+colone+" like ?");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}
			

				while(resultat.next()) {
					Proprietaire u = new Proprietaire();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setVille(resultat.getString( "ville" ));
					u.setDateP(resultat.getString( "dateP" ));
					
				
					col.add(u);

				}
				return col;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}

}


