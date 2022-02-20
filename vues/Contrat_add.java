package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.AgenceDAO;
import DAO.ContratDAO;
import DAO.LocataireDAO;
import DAO.LogementDAO;
import DAO.ProprietaireDAO;
import entites.Agence;
import entites.Contrat;
import entites.Database;
import entites.Locataire;
import entites.Logement;
import entites.Proprietaire;

import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Contrat_add {

	private JFrame frame;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contrat_add window = new Contrat_add();
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
	public Contrat_add() {
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
			
			JLabel lblNewLabel_1 = new JLabel("Numero");
			lblNewLabel_1.setBounds(63, 25, 71, 14);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1);
			
			final JTextField tnumero = new JTextField();
			tnumero.setBounds(198, 25, 289, 19);
			panel.add(tnumero);
			tnumero.setColumns(10);
			
			JLabel lblNewLabel_1_1 = new JLabel("DateC");
			lblNewLabel_1_1.setBounds(63, 72, 71, 14);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1_1);
			
			final JTextField tdateC = new JTextField();
			tdateC.setBounds(198, 72, 289, 19);
			tdateC.setColumns(10);
			panel.add(tdateC);
			
			JLabel lblNewLabel_1_2 = new JLabel("id_Locataire");
			lblNewLabel_1_2.setBounds(63, 115, 100, 14);
			lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1_2);
			
		
			
			JLabel lblNewLabel_1_3 = new JLabel("Id_Proprietaire");
			lblNewLabel_1_3.setBounds(63, 162, 100, 22);
			lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1_3);
			
		
			
			JLabel lblNewLabel_1_4 = new JLabel("Id_Agence");
			lblNewLabel_1_4.setBounds(63, 213, 100, 20);
			lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1_4);
			
			JLabel lblNewLabel_1_5 = new JLabel("Id_Logement");
			lblNewLabel_1_5.setBounds(63, 263, 86, 18);
			lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1_5);

			final JComboBox tcomboBoxid_locataire = new JComboBox();
			tcomboBoxid_locataire.setBounds(198, 113, 289, 20);
			panel.add(tcomboBoxid_locataire);
			
			final JComboBox tcomboBoxid_proprietaire = new JComboBox();
			tcomboBoxid_proprietaire.setBounds(198, 165, 289, 20);
			panel.add(tcomboBoxid_proprietaire);
			
			final JComboBox tcomboBoxid_Logement = new JComboBox();
			tcomboBoxid_Logement.setBounds(198, 261, 289, 20);
			panel.add(tcomboBoxid_Logement);
			
			final JComboBox tcomboBoxid_agence = new JComboBox();
			tcomboBoxid_agence.setBounds(198, 214, 289, 22);
			panel.add(tcomboBoxid_agence);
			
			Database.Connect();
			final ContratDAO contrdao = new ContratDAO();
			LocataireDAO locadao = new LocataireDAO();
			ProprietaireDAO propridao = new ProprietaireDAO();
			AgenceDAO agedao = new AgenceDAO();
			LogementDAO logedao = new LogementDAO();
			
			//JComboBox= new JComboBox<Locataire>();
			ArrayList<Locataire> loca = locadao.getAll();
		      for(int i=0;i<loca.size();i++) {
		    	  tcomboBoxid_locataire.addItem(loca.get(i));
		    }
			
			//JComboBox<Proprietaire> Prop = new JComboBox<Proprietaire>();
			ArrayList<Proprietaire> prop = propridao.getAll();
		      for(int i=0;i<prop.size();i++) {
		    	  tcomboBoxid_proprietaire.addItem(prop.get(i));
		    }
			
		      
		      ArrayList<Agence> agen = agedao.getAll();
		      for(int i=0;i<agen.size();i++) {
		    	  tcomboBoxid_agence.addItem(agen.get(i));
		    }
		      
		      ArrayList<Logement> loge = logedao.getAll();
		      for(int i=0;i<loge.size();i++) {
		    	  tcomboBoxid_Logement.addItem(loge.get(i));
		    }
			
			JPanel panel_1 = new JPanel();
			
			
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
			
			JLabel lblNewLabel = new JLabel("Ajouter un contrat");
			lblNewLabel.setBounds(247, 22, 227, 31);
			lblNewLabel.setForeground(Color.WHITE);
			panel_2.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Contrat_add.class.getResource("/res/contract2.png")));
			lblNewLabel_4.setBounds(54, 0, 77, 66);
			panel_2.add(lblNewLabel_4);
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(tnumero.getText().equals("") || tdateC.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Veuillez remplir les données","ERREUR de SAISI",JOptionPane.ERROR_MESSAGE); 
					}else {
				
						int numero = Integer.parseInt(tnumero.getText());
						String dateC = tdateC.getText();
					
						Locataire loca =(Locataire)tcomboBoxid_locataire.getSelectedItem();
						int id_Locataire = loca.getId();
						Proprietaire prop =(Proprietaire)tcomboBoxid_proprietaire.getSelectedItem();
						int id_Proprietaire = prop.getId();
						
										
						Agence age =(Agence)tcomboBoxid_agence.getSelectedItem();
						int id_Agence = age.getId();
						
						Logement log =(Logement)tcomboBoxid_Logement.getSelectedItem();
						int id_Logement = log.getId();
						
						Contrat contr = new Contrat(numero,dateC,id_Locataire,id_Proprietaire,id_Agence,id_Logement);
						System.out.print(contr);
						contrdao.save(contr);
						
						
					
						tnumero.setText("");
						tdateC.setText("");
						
						tnumero.requestFocus();
						
						Contrat_liste2.remp();
						JOptionPane.showMessageDialog(null, "le contrat a bien été ajouté");
					
					}
				}
			});
			
		}

		public Window getFrame() {
			// TODO Auto-generated method stub
			return frame;
		}
	}

	