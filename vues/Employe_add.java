package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;

import DAO.AgenceDAO;

import DAO.EmployeDAO;

import entites.Agence;

import entites.Database;
import entites.Employe;


import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Employe_add {

	private JFrame frame;
	private JTextField tnom;
	private JTextField tprenom;
	private JTextField tdateE;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employe_add window = new Employe_add();
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
	public Employe_add() {
		initialize();
	}


		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			Database.Connect();
			final EmployeDAO empldao = new EmployeDAO();
			AgenceDAO agendao = new AgenceDAO();
			
			frame = new JFrame();
			frame.setBounds(100, 100, 867, 546);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Ajouter un empl");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(367, 30, 238, 42);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			frame.getContentPane().add(lblNewLabel);
			
			JPanel panel = new JPanel();
			panel.setBounds(222, 83, 440, 332);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Nom");
			lblNewLabel_1.setForeground(Color.GRAY);
			lblNewLabel_1.setBounds(53, 47, 46, 14);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1);
			
			
			
			JLabel lblNewLabel_1_1 = new JLabel("Prenom");
			lblNewLabel_1_1.setForeground(Color.GRAY);
			lblNewLabel_1_1.setBounds(53, 98, 58, 14);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1_1);
			
			tprenom = new JTextField();
			tprenom.setBounds(141, 97, 217, 20);
			tprenom.setColumns(10);
			panel.add(tprenom);
			
			tnom = new JTextField();
			tnom.setBounds(142, 46, 217, 20);
			panel.add(tnom);
			tnom.setColumns(10);
			
			tdateE = new JTextField();
			tdateE.setColumns(10);
			tdateE.setBounds(142, 152, 217, 20);
			panel.add(tdateE);
			
			final JComboBox tcomboBoxid_agence = new JComboBox();
			tcomboBoxid_agence.setBounds(142, 202, 217, 22);
			panel.add(tcomboBoxid_agence);
			
			ArrayList<Agence> age = agendao.getAll();
		      for(int i=0;i<age.size();i++) {
		    	  tcomboBoxid_agence.addItem(age.get(i));
		    }
			
			JPanel comboagence = new JPanel();
				
			comboagence.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
							Database.Connect();
							
							String nom=tnom.getText();
							String prenom=tprenom.getText();
							String dateE=tdateE.getText();
							AgenceDAO dao = new AgenceDAO();
							Agence age =(Agence)tcomboBoxid_agence.getSelectedItem();
							int id_Agence = age.getId();
							Agence agen = new Agence(nom,prenom);
							
							dao.save(agen);
							
							Employe emp = new Employe(nom,prenom,dateE,id_Agence);
					
							empldao.save(emp);
							
							
							tnom.setText("");
							tprenom.setText("");
							tdateE.setText("");
							tnom.requestFocus();
							Employe_liste.remp();
				JOptionPane.showMessageDialog(null, "L' employé a bien été ajouté");
			}
				
			});
		
			

			comboagence.setBackground(new Color(230, 126, 34));
			comboagence.setBounds(142, 263, 217, 32);
			panel.add(comboagence);
			comboagence.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Ajouter");
			lblNewLabel_2.setBounds(81, 9, 46, 14);
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboagence.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(Agence_add.class.getResource("/res/pen.png")));
			lblNewLabel_3.setBounds(161, 9, 46, 16);
			comboagence.add(lblNewLabel_3);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Id_Agence");
			lblNewLabel_1_1_1.setForeground(Color.GRAY);
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_1_1.setBounds(53, 204, 79, 14);
			panel.add(lblNewLabel_1_1_1);
			
			JLabel lblNewLabel_1_2 = new JLabel("DateE");
			lblNewLabel_1_2.setForeground(Color.GRAY);
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_2.setBounds(53, 153, 46, 14);
			panel.add(lblNewLabel_1_2);
			
	
			
		
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.GRAY);
			panel_2.setBounds(178, 11, 525, 456);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Employe_add.class.getResource("/res/low.png")));
			lblNewLabel_4.setBounds(60, 11, 71, 53);
			panel_2.add(lblNewLabel_4);
		}

		public Window getFrame() {
			// TODO Auto-generated method stub
			return frame;
		}
	}
