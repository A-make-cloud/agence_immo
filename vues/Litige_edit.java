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

import DAO.ContratDAO;
import DAO.LitigeDAO;
import DAO.LocataireDAO;
import entites.Contrat;
import entites.Database;
import entites.Litige;
import entites.Locataire;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Litige_edit {

		private JFrame frame;
		private JTextField tmotif;
		private JTextField tnumero;
		private JTextField tdateL;
		private Litige litige;
	
		


		



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
						Litige_edit window = new Litige_edit();
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
		public Litige_edit() {
			initialize();
		}
		
		public Litige_edit(Litige liti) {
			this.litige=liti;
			initialize();
			
			}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			Database.Connect();
			frame = new JFrame();
			frame.setBounds(100, 100, 835, 546);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Motif");
			lblNewLabel.setBounds(224, 135, 79, 14);
			lblNewLabel.setForeground(Color.GRAY);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_2 = new JLabel("DateL");
			lblNewLabel_2.setBounds(224, 200, 79, 14);
			lblNewLabel_2.setForeground(Color.GRAY);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Numero");
			lblNewLabel_3.setBounds(224, 160, 79, 29);
			lblNewLabel_3.setForeground(Color.GRAY);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel_3);
	
		
			
			final JComboBox tcomboBoxid_locataire = new JComboBox();
			tcomboBoxid_locataire.setBounds(321, 241, 207, 22);
			frame.getContentPane().add(tcomboBoxid_locataire);
			final JComboBox tcomboBoxid_contrat = new JComboBox();
			tcomboBoxid_contrat.setBounds(321, 288, 207, 22);
			frame.getContentPane().add(tcomboBoxid_contrat);
	
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(230, 126, 34));
			panel.setBounds(321, 338, 207, 38);
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String motif = tmotif.getText();
					int numero=Integer.parseInt(tnumero.getText());
					String dateL = tdateL.getText();
					
					Locataire lo= (Locataire)tcomboBoxid_locataire.getSelectedItem();
					int locataire=lo.getId();
					
					litige.setId_Locataire(locataire);
					
					Contrat co= (Contrat)tcomboBoxid_contrat.getSelectedItem();
					int contrat=co.getId();
					
					litige.setId_Contrat(contrat);
				
					litige.setNumero(numero);
					litige.setMotif(motif);
					litige.setDateL(dateL);
					
					LitigeDAO ldao=new LitigeDAO();
					ldao.save(litige);
					System.out.print(litige);
					JOptionPane.showMessageDialog(null, "Le litige a bien été modifié");
					Litige_liste.remp();
					
				}
			});
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("Modifier");
			lblNewLabel_4.setBounds(69, 11, 93, 16);
			lblNewLabel_4.setForeground(Color.WHITE);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setIcon(new ImageIcon(Litige_edit.class.getResource("/res/change2.png")));
			lblNewLabel_8.setBounds(151, 0, 46, 38);
			panel.add(lblNewLabel_8);
			
			JLabel lblNewLabel_5 = new JLabel("Id_Locataire");
			lblNewLabel_5.setBounds(225, 243, 78, 14);
			lblNewLabel_5.setForeground(Color.GRAY);
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("Id_Contrat");
			lblNewLabel_6.setBounds(225, 290, 78, 14);
			lblNewLabel_6.setForeground(Color.GRAY);
			lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel_6);
			
			tmotif = new JTextField();
			tmotif.setBounds(321, 134, 207, 20);
			frame.getContentPane().add(tmotif);
			tmotif.setColumns(10);
			
			tnumero = new JTextField();
			tnumero.setBounds(321, 166, 207, 20);
			tnumero.setColumns(10);
			frame.getContentPane().add(tnumero);
			
			tdateL = new JTextField();
			tdateL.setBounds(321, 199, 207, 20);
			tdateL.setColumns(10);
			frame.getContentPane().add(tdateL);
			
			
			
			//////////COMBOBOX////////////
			LocataireDAO locadao=new LocataireDAO();
			
			ArrayList<Locataire> locList = locadao.getAll();
			
			for(Locataire loc:locList) {
				tcomboBoxid_locataire.addItem(loc);
			}
			
			
			///////////////////////
			
			//////////COMBOBOX////////////
			ContratDAO contrdao=new ContratDAO();
			
			ArrayList<Contrat> conList = contrdao.getAll();
			
			for(Contrat con:conList) {
				tcomboBoxid_contrat.addItem(con);
			}
			
			
			///////////////////////
			
			tmotif.setText(this.litige.getMotif());

			tnumero.setText(this.litige.getNumero()+"");
			tdateL.setText(this.litige.getDateL());
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(213, 105, 375, 319);
			frame.getContentPane().add(panel_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.LIGHT_GRAY);
			panel_2.setBounds(154, 0, 509, 476);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Modifier un litige");
			lblNewLabel_1.setBounds(149, 38, 227, 38);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
			panel_2.add(lblNewLabel_1);
			
			JLabel lblNewLabel_7 = new JLabel("");
			lblNewLabel_7.setIcon(new ImageIcon(Litige_edit.class.getResource("/res/volume-\u00E9lev\u00E9.png")));
			lblNewLabel_7.setBounds(40, 11, 79, 82);
			panel_2.add(lblNewLabel_7);
			
			JLabel lblNewLabel_7_1 = new JLabel("");
			lblNewLabel_7_1.setIcon(new ImageIcon(Litige_edit.class.getResource("/res/voisin-.png")));
			lblNewLabel_7_1.setBounds(404, 11, 79, 82);
			panel_2.add(lblNewLabel_7_1);
			
		
			
			Locataire loc=locadao.getById(this.litige.getId_Locataire());
			Contrat con=contrdao.getById(this.litige.getId_Contrat());
		}
	}

