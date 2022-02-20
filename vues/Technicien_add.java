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

import DAO.AgenceDAO;

import DAO.TechnicienDAO;
import entites.Agence;
import entites.Database;

import entites.Technicien;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Technicien_add {

	private JFrame frame;
	private JTextField tnom;
	private JTextField tprenom;
	private JTextField tspecialite;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Technicien_add window = new Technicien_add();
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
	public Technicien_add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 824, 513);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un technicien");
		lblNewLabel.setBounds(333, 27, 258, 42);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(202, 80, 400, 329);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(72, 16, 52, 17);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		tnom = new JTextField();
		tnom.setBounds(151, 11, 202, 31);
		panel.add(tnom);
		tnom.setColumns(10);
		
		Database.Connect();
		final TechnicienDAO techndao = new TechnicienDAO();
		AgenceDAO agendao = new AgenceDAO();
		
		final JComboBox tcomboBoxid_agence = new JComboBox();
		tcomboBoxid_agence.setBounds(151, 206, 202, 31);
		panel.add(tcomboBoxid_agence);
		
		ArrayList<Agence> agen = agendao.getAll();
	      for(int i=0;i<agen.size();i++) {
	    	  tcomboBoxid_agence.addItem(agen.get(i));
	    }
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
		if(tnom.getText().equals("") || tprenom.getText().equals("") || tspecialite.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Veuillez remplir les données","ERREUR de SAISI",JOptionPane.ERROR_MESSAGE); 
		}else {
			String nom = tnom.getText();
			String prenom = tprenom.getText();
			String specialite = tspecialite.getText();
		
			Agence age =(Agence)tcomboBoxid_agence.getSelectedItem();
			int id_Agence = age.getId();
			Technicien techn = new Technicien(nom,prenom,specialite,id_Agence);
			
			techndao.save(techn);
			Technicien_liste.remp();
			
			System.out.println(techn);
		}
		
				
			}
		});
		panel_1.setBounds(151, 269, 202, 31);
		panel_1.setBackground(new Color(230, 126, 34));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Ajouter");
		lblNewLabel_3.setBounds(78, 5, 45, 17);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Technicien_add.class.getResource("/res/pen.png")));
		lblNewLabel_2.setBounds(146, 5, 46, 26);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenom");
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setBounds(72, 77, 52, 17);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1);
		
		tprenom = new JTextField();
		tprenom.setBounds(151, 72, 202, 31);
		tprenom.setColumns(10);
		panel.add(tprenom);
		
		JLabel lblNewLabel_1_2 = new JLabel("Specialite");
		lblNewLabel_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_2.setBounds(72, 142, 69, 17);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_2);
		
		tspecialite = new JTextField();
		tspecialite.setBounds(151, 137, 202, 31);
		tspecialite.setColumns(10);
		panel.add(tspecialite);
		
		JLabel lblNewLabel_1_3 = new JLabel("id_Agence");
		lblNewLabel_1_3.setForeground(Color.GRAY);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(72, 216, 69, 17);
		panel.add(lblNewLabel_1_3);
		
	
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(163, 11, 483, 432);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Technicien_add.class.getResource("/res/mechanic.png")));
		lblNewLabel_4.setBounds(50, 0, 70, 65);
		panel_2.add(lblNewLabel_4);
	}

	public Window getFrame() {
	
		return frame;
	}
	
	
}
