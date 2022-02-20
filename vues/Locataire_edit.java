package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.AgenceDAO;
import DAO.LocataireDAO;
import entites.Database;
import entites.Locataire;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import com.toedter.calendar.JDateChooser;

public class Locataire_edit {

	private JFrame frame;
	private JTextField tnom;
	private JTextField tprenom;
	private JTextField tage;
	private Locataire locataire;
	protected JDateChooser tdate_naissance;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Locataire_edit window = new Locataire_edit();
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
	public Locataire_edit() {
		initialize();
	}
	public Locataire_edit(Locataire loc) {
		initialize();
		this.locataire=loc;
	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 543);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(144, 38, 576, 456);
		panel_2.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(45, 86, 488, 335);
		panel_2.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(64, 51, 35, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		tnom = new JTextField();
		tnom.setBounds(146, 47, 229, 30);
		panel.add(tnom);
		tnom.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Database.Connect();
				LocataireDAO locadao=new LocataireDAO();
				
				String nom=tnom.getText();
				String prenom=tprenom.getText();
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date now = new Date(0);
				//String date_naissance= sdf.format(tdate.getDate());
				//String date_entree= ((JTextField) tdate_naissance.getDateEditor().getUiComponent()).getText();
				String date_naissance= sdf.format(tdate_naissance.getDate());
				//Date date_naissance= tdate.getDateEditor()+"";
				int age=Integer.parseInt(tage.getText());
				locataire.setNom(nom);
				locataire.setPrenom(prenom);
				locataire.setAge(age);
				locadao.save(locataire);
				tnom.setText("");
				tprenom.setText("");
				tage.setText("");
				//tnom.requestFocus();
				JOptionPane.showMessageDialog(null, "Le locataire a bien été modifiée");
				Locataire_liste.remp();
			}
		});
		panel_1.setBounds(146, 294, 229, 30);
		panel_1.setBackground(new Color(230, 126, 34));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Modifier");
		lblNewLabel_3.setBounds(91, 5, 46, 17);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Locataire_edit.class.getResource("/res/change2.png")));
		lblNewLabel_5.setBounds(173, 5, 46, 25);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenom");
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setBounds(64, 109, 58, 19);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1_1);
		
		tprenom = new JTextField();
		tprenom.setBounds(146, 105, 229, 30);
		tprenom.setColumns(10);
		panel.add(tprenom);
		
		JLabel lblNewLabel_1_2 = new JLabel("Age");
		lblNewLabel_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(64, 241, 35, 19);
		panel.add(lblNewLabel_1_2);
		
		tage = new JTextField();
		tage.setColumns(10);
		tage.setBounds(146, 237, 229, 30);
		panel.add(tage);
		/*
		JDateChooser tdate = new JDateChooser();
		//tdate.setDateFormatString("yyyy-MM-dd");
		tdate.setCalendar("yyyy-MM-dd");
		tdate.setBounds(152, 157, 217, 30);
		panel.add(tdate);
		*/
	
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Date de naissance");
		lblNewLabel_1_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(64, 173, 78, 14);
		panel.add(lblNewLabel_1_1_2);
		
		
	//	JPanel panel = new JPanel();
		
		JDateChooser chooser = new JDateChooser();
		chooser.setLocale(Locale.FRANCE);
		JDateChooser tdate_naissance = new JDateChooser();
		tdate_naissance.setBounds(148, 167, 227, 20);
		panel.add(new JLabel("Date of Birth:"));
		panel.add(tdate_naissance);
		
		JLabel lblNewLabel = new JLabel("Modifier un locataire");
		lblNewLabel.setBounds(173, 32, 253, 31);
		lblNewLabel.setForeground(Color.WHITE);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(44, 22, 61, 53);
		lblNewLabel_2.setIcon(new ImageIcon(Locataire_edit.class.getResource("/res/data_provider.png")));
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Locataire_edit.class.getResource("/res/keys.png")));
		lblNewLabel_4.setBounds(472, 22, 61, 53);
		panel_2.add(lblNewLabel_4);
	}

	public Window getFrame() {
		
		return frame;
	}
}
