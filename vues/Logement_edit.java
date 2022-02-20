package vues;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import DAO.CategorieDAO;

import DAO.LogementDAO;
import DAO.ProprietaireDAO;

import entites.Categorie;

import entites.Database;

import entites.Logement;
import entites.Proprietaire;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Logement_edit {

		private JFrame frame;
	
		


		private JTextField tville;
		private JTextField tprix;
		private JTextField tetage;
		private JTextField ttaille;

		private Logement logement;



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
						Logement_edit window = new Logement_edit();
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
		public Logement_edit() {
			initialize();
		}
		
		public Logement_edit(Logement log) {
			this.logement=log;
			initialize();
			
			}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			Database.Connect();
			frame = new JFrame();
			frame.setBounds(100, 100, 917, 595);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Ville");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setForeground(Color.GRAY);
			lblNewLabel.setBounds(122, 174, 79, 14);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_2 = new JLabel("Id_Proprietaire");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2.setForeground(Color.GRAY);
			lblNewLabel_2.setBounds(122, 334, 104, 14);
			frame.getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Prix");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3.setForeground(Color.GRAY);
			lblNewLabel_3.setBounds(122, 208, 79, 29);
			frame.getContentPane().add(lblNewLabel_3);
	
		
			
			tville = new JTextField();
			tville.setBounds(236, 171, 204, 20);
			frame.getContentPane().add(tville);
			tville.setColumns(10);
			
			tprix = new JTextField();
			tprix.setBounds(236, 212, 204, 20);
			tprix.setColumns(10);
			frame.getContentPane().add(tprix);
			
			JLabel lblNewLabel_2_2 = new JLabel("Etage");
			lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2_2.setForeground(Color.GRAY);
			lblNewLabel_2_2.setBounds(122, 290, 104, 14);
			frame.getContentPane().add(lblNewLabel_2_2);
			
			final JComboBox tcomboBoxid_proprietaire = new JComboBox();
			tcomboBoxid_proprietaire.setBounds(236, 330, 204, 22);
			frame.getContentPane().add(tcomboBoxid_proprietaire);
			
			JLabel lblNewLabel_2_3 = new JLabel("Id_Categorie");
			lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2_3.setForeground(Color.GRAY);
			lblNewLabel_2_3.setBounds(128, 377, 95, 14);
			frame.getContentPane().add(lblNewLabel_2_3);
			
			final JComboBox tcomboBoxid_categorie = new JComboBox();
			tcomboBoxid_categorie.setBounds(236, 373, 204, 22);
			frame.getContentPane().add(tcomboBoxid_categorie);
			
			//////////COMBOBOX////////////
			ProprietaireDAO propdao=new ProprietaireDAO();
			
			ArrayList<Proprietaire> propList = propdao.getAll();
			
			for(Proprietaire pro:propList) {
				tcomboBoxid_proprietaire.addItem(pro);
			}
			
			
			///////////////////////

			//////////COMBOBOX////////////
			CategorieDAO catedao=new CategorieDAO();
			
			ArrayList<Categorie> cateList = catedao.getAll();
			
			for(Categorie cat:cateList) {
				tcomboBoxid_categorie.addItem(cat);
			}
			
			
			///////////////////////
	
			
			tville.setText(this.logement.getVille());

			tprix.setText(this.logement.getPrix()+"");
			
			JLabel lblNewLabel_2_1 = new JLabel("Taille");
			lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_2_1.setForeground(Color.GRAY);
			lblNewLabel_2_1.setBounds(122, 248, 104, 14);
			frame.getContentPane().add(lblNewLabel_2_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBounds(50, 129, 521, 398);
			frame.getContentPane().add(panel_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setForeground(Color.GRAY);
			panel_2.setBounds(34, 0, 436, 367);
			panel_1.add(panel_2);
			panel_2.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(151, 295, 207, 38);
			panel_2.add(panel);
			panel.setBackground(new Color(230,126,34));
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					String ville = tville.getText();
					float prix=Float.parseFloat(tprix.getText());
					int taille=Integer.parseInt(ttaille.getText());
					int etage=Integer.parseInt(tetage.getText());
					
					Proprietaire prop= (Proprietaire)tcomboBoxid_proprietaire.getSelectedItem();
					int proprietaire=prop.getId();
					
				
					
					Categorie log= (Categorie)tcomboBoxid_categorie.getSelectedItem();
					int categorie=log.getId();
					
					
					logement.setId_Proprietaire(proprietaire);
					logement.setId_Categorie(categorie);
					
					
					logement.setVille(ville);
					logement.setPrix(prix);
					logement.setTaille(taille);
					logement.setEtage(etage);
					
					LogementDAO logedao=new LogementDAO();
					logedao.save(logement);
					System.out.print(logement);
					
					JOptionPane.showMessageDialog(null, "Le logement a bien été modifié");
					Logement_liste.remp();
				}
			});
			panel.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("Modifier");
			lblNewLabel_4.setBounds(69, 11, 93, 16);
			lblNewLabel_4.setForeground(Color.WHITE);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setIcon(new ImageIcon(Logement_edit.class.getResource("/res/change2.png")));
			lblNewLabel_8.setBounds(155, 6, 46, 27);
			panel.add(lblNewLabel_8);
			
			tetage = new JTextField();
			tetage.setText((String) null);
			tetage.setColumns(10);
			tetage.setBounds(151, 163, 204, 20);
			panel_2.add(tetage);
			
			ttaille = new JTextField();
			ttaille.setText("0");
			ttaille.setColumns(10);
			ttaille.setBounds(151, 122, 204, 20);
			panel_2.add(ttaille);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(Color.LIGHT_GRAY);
			panel_3.setBounds(50, 22, 521, 505);
			frame.getContentPane().add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_3_1 = new JLabel("");
			lblNewLabel_3_1.setIcon(new ImageIcon(Logement_edit.class.getResource("/res/keys-holder.png")));
			lblNewLabel_3_1.setBounds(425, 35, 64, 62);
			panel_3.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon(Logement_edit.class.getResource("/res/appartement.png")));
			lblNewLabel_5.setBounds(30, 35, 80, 65);
			panel_3.add(lblNewLabel_5);
			
			JLabel lblNewLabel_1 = new JLabel("Modifier un Logement");
			lblNewLabel_1.setBounds(101, 54, 309, 38);
			panel_3.add(lblNewLabel_1);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
			
			JLabel lblNewLabel_6 = new JLabel("");
			lblNewLabel_6.setBounds(134, 55, 67, 64);
			frame.getContentPane().add(lblNewLabel_6);
			
			JLabel lblModifierUnContrat = new JLabel("Modifier un contrat");
			lblModifierUnContrat.setForeground(Color.WHITE);
			lblModifierUnContrat.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblModifierUnContrat.setBounds(275, 55, 234, 41);
			frame.getContentPane().add(lblModifierUnContrat);
			
		
			
			Proprietaire prop= propdao.getById(this.logement.getId_Proprietaire());
			Categorie cat=catedao.getById(this.logement.getId_Categorie());
			
		}
	}

