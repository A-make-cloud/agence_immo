package DAO;

import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.text.ParagraphView;


import com.mysql.jdbc.JDBC4Connection;
import com.mysql.jdbc.JDBC4MySQLConnection;

import entites.Database;

import entites.Agence;

public class AgenceDAO {

	public void save(Agence obj) {
		System.out.println("SAVING.....");
		try {
			if(obj.getId() != 0) {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"UPDATE agence set nom=?,adresse=? WHERE id=?");
	
				ps.setString(1,obj.getNom());
				ps.setString(2,obj.getAdresse());
				ps.setInt(3,obj.getId());
				ps.executeUpdate();
				System.out.println("UPDATE OK");
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"INSERT INTO agence (nom,adresse) VALUES(?,?)");
				ps.setString(1,obj.getNom());
				ps.setString(2,obj.getAdresse());
			
				ps.executeUpdate();
				System.out.println("ADD OK");
			}
			
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("SAVED NO");
        }
	
}
	public Agence getById(int id) {
		try {
		
				PreparedStatement ps  = Database.connexion.prepareStatement(
						"SELECT * FROM agence WHERE id=?");
				ps.setInt(1,id);
				
				ResultSet resultat=ps.executeQuery();
				resultat.next();
				
				Agence u = new Agence();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setAdresse(resultat.getString( "adresse" ));
				
				return u;
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	return null;
        }
	}
	public ArrayList<Agence> getAll() {
		ArrayList<Agence> col = new ArrayList<Agence>();
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM agence");
				
				ResultSet resultat=ps.executeQuery();

				while(resultat.next()) {
					Agence u = new Agence();
					u.setId(resultat.getInt( "id" ));
					u.setNom(resultat.getString( "nom" ));
					u.setAdresse(resultat.getString( "adresse" ));
				
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
			
				PreparedStatement ps  = Database.connexion.prepareStatement("DELETE FROM agence WHERE id=?");
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("DELETED OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("DELETED NO");
        }
	}
	public void activated(int id) {
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("select * FROM agence WHERE actif=1");
			//	colonne actif type bolean valeur 1 tininty
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("activated OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("activated NO");
        }
	}
	public void desactivated(int id) {
		try {
			
				PreparedStatement ps  = Database.connexion.prepareStatement("select * FROM agence WHERE actif=0");
			//	colonne actif type bolean valeur 1 tininty
				ps.setInt(1,id);
				
				ps.executeUpdate();
				
				System.out.println("desactivated OK");
			
		} catch (Exception ex) {
        	ex.printStackTrace();
        	System.out.println("desactivated NO");
        }
	}
	public ArrayList<Agence> Recherche(String recherche, String colone) {
	
		ArrayList<Agence> col = new ArrayList<Agence>();
		try {
			
			ResultSet resultat;
			if(colone.equals("Nom")) {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM agence WHERE nom WHERE nom like ?)");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}else {
				PreparedStatement ps  = Database.connexion.prepareStatement("SELECT * FROM agence WHERE "+colone+" like ?");
				ps.setString(1,"%"+recherche+"%");
				resultat=ps.executeQuery();
			}
			

				while(resultat.next()) {
					Agence p = new Agence();
					p.setId(resultat.getInt( "id" ));
					p.setNom(resultat.getString( "Nom" ));
					p.setAdresse(resultat.getString( "Adresse" ));
					
					col.add(p);
				}
				return col;
			
		} catch (Exception ex) {
	    	ex.printStackTrace();
	    	return null;
	    }
	}
	/*
	public  void docPdf(Object PdfWriter) {
		try {
			String file_name = "Z:\\Utilisateur\\eclipse-workspace\\Generate_PDF\\chillyfacts_test_Dynamic.pdf";
			
			Document document = new Document();
			
			//simple paragraph
			
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			
			document.open();

			JDBC4MySQLConnection obJDBConnection = new JDBC4Connection();
			Connection connection = obJDBConnection.getConnectionCollation();
			PreparedStatement ps=null;
			ResultSet resultat=null;
			
			String query="select * from agence";
			ps=connection.prepareStatement(query);
			resultat=ps.executeQuery();
			
			while(resultat.next()) {
				Agence p = new Agence();
				p.setId(resultat.getInt( "id" ));
				p.setNom(resultat.getString( "Nom" ));
				p.setAdresse(resultat.getString( "Adresse" ));
				ParagraphView para = new Paragraph(rs.getString("sl_no")+ " "+rs.getString("nom")+ " "+rs.getString("adresse"));
				document.add(para);
				document.add(new Paragraph(" "));
			}
				
				

		
	
		document.close();
		
		System.out.println("finished dynamic");
		
	}catch (Exception e) {
		System.err.println(e);
	}
	

}
*/
		public Agence generatePDF() {
			try {
			
					PreparedStatement ps  = Database.connexion.prepareStatement(
							"SELECT * FROM agence WHERE id=?");
				//	ps.setInt(1,id);
					
					ResultSet resultat=ps.executeQuery();
					resultat.next();
					
					Agence u = new Agence();
						u.setId(resultat.getInt( "id" ));
						u.setNom(resultat.getString( "nom" ));
						u.setAdresse(resultat.getString( "adresse" ));
					
					return u;
				
			} catch (Exception ex) {
	        	ex.printStackTrace();
	        	return null;
	        }
		}
		
}
