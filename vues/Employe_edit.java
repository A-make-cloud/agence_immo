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
import DAO.EmployeDAO;


import entites.Agence;
import entites.Database;
import entites.Employe;
import entites.Litige;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Employe_edit {

		private JFrame frame;
	
		private JTextField tnom;
		private JTextField tdateE;
		private JTextField tprenom;

		private Employe employe;

		private Agence agence;

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
						Employe_edit window = new Employe_edit();
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
		public Employe_edit() {
			initialize();
		}
		
		public Employe_edit(Employe empl) {
			this.employe=empl;
			initialize();
			
			}

		public Employe_edit(Agence p) {
			this.agence=p;
		}

	
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			Database.Connect();
			frame = new JFrame();
			frame.setBounds(100, 100, 808, 558);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Nom");
			lblNewLabel.setBounds(149, 131, 82, 14);
			lblNewLabel.setForeground(Color.GRAY);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_2 = new JLabel("Prenom");
			lblNewLabel_2.setBounds(149, 173, 82, 14);
			lblNewLabel_2.setForeground(Color.GRAY);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("DateE");
			lblNewLabel_3.setBounds(149, 216, 82, 29);
			lblNewLabel_3.setForeground(Color.GRAY);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel_3);
	
		
			
			tnom = new JTextField();
			tnom.setBounds(270, 128, 204, 20);
			frame.getContentPane().add(tnom);
			tnom.setColumns(10);
			
			tdateE = new JTextField();
			tdateE.setBounds(270, 220, 204, 20);
			tdateE.setColumns(10);
			frame.getContentPane().add(tdateE);
			
			
			final JComboBox tcomboBoxid_agence = new JComboBox();
			tcomboBoxid_agence.setBounds(270, 269, 204, 22);
			frame.getContentPane().add(tcomboBoxid_agence);
			
			JPanel panel = new JPanel();
			panel.setBounds(267, 347, 207, 38);
			panel.setBackground(new Color(230, 126, 34));
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String nom = tnom.getText();
					String prenom = tprenom.getText();
					String dateE = tdateE.getText();
				
					
					Agence ag= (Agence)tcomboBoxid_agence.getSelectedItem();
					int agence=ag.getId();
					
					employe.setId_Agence(agence);
					employe.setNom(nom);
					employe.setPrenom(prenom);
					employe.setDateE(dateE);
					
					
					EmployeDAO edao=new EmployeDAO();
					edao.save(employe);
					Employe_liste.remp();
					JOptionPane.showMessageDialog(null, "Le employe a bien été modifié");
					
				}
			});
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("Modifier");
			lblNewLabel_4.setForeground(Color.WHITE);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_4.setBounds(69, 11, 93, 16);
			panel.add(lblNewLabel_4);
			
			//////////COMBOBOX////////////
			AgenceDAO agendao=new AgenceDAO();
			
			ArrayList<Agence> agenList = agendao.getAll();
			
			for(Agence ag:agenList) {
				tcomboBoxid_agence.addItem(ag);
			}
			
			
			///////////////////////
			
			tnom.setText(this.employe.getNom());
			
			JLabel lblNewLabel_3_1 = new JLabel("Id_Agence");
			lblNewLabel_3_1.setBounds(149, 266, 82, 29);
			lblNewLabel_3_1.setForeground(Color.GRAY);
			lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel_3_1);
		
			
			tprenom = new JTextField();
			tprenom.setBounds(270, 170, 204, 20);
			tprenom.setText((String) null);
			tprenom.setColumns(10);
			frame.getContentPane().add(tprenom);
			tprenom.setText(this.employe.getPrenom());
			tdateE.setText(this.employe.getDateE());
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(109, 101, 438, 314);
			frame.getContentPane().add(panel_1);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.LIGHT_GRAY);
			panel_2.setBounds(72, 11, 512, 450);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Modifier un employe");
			lblNewLabel_1.setBounds(119, 33, 277, 38);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
			panel_2.add(lblNewLabel_1);
			
			JLabel lblNewLabel_5 = new JLabel("New label");
			lblNewLabel_5.setIcon(new ImageIcon(Employe_edit.class.getResource("/res/employee.png")));
			lblNewLabel_5.setBounds(42, 11, 67, 73);
			panel_2.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("New label");
			lblNewLabel_6.setIcon(new ImageIcon(Employe_edit.class.getResource("/res/transfer.png")));
			lblNewLabel_6.setBounds(406, 24, 67, 58);
			panel_2.add(lblNewLabel_6);
	
			
			Agence ag=agendao.getById(this.employe.getId_Agence());
		}
	}

