package DAO;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entites.Database;
import entites.Agence;
import entites.Categorie;

public class CategorieDAO {
	
	public void save(Categorie obj) {
		System.out.println("SAVING.....");
			try {
				if(obj.getId() != 0) {
					PreparedStatement ps  = Database.connexion.prepareStatement(
							"UPDATE categorie set type=? WHERE id=?");
					ps.setString(1,obj.getType());
				
					ps.setInt(2,obj.getId());
					ps.executeUpdate();
					System.out.println("UPDATE OK");
				}else {
					PreparedStatement ps  = Database.connexion.prepareStatement(
							"INSERT INTO categorie (type) VALUES(?)");
					ps.setString(1,obj.getType());
				
					ps.executeUpdate();
				}
				System.out.println("ADD CATEG OK");
				
			} catch (Exception ex) {
	        	ex.printStackTrace();
	        	System.out.println("SAVED NO");
	        }
		
	}
	
	public Categorie getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"SELECT * FROM categorie WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				resultat.next();
				
				Categorie u = new Categorie();
					u.setId(resultat.getInt( "id" ));
					u.setType(resultat.getString( "type" ));
			
				
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	
	
	public ArrayList<Categorie> getAll() {
		ArrayList<Categorie> col = new ArrayList<Categorie>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM categorie");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Categorie u = new Categorie();
					u.setId(resultat.getInt( "id" ));
					u.setType(resultat.getString( "type" ));
				
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
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM categorie WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}

	public ArrayList<Categorie> Recherche(String recherche, String colone) {
		ArrayList<Categorie> col = new ArrayList<Categorie>();
		try {
			
			ResultSet resultat;
			if(colone.equals("Nom")) {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM categorie WHERE nom WHERE nom like ?)");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM categorie WHERE "+colone+" like ?");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}
			


				

				while(resultat.next()) {
					Categorie p = new Categorie();
					p.setId(resultat.getInt( "id" ));
					p.setType(resultat.getString( "Type" ));
					
					
					col.add(p);
				}
				return col;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
		
	
	}
}

