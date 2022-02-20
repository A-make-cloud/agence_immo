package vues;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import DAO.AgenceDAO;
import DAO.UserDAO;
import entites.Agence;
import entites.Database;
import entites.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JSeparator;

public class tableau_bord {

	private JFrame frameTableauBord;
	protected JLabel tidentifiant;
	protected JLabel tmotdepasse;
	protected Window frame;
	protected JTable table;
	private String username;
	private JLabel tval;
	
	public static JLabel lbl_welcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					tableau_bord window = new tableau_bord();
					window.frameTableauBord.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tableau_bord() {
		initialize();
	}
	public tableau_bord(String username) {
		this.username=username;
		initialize();
		tval.setText(username);
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @param identifiant 
	 */
	private void initialize() {
		
		frameTableauBord = new JFrame();
		frameTableauBord.setBounds(100, 100, 825, 554);
		frameTableauBord.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTableauBord.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(85, 11, 645, 114);
		panel.setBackground(Color.LIGHT_GRAY);
		frameTableauBord.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(93, 11, 228, 103);
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(tableau_bord.class.getResource("/res/chevron-up.png")).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
		panel.setLayout(null);
		panel.setLayout(null);
		lblNewLabel.setIcon(imageIcon2);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Gestion");
		lblNewLabel_1.setBounds(10, 33, 114, 31);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Immo");
		lblNewLabel_1_1.setBounds(303, 33, 91, 31);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel_1_1);
		
		JPanel panel_9 = new JPanel();

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/user3.png")));
		lblNewLabel_2.setBounds(10, 11, 40, 50);
		panel_9.add(lblNewLabel_2);
		
		
		tval = new JLabel("");
		tval.setForeground(new Color(255, 0, 0));
		tval.setFont(new Font("Dialog", Font.BOLD, 20));
		tval.setBounds(60, 11, 89, 44);
		panel_9.add(tval);
		
	   ;
	    
	
		tval.setText("");
		tval.requestFocus();
	
		panel_9.setBounds(486, 37, 149, 66);
		panel_9.setBackground(Color.LIGHT_GRAY);
		panel.add(panel_9);
		panel_9.setLayout(null);
		
		
	
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(85, 125, 107, 330);
		panel_1.setBackground(Color.LIGHT_GRAY);
		frameTableauBord.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_7_2 = new JLabel("Biens vari\u00E9s");
		lblNewLabel_7_2.setBounds(14, 25, 97, 14);
		lblNewLabel_7_2.setForeground(Color.WHITE);
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_7_2);
		
