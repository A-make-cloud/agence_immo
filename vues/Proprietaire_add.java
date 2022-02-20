package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;

import DAO.AgenceDAO;
import DAO.ProprietaireDAO;
import entites.Agence;
import entites.Database;
import entites.Proprietaire;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Proprietaire_add {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	
	private JTextField tprenom;
	private JTextField tville;
	private JTextField tdateP;
	private JTextField tnom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proprietaire_add window = new Proprietaire_add();
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
	public Proprietaire_add() {
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
			
			JPanel panel = new JPanel();
			panel.setBounds(222, 83, 440, 332);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Nom");
			lblNewLabel_1.setBounds(53, 47, 46, 14);
			lblNewLabel_1.setForeground(Color.GRAY);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1);
			
			
			
			
			
			JLabel lblNewLabel_1_1 = new JLabel("Prenom");
			lblNewLabel_1_1.setBounds(53, 84, 58, 14);
			lblNewLabel_1_1.setForeground(Color.GRAY);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1_1);
			
			tville = new JTextField();
			tville.setBounds(141, 107, 217, 22);
			tville.setColumns(10);
			panel.add(tville);
			
			JPanel comboagence = new JPanel();
			comboagence.setBounds(141, 204, 217, 32);
		
			comboagence.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
							Database.Connect();
							
						
							String nom=tnom.getText();
							String prenom=tprenom.getText();
							String ville=tville.getText();
							String dateP=tdateP.getText();
							ProprietaireDAO dao = new ProprietaireDAO();
						
							Proprietaire propri = new Proprietaire(nom,prenom,ville,dateP);
							
							
							System.out.println(propri);
							dao.save(propri);
							
								tnom.setText("");
								tprenom.setText("");
								tville.setText("");
							tdateP.setText("");
							tnom.requestFocus();
							
					
					JOptionPane.showMessageDialog(null, "Le proprietaire a bien été ajouté");
							Proprietaire_liste.remp();
							
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
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Ville");
			lblNewLabel_1_1_1.setBounds(53, 109, 58, 14);
			lblNewLabel_1_1_1.setForeground(Color.GRAY);
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1_1_1);
			
			tdateP = new JTextField();
			tdateP.setBounds(141, 143, 217, 22);
			tdateP.setColumns(10);
			panel.add(tdateP);
			
			tprenom = new JTextField();
			tprenom.setBounds(141, 77, 217, 20);
			panel.add(tprenom);
			
			JLabel lblNewLabel_1_1_1_1 = new JLabel("DateP");
			lblNewLabel_1_1_1_1.setBounds(53, 145, 58, 14);
			lblNewLabel_1_1_1_1.setForeground(Color.GRAY);
			lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1_1_1_1);
			
			tnom = new JTextField();
			tnom.setBounds(141, 46, 217, 20);
			panel.add(tnom);
			tnom.setColumns(10);
			
		
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.LIGHT_GRAY);
			panel_2.setBounds(178, 11, 525, 456);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Proprietaire_add.class.getResource("/res/agile.png")));
			lblNewLabel_4.setBounds(49, 0, 68, 71);
			panel_2.add(lblNewLabel_4);
			
			JLabel lblNewLabel = new JLabel("Ajouter un proprietaire");
			lblNewLabel.setBounds(141, 22, 257, 42);
			panel_2.add(lblNewLabel);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}

		public Window getFrame() {
			// TODO Auto-generated method stub
			return frame;
		}
	}
