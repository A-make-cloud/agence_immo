package DAO;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;


import entites.Database;
import entites.Litige;
import entites.Technicien;

public class LitigeDAO {

	public void save(Litige obj) {
		try {
			if(obj.getId() != 0) {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"UPDATE litige set motif=?,numero=?,dateL=?,id_Locataire=?,Id_Contrat=?  WHERE id=?");
				ps.setString(1,obj.getMotif());
				ps.setInt(2,obj.getNumero());
				ps.setString(3,obj.getDateL());
				ps.setInt(4,obj.getId_Locataire());
				ps.setInt(5,obj.getId_Contrat());
				ps.setInt(6,obj.getId());
				
				ps.executeUpdate();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"INSERT INTO litige (motif,numero,dateL,id_Locataire,Id_Contrat) VALUES(?,?,?,?,?)");
				ps.setString(1,obj.getMotif());
				
				ps.setInt(2,obj.getNumero());
				ps.setString(3,obj.getDateL());
				ps.setInt(4,obj.getId_Locataire());
				ps.setInt(5,obj.getId_Contrat());
			
				ps.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public Litige getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"SELECT * FROM litige WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				resultat.next();
				
				Litige u = new Litige();
				u.setId(resultat.getInt( "id" ));
				u.setMotif(resultat.getString( "motif" ));
			
				u.setNumero(resultat.getInt( "numero" ));
				u.setDateL(resultat.getString( "dateL" ));
				u.setId_Locataire(resultat.getInt( "id_Locataire" ));
				u.setId_Contrat(resultat.getInt( "id_Contrat" ));
					
			
				
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public ArrayList<Litige> getAll() {
		ArrayList<Litige> col = new ArrayList<Litige>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM litige");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Litige u = new Litige();
					u.setId(resultat.getInt( "id" ));
					u.setMotif(resultat.getString( "motif" ));
			
					u.setNumero(resultat.getInt( "numero" ));
					u.setDateL(resultat.getString( "dateL" ));
					u.setId_Locataire(resultat.getInt( "id_Locataire" ));
					u.setId_Contrat(resultat.getInt( "id_Contrat" ));
					
				
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
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM litige WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
	public ArrayList<Litige> Recherche(String recherche, String colone) {
	
		

		ArrayList<Litige> col = new ArrayList<Litige>();
		try {
			
			ResultSet resultat;
			if(colone.equals("Nom")) {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM litige WHERE nom WHERE nom like ?)");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM litige WHERE "+colone+" like ?");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}
			

				while(resultat.next()) {
					Litige u = new Litige();
					u.setId(resultat.getInt( "id" ));
					u.setMotif(resultat.getString( "motif" ));
			
					u.setNumero(resultat.getInt( "numero" ));
					u.setDateL(resultat.getString( "dateL" ));
					u.setId_Locataire(resultat.getInt( "id_Locataire" ));
					u.setId_Contrat(resultat.getInt( "id_Contrat" ));
					
				
					col.add(u);
				}
				return col;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
		
	}

}



