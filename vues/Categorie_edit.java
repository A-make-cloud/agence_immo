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
import DAO.CategorieDAO;
import entites.Categorie;
import entites.Database;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Categorie_edit {

	private JFrame frame;
	private JTextField ttype;
	private Categorie categorie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categorie_edit window = new Categorie_edit();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param cate 
	 */
	public Categorie_edit() {
		initialize();
		
	}
	public Categorie_edit(Categorie cate) {
		initialize();
		this.categorie=cate;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 834, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(189, 70, 488, 235);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setForeground(Color.GRAY);
		lblNewLabel_1.setBounds(64, 51, 35, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblNewLabel_1);
		
		ttype = new JTextField();
		ttype.setBounds(146, 47, 229, 30);
		panel.add(ttype);
		ttype.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Database.Connect();
				CategorieDAO catedao=new CategorieDAO();
				
				String type=ttype.getText();
				
				categorie.setType(type);
				
				catedao.save(categorie);
				ttype.setText("");
			
				ttype.requestFocus();
				JOptionPane.showMessageDialog(null, "La catégorie a bien été modifiée");
				Categorie_liste.remp();
			}
		});
		panel_1.setBackground(new Color(230, 126, 34));
		panel_1.setBounds(146, 126, 229, 30);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Modifier");
		lblNewLabel_3.setBounds(91, 5, 46, 17);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Categorie_edit.class.getResource("/res/change2.png")));
		lblNewLabel_5.setBounds(173, 5, 46, 22);
		panel_1.add(lblNewLabel_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(124, 11, 616, 354);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 11, 51, 44);
		lblNewLabel_2.setIcon(new ImageIcon(Categorie_edit.class.getResource("/res/appartement.png")));
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Categorie_edit.class.getResource("/res/room.png")));
		lblNewLabel_4.setBounds(555, 11, 51, 52);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Modifier une cat\u00E9gorie de logement");
		lblNewLabel.setBounds(105, 15, 415, 31);
		panel_2.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
	}

	public Window getFrame() {
		
		return frame;
	}

}
