package DAO;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;


import entites.Database;
import entites.Technicien;
import entites.Contrat;

public class ContratDAO {

	public void save(Contrat obj) {
		System.out.println("contrat OK...");
		try {
			if(obj.getId() != 0) {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"UPDATE contrat set numero=?,dateC=?,id_Locataire=?,id_Proprietaire=?,Id_Agence=?,Id_Logement=?  WHERE id=?");
				ps.setInt(1,obj.getNumero());
				ps.setString(2,obj.getDateC());
				ps.setInt(3,obj.getId_Locataire());
				ps.setInt(4,obj.getId_Proprietaire());
				ps.setInt(5,obj.getId_Agence());
				ps.setInt(6,obj.getId_Logement());
				ps.setInt(7,obj.getId());
				
				ps.executeUpdate();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"INSERT INTO contrat (numero,dateC,id_Locataire,id_Proprietaire,Id_Agence,Id_Logement) VALUES(?,?,?,?,?,?)");
				ps.setInt(1,obj.getNumero());
				ps.setString(2,obj.getDateC());
				ps.setInt(3,obj.getId_Locataire());
				ps.setInt(4,obj.getId_Proprietaire());
				ps.setInt(5,obj.getId_Agence());
				ps.setInt(6,obj.getId_Logement());
			
				ps.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public Contrat getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"SELECT * FROM contrat WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				resultat.next();
				
				Contrat u = new Contrat();
				u.setId(resultat.getInt( "id" ));
				u.setNumero(resultat.getInt( "numero" ));
				u.setDateC(resultat.getString( "dateC" ));
				u.setId_Locataire(resultat.getInt( "id_Locataire" ));
				u.setId_Proprietaire(resultat.getInt( "id_Proprietaire" ));
				u.setId_Agence(resultat.getInt( "id_Agence"));
				u.setId_Logement(resultat.getInt( "id_Logement" ));
					
			
				
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public ArrayList<Contrat> getAll() {
		ArrayList<Contrat> col = new ArrayList<Contrat>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM contrat");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Contrat u = new Contrat();
					u.setId(resultat.getInt( "id" ));
					u.setNumero(resultat.getInt( "numero" ));
					u.setDateC(resultat.getString( "dateC" ));
					u.setId_Locataire(resultat.getInt( "id_Locataire" ));
					u.setId_Proprietaire(resultat.getInt( "id_Proprietaire" ));
					u.setId_Agence(resultat.getInt( "id_Agence"));
					u.setId_Logement(resultat.getInt( "id_Logement" ));
					
				
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
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM contrat WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
	public ArrayList<Contrat> Recherche(String recherche, String colone) {
		

		ArrayList<Contrat> col = new ArrayList<Contrat>();
		try {
			
			ResultSet resultat;
			if(colone.equals("Nom")) {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM contrat WHERE nom WHERE nom like ?)");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM contrat WHERE "+colone+" like ?");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}
			

				while(resultat.next()) {
					Contrat u = new Contrat();
					u.setId(resultat.getInt( "id" ));
					u.setNumero(resultat.getInt( "numero" ));
					u.setDateC(resultat.getString( "dateC" ));
					u.setId_Locataire(resultat.getInt( "id_Locataire" ));
					u.setId_Proprietaire(resultat.getInt( "id_Proprietaire" ));
					u.setId_Agence(resultat.getInt( "id_Agence"));
					u.setId_Logement(resultat.getInt( "id_Logement" ));
					
				
					col.add(u);
				}
				return col;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
		
	}

}



