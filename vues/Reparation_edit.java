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

import DAO.LitigeDAO;
import DAO.ReparationDAO;
import entites.Database;
import entites.Litige;
import entites.Reparation;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Reparation_edit{

		private JFrame frame;
	
	
		private Reparation reparation;
		private JTextField ttype;
		private JTextField tnumero;
		private JTextField tprix;
		private JTextField tdateR;


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
						Reparation_edit window = new Reparation_edit();
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
		public Reparation_edit() {
			initialize();
		}
		
		public Reparation_edit(Reparation rep) {
			this.reparation=rep;
			initialize();
			
			}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			Database.Connect();
			frame = new JFrame();
			frame.setBounds(100, 100, 940, 559);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Modifier un Reparation");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(122, 49, 553, 38);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 31));
			frame.getContentPane().add(lblNewLabel_1);
	
		
			
			final JComboBox tcomboBoxid_litige = new JComboBox();
			tcomboBoxid_litige.setBounds(347, 310, 204, 22);
			frame.getContentPane().add(tcomboBoxid_litige);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(240, 126, 34));
			panel.setBounds(347, 371, 207, 38);
			panel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					String type = ttype.getText();
					int numero=Integer.parseInt(tnumero.getText());
					float prix = Float.parseFloat(tprix.getText());
					String dateR = tdateR.getText();
					
					Litige pr= (Litige)tcomboBoxid_litige.getSelectedItem();
					int litige=pr.getId();
					
					reparation.setId_Litige(litige);
					reparation.setNumero(numero);
					reparation.setType(type);
					reparation.setPrix(prix);
					reparation.setDateR(dateR);
					
					ReparationDAO rdao=new ReparationDAO();
					rdao.save(reparation);
					
					JOptionPane.showMessageDialog(null, "Le Reparation a bien été modifié");
					Reparation_liste.remp();
					
				}
			});
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("Modifier");
			lblNewLabel_4.setBounds(69, 11, 93, 16);
			panel.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon(Reparation_edit.class.getResource("/res/change2.png")));
			lblNewLabel_5.setBounds(151, 0, 46, 38);
			panel.add(lblNewLabel_5);
			
			JLabel lblType = new JLabel("Type");
			lblType.setBounds(215, 146, 79, 20);
			lblType.setForeground(Color.GRAY);
			lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblType);
			
			JLabel lblNewLabel = new JLabel("Numero");
			lblNewLabel.setBounds(215, 185, 79, 14);
			lblNewLabel.setForeground(Color.GRAY);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_3_2 = new JLabel("Prix");
			lblNewLabel_3_2.setBounds(215, 226, 79, 29);
			lblNewLabel_3_2.setForeground(Color.GRAY);
			lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel_3_2);
			
			JLabel lblNewLabel_3 = new JLabel("DateR");
			lblNewLabel_3.setBounds(215, 266, 79, 29);
			lblNewLabel_3.setForeground(Color.GRAY);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel_3);
			
			JLabel lblNewLabel_2_3 = new JLabel("Id_Litige");
			lblNewLabel_2_3.setBounds(215, 310, 95, 18);
			lblNewLabel_2_3.setForeground(Color.GRAY);
			lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			frame.getContentPane().add(lblNewLabel_2_3);
			
			ttype = new JTextField();
			ttype.setBounds(347, 146, 204, 20);
			frame.getContentPane().add(ttype);
			ttype.setColumns(10);
			
			tnumero = new JTextField();
			tnumero.setBounds(347, 184, 204, 20);
			tnumero.setColumns(10);
			frame.getContentPane().add(tnumero);
			
			tprix = new JTextField();
			tprix.setBounds(347, 226, 204, 20);
			tprix.setColumns(10);
			frame.getContentPane().add(tprix);
			
			tdateR = new JTextField();
			tdateR.setBounds(347, 264, 204, 20);
			tdateR.setColumns(10);
			frame.getContentPane().add(tdateR);
			
			//////////COMBOBOX////////////
			LitigeDAO litidao=new LitigeDAO();
			
			ArrayList<Litige> litiList = litidao.getAll();
			
			for(Litige lit:litiList) {
				tcomboBoxid_litige.addItem(lit);
			}
			
			
			///////////////////////
			
			ttype.setText(this.reparation.getType());

			tnumero.setText(this.reparation.getNumero()+"");
			tprix.setText(this.reparation.getPrix()+"");

			tdateR.setText(this.reparation.getDateR());
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(173, 119, 477, 320);
			frame.getContentPane().add(panel_2);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBounds(132, 24, 557, 445);
			frame.getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(Reparation_edit.class.getResource("/res/work.png")));
			lblNewLabel_2.setBounds(20, 11, 72, 66);
			panel_1.add(lblNewLabel_2);
			
			JLabel lblNewLabel_2_1 = new JLabel("");
			lblNewLabel_2_1.setIcon(new ImageIcon(Reparation_edit.class.getResource("/res/person-mechanic.png")));
			lblNewLabel_2_1.setBounds(475, 11, 72, 66);
			panel_1.add(lblNewLabel_2_1);
			
			Litige lit=litidao.getById(this.reparation.getId_Litige());
		}
	}

