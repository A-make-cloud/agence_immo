	package vues;

	import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import DAO.AgenceDAO;
import DAO.CategorieDAO;
import entites.Categorie;
import entites.Database;
	

	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.SwingConstants;
	import java.awt.Font;
import java.awt.Window;
import java.util.ArrayList;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JTextField;
	import javax.swing.JComboBox;
	import javax.swing.DefaultComboBoxModel;
	import javax.swing.JPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

	public class Categorie_liste {

		private JFrame frame;
		private static JTable table;
		private JTextField tRecherche;
		protected Window frameTableauBord;
		
		public JFrame getFrame() {
			return frame;
		}

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Categorie_liste window = new Categorie_liste();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public Categorie_liste() {
			initialize();
			remp();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					
					tableau_bord t = new tableau_bord();
					t.getFrameTableauBord().setVisible(true);
					frameTableauBord.dispose();
				}
			});
			frame.setBounds(100, 100, 1000, 750);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(59, 127, 864, 443);
			frame.getContentPane().add(scrollPane);
			
			Database.Connect();
			
			table = new JTable();	
			table.setModel(new DefaultTableModel());
			scrollPane.setViewportView(table);
			
			final JLabel lblNewLabel = new JLabel("Cat\u00E9gorie");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(304, 11, 399, 56);
			lblNewLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					 Color myColor = new Color(255, 200, 113);
					lblNewLabel.setBackground(myColor);
				}
			});
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			frame.getContentPane().add(lblNewLabel);
			
			tRecherche = new JTextField();
			tRecherche.setBounds(310, 78, 263, 39);
			tRecherche.setFont(new Font("Tahoma", Font.PLAIN, 30));
			frame.getContentPane().add(tRecherche);
			tRecherche.setColumns(10);
			
			final JComboBox<String> cRecherche = new JComboBox<String>();
			cRecherche.setBounds(581, 78, 122, 39);
			cRecherche.setModel(new DefaultComboBoxModel(new String[] {"type"}));
			frame.getContentPane().add(cRecherche);
			
			JButton btnNewButton_1 = new JButton("Recherche");
			btnNewButton_1.setBounds(713, 76, 151, 39);
			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String r = tRecherche.getText();
					String cat = (String)cRecherche.getSelectedItem();
					recherche(r,cat);
				}
			});
			btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
			frame.getContentPane().add(btnNewButton_1);
			
			JPanel comboagence = new JPanel();
			comboagence.setBounds(732, 35, 176, 32);
			comboagence.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Categorie_add add = new Categorie_add();
					add.getFrame().setVisible(true);
					
				}
			});
			comboagence.setLayout(null);
			comboagence.setBackground(new Color(230, 126, 34));
			frame.getContentPane().add(comboagence);
			
			JLabel lblNewLabel_2_1 = new JLabel("Ajouter");
			lblNewLabel_2_1.setForeground(Color.WHITE);
			lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2_1.setBounds(29, 9, 46, 14);
			comboagence.add(lblNewLabel_2_1);
			
			JLabel lblNewLabel_3_2 = new JLabel("");
			lblNewLabel_3_2.setBounds(121, 7, 46, 16);
			comboagence.add(lblNewLabel_3_2);
			
			JPanel comboagence_1 = new JPanel();
			comboagence_1.setBounds(82, 35, 176, 32);
			comboagence_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Categorie_liste cat = new Categorie_liste();
					cat.getFrame().setVisible(true);
					frame.dispose();
				}
			});
			comboagence_1.setLayout(null);
			comboagence_1.setBackground(new Color(230, 126, 34));
			frame.getContentPane().add(comboagence_1);
			
			JLabel lblNewLabel_2_1_1 = new JLabel("Reset");
			lblNewLabel_2_1_1.setForeground(Color.WHITE);
			lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2_1_1.setBounds(10, 9, 63, 14);
			comboagence_1.add(lblNewLabel_2_1_1);
			
			JLabel lblNewLabel_3_2_1 = new JLabel("");
			lblNewLabel_3_2_1.setBounds(120, 9, 46, 16);
			comboagence_1.add(lblNewLabel_3_2_1);
			
			JPanel panel = new JPanel();
			panel.setBounds(30, 73, 911, 568);
			panel.setBackground(Color.LIGHT_GRAY);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JPanel panel_1_2 = new JPanel();
			panel_1_2.setBounds(39, 517, 176, 27);
			panel.add(panel_1_2);
			panel_1_2.addMouseListener(new MouseAdapter() {
			
				public void mouseClicked(MouseEvent e) {
					
					Document doc =new Document();
					
					
					
					try {
						
						System.out.print("HEp");
						PreparedStatement ps  = Database.connexion.prepareStatement(
								"SELECT * FROM categorie");
					
						// statement.setInt(1, id);
						ResultSet resultat=ps.executeQuery();
						resultat.next();
						
					        
					/*
						AgenceDAO uprod = new AgenceDAO();
						uprod.generatePDF();
						*/
						
					PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Utilisateur\\Desktop\\eclipse_dossier\\agenceSwing7\\cate.pdf"));
					doc.open();
					//ENTETE DEBUT
					Image logo = Image.getInstance("C:\\Users\\Utilisateur\\Desktop\\eclipse_dossier\\agenceSwing7\\bord.png");
					logo.scaleAbsoluteWidth(40);
					logo.scaleAbsoluteHeight(40);
					logo.setAlignment(Image.ALIGN_LEFT);
					logo.setBorderWidthRight(100);
					doc.add(logo);
					
					doc.add(new Paragraph("Cr?ation d'application Java"));
					doc.add(new Paragraph("Gestion Immo"));
					doc.add(new Paragraph("N?1 de la Gestion Immobili?re"));
					
					doc.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
					//ENTETE FIN
					
					doc.add(new Paragraph("Cat?gorie de logement"));
					Image img = Image.getInstance("C:\\Users\\Utilisateur\\Desktop\\eclipse_dossier\\agenceSwing7\\categories.png");
					img.scaleAbsoluteWidth(100);
					img.scaleAbsoluteHeight(92);
					
					img.setAlignment(Image.ALIGN_CENTER);
					
					doc.add(img);
					
					doc.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
					doc.add(new Paragraph("Cat?gorie :"));
					doc.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));
					 
					PdfPTable table = new PdfPTable(2);
					table.setWidthPercentage(100);
					
					PdfPCell cell;
					
					/////////////////////////////////////////////////
					
					cell = new PdfPCell(new Phrase("Id",FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);

					cell = new PdfPCell(new Phrase("Type",FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					cell.setBackgroundColor(BaseColor.GRAY);
					table.addCell(cell);
					
				
					
					/////////////////////////////////////////////////
			
					/////////////////////////////////////////////////
					while(resultat.next()) {
					
					
					cell = new PdfPCell(new Phrase(resultat.getString("Id").toString(),FontFactory.getFont("Comic Sans MS", 12)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				
					table.addCell(cell);
					
					cell = new PdfPCell(new Phrase (resultat.getString("type").toString(),FontFactory.getFont("Arial", 11)));
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				
					table.addCell(cell);
					
				
					
					
					}
					/////////////////////////////////////////////////

					
					doc.add(table);
					
				///FOOTER
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph(" "));
					doc.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------- "));		
					doc.add(new Paragraph(" "));
					
					doc.add(new Paragraph("       Association loi 1901                                    Copyright ? 2022                              Agn?s Cloud"));
					doc.close();
					
									try {
										Desktop.getDesktop().open(new File("C:\\Users\\Utilisateur\\Desktop\\eclipse_dossier\\agenceSwing7\\cate.pdf"));
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
						}catch(FileNotFoundException e1) {
							
							e1.printStackTrace();
						}catch(DocumentException e1) {
							
							e1.printStackTrace();
						} catch (MalformedURLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}catch(SQLException e1) {
							e1.printStackTrace();
						}
				
				}
			});
			panel_1_2.setLayout(null);
			panel_1_2.setBackground(new Color(230, 126, 34));
			
			JLabel lblNewLabel_3_3 = new JLabel("PDF");
			lblNewLabel_3_3.setForeground(Color.WHITE);
			lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3_3.setBounds(10, 5, 46, 17);
			panel_1_2.add(lblNewLabel_3_3);
			
			JLabel lblNewLabel_4_1 = new JLabel("");
			lblNewLabel_4_1.setBounds(80, 5, 16, 17);
			panel_1_2.add(lblNewLabel_4_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(370, 517, 176, 27);
			panel.add(panel_1);
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(table.getSelectedRow()!=-1) {
						CategorieDAO uprod = new CategorieDAO();
						int test=table.getSelectedRow();
						int selectedId = Integer.parseInt(table.getModel().getValueAt(test, 0).toString());
						Categorie p = uprod.getById(selectedId);

								new Categorie_edit(p).getFrame().setVisible(true);
						 
					}else {
						JOptionPane.showMessageDialog(null, "Veuillez choisir une ligne ");
					}
					
				}
			});
			panel_1.setLayout(null);
			panel_1.setBackground(new Color(230, 126, 34));
			
			JLabel lblNewLabel_3 = new JLabel("Modifier");
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(10, 5, 46, 17);
			panel_1.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setBounds(80, 5, 16, 17);
			panel_1.add(lblNewLabel_4);
			
			JPanel panel_1_1 = new JPanel();
			panel_1_1.setBounds(724, 517, 176, 27);
			panel.add(panel_1_1);
			panel_1_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					CategorieDAO uprod = new CategorieDAO();
					if(table.getSelectedRow()!=-1) {
						 int input = JOptionPane.showConfirmDialog(null, "voullez vous supprimer ?");
						 if(input==0) {
							 	int test=table.getSelectedRow();
								int selectedId = Integer.parseInt(table.getModel().getValueAt(test, 0).toString());
								uprod.deleteById(selectedId);
								((DefaultTableModel)table.getModel()).removeRow(test);
								JOptionPane.showMessageDialog(null, "Le Categorie bien ?t? supprim? ");
						 }
						
					}else {
						JOptionPane.showMessageDialog(null, "Veuillez choisir une ligne ");
					}
				}
			});
			panel_1_1.setLayout(null);
			panel_1_1.setBackground(new Color(230, 126, 34));
			
			JLabel lblNewLabel_3_1 = new JLabel("Supprimer");
			lblNewLabel_3_1.setForeground(Color.WHITE);
			lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3_1.setBounds(10, 5, 63, 17);
			panel_1_1.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setBounds(83, 5, 23, 17);
			panel_1_1.add(lblNewLabel_5);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(241, 196, 15));
			panel_2.setBounds(-12, 0, 986, 670);
			frame.getContentPane().add(panel_2);

		}
		
		public static void remp() {
			CategorieDAO uproduit = new CategorieDAO();
			 ArrayList<Categorie> uprod = uproduit.getAll();
			
		     String columns[] = { "ID", "TYPE" };
		     String data[][] = new String[uprod.size()][columns.length];

		     for(int i=0;i<uprod.size();i++) {
		    	  	data[i][0] = uprod.get(i).getId()+"";
			        data[i][1] = uprod.get(i).getType();
			     
			    
		      }
		      
		      DefaultTableModel model = new DefaultTableModel(data, columns);
		      table.setModel(model);
		      
		}
		
		public static void recherche(String rech,String nom) {
			CategorieDAO uproduit = new CategorieDAO();	 
			 ArrayList<Categorie> uprod = uproduit.Recherche(rech,nom);
				
				String columns[] = { "ID", "TYPE" };
		     String data[][] = new String[uprod.size()][columns.length];
		     
		     for(int i=0;i<uprod.size();i++) {
		    	  	data[i][0] = uprod.get(i).getId()+"";
		    	  	 data[i][1] = uprod.get(i).getType();
				       
			       
		      }
		      
		      DefaultTableModel model = new DefaultTableModel(data, columns);
		      table.setModel(model);
		      
		}

		public Window getFrameListeCategorie() {
			// TODO Auto-generated method stub
			return frame;
		}
	}


	
	
	

