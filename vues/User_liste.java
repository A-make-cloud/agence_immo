	package vues;

	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;

	import java.awt.Font;
	import java.awt.Window;
	import java.awt.event.WindowAdapter;
	import java.awt.event.WindowEvent;
	import java.util.ArrayList;

	import javax.swing.JTable;
	import javax.swing.table.DefaultTableModel;
	import javax.swing.JScrollPane;


	import DAO.UserDAO;


	import entites.User;

	import entites.Database;
	import javax.swing.JPanel;
	import java.awt.Color;
	import javax.swing.ImageIcon;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;

	public class User_liste {
		

		JFrame frameListeUser;
		private JTable table;
		private Window frameTableauBord;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						User_liste window = new User_liste();
						window.frameListeUser.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public User_liste() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frameListeUser = new JFrame();
			frameListeUser.getContentPane().setBackground(new Color(46, 49, 49));
			frameListeUser.addWindowListener(new WindowAdapter() {
				
				

				@Override
				public void windowClosing(WindowEvent e) {
					tableau_bord ta = new tableau_bord();
					ta.getFrameTableauBord().setVisible(true);
					frameTableauBord.dispose();
				}
			});
			

			frameListeUser.setBounds(100, 100, 766, 490);
			frameListeUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameListeUser.getContentPane().setLayout(null);
		
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(25, 75, 704, 300);
			frameListeUser.getContentPane().add(scrollPane);
			Database.Connect();
			UserDAO userdao=new UserDAO();

			 ArrayList<User> user = userdao.getAll();
			table = new JTable();
			scrollPane.setColumnHeaderView(table);
			 String columns[] = { "ID", "IDENTIFIANT","MOT DE PASSE"};
		      String data[][] = new String[user.size()][columns.length];
		
		      for(int i=0;i<user.size();i++) {
		    	  data[i][0] = user.get(i).getId()+"";
			        data[i][1] = user.get(i).getIdentifiant();
			        data[i][2] = user.get(i).getPassword();
			     
		      }
		      DefaultTableModel model = new DefaultTableModel(data, columns);
			     
		      table = new JTable(model);
		      
				//table = new JTable();
				scrollPane.setViewportView(table);
				// DefaultTableModel model = new DefaultTableModel(data, columns);
			     
			      table = new JTable(model);
			  
				scrollPane.setViewportView(table);
			
			JPanel panel = new JPanel();
			panel.setBounds(25, 11, 704, 63);
			panel.setBackground(Color.LIGHT_GRAY);
			frameListeUser.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setBounds(26, 0, 59, 63);
			lblNewLabel_1.setIcon(new ImageIcon(User_liste.class.getResource("/res/employee.png")));
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBounds(585, 11, 65, 52);
			lblNewLabel_2.setIcon(new ImageIcon(User_liste.class.getResource("/res/staff.png")));
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel = new JLabel("Liste des Users");
			lblNewLabel.setBounds(225, 21, 243, 31);
			panel.add(lblNewLabel);
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
			
			JPanel panel_1 = new JPanel();
			panel_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if(table.getSelectedRow()!=-1) {
						
						int test=table.getSelectedRow();
						int selectedId = Integer.parseInt(table.getModel().getValueAt(test, 0).toString());
							
						UserDAO Userdao=new UserDAO();
						User user=Userdao.getById(selectedId);
						
						
						new User_edit(user).getFrameListeUser().setVisible(true);
						
						
						
					}else {
						JOptionPane.showMessageDialog(null, "Veuillez choisir une ligne ");
					}
				}
			});
			panel_1.setBackground(new Color(230, 126, 34));
			panel_1.setBounds(348, 398, 106, 27);
			frameListeUser.getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Modifier");
			lblNewLabel_3.setBounds(10, 5, 46, 17);
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			panel_1.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setBounds(80, 5, 16, 17);
			lblNewLabel_4.setIcon(new ImageIcon(User_liste.class.getResource("/res/information2.png")));
			panel_1.add(lblNewLabel_4);
			
			JPanel panel_1_1 = new JPanel();
			panel_1_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					UserDAO userdao=new UserDAO();
					if(table.getSelectedRow()!=-1) {
						 int input = JOptionPane.showConfirmDialog(null, "voullez vous supprimer ?");
						 if(input==0) {
								int test=table.getSelectedRow();
								int selectedId = Integer.parseInt(table.getModel().getValueAt(test, 0).toString());
								userdao.deleteById(selectedId);
								((DefaultTableModel)table.getModel()).removeRow(test);
								JOptionPane.showMessageDialog(null, "... a bien été supprimé ");
						 }
						
					}else {
						JOptionPane.showMessageDialog(null, "Veuillez choisir une ligne ");
					}
					
					
				}
			});
			panel_1_1.setLayout(null);
			panel_1_1.setBackground(new Color(230, 126, 34));
			panel_1_1.setBounds(555, 398, 106, 27);
			frameListeUser.getContentPane().add(panel_1_1);
			
			JLabel lblNewLabel_3_1 = new JLabel("Supprimer");
			lblNewLabel_3_1.setForeground(Color.WHITE);
			lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3_1.setBounds(10, 5, 63, 17);
			panel_1_1.add(lblNewLabel_3_1);
			
			JLabel lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon(User_liste.class.getResource("/res/unavailable.png")));
			lblNewLabel_5.setBounds(83, 5, 23, 17);
			panel_1_1.add(lblNewLabel_5);
		}



		public JFrame getFrameTableauBord() {
			return frameListeUser;
		}

		public void setFrameTableauBord(JFrame frameTableauBord) {
			this.frameListeUser = frameTableauBord;
		}

		public Window getFrameListeUser() {
			
			return frameListeUser;
		}
	}

