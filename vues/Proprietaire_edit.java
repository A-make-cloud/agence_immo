package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.ImageIcon;
import javax.swing.JTextField;


import DAO.ProprietaireDAO;
import entites.Database;
import entites.Proprietaire;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Proprietaire_edit {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Proprietaire proprietaire;
	private JTextField tnom;
	private JTextField tprenom;
	private JTextField tville;
	private JTextField tdateP;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proprietaire_edit window = new Proprietaire_edit();
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
	public Proprietaire_edit() {
		initialize();
	}

	public Proprietaire_edit(Proprietaire propr) {
		initialize();
		this.proprietaire=propr;
	}

	
	
	
	
	
	


		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 834, 500);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(189, 96, 488, 307);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Nom");
			lblNewLabel_1.setForeground(Color.GRAY);
			lblNewLabel_1.setBounds(64, 51, 35, 19);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1);
			
			tnom = new JTextField();
			tnom.setBounds(146, 52, 229, 19);
			panel.add(tnom);
			tnom.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Database.Connect();
					ProprietaireDAO proprdao=new ProprietaireDAO();
					
					String nom=tnom.getText();
					String prenom=tprenom.getText();
					String ville=tville.getText();
					String dateP=tdateP.getText();
					proprietaire.setNom(nom);
					proprietaire.setPrenom(prenom);
					proprietaire.setVille(ville);
					proprietaire.setDateP(dateP);
					proprdao.save(proprietaire);
					tnom.setText("");
					tprenom.setText("");
					tville.setText("");
					tdateP.setText("");
					tnom.requestFocus();
					JOptionPane.showMessageDialog(null, "L' agence a bien été modifiée");
					Proprietaire_liste.remp();
				}
			});
			panel_1.setBounds(146, 253, 229, 30);
			panel_1.setBackground(new Color(230, 126, 34));
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Modifier");
			lblNewLabel_3.setBounds(91, 5, 46, 17);
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel_1.add(lblNewLabel_3);
			
			JLabel lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon(Agence_edit.class.getResource("/res/change2.png")));
			lblNewLabel_5.setBounds(155, 5, 46, 22);
			panel_1.add(lblNewLabel_5);
			
			JLabel lblNewLabel_1_1 = new JLabel("Prenom");
			lblNewLabel_1_1.setForeground(Color.GRAY);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_1.setBounds(64, 98, 54, 19);
			panel.add(lblNewLabel_1_1);
			
			
			
			JLabel lblNewLabel_1_2 = new JLabel("Ville");
			lblNewLabel_1_2.setForeground(Color.GRAY);
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_2.setBounds(64, 142, 35, 19);
			panel.add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("DateP");
			lblNewLabel_1_1_1.setForeground(Color.GRAY);
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_1_1.setBounds(64, 189, 54, 19);
			panel.add(lblNewLabel_1_1_1);
			
			tprenom = new JTextField();
			tprenom.setColumns(10);
			tprenom.setBounds(146, 97, 229, 20);
			panel.add(tprenom);
			
			tville = new JTextField();
			tville.setColumns(10);
			tville.setBounds(146, 143, 229, 20);
			panel.add(tville);
			
			tdateP = new JTextField();
			tdateP.setColumns(10);
			tdateP.setBounds(146, 190, 229, 20);
			panel.add(tdateP);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.LIGHT_GRAY);
			panel_2.setBounds(156, 11, 550, 428);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBounds(39, 11, 71, 70);
			lblNewLabel_2.setIcon(new ImageIcon(Proprietaire_edit.class.getResource("/res/house.png")));
			panel_2.add(lblNewLabel_2);
			
			JLabel lblNewLabel = new JLabel("Modifier un proprietaire");
			lblNewLabel.setBounds(140, 23, 293, 31);
			panel_2.add(lblNewLabel);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Proprietaire_edit.class.getResource("/res/owner.png")));
			lblNewLabel_4.setBounds(443, 21, 71, 60);
			panel_2.add(lblNewLabel_4);
		}

		public Window getFrame() {
			
			return frame;
		}
	}
