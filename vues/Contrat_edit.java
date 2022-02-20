	package vues;

	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;

	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;
	import javax.swing.SwingConstants;


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

import javax.swing.JPanel;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.awt.Color;
	import javax.swing.ImageIcon;

	public class Contrat_edit {

			private JFrame frame;
		
			private JTextField tnumero;
			private JTextField tdateC;
			

			

			private Contrat contrat;

			

			private JComboBox tcomboBoxid_locataire;

			private JComboBox tcomboBoxid_agence;

			private JComboBox tcomboBoxid_logement;

			protected JComboBox tcomboBoxid_proprietaire;

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
							Contrat_edit window = new Contrat_edit();
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
			public Contrat_edit() {
				initialize();
			}
			
			public Contrat_edit(Contrat contr) {
				this.contrat=contr;
				initialize();
				
				}

	

		
			/**
			 * Initialize the contents of the frame.
			 */
			private void initialize() {
				Database.Connect();
				frame = new JFrame();
				frame.setBounds(100, 100, 808, 558);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().setLayout(null);
				
				//////////COMBOBOX////////////
				ProprietaireDAO propdao=new ProprietaireDAO();
				
				ArrayList<Proprietaire> propList = propdao.getAll();
				
				for(Proprietaire pro:propList) {
					tcomboBoxid_proprietaire.addItem(pro);
				}
				
				
				///////////////////////
				
				//////////COMBOBOX////////////
				LocataireDAO locdao=new LocataireDAO();
				
				ArrayList<Locataire> locList = locdao.getAll();
				
				for(Locataire lo:locList) {
					tcomboBoxid_locataire.addItem(lo);
				}
				
				
				///////////////////////
				
				//////////COMBOBOX////////////
				AgenceDAO agendao=new AgenceDAO();
				
				ArrayList<Agence> agenList = agendao.getAll();
				
				for(Agence ag:agenList) {
					tcomboBoxid_agence.addItem(ag);
				}
				
				
				///////////////////////
				
				//////////COMBOBOX////////////
				LogementDAO logedao=new LogementDAO();
				
				ArrayList<Logement> logList = logedao.getAll();
				
				for(Logement log:logList) {
					tcomboBoxid_logement.addItem(log);
				}
				tdateC.setText(this.contrat.getDateC());
				
				
				
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(Color.LIGHT_GRAY);
				panel_2.setBounds(72, 11, 512, 450);
				frame.getContentPane().add(panel_2);
				panel_2.setLayout(null);
				
				JLabel lblNewLabel_1 = new JLabel("Modifier un employe");
				lblNewLabel_1.setBounds(119, 33, 277, 38);
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
				panel_2.add(lblNewLabel_1);
				
				JLabel lblNewLabel_5 = new JLabel("New label");
				lblNewLabel_5.setIcon(new ImageIcon(Contrat_edit.class.getResource("/res/employee.png")));
				lblNewLabel_5.setBounds(42, 11, 67, 73);
				panel_2.add(lblNewLabel_5);
				
				JLabel lblNewLabel_6 = new JLabel("New label");
				lblNewLabel_6.setIcon(new ImageIcon(Contrat_edit.class.getResource("/res/transfer.png")));
				lblNewLabel_6.setBounds(406, 24, 67, 58);
				panel_2.add(lblNewLabel_6);
				
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(52, 82, 438, 314);
				panel_2.add(panel_1);
				panel_1.setLayout(null);
				
				final JComboBox tcomboBoxid_logement = new JComboBox();
				tcomboBoxid_logement.setBounds(158, 210, 204, 22);
				panel_1.add(tcomboBoxid_logement);
				
				final JComboBox tcomboBoxid_locataire = new JComboBox();
				tcomboBoxid_locataire.setBounds(158, 93, 204, 22);
				panel_1.add(tcomboBoxid_locataire);
				JComboBox tcomboBox_proprietaire = new JComboBox();
				tcomboBox_proprietaire.setBounds(158, 126, 204, 22);
				panel_1.add(tcomboBox_proprietaire);
			
				
				JLabel lblNewLabel_3 = new JLabel("DateC");
				lblNewLabel_3.setBounds(37, 55, 82, 29);
				panel_1.add(lblNewLabel_3);
				lblNewLabel_3.setForeground(Color.GRAY);
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
				tdateC = new JTextField();
				tdateC.setBounds(158, 59, 204, 20);
				panel_1.add(tdateC);
				tdateC.setColumns(10);
				tdateC.setText(this.contrat.getDateC());
				
				JLabel lblNewLabel_3_1_1 = new JLabel("Id_Locataire");
				lblNewLabel_3_1_1.setForeground(Color.GRAY);
				lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_3_1_1.setBounds(37, 90, 82, 29);
				panel_1.add(lblNewLabel_3_1_1);
				
				
				
				JLabel lblNewLabel_3_1_2 = new JLabel("Id_Proprietaire");
				lblNewLabel_3_1_2.setForeground(Color.GRAY);
				lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_3_1_2.setBounds(37, 125, 94, 29);
				panel_1.add(lblNewLabel_3_1_2);
				
			
				
				JLabel lblNewLabel_3_1_3 = new JLabel("Id_Logement");
				lblNewLabel_3_1_3.setForeground(Color.GRAY);
				lblNewLabel_3_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_3_1_3.setBounds(37, 207, 82, 29);
				panel_1.add(lblNewLabel_3_1_3);
				
				JLabel lblNewLabel_3_1_2_1 = new JLabel("Id_Agence");
				lblNewLabel_3_1_2_1.setForeground(Color.GRAY);
				lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_3_1_2_1.setBounds(37, 161, 94, 29);
				panel_1.add(lblNewLabel_3_1_2_1);
				
				final JComboBox tcomboBoxid_agence = new JComboBox();
				tcomboBoxid_agence.setBounds(158, 164, 204, 22);
				panel_1.add(tcomboBoxid_agence);
				
				JLabel lblNewLabel = new JLabel("Numero");
				lblNewLabel.setBounds(37, 27, 82, 14);
				panel_1.add(lblNewLabel);
				lblNewLabel.setForeground(Color.GRAY);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
					
						
						tnumero = new JTextField();
						tnumero.setBounds(158, 24, 204, 20);
						panel_1.add(tnumero);
						tnumero.setColumns(10);
						
						
						///////////////////////
						
						tnumero.setText(this.contrat.getNumero()+"");
						
							
							JPanel panel = new JPanel();
							panel.setBounds(158, 265, 207, 38);
							panel_1.add(panel);
							panel.setBackground(new Color(230, 126, 34));
							panel.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									int numero =Integer.parseInt(tnumero.getText());
									
									String dateC = tdateC.getText();
								
									Locataire loc= (Locataire)tcomboBoxid_locataire.getSelectedItem();
									int locataire=loc.getId();
									
									Proprietaire prop= (Proprietaire)tcomboBoxid_proprietaire.getSelectedItem();
									int proprietaire= prop.getId();
									
									Agence ag= (Agence)tcomboBoxid_agence.getSelectedItem();
									int agence=ag.getId();
									
									Logement loge= (Logement)tcomboBoxid_logement.getSelectedItem();
									int logement=loge.getId();
									
									contrat.setId_Locataire(locataire);
									contrat.setId_Proprietaire(proprietaire);
									contrat.setId_Agence(agence);
									contrat.setId_Logement(logement);
									contrat.setNumero(numero);
									contrat.setDateC(dateC);
									
									
									ContratDAO ctrdao=new ContratDAO();
									ctrdao.save(contrat);
									Contrat_liste2.remp();
									JOptionPane.showMessageDialog(null, "Le contrat a bien été modifié");
									
								}
							});
							panel.setLayout(null);
							
							JLabel lblNewLabel_4 = new JLabel("Modifier");
							lblNewLabel_4.setForeground(Color.WHITE);
							lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
							lblNewLabel_4.setBounds(69, 11, 93, 16);
							panel.add(lblNewLabel_4);
							
							
		
				
				Proprietaire prop=propdao.getById(this.contrat.getId_Proprietaire());
				Locataire loc=locdao.getById(this.contrat.getId_Locataire());
				Agence ag=agendao.getById(this.contrat.getId_Agence());
				Logement log=logedao.getById(this.contrat.getId_Logement());
			}
		}

