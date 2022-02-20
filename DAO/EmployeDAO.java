package DAO;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;


import entites.Database;
import entites.Employe;


public class EmployeDAO {

	private ArrayList<Employe> frame;
	public void save(Employe obj) {
		System.out.println("employe OK");
		try {
			if(obj.getId() != 0) {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"UPDATE employe set nom=?,prenom=?,dateE=?,id_Agence=? WHERE id=?");
				ps.setString(1,obj.getNom());
				ps.setString(2,obj.getPrenom());
				ps.setString(3,obj.getDateE());
				ps.setInt(4,obj.getId_Agence());
				ps.setInt(5,obj.getId());
				ps.executeUpdate();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"INSERT INTO employe (nom,prenom,dateE,id_Agence) VALUES(?,?,?,?)");
				ps.setString(1,obj.getNom());
				ps.setString(2,obj.getPrenom());
				ps.setString(3,obj.getDateE());
				ps.setInt(4,obj.getId_Agence());
				ps.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public Employe getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"SELECT * FROM employe WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				resultat.next();
				
				Employe u = new Employe();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setDateE(resultat.getString( "dateE" ));
					u.setId_Agence(resultat.getInt( "id_Agence" ));
			
				
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public ArrayList<Employe> getAll() {
		ArrayList<Employe> col = new ArrayList<Employe>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM employe");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Employe u = new Employe();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setPrenom(resultat.getString( "prenom" ));
					u.setDateE(resultat.getString( "dateE" ));
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
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM employe WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
	
	
	public ArrayList<Employe> Recherche(String recherche,String colone) {
		ArrayList<Employe> col = new ArrayList<Employe>();
		try {
			
			ResultSet resultat;
			if(colone.equals("Categorie")) {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM employe WHERE Id_Agence IN(SELECT id FROM agence WHERE nom like ?)");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM employe WHERE "+colone+" like ?");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}
			


				

				while(resultat.next()) {
					Employe p = new Employe();
					p.setId(resultat.getInt( "id" ));
					p.setNom(resultat.getString( "nom" ));
					p.setPrenom(resultat.getString( "prenom" ));
					p.setDateE(resultat.getString("dateE"));
					p.setId_Agence(resultat.getInt("Id_Agence"));
					col.add(p);
				}
				return col;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}

}

