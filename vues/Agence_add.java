package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import DAO.AgenceDAO;
import entites.Agence;
import entites.Database;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Agence_add {

	private JFrame frame;
	private JTextField tnom;
	private JTextField tadresse;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	

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
					Agence_add window = new Agence_add();
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
	public Agence_add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Database.Connect();
		AgenceDAO uprod = new AgenceDAO();
		

		frame = new JFrame();
		frame.setBounds(100, 100, 1050, 650);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajout d'une Agence");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(250, 25, 550, 55);
		frame.getContentPane().add(lblNewLabel);
		
		tnom = new JTextField();
		tnom.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tnom.setBounds(300, 125, 650, 50);
		frame.getContentPane().add(tnom);
		tnom.setColumns(10);
		
		tadresse = new JTextField();
		tadresse.setFont(new Font("Tahoma", Font.PLAIN, 30));
		tadresse.setColumns(10);
		tadresse.setBounds(300, 215, 650, 50);
		frame.getContentPane().add(tadresse);
		
		lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(25, 125, 250, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Adresse");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(25, 215, 250, 50);
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel comboagence = new JPanel();
		comboagence.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tnom.getText().equals("") || tadresse.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuillez remplir les données","ERREUR de SAISI",JOptionPane.ERROR_MESSAGE); 
				}else {
					String nom = tnom.getText();
					String adresse = tadresse.getText();
					Database.Connect();
					AgenceDAO uprod = new AgenceDAO();
					Agence c = new Agence(nom,adresse);
					uprod.save(c);
					
					JOptionPane.showMessageDialog(null, "L' agence a bien été ajoutée");
					Agence_Liste.remp();
				}
				
			}
		});
		comboagence.setLayout(null);
		comboagence.setBackground(new Color(230, 126, 34));
		comboagence.setBounds(446, 370, 217, 32);
		frame.getContentPane().add(comboagence);
		
		JLabel lblNewLabel_2_1 = new JLabel("Ajouter");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(81, 9, 46, 14);
		comboagence.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(161, 9, 46, 16);
		comboagence.add(lblNewLabel_3);
	}
}
