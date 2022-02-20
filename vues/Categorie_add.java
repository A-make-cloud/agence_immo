package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;


import DAO.CategorieDAO;

import entites.Categorie;
import entites.Database;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Categorie_add {

	private JFrame frame;
	
	private JTextField ttype;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categorie_add window = new Categorie_add();
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
	public Categorie_add() {
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
			
	
			
		
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.LIGHT_GRAY);
			panel_2.setBounds(178, 11, 525, 456);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(45, 113, 440, 229);
			panel_2.add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Type");
			lblNewLabel_1.setForeground(Color.GRAY);
			lblNewLabel_1.setBounds(65, 41, 46, 32);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1);
			
			
			JPanel comboagence = new JPanel();
			
				comboagence.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
								Database.Connect();
								
							
								String type=ttype.getText();
							
							
								CategorieDAO dao = new CategorieDAO();
							
								Categorie agen = new Categorie(type);
								
								
								System.out.println(agen);
								dao.save(agen);
								
									ttype.setText("");
							
								ttype.requestFocus();
								Categorie_liste.remp();
						
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
					comboagence.setBounds(151, 142, 217, 32);
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
					
					ttype = new JTextField();
					ttype.setBounds(151, 41, 217, 32);
					panel.add(ttype);
					ttype.setColumns(10);
					
					JLabel lblNewLabel = new JLabel("Ajouter une cat\u00E9gorie de logement");
					lblNewLabel.setForeground(Color.WHITE);
					lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
					lblNewLabel.setBounds(89, 16, 406, 42);
					panel_2.add(lblNewLabel);
					
					JLabel lblNewLabel_4 = new JLabel("");
					lblNewLabel_4.setIcon(new ImageIcon(Categorie_add.class.getResource("/res/room3.png")));
					lblNewLabel_4.setBounds(28, 11, 46, 53);
					panel_2.add(lblNewLabel_4);
		}

		public Window getFrame() {
			
			
			
			return frame;
		}
	}

	
	
	