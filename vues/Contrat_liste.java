package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import DAO.AgenceDAO;

import DAO.ContratDAO;
import DAO.LocataireDAO;
import DAO.LogementDAO;
import DAO.ProprietaireDAO;

import entites.Contrat;
import entites.Database;
import entites.Logement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Contrat_liste {

	private JFrame frameListeContrat;
	private static JTable table;
	private final JPanel panel_2 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contrat_liste window = new Contrat_liste();
					window.frameListeContrat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Contrat_liste() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameListeContrat = new JFrame();
		frameListeContrat.addWindowListener(new WindowAdapter() {
			private Window frameTableauBord;

			@Override
			public void windowClosing(WindowEvent e) {
				tableau_bord t = new tableau_bord();
				t.getFrameTableauBord().setVisible(true);
				frameTableauBord.dispose();
			}
		});
		frameListeContrat.setBackground(new Color(95, 158, 160));
		frameListeContrat.setBounds(100, 100, 874, 555);
		frameListeContrat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameListeContrat.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 92, 775, 347);
		frameListeContrat.getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		Database.Connect();
		final ContratDAO contrdao=new ContratDAO();
		
		 ArrayList<Contrat> cont = contrdao.getAll();
			 String columns[] = {"ID", "NUMERO", "DATEC", "ID_LOCATAIRE", "ID_PROPRIETAIRE", "ID_AGENCE", "ID_LOGEMENT"};
		      String data[][] = new String[cont.size()][columns.length];
		      
		      for(int i=0;i<cont.size();i++) {
		    	  data[i][0] = cont.get(i).getId()+"";
		    	  data[i][1] = cont.get(i).getNumero()+"";
			        data[i][2] = cont.get(i).getDateC();
			        data[i][3] = cont.get(i).getId_Locataire()+"";
			        data[i][4] = cont.get(i).getId_Proprietaire()+"";
			        data[i][5] = cont.get(i).getId_Agence()+"";
			        data[i][6] = cont.get(i).getId_Logement()+"";
			     
		      }
		      DefaultTableModel model = new DefaultTableModel(data, columns);
		      table = new JTable(model);
		      
				//table = new JTable();
				scrollPane.setViewportView(table);
				// DefaultTableModel model = new DefaultTableModel(data, columns);
			     
			      table = new JTable(model);
			  
				scrollPane.setViewportView(table);
			
		
		
		JPanel panel = new JPanel();
		panel.setBounds(36, 23, 775, 72);
		panel.setBackground(Color.LIGHT_GRAY);
		frameListeContrat.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblListeDesContrats = new JLabel("Liste des contrats");
		lblListeDesContrats.setBackground(new Color(95, 158, 160));
		lblListeDesContrats.setBounds(285, 21, 193, 31);
		lblListeDesContrats.setForeground(Color.WHITE);
		lblListeDesContrats.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblListeDesContrats);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(566, 11, 73, 63);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(578, 11, 78, 63);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(593, 16, 46, 52);
		lblNewLabel_2.setIcon(new ImageIcon(Contrat_liste.class.getResource("/res/menu.png")));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Contrat_liste.class.getResource("/res/accountant.png")));
		lblNewLabel_3.setBounds(75, 11, 63, 53);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					if(table.getSelectedRow()!=-1) {
					
					int test=table.getSelectedRow();
					int selectedId = Integer.parseInt(table.getModel().getValueAt(test, 0).toString());
						
					ContratDAO contrdao=new ContratDAO();
					Contrat cont=contrdao.getById(selectedId);
					
					
				
					new Contrat_edit(cont).getFrame().setVisible(true);
					
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Veuillez choisir une ligne ");
				}
				
			}
		});
		panel_1.setBounds(176, 450, 106, 27);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(230, 126, 34));
		frameListeContrat.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Modifier");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(10, 5, 46, 17);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Contrat_liste.class.getResource("/res/information2.png")));
		lblNewLabel_4.setBounds(80, 5, 16, 17);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(table.getSelectedRow()!=-1) {
					 int input = JOptionPane.showConfirmDialog(null, "voullez vous supprimer ?");
					 if(input==0) {
							int test=table.getSelectedRow();
							int selectedId = Integer.parseInt(table.getModel().getValueAt(test, 0).toString());
							contrdao.deleteById(selectedId);
							((DefaultTableModel)table.getModel()).removeRow(test);
							JOptionPane.showMessageDialog(null, "... a bien été supprimé ");
					 }
					
				}else {
					JOptionPane.showMessageDialog(null, "Veuillez choisir une ligne ");
				}
			}
		});
		panel_1_1.setBounds(566, 450, 106, 27);
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(230, 126, 34));
		frameListeContrat.getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Supprimer");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(10, 5, 63, 17);
		panel_1_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Contrat_liste.class.getResource("/res/unavailable.png")));
		lblNewLabel_5.setBounds(83, 5, 23, 17);
		panel_1_1.add(lblNewLabel_5);
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(10, 11, 848, 505);
		frameListeContrat.getContentPane().add(panel_2);
		

		
		     
	}
	
	public static void remp() {
		ContratDAO contrdao = new ContratDAO();
		LocataireDAO locadao = new LocataireDAO();
	  ProprietaireDAO propdao = new ProprietaireDAO();
	 AgenceDAO agendao = new AgenceDAO();
	  LogementDAO logedao = new LogementDAO();
	 
	 ArrayList<Contrat> contrList = contrdao.getAll();
     String columns[] = {  "ID", "NUMERO", "DATEC", "ID_LOCATAIRE", "ID_PROPRIETAIRE", "ID_AGENCE","ID_LOGEMENT"};
     String data[][] = new String[contrList.size()][columns.length];

     for(int i=0;i<contrList.size();i++) {
    	  	data[i][0] = contrList.get(i).getId()+"";
	        data[i][1] = contrList.get(i).getNumero()+"";
	        data[i][2] = contrList.get(i).getDateC();
	        data[i][3] = locadao.getById(contrList.get(i).getId_Locataire())+"";
	        data[i][4] = propdao.getById(contrList.get(i).getId_Proprietaire())+"";
	        data[i][5] = agendao.getById(contrList.get(i).getId_Agence())+"";
	        data[i][6] = logedao.getById(contrList.get(i).getId_Logement())+"";
      }
      
      DefaultTableModel model = new DefaultTableModel(data, columns);
      table.setModel(model);
      
	
}

	public Window getFrameListeContrat() {
		
		return frameListeContrat;
	}
}
