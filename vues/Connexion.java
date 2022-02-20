package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entites.User;
import DAO.UserDAO;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPasswordField;

public class Connexion {

	private JFrame frameConnexion;
	private JTextField tidentifiant;
	private JTextField tval;
	private final JPanel panel_3 = new JPanel();
	protected Window frame;
	private JPanel panel_2_1;
	public static JLabel lbl_welcome;
	JLabel lbl_userName;
	private JPasswordField tmotdepasse;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion window = new Connexion();
					window.frameConnexion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Connexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameConnexion = new JFrame();
		frameConnexion.setBounds(100, 100, 807, 669);
		frameConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameConnexion.getContentPane().setLayout(null);
		panel_3.setBackground(new Color(46,49,49));
		panel_3.setBounds(42, 25, 675, 595);
		frameConnexion.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3_1 = new JLabel("GESTION IMMO");
		lblNewLabel_3_1.setBounds(350, 172, 223, 31);
		lblNewLabel_3_1.setForeground(new Color(255, 2, 0));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_3.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3 = new JLabel("Se connecter \u00E0");
		lblNewLabel_3.setBounds(164, 174, 175, 31);
		lblNewLabel_3.setForeground(Color.WHITE);
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JPanel panel = new JPanel();
		panel.setBounds(143, 231, 437, 308);
		panel_3.add(panel);
		panel.setBackground(new Color(232, 236, 241));
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Identifiant");
		lblNewLabel_1.setBounds(42, 22, 80, 28);
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mot de passe");
		lblNewLabel_1_1.setBounds(42, 87, 98, 28);
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(lblNewLabel_1_1);
		
		tidentifiant = new JTextField();
		tidentifiant.setBounds(172, 28, 177, 20);
		panel.add(tidentifiant);
		tidentifiant.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(216, 226, 73, 52);
		panel.add(panel_2);
		panel_2.setBackground(new Color(230, 126, 34));
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Valider");
		lblNewLabel_2.setBounds(10, 0, 55, 50);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(Connexion.class.getResource("/res/process.png")));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		panel_2_1 = new JPanel();
		panel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
		
				 String identifiant = tidentifiant.getText();
                String password = tmotdepasse.getText();
       
               
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/agence",
                        "root", "");

                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select identifiant, password from user where identifiant=? and password=?");

                    st.setString(1, identifiant);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                   
                    if (rs.next()) {
                    	UserDAO user = new UserDAO();
                         user.setVisible(true);
                         
                        JOptionPane.showMessageDialog(null, "Vous êtes bien connecté");
                   
                    	tableau_bord t=new tableau_bord(identifiant);
        				t.getFrameTableauBord().setVisible(true);
        				frame.dispose();
        	
                    } else {
                        JOptionPane.showMessageDialog(null, "Mauvais Identifiant ou Mot de passe");
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }    	
			
			
			}
		});
		


		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(230, 126, 34));
		panel_2_1.setBounds(172, 148, 177, 28);
		panel.add(panel_2_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Valider");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(63, 0, 55, 28);
		panel_2_1.add(lblNewLabel_2_1);
		
		tmotdepasse = new JPasswordField();
		tmotdepasse.setBounds(172, 93, 177, 20);
		panel.add(tmotdepasse);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(34, 24, 149, 76);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBackground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Connexion.class.getResource("/res/chevron-up.png")));
		lblNewLabel.setBounds(29, 21, 91, 66);
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1_2 = new JLabel("Gestion");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(0, 7, 77, 31);
		panel_4.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Immo");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(92, 7, 63, 31);
		panel_4.add(lblNewLabel_1_1_1);
		
		JPanel tval_1 = new JPanel();
		tval_1.setBounds(475, 34, 149, 66);
		panel_3.add(tval_1);
		tval_1.setBackground(Color.LIGHT_GRAY);
		tval_1.setLayout(null);
		
		//lbl_welcome= new JLabel("Welcome "+userName);
		
		JLabel tva = new JLabel("Utilisateur");
		tva.setBounds(66, 16, 79, 31);
		tva.setForeground(Color.WHITE);
		tva.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tval_1.add(tva);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(10, 11, 46, 44);
		tval_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 11, 47, 48);
		tval_1.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(Connexion.class.getResource("/res/user3.png")));
	}

	public Window getFrameConnexion() {
	
		return frameConnexion;
	}
}
