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
import DAO.LogementDAO;

import DAO.ProprietaireDAO;

import entites.Categorie;
import entites.Database;
import entites.Logement;

import entites.Proprietaire;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Logement_add {

	private JFrame frame;
	private JTextField tville;
	private JTextField tprix;
	private JTextField ttaille;
	private JTextField tetage;
	protected JLabel ttype;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logement_add window = new Logement_add();
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
	public Logement_add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 926, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(146, 79, 571, 349);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ville");
		lblNewLabel_1.setBounds(63, 25, 71, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		tville = new JTextField();
		tville.setBounds(198, 25, 289, 19);
		panel.add(tville);
		tville.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prix");
		lblNewLabel_1_1.setBounds(63, 72, 71, 14);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1);
		
		tprix = new JTextField();
		tprix.setBounds(198, 72, 289, 19);
		tprix.setColumns(10);
		panel.add(tprix);
		
		JLabel lblNewLabel_1_2 = new JLabel("Taille");
		lblNewLabel_1_2.setBounds(63, 115, 71, 14);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_2);
		
		ttaille = new JTextField();
		ttaille.setBounds(198, 115, 289, 19);
		ttaille.setColumns(10);
		panel.add(ttaille);
		
		JLabel lblNewLabel_1_3 = new JLabel("Etage");
		lblNewLabel_1_3.setBounds(63, 162, 71, 19);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_3);
		
		tetage = new JTextField();
		tetage.setBounds(198, 162, 289, 19);
		tetage.setColumns(10);
		panel.add(tetage);
		
		JLabel lblNewLabel_1_4 = new JLabel("Id_Proprietaire");
		lblNewLabel_1_4.setBounds(63, 213, 100, 14);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Id_Categorie");
		lblNewLabel_1_5.setBounds(63, 263, 86, 14);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_5);
		
		final JComboBox tcomboBoxid_proprietaire = new JComboBox();
		tcomboBoxid_proprietaire.setBounds(198, 213, 289, 20);
		panel.add(tcomboBoxid_proprietaire);
		
		final JComboBox tcomboBoxid_Categorie = new JComboBox();
		tcomboBoxid_Categorie.setBounds(198, 261, 289, 20);
		panel.add(tcomboBoxid_Categorie);
		
		Database.Connect();
		final LogementDAO logedao = new LogementDAO();
		ProprietaireDAO propridao = new ProprietaireDAO();
		CategorieDAO catedao = new CategorieDAO();
		//JComboBox<Categorie> cCategorie = new JComboBox<Categorie>();
		ArrayList<Proprietaire> prop = propridao.getAll();
	      for(int i=0;i<prop.size();i++) {
	    	  tcomboBoxid_proprietaire.addItem(prop.get(i));
	    }
		
	      
	      ArrayList<Categorie> categ = catedao.getAll();
	      for(int i=0;i<categ.size();i++) {
	    	  tcomboBoxid_Categorie.addItem(categ.get(i));
	    }
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(tville.getText().equals("") || tprix.getText().equals("")|| ttaille.getText().equals("") || tetage.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuillez remplir les données","ERREUR de SAISI",JOptionPane.ERROR_MESSAGE); 
				}else {
			
					String ville = tville.getText();
					float prix = Float.parseFloat(tprix.getText());
					int taille =Integer.parseInt(ttaille.getText());
					int etage =Integer.parseInt(tetage.getText());
					
					Proprietaire prop =(Proprietaire)tcomboBoxid_proprietaire.getSelectedItem();
					int id_Proprietaire = prop.getId();
					
					Categorie cat =(Categorie)tcomboBoxid_Categorie.getSelectedItem();
					int id_Categorie = cat.getId();
					Logement lo = new Logement(ville,prix,taille,etage,id_Proprietaire,id_Categorie);
					logedao.save(lo);
					Logement_liste.remp();
					
				
					tville.setText("");
					tprix.setText("");
					ttaille.setText("");
					tetage.setText("");
					ttype.requestFocus();
				
				}
			}
		});
		panel_1.setBackground(new Color(230, 126, 34));
		panel_1.setBounds(198, 300, 289, 38);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ajouter");
		lblNewLabel_2.setBounds(98, 11, 55, 14);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Logement_add.class.getResource("/res/pen.png")));
		lblNewLabel_3.setBounds(216, 0, 46, 38);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(113, 11, 639, 463);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter un logement");
		lblNewLabel.setBounds(247, 22, 227, 31);
		lblNewLabel.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Logement_add.class.getResource("/res/house2.png")));
		lblNewLabel_4.setBounds(83, 11, 63, 42);
		panel_2.add(lblNewLabel_4);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
