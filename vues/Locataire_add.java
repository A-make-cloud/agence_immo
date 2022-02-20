package vues;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.sql.Date;
import java.util.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import DAO.LocataireDAO;
import entites.Database;
import entites.Locataire;

public class Locataire_add {

	private JFrame frame;
	private JTextField tnom;
	private JTextField tprenom;
	private JTextField tage;
	protected JLabel tdate_naissance;
	protected JDateChooser tdate;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Locataire_add window = new Locataire_add();
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
	public Locataire_add() {
		initialize();
	}

	
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 867, 546);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBounds(222, 130, 440, 314);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("Nom");
			lblNewLabel_1.setForeground(Color.GRAY);
			lblNewLabel_1.setBounds(53, 47, 46, 14);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1);
			
			
			
			JLabel lblNewLabel_1_1 = new JLabel("Prenom");
			lblNewLabel_1_1.setForeground(Color.GRAY);
			lblNewLabel_1_1.setBounds(53, 98, 58, 14);
			lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel.add(lblNewLabel_1_1);
			
			JCalendar calendar = new JCalendar();        
			JLabel label = new JLabel("Select date of birth:");
			label.setLayout(new BorderLayout());
			label.add(calendar, BorderLayout.EAST);
			
			JPanel comboagence = new JPanel();
		
			comboagence.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
							Database.Connect();
							/*
							public static String getValidSqlDate( Date jxDate )
							{
								if( jxDate == null ) {
									return "0000-00-00";
								}
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");		 	
								return formatter.format( jxDate );
							}
						*/
							String nom=tnom.getText();
							String prenom=tprenom.getText();
							Date now = new Date();
							int age= Integer.parseInt(tage.getText());
							
							final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

							//String date_naissance= sdf.format(tdate.getDate());
							final String date_naissance= sdf.format(now);
							final String dc = date_naissance;
							
						
							LocataireDAO dao = new LocataireDAO();
						
							Locataire loc = new Locataire(nom,prenom,date_naissance,age);
							
							
							System.out.println(now);
							System.out.println(dc);
							dao.save(loc);
							
							tnom.setText("");
							tprenom.setText("");
							tage.setText("");
							tnom.requestFocus();
							
					
					JOptionPane.showMessageDialog(null, "Le locataire a bien été ajouté");
							Locataire_liste.remp();
							
					/*
					Database.Connect();
					AgenceDAO dao = new AgenceDAO();
					Agence a = new Agence(nom.getText());
					categoriedao.save(cat);
					titre.setText("");
					titre.requestFocus();
					JOptionPane.showMessageDialog(null, "La catégorie a bien été ajoutée");		
			*/
					
				}
				
			});
		
			

			comboagence.setBackground(new Color(230, 126, 34));
			comboagence.setBounds(141, 248, 217, 32);
			panel.add(comboagence);
			comboagence.setLayout(null);
			
			JLabel lblNewLabel_2 = new JLabel("Ajouter");
			lblNewLabel_2.setBounds(81, 9, 46, 14);
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboagence.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(Agence_add.class.getResource("/res/pen.png")));
			lblNewLabel_3.setBounds(161, 9, 46, 16);
			comboagence.add(lblNewLabel_3);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Age");
			lblNewLabel_1_1_1.setForeground(Color.GRAY);
			lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_1_1.setBounds(53, 193, 58, 19);
			panel.add(lblNewLabel_1_1_1);
			
			tnom = new JTextField();
			tnom.setColumns(10);
			tnom.setBounds(141, 46, 217, 20);
			panel.add(tnom);
			final JScrollPane scrollPane_locataire = new JScrollPane();
			scrollPane_locataire.setBounds(132, 127, 732, 430);
			frame.getContentPane().add(scrollPane_locataire);
			
			tprenom = new JTextField();
			tprenom.setColumns(10);
			tprenom.setBounds(141, 97, 217, 20);
			panel.add(tprenom);
			
			tage = new JTextField();
			
			tage.addMouseListener(new MouseAdapter() {
				
				public void mouseEntered(MouseEvent e) {
					/*
					int srow =scrollPane_locataire.getSelectedRow();
					Date date = new SimpleFormatDate("yyyy-MM-dd").parse((String).model.getValueAt(scrow,4));
					tdate.setDate(date);
					*/
					/*
					LocalDate today = LocalDate.now();
					LocalDate date_naissance= tdate.getDateEditor()+"";
					int years = Period.between(date_naissance, today).getYears();
					LocalDate birthDate = LocalDate.of(year, month,daysOfMonth);
					//LocalDate birthDate = LocalDate.of(1996, 8, 18);
					Period.between(startDateInclusive, endDateExclusive);
					
				System.out.println(years);
				tage.setText(years);
				*/	
				}
			});
			
		
			tage.setColumns(10);
			tage.setBounds(141, 192, 217, 20);
			panel.add(tage);
			
			JLabel lblNewLabel_1_1_2 = new JLabel("Date de naissance");
			lblNewLabel_1_1_2.setForeground(Color.GRAY);
			lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_1_1_2.setBounds(53, 145, 78, 14);
			panel.add(lblNewLabel_1_1_2);
			
			JDateChooser tdate = new JDateChooser();
			tdate.setBounds(141, 145, 217, 20);
			panel.add(tdate);
			
		
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.LIGHT_GRAY);
			panel_2.setBounds(184, 2, 525, 442);
			frame.getContentPane().add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setIcon(new ImageIcon(Locataire_add.class.getResource("/res/user.png")));
			lblNewLabel_4.setBounds(65, 0, 71, 94);
			panel_2.add(lblNewLabel_4);
			
			JLabel lblNewLabel = new JLabel("Ajouter un locataire");
			lblNewLabel.setBounds(166, 38, 238, 42);
			panel_2.add(lblNewLabel);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		}

		public Window getFrame() {
			// TODO Auto-generated method stub
			return frame;
		}
	}
