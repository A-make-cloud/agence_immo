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

import DAO.AgenceDAO;
import DAO.TechnicienDAO;
import entites.Agence;
import entites.Database;
import entites.Technicien;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Technicien_edit {

		private JFrame frame;
	
		


		private JTextField tnom;
		private JTextField tspecialite;




		private Technicien technicien;
		private JTextField tprenom;



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
						Technicien_edit window = new Technicien_edit();
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
		public Technicien_edit() {
			initialize();
		}
		
		public Technicien_edit(Technicien tec) {
			this.technicien=tec;
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
	
		
			
			tnom = new JTextField();
			tnom.setBounds(363, 176, 204, 20);
			frame.getContentPane().add(tnom);
			tnom.setColumns(10);
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBounds(177, 134, 521, 398);
			frame.getContentPane().add(panel_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setForeground(Color.GRAY);
			panel_2.setBounds(34, 0, 436, 367);
			panel_1.add(panel_2);
			panel_2.setLayout(null);
			tprenom = new JTextField();
			tprenom.setBounds(154, 91, 207, 22);
			panel_2.add(tprenom);
			tprenom.setColumns(10);
			
			
			tspecialite = new JTextField();
			tspecialite.setText((String) null);
			tspecialite.setColumns(10);
			tspecialite.setBounds(154, 140, 204, 20);
			panel_2.add(tspecialite);
		
	
			
			tnom.setText(this.technicien.getNom());
			tprenom.setText(this.technicien.getPrenom());
			tspecialite.setText(this.technicien.getSpecialite());
			
		
		
			
			JPanel panel = new JPanel();
			panel.setBounds(148, 256, 207, 38);
			panel_2.add(panel);
			
			final JComboBox tcomboBoxid_agence = new JComboBox();
			tcomboBoxid_agence.setBounds(150, 187, 205, 22);
			panel_2.add(tcomboBoxid_agence);
			panel.setBackground(new Color(230,126,34));
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				
					String nom = tnom.getText();
					String prenom = tprenom.getText();
					String specialite = tspecialite.getText();
					
					Agence age= (Agence)tcomboBoxid_agence.getSelectedItem();
					int agence=age.getId();
					
				
					technicien.setId_Agence(agence);
					
					
					technicien.setNom(nom);
					technicien.setPrenom(prenom);
					technicien.setSpecialite(specialite);
					
					
					TechnicienDAO techndao=new TechnicienDAO();
					techndao.save(technicien);
					System.out.print(technicien);
					
					JOptionPane.showMessageDialog(null, "Le technicien a bien été modifié");
					Technicien_liste.remp();
					
				}
			});
			panel.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("Modifier");
			lblNewLabel_4.setBounds(69, 11, 93, 16);
			lblNewLabel_4.setForeground(Color.WHITE);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_8 = new JLabel("");
			lblNewLabel_8.setIcon(new ImageIcon(Technicien_edit.class.getResource("/res/change2.png")));
			lblNewLabel_8.setBounds(155, 6, 46, 27);
			panel.add(lblNewLabel_8);
			
			JLabel lblNewLabel_1_1 = new JLabel("Nom");
			lblNewLabel_1_1.setForeground(Color.GRAY);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_1.setBounds(46, 45, 72, 14);
			panel_2.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Prenom");
			lblNewLabel_1_1_1.setForeground(Color.GRAY);
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_1_1.setBounds(46, 92, 72, 14);
			panel_2.add(lblNewLabel_1_1_1);
			
			JLabel lblNewLabel_1_2 = new JLabel("Specialite");
			lblNewLabel_1_2.setForeground(Color.GRAY);
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_2.setBounds(46, 139, 72, 19);
			panel_2.add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_3 = new JLabel("Id_Agence");
			lblNewLabel_1_3.setForeground(Color.GRAY);
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_3.setBounds(46, 186, 94, 20);
			panel_2.add(lblNewLabel_1_3);
			
						tnom.setText(this.technicien.getNom());
						tspecialite.setText(this.technicien.getSpecialite());
					
						
					
						
						
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(Color.LIGHT_GRAY);
			panel_3.setBounds(177, 27, 521, 505);
			frame.getContentPane().add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_3_1 = new JLabel("");
			lblNewLabel_3_1.setIcon(new ImageIcon(Technicien_edit.class.getResource("/res/tuyauterie.png")));
			lblNewLabel_3_1.setBounds(417, 27, 64, 73);
			panel_3.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon(Technicien_edit.class.getResource("/res/mechanic.png")));
			lblNewLabel_5.setBounds(30, 35, 80, 65);
			panel_3.add(lblNewLabel_5);
			
			JLabel lblNewLabel_1 = new JLabel("Modifier un Technicien");
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
			
			//////////COMBOBOX////////////
			AgenceDAO agendao=new AgenceDAO();
			
			ArrayList<Agence> agenList = agendao.getAll();
			
			for(Agence age:agenList) {
				tcomboBoxid_agence.addItem(age);
			}
			
			
			///////////////////////
			
	
			Agence age=agendao.getById(this.technicien.getId_Agence());
			
		}
	}