		final JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 63, 87, 87);
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		final JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/room3.png")));
		lblNewLabel_3.setBounds(20, 11, 55, 57);
		panel_4.add(lblNewLabel_3);
		panel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Logement_liste lo= new Logement_liste();
				lo.getFrameListeLogement().setVisible(true);
				frameTableauBord.dispose();
				
			
			}
			
			public void mouseEntered(MouseEvent e) {
				panel_4.setBackground(new Color(235,145,66));
				lblNewLabel_3.setForeground(Color.black);
			}
			
			public void mouseExited(MouseEvent e) {
				panel_4.setBackground(Color.LIGHT_GRAY);
				lblNewLabel_3.setForeground(Color.white);
			}
		});
		
		
		JLabel lblNewLabel_8 = new JLabel("Logement");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(20, 62, 63, 14);
		panel_4.add(lblNewLabel_8);
		
		final JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(14, 194, 83, 84);
		panel_1.add(panel_5);
		panel_5.setLayout(null);
		
		final JLabel lblNewLabel_9 = new JLabel("Cat\u00E9gorie");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(18, 61, 55, 14);
		panel_5.add(lblNewLabel_9);
		final JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/house2.png")));
		lblNewLabel_4.setBounds(18, 0, 55, 50);
		panel_5.add(lblNewLabel_4);
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Categorie_liste ca= new Categorie_liste();
				ca.getFrameListeCategorie().setVisible(true);
				frameTableauBord.dispose();
			}
			
			public void mouseEntered(MouseEvent e) {
				panel_5.setBackground(new Color(235,145,66));
				lblNewLabel_9.setForeground(Color.black);
			}
			
			public void mouseExited(MouseEvent e) {
				panel_5.setBackground(Color.LIGHT_GRAY);
				lblNewLabel_4.setForeground(Color.white);
			}
		});
		
		
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(14, 161, 86, 2);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(14, 289, 86, 2);
		panel_1.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(11, 50, 86, 2);
		panel_1.add(separator_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(10, 50, 86, 2);
		panel_1.add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setBounds(10, 12, 86, 2);
		panel_1.add(separator_1_3);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(371, 125, 120, 330);
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		frameTableauBord.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_7_1 = new JLabel("Accompagnement");
		lblNewLabel_7_1.setBounds(4, 22, 120, 22);
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1_1.add(lblNewLabel_7_1);
		
		final JPanel panel_6 = new JPanel();
		panel_6.setBounds(27, 58, 83, 81);
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_1_1.add(panel_6);
		panel_6.setLayout(null);
		
		final JLabel lblNewLabel_8_1_1_1_1 = new JLabel("Proprietaire");
		lblNewLabel_8_1_1_1_1.setBounds(8, 61, 75, 14);
		lblNewLabel_8_1_1_1_1.setForeground(Color.WHITE);
		panel_6.add(lblNewLabel_8_1_1_1_1);
		panel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Proprietaire_liste p= new Proprietaire_liste();
				p.getFrameListeProprietaire().setVisible(true);
				frameTableauBord.dispose();
			}
		
			public void mouseEntered(MouseEvent e) {
				panel_6.setBackground(new Color(235,145,66));
				lblNewLabel_8_1_1_1_1.setForeground(Color.black);
			}
			
			public void mouseExited(MouseEvent e) {
				panel_6.setBackground(Color.LIGHT_GRAY);
				lblNewLabel_8_1_1_1_1.setForeground(Color.white);
			}
		});
	
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(8, 0, 58, 60);
		lblNewLabel_3_1.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/agile.png")));
		panel_6.add(lblNewLabel_3_1);
		
		final JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(27, 190, 72, 74);
		panel_1_1.add(panel_7);
		panel_7.setLayout(null);
		
		final JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/keys-holder.png")));
		lblNewLabel_4_1.setBounds(8, 11, 54, 50);
		panel_7.add(lblNewLabel_4_1);
		panel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Locataire_liste lo =new Locataire_liste();
				lo.getFrameListeLocataire().setVisible(true);
				frameTableauBord.dispose();
			}
			
			public void mouseEntered(MouseEvent e) {
				panel_7.setBackground(new Color(235,145,66));
				lblNewLabel_4_1.setForeground(Color.black);
			}
			
			public void mouseExited(MouseEvent e) {
				panel_7.setBackground(Color.LIGHT_GRAY);
				lblNewLabel_4_1.setForeground(Color.white);
				
			}
		});
	
		
		JLabel lblNewLabel_8_1_1_1 = new JLabel("Locataire");
		lblNewLabel_8_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_1_1_1.setBounds(8, 58, 63, 14);
		panel_7.add(lblNewLabel_8_1_1_1);
		
		JSeparator separator_1_3_1 = new JSeparator();
		separator_1_3_1.setBounds(27, 12, 86, 2);
		panel_1_1.add(separator_1_3_1);
		
		JSeparator separator_1_3_2 = new JSeparator();
		separator_1_3_2.setBounds(27, 150, 86, 2);
		panel_1_1.add(separator_1_3_2);
		
		JSeparator separator_1_3_3 = new JSeparator();
		separator_1_3_3.setBounds(10, 279, 86, 2);
		panel_1_1.add(separator_1_3_3);
		
		JSeparator separator_1_3_7_2 = new JSeparator();
		separator_1_3_7_2.setBounds(24, 50, 86, 2);
		panel_1_1.add(separator_1_3_7_2);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBounds(610, 125, 120, 330);
		panel_1_1_1.setBackground(Color.LIGHT_GRAY);
		frameTableauBord.getContentPane().add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Experts Locaux");
		lblNewLabel_7.setBounds(6, 22, 97, 14);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(Color.WHITE);
		panel_1_1_1.add(lblNewLabel_7);
		
		final JPanel panel_8 = new JPanel();
		panel_8.setBounds(21, 50, 69, 70);
		panel_8.setBackground(Color.LIGHT_GRAY);
		panel_1_1_1.add(panel_8);
		panel_8.setLayout(null);
		
		final JLabel lblNewLabel_8_1 = new JLabel("Contrat");
		lblNewLabel_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_1.setBounds(10, 56, 49, 14);
		panel_8.add(lblNewLabel_8_1);
		panel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Contrat_liste cl = new Contrat_liste();
				cl.getFrameListeContrat().setVisible(true);
				frameTableauBord.dispose();
			}
			
			public void mouseEntered(MouseEvent e) {
				panel_8.setBackground(new Color(235,145,66));
				lblNewLabel_8_1.setForeground(Color.black);
			}
			public void mouseExited(MouseEvent e) {
				panel_8.setBackground(Color.LIGHT_GRAY);
				lblNewLabel_8_1.setForeground(Color.white);
			}
		});
	
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/contract2.png")));
		lblNewLabel_3_1_1.setBounds(10, 0, 49, 50);
		panel_8.add(lblNewLabel_3_1_1);
		
		final JPanel panel_8_1 = new JPanel();
		panel_8_1.setBounds(21, 140, 69, 70);
		panel_8_1.setLayout(null);
		panel_8_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1_1.add(panel_8_1);
		
		final JLabel lblNewLabel_8_1_1 = new JLabel("R\u00E9paration");
		lblNewLabel_8_1_1.setForeground(Color.WHITE);
		lblNewLabel_8_1_1.setBounds(2, 56, 65, 14);
		panel_8_1.add(lblNewLabel_8_1_1);
		panel_8_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Reparation_liste r= new Reparation_liste();
				r.getFrameListeReparation().setVisible(true);
				frameTableauBord.dispose();
			}
			
			public void mouseEntered(MouseEvent e) {
				panel_8_1.setBackground(new Color(235,145,66));
				lblNewLabel_8_1_1.setForeground(Color.black);
			}
			
			public void mouseExited(MouseEvent e) {
				panel_8_1.setBackground(Color.LIGHT_GRAY);
				lblNewLabel_8_1_1.setForeground(Color.white);
			}
		});
	
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("");
		lblNewLabel_3_1_1_1.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/repairs2.png")));
		lblNewLabel_3_1_1_1.setBounds(0, 0, 59, 50);
		panel_8_1.add(lblNewLabel_3_1_1_1);
		
		final JPanel panel_8_2 = new JPanel();
		panel_8_2.setLayout(null);
		panel_8_2.setBackground(Color.LIGHT_GRAY);
		panel_8_2.setBounds(21, 225, 69, 70);
		panel_1_1_1.add(panel_8_2);
		
		final JLabel lblNewLabel_8_1_2 = new JLabel("Litige");
		lblNewLabel_8_1_2.setForeground(Color.WHITE);
		lblNewLabel_8_1_2.setBounds(21, 56, 38, 14);
		panel_8_2.add(lblNewLabel_8_1_2);
		panel_8_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Litige_liste li= new Litige_liste();
				li.getFrameListeLitige().setVisible(true);
				frameTableauBord.dispose();
			}
			
			public void mouseEntered(MouseEvent e) {
				panel_8_2.setBackground(new Color(235,145,66));
				lblNewLabel_8_1_2.setForeground(Color.black);
			}
			
			public void mouseExited(MouseEvent e) {
				panel_8_2.setBackground(Color.LIGHT_GRAY);
				lblNewLabel_8_1_2.setForeground(Color.white);
			}
		});
	
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("");
		lblNewLabel_3_1_1_2.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/law.png")));
		lblNewLabel_3_1_1_2.setBounds(0, 0, 69, 50);
		panel_8_2.add(lblNewLabel_3_1_1_2);
		
		JSeparator separator_1_3_4 = new JSeparator();
		separator_1_3_4.setBounds(17, 306, 86, 2);
		panel_1_1_1.add(separator_1_3_4);
		
		JSeparator separator_1_3_5 = new JSeparator();
		separator_1_3_5.setBounds(6, 212, 86, 2);
		panel_1_1_1.add(separator_1_3_5);
		
		JSeparator separator_1_3_6 = new JSeparator();
		separator_1_3_6.setBounds(6, 131, 86, 2);
		panel_1_1_1.add(separator_1_3_6);
		
		JSeparator separator_1_3_7 = new JSeparator();
		separator_1_3_7.setBounds(17, 12, 86, 2);
		panel_1_1_1.add(separator_1_3_7);
		
		JSeparator separator_1_3_7_1 = new JSeparator();
		separator_1_3_7_1.setBounds(16, 44, 86, 2);
		panel_1_1_1.add(separator_1_3_7_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(85, 454, 645, 50);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.LIGHT_GRAY);
		frameTableauBord.getContentPane().add(panel_2);
		
		final JPanel panel_3 = new JPanel();
		panel_3.setBounds(242, 136, 82, 93);
		frameTableauBord.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		final JLabel lblNewLabel_10 = new JLabel("Agence");
		lblNewLabel_10.setBounds(20, 68, 46, 14);
		panel_3.add(lblNewLabel_10);
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Agence_Liste w = new Agence_Liste();
				w.getFrameListeAgence().setVisible(true);
				frameTableauBord.dispose();
			
				

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3.setBackground(new Color(235,145,66));
				lblNewLabel_10.setForeground(Color.white);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3.setBackground(new Color(240,240,240));
				lblNewLabel_10.setForeground(Color.black);
			}
		});
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/agency.png")));
		lblNewLabel_5.setBounds(10, 0, 62, 64);
		panel_3.add(lblNewLabel_5);
		
		final JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(242, 248, 82, 82);
		frameTableauBord.getContentPane().add(panel_3_1);
		panel_3_1.setLayout(null);
		
		final JLabel lblNewLabel_10_1 = new JLabel("Employ\u00E9");
		lblNewLabel_10_1.setBounds(13, 60, 52, 14);
		panel_3_1.add(lblNewLabel_10_1);
		panel_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Employe_liste em=new Employe_liste();
				em.getFrameListeEmploye().setVisible(true);
				frameTableauBord.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_3_1.setBackground(new Color(235,145,66));
				lblNewLabel_10_1.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_3_1.setBackground(new Color(240,240,240));
				lblNewLabel_10_1.setForeground(Color.black);
			}
		});

		
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		lblNewLabel_5_1.setBounds(10, 0, 56, 61);
		lblNewLabel_5_1.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/female.png")));
		panel_3_1.add(lblNewLabel_5_1);
		
		final JPanel panel_3_2 = new JPanel();
		
		panel_3_2.setBounds(242, 351, 82, 82);
		panel_3_2.setLayout(null);
		frameTableauBord.getContentPane().add(panel_3_2);
		
		final JLabel lblNewLabel_10_2 = new JLabel("Technicien");
		lblNewLabel_10_2.setBounds(10, 69, 62, 12);
		panel_3_2.add(lblNewLabel_10_2);
		panel_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Technicien_liste te = new Technicien_liste();
				te.getFrameListeTechnicien().setVisible(true);
				frameTableauBord.dispose();
			}
		
			public void mouseEntered(MouseEvent e) {
				panel_3_2.setBackground(new Color(235,145,66));
				lblNewLabel_10_2.setForeground(Color.white);
			}
	
			public void mouseExited(MouseEvent e) {
				panel_3_2.setBackground(new Color(240,240,240));
				lblNewLabel_10_2.setForeground(Color.black);
			}
		});
		
		
		JLabel lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/person-mechanic.png")));
		lblNewLabel_5_2.setBounds(10, 0, 48, 67);
		panel_3_2.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(511, 133, 70, 96);
		lblNewLabel_11.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/chevron-left.png")));
		frameTableauBord.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(488, 187, 75, 96);
		lblNewLabel_12.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/chevron-right.png")));
		frameTableauBord.getContentPane().add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setBounds(511, 256, 70, 82);
		lblNewLabel_13.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/chevron-left.png")));
		frameTableauBord.getContentPane().add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(488, 317, 75, 85);
		lblNewLabel_14.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/chevron-right.png")));
		frameTableauBord.getContentPane().add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setBounds(521, 373, 70, 70);
		lblNewLabel_15.setIcon(new ImageIcon(tableau_bord.class.getResource("/res/chevron-left.png")));
		frameTableauBord.getContentPane().add(lblNewLabel_15);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(491, 125, 120, 329);
		frameTableauBord.getContentPane().add(panel_11);
		
		
		
	}

	public Window getFrameTableauBord() {
		
		return frameTableauBord;
	}
	
	public void setFrame(JFrame frame) {
		this.frameTableauBord = frame;
	}

	public void setTitle(String string) {
	
		
	}

	public void setVisible(boolean b) {
		
		
	}
	
    private JPanel espacePerso(){
    	JPanel panel = new JPanel();
    	panel.setLayout(new FlowLayout());
     
    	JLabel lbl_welcome = new JLabel("Bienvenue "+ tidentifiant);
     
    	lbl_welcome.add(lbl_welcome);
     
    	return panel;
    }
}
