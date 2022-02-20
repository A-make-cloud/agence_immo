package vues;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;

import DAO.AgenceDAO;
import DAO.EmployeDAO;
import DAO.LitigeDAO;
import DAO.ReparationDAO;
import entites.Agence;
import entites.Database;
import entites.Employe;
import entites.Litige;
import entites.Reparation;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Reparation_add {

	private JFrame frame;
	private JTextField tnumero;
	private JTextField tprix;

	private JTextField ttype;
	private JTextField tdateR;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reparation_add window = new Reparation_add();
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
	public Reparation_add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 918, 585);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Numero");
		lblNewLabel_1.setBounds(257, 177, 75, 17);
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_1);
		
		ttype = new JTextField();
		ttype.setBounds(376, 113, 229, 20);
		ttype.setColumns(10);
		frame.getContentPane().add(ttype);
		
		tnumero = new JTextField();
		tnumero.setBounds(376, 177, 229, 20);
		tnumero.setColumns(10);
		frame.getContentPane().add(tnumero);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prix");
		lblNewLabel_1_1.setBounds(257, 225, 75, 17);
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		tprix = new JTextField();
		tprix.setBounds(376, 225, 229, 20);
		tprix.setColumns(10);
		frame.getContentPane().add(tprix);
		
		JLabel lblNewLabel_1_2 = new JLabel("DateR");
		lblNewLabel_1_2.setBounds(257, 284, 75, 17);
		lblNewLabel_1_2.setForeground(Color.GRAY);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_1_2);
		
		
		
		JLabel lblNewLabel_1_3 = new JLabel("Id_Litige");
		lblNewLabel_1_3.setBounds(257, 348, 75, 17);
		lblNewLabel_1_3.setForeground(Color.GRAY);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_1_3);
		
		Database.Connect();
		final ReparationDAO repardao = new ReparationDAO();
		LitigeDAO litidao = new LitigeDAO();
		
		
		final JComboBox tcomboBoxid_Litige = new JComboBox();
		tcomboBoxid_Litige.setBounds(376, 347, 229, 22);
		frame.getContentPane().add(tcomboBoxid_Litige);
		
		ArrayList<Litige> liti = litidao.getAll();
	      for(int i=0;i<liti.size();i++) {
	    	  tcomboBoxid_Litige.addItem(liti.get(i));
	    }
		
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ttype.getText().equals("")|| tnumero.getText().equals("")|| tprix.getText().equals("")|| tdateR.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veuillez remplir les données","ERREUR de SAISI",JOptionPane.ERROR_MESSAGE); 
				}else {
					String type = ttype.getText();
					int numero = Integer.parseInt(tnumero.getText());
					float prix = Float.parseFloat(tprix.getText());
					String dateR = tdateR.getText();
				
					Litige liti =(Litige)tcomboBoxid_Litige.getSelectedItem();
					int id_Litige = liti.getId();
			
					Reparation r = new Reparation(type,numero,prix,dateR,id_Litige);
					System.out.print(r);
					repardao.save(r);
					Reparation_liste.remp();
				}
				
				
			}
		});
		panel.setBounds(376, 413, 229, 39);
		panel.setBackground(new Color(230, 146, 34));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Ajouter");
		lblNewLabel_2.setBounds(82, 11, 57, 14);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Reparation_add.class.getResource("/res/pen.png")));
		lblNewLabel.setBounds(161, 6, 46, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_4 = new JLabel("Type");
		lblNewLabel_1_4.setBounds(257, 113, 75, 17);
		lblNewLabel_1_4.setForeground(Color.GRAY);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.getContentPane().add(lblNewLabel_1_4);
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(242, 90, 405, 386);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		tdateR = new JTextField();
		tdateR.setColumns(10);
		tdateR.setBounds(134, 189, 229, 20);
		panel_1.add(tdateR);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(197, 11, 500, 503);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblAjouterUneRparation = new JLabel("Ajouter une r\u00E9paration");
		lblAjouterUneRparation.setBounds(170, 32, 250, 31);
		panel_2.add(lblAjouterUneRparation);
		lblAjouterUneRparation.setForeground(Color.WHITE);
		lblAjouterUneRparation.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Reparation_add.class.getResource("/res/repairs2.png")));
		lblNewLabel_3.setBounds(63, 11, 60, 52);
		panel_2.add(lblNewLabel_3);
	}

	public Window getFrame() {
		// TODO Auto-generated method stub
		return frame;
	}
}
