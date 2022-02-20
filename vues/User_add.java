package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


import DAO.UserDAO;

import entites.Database;
import entites.User;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class User_add {

	private JFrame frame;
	private JTextField tidentifiant;
	private JTextField tpassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_add window = new User_add();
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
	public User_add() {
		initialize();
	}



		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 867, 546);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Ajouter un utilisateur");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(367, 30, 238, 42);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			frame.getContentPane().add(lblNewLabel);
			
			JPanel panel = new JPanel();
			panel.setBounds(222, 83, 440, 332);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Identifiant");
			lblNewLabel_1.setForeground(Color.GRAY);
			lblNewLabel_1.setBounds(53, 47, 68, 14);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1);
			
	
			
			JLabel lblNewLabel_1_1 = new JLabel("Mot de passe");
			lblNewLabel_1_1.setForeground(Color.GRAY);
			lblNewLabel_1_1.setBounds(53, 99, 80, 14);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1_1);
			
		
			
			JPanel comboagence = new JPanel();
		
			comboagence.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
							Database.Connect();
							
						
							String identifiant=tidentifiant.getText();
							String password=tpassword.getText();
						
							UserDAO dao = new UserDAO();
						
							User us = new User(identifiant,password);
							
							
							System.out.println(us);
							dao.save(us);
							
								tidentifiant.setText("");
								tpassword.setText("");
							tidentifiant.requestFocus();
							
					
					//JOptionPane.showMessageDialog(null, "L' agence a bien été ajouté");
							
							
					/*
					Database.Connect();
					AgenceDAO dao = new AgenceDAO();
					Agence a = new Agence(nom.getText());
					categoriedao.save(cat);
					titre.setText("");
					titre.requestFocus();
					JOptionPane.showMessageDialog(null, "La catégorie a bien été ajoutée");		
			*/
					
				}
				
			});
		
			

			comboagence.setBackground(new Color(230, 126, 34));
			comboagence.setBounds(165, 157, 207, 32);
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
			
			tidentifiant = new JTextField();
			tidentifiant.setBounds(165, 46, 207, 20);
			panel.add(tidentifiant);
			tidentifiant.setColumns(10);
			
			tpassword = new JTextField();
			tpassword.setColumns(10);
			tpassword.setBounds(165, 98, 207, 20);
			panel.add(tpassword);
			
		
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(46, 49, 49));
			panel_2.setBounds(178, 11, 525, 456);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(User_add.class.getResource("/res/user3.png")));
			lblNewLabel_4.setBounds(40, 11, 90, 55);
			panel_2.add(lblNewLabel_4);
		}
	}

	
	