package vues;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import DAO.UserDAO;


import entites.Database;

import entites.User;


import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class User_edit {

		private JFrame frame;
	
		


		private JTextField tidentifiant;
		private JTextField tpassword;

		private User User;




		private entites.User user;



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
						User_edit window = new User_edit();
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
		public User_edit() {
			initialize();
		}
		
		public User_edit(User use) {
			this.user=use;
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
			
			JLabel lblNewLabel_6 = new JLabel("");
			lblNewLabel_6.setBounds(134, 55, 67, 64);
			frame.getContentPane().add(lblNewLabel_6);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(246, 11, 565, 528);
			panel_4.setBackground(Color.ORANGE);
			frame.getContentPane().add(panel_4);
			panel_4.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(21, 11, 521, 505);
			panel_4.add(panel_3);
			panel_3.setBackground(Color.LIGHT_GRAY);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_3_1 = new JLabel("");
			lblNewLabel_3_1.setBounds(401, 27, 64, 73);
			lblNewLabel_3_1.setIcon(new ImageIcon(User_edit.class.getResource("/res/employee.png")));
			panel_3.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setBounds(30, 35, 80, 65);
			lblNewLabel_5.setIcon(new ImageIcon(User_edit.class.getResource("/res/contract.png")));
			panel_3.add(lblNewLabel_5);
			
			JLabel lblNewLabel_1 = new JLabel("Modifier un Utilisateur");
			lblNewLabel_1.setBounds(101, 54, 309, 38);
			panel_3.add(lblNewLabel_1);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
			
			tpassword = new JTextField();
			tpassword.setBounds(186, 190, 204, 20);
			panel_3.add(tpassword);
			tpassword.setColumns(10);
			
						tpassword.setText(this.user.getPassword());
						
							
								
								tidentifiant = new JTextField();
								tidentifiant.setBounds(186, 149, 204, 20);
								panel_3.add(tidentifiant);
								tidentifiant.setColumns(10);
								
	
								
								tidentifiant.setText(this.user.getIdentifiant());
								
								JLabel lblNewLabel = new JLabel("Identifiant");
								lblNewLabel.setBounds(72, 152, 79, 14);
								panel_3.add(lblNewLabel);
								lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
								lblNewLabel.setForeground(Color.GRAY);
								
								JLabel lblNewLabel_3 = new JLabel("Mot de passe");
								lblNewLabel_3.setBounds(72, 186, 92, 29);
								panel_3.add(lblNewLabel_3);
								lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
								lblNewLabel_3.setForeground(Color.GRAY);
								
								JPanel panel_1 = new JPanel();
								panel_1.setBounds(0, 107, 521, 398);
								panel_3.add(panel_1);
								panel_1.setLayout(null);
								panel_1.setBackground(Color.LIGHT_GRAY);
								
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
										
										String identifiant = tidentifiant.getText();
										String password = tpassword.getText();
									
									
										
										user.setIdentifiant(identifiant);
										user.setPassword(password);
										
										
								
										
										UserDAO logedao=new UserDAO();
										logedao.save(user);
										System.out.print(user);
										
										JOptionPane.showMessageDialog(null, "Le User a bien été modifié");
									//	User_liste.remp();
										
									}
								});
								panel.setLayout(null);
								
								JLabel lblNewLabel_4 = new JLabel("Modifier");
								lblNewLabel_4.setBounds(69, 11, 93, 16);
								lblNewLabel_4.setForeground(Color.WHITE);
								lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
								panel.add(lblNewLabel_4);
								
								JLabel lblNewLabel_8 = new JLabel("");
								lblNewLabel_8.setIcon(new ImageIcon(User_edit.class.getResource("/res/change2.png")));
								lblNewLabel_8.setBounds(155, 6, 46, 27);
								panel.add(lblNewLabel_8);
			
		
			

			
		}

		public Window getFrameListeUser() {
			
			return frame;
		}
	}

