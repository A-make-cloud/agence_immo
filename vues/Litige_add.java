package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.CategorieDAO;
import DAO.ContratDAO;
import DAO.LitigeDAO;
import DAO.LocataireDAO;
import DAO.LogementDAO;
import DAO.ProprietaireDAO;
import entites.Categorie;
import entites.Contrat;
import entites.Database;
import entites.Litige;
import entites.Locataire;
import entites.Logement;
import entites.Proprietaire;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Litige_add {

	private JFrame frame;
	private JTextField tmotif;
	private JTextField tnumero;
	private JTextField tdateL;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Litige_add window = new Litige_add();
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
	public Litige_add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 922, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un litige");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(385, 11, 208, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(201, 73, 460, 328);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Motif");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(44, 23, 109, 21);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		tmotif = new JTextField();
		tmotif.setBounds(163, 23, 236, 22);
		panel.add(tmotif);
		tmotif.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Numero");
		lblNewLabel_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_2.setBounds(44, 66, 109, 21);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_2);
		
		tnumero = new JTextField();
		tnumero.setBounds(163, 66, 236, 22);
		tnumero.setColumns(10);
		panel.add(tnumero);
		
		JLabel lblNewLabel_1_3 = new JLabel("DateL");
		lblNewLabel_1_3.setForeground(Color.GRAY);
		lblNewLabel_1_3.setBounds(44, 111, 109, 21);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_3);
		
		
		
		JLabel lblNewLabel_1_4 = new JLabel("Id_Locataire");
		lblNewLabel_1_4.setForeground(Color.GRAY);
		lblNewLabel_1_4.setBounds(44, 156, 109, 21);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Id_Contrat");
		lblNewLabel_1_5.setForeground(Color.GRAY);
		lblNewLabel_1_5.setBounds(44, 201, 109, 21);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_5);
		
		final JComboBox tcomboBoxid_locataire = new JComboBox();
		tcomboBoxid_locataire.setBounds(163, 158, 236, 21);
		panel.add(tcomboBoxid_locataire);
		
		final JComboBox tcomboBoxid_contrat = new JComboBox();
		tcomboBoxid_contrat.setBounds(163, 202, 236, 21);
		panel.add(tcomboBoxid_contrat);
		Database.Connect();
		LitigeDAO litidao = new LitigeDAO();
		LocataireDAO locadao = new LocataireDAO();
		ContratDAO contrdao = new ContratDAO();
		//JComboBox<Categorie> cCategorie = new JComboBox<Categorie>();
		ArrayList<Locataire> locat = locadao.getAll();
	      for(int i=0;i<locat.size();i++) {
	    	  tcomboBoxid_locataire.addItem(locat.get(i));
	    }
		
	      
	      ArrayList<Contrat> contr = contrdao.getAll();
	      for(int i=0;i<contr.size();i++) {
	    	  tcomboBoxid_contrat.addItem(contr.get(i));
	    }
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LitigeDAO litidao = new LitigeDAO();

				if(tmotif.getText().equals("") || tnumero.getText().equals("") || tdateL.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuillez remplir les données","ERREUR de SAISI",JOptionPane.ERROR_MESSAGE); 
				}else {
			
					String motif = tmotif.getText();
					int numero =Integer.parseInt(tnumero.getText());
					String dateL = tdateL.getText();
					
					
					
					Locataire loc =(Locataire)tcomboBoxid_locataire.getSelectedItem();
					int id_Locataire = loc.getId();
					
					Contrat cat =(Contrat)tcomboBoxid_contrat.getSelectedItem();
					int id_Contrat = cat.getId();
					Litige lit = new Litige(motif,numero,dateL,id_Locataire,id_Contrat);
					System.out.print(lit);
					litidao.save(lit);
					Litige_liste.remp();
					
				
					tmotif.setText("");
					tnumero.setText("");
					tdateL.setText("");
					
					JOptionPane.showMessageDialog(null, " litige ajouté");
					
					Litige_liste.remp();
				
				
				}
				
			}
		});
		panel_1.setBackground(new Color(230, 126, 34));
		panel_1.setBounds(163, 266, 236, 32);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ajouter");
		lblNewLabel_2.setBounds(93, 5, 55, 21);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Litige_add.class.getResource("/res/pen.png")));
		lblNewLabel_3.setBounds(180, 5, 46, 27);
		panel_1.add(lblNewLabel_3);
		
		tdateL = new JTextField();
		tdateL.setColumns(10);
		tdateL.setBounds(163, 113, 236, 22);
		panel.add(tdateL);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(157, 0, 576, 445);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(Litige_add.class.getResource("/res/law.png")));
		lblNewLabel_4.setBounds(88, 11, 64, 59);
		panel_2.add(lblNewLabel_4);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
