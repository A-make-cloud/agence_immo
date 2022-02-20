package DAO;

import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;

import entites.Agence;
import entites.Database;
import entites.Reparation;



public class ReparationDAO {

	public void save(Reparation obj) {
		try {
			if(obj.getId() != 0) {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"UPDATE reparation set type=?,numero=?,prix=?,dateR=?,id_Litige=? WHERE id=?");
				ps.setString(1,obj.getType());
				ps.setInt(2,obj.getNumero());
				ps.setFloat(3,obj.getPrix());
				ps.setString(4,obj.getDateR());
				ps.setInt(5,obj.getId_Litige());
				ps.setInt(6,obj.getId());
				ps.executeUpdate();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"INSERT INTO reparation (type,numero,prix,dateR,id_Litige) VALUES(?,?,?,?,?)");
				ps.setString(1,obj.getType());
				ps.setInt(2,obj.getNumero());
				ps.setFloat(3,obj.getPrix());
				ps.setString(4,obj.getDateR());
				ps.setInt(5,obj.getId_Litige());
			
				ps.executeUpdate();
			}
			System.out.println("SAVED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public Reparation getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"SELECT * FROM reparation WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				resultat.next();
				
				Reparation u = new Reparation();
					u.setId(resultat.getInt( "id" ));
					u.setType(resultat.getString( "type" ));
					u.setNumero(resultat.getInt( "numero" ));
					u.setPrix(resultat.getFloat( "prix" ));
					
					u.setDateR(resultat.getString( "dateR" ));
					u.setId_Litige(resultat.getInt( "id_Litige" ));
					
			
				
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public ArrayList<Reparation> getAll() {
		ArrayList<Reparation> col = new ArrayList<Reparation>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM reparation");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Reparation u = new Reparation();
					u.setId(resultat.getInt( "id" ));
					u.setType(resultat.getString( "type" ));
					u.setNumero(resultat.getInt( "numero" ));
					u.setPrix(resultat.getFloat( "prix" ));
					u.setDateR(resultat.getString( "dateR" ));
					u.setId_Litige(resultat.getInt( "id_Litige" ));
			
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
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM reparation WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
	public ArrayList<Reparation> Recherche(String recherche, String colone) {
		
		
		ArrayList<Reparation> col = new ArrayList<Reparation>();
		try {
			
			ResultSet resultat;
			if(colone.equals("Nom")) {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM reparation WHERE nom WHERE nom like ?)");
				ps.setString(1,"%"+recherche);
				resultat=ps.executeQuery();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM reparation WHERE "+colone+" like ?");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}
			

				while(resultat.next()) {
					Reparation u = new Reparation();
					u.setId(resultat.getInt( "id" ));
					u.setType(resultat.getString( "type" ));
					u.setNumero(resultat.getInt( "numero" ));
					u.setPrix(resultat.getFloat( "prix" ));
					u.setDateR(resultat.getString( "dateR" ));
					u.setId_Litige(resultat.getInt( "id_Litige" ));
			
					col.add(u);
				}
				return col;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}

}


