package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.SoftBevelBorder;
import java.awt.Component;

public class EditTutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;
	private JTextField name;
	private JTextField email;
	private JTextField password;
	private JTextField phone;
	private JTable table;
	private JTable table_1;
	private JTextField search;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditTutor frame = new EditTutor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EditTutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 548);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] module_names = {"Fundamentals of Computer", "C Programming", "Operating Systems", "Multimedia Systems", "Data and Database", "Web development", "Computer Lab and Practical Work", "Python", "Concepts of AI", "OOP"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 71, 613, 386);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setForeground(new Color(0, 0, 0));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tbl = (DefaultTableModel) table.getModel();
				
				String iid = tbl.getValueAt(table.getSelectedRow(), 0).toString();
				String username = tbl.getValueAt(table.getSelectedRow(), 1).toString();
				String em = tbl.getValueAt(table.getSelectedRow(), 2).toString();
				String pass = tbl.getValueAt(table.getSelectedRow(), 3).toString();
				String ph = tbl.getValueAt(table.getSelectedRow(), 4).toString();
				
				id.setText(iid);
				name.setText(username);
				email.setText(em);
				password.setText(pass);
				phone.setText(ph);
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Email", "Password", "Phone", "Module"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(2).setPreferredWidth(82);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(95);
		scrollPane.setViewportView(table);
		
		search = new JTextField();
		search.setBackground(SystemColor.menu);
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				TableRowSorter<DefaultTableModel> model1 = new TableRowSorter<>(model);
				
				table.setRowSorter(model1);
				model1.setRowFilter(RowFilter.regexFilter(search.getText()));
			}
		});
		search.setBorder(null);
		search.setToolTipText("");
		search.setHorizontalAlignment(SwingConstants.LEFT);
		search.setForeground(new Color(0, 102, 0));
		search.setFont(new Font("Arial", Font.PLAIN, 12));
		search.setColumns(10);
		search.setBounds(759, 36, 162, 17);
		contentPane.add(search);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EditTutor.class.getResource("/Images/icons8-search-24.png")));
		lblNewLabel_1.setBounds(923, 36, 24, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("_________________________");
		lblNewLabel_3.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel_3.setBounds(759, 41, 165, 17);
		contentPane.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 301, 539);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddTutor = new JLabel("Edit Tutor");
		lblAddTutor.setBounds(36, 42, 217, 32);
		panel.add(lblAddTutor);
		lblAddTutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddTutor.setFont(new Font("Arial", Font.BOLD, 18));
		
		id = new JTextField();
		id.setBounds(103, 94, 133, 12);
		panel.add(id);
		id.setBorder(null);
		id.setToolTipText("");
		id.setHorizontalAlignment(SwingConstants.LEFT);
		id.setForeground(SystemColor.windowText);
		id.setFont(new Font("Arial", Font.PLAIN, 14));
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(103, 131, 133, 12);
		panel.add(name);
		name.setBorder(null);
		name.setToolTipText("");
		name.setHorizontalAlignment(SwingConstants.LEFT);
		name.setForeground(new Color(0, 102, 0));
		name.setFont(new Font("Arial", Font.PLAIN, 12));
		name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(70, 93, 15, 17);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		lblNewLabel_2_1.setBounds(54, 129, 37, 17);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		email = new JTextField();
		email.setBounds(103, 156, 133, 20);
		panel.add(email);
		email.setBorder(null);
		email.setToolTipText("");
		email.setHorizontalAlignment(SwingConstants.LEFT);
		email.setForeground(SystemColor.windowText);
		email.setFont(new Font("Arial", Font.PLAIN, 14));
		email.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(103, 228, 133, 17);
		panel.add(phone);
		phone.setBorder(null);
		phone.setToolTipText("");
		phone.setHorizontalAlignment(SwingConstants.LEFT);
		phone.setForeground(new Color(0, 102, 0));
		phone.setFont(new Font("Arial", Font.PLAIN, 12));
		phone.setColumns(10);
		
		password = new JTextField();
		password.setBounds(103, 195, 133, 12);
		panel.add(password);
		password.setBorder(null);
		password.setToolTipText("");
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setForeground(new Color(0, 102, 0));
		password.setFont(new Font("Arial", Font.PLAIN, 12));
		password.setColumns(10);
		
		JLabel lblNewLabel_2_3 = new JLabel("Email");
		lblNewLabel_2_3.setBounds(54, 163, 37, 17);
		panel.add(lblNewLabel_2_3);
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Password");
		lblNewLabel_2_1_1.setBounds(26, 195, 59, 17);
		panel.add(lblNewLabel_2_1_1);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		JComboBox modules = new JComboBox(module_names);
		modules.setBounds(36, 300, 202, 21);
		panel.add(modules);
		modules.setFont(new Font("Arial", Font.PLAIN, 14));
		modules.setForeground(Color.BLACK);
		modules.setBackground(Color.WHITE);
		modules.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		
		JLabel lblNewLabel_2_3_1_1_1_1 = new JLabel("Choose Module");
		lblNewLabel_2_3_1_1_1_1.setBounds(36, 279, 118, 17);
		panel.add(lblNewLabel_2_3_1_1_1_1);
		lblNewLabel_2_3_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		
				
				JLabel lblNewLabel_2_1_1_1 = new JLabel("Phone");
				lblNewLabel_2_1_1_1.setBounds(48, 228, 37, 17);
				panel.add(lblNewLabel_2_1_1_1);
				lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
				
				JLabel lblNewLabel = new JLabel("______________________");
				lblNewLabel.setBounds(103, 96, 155, 17);
				panel.add(lblNewLabel);
				
				JLabel lblNewLabel_4 = new JLabel("______________________");
				lblNewLabel_4.setBounds(103, 132, 155, 17);
				panel.add(lblNewLabel_4);
				
				JLabel lblNewLabel_5 = new JLabel("______________________");
				lblNewLabel_5.setBounds(98, 165, 155, 17);
				panel.add(lblNewLabel_5);
				
				JLabel lblNewLabel_6 = new JLabel("______________________");
				lblNewLabel_6.setBounds(103, 198, 155, 17);
				panel.add(lblNewLabel_6);
				
				JLabel lblNewLabel_7 = new JLabel("______________________");
				lblNewLabel_7.setBounds(103, 233, 155, 17);
				panel.add(lblNewLabel_7);
				
				JButton edit = new JButton("Edit");
				edit.setBounds(38, 386, 97, 32);
				panel.add(edit);
				edit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String username = name.getText();
						String module = modules.getSelectedItem().toString();
						String em = email.getText();
						String pass = password.getText();
						String tutor_id = id.getText();
						int t_id = Integer.parseInt(tutor_id);
						String ph = phone.getText();
						
						boolean check = false;
						
						if((!name.equals("")) && (!em.equals("")) && (!ph.equals("")) && (!pass.equals(""))) {
							String unRegex = "[a-zA-Z0-9]+";
							String emailRegex = "[a-zA-Z0-9]+[@gmail.com]$";
							String passwordRegex = "[A-Za-z0-9]+{8,9}";
							String phoneRegex = "^[9][0-9]+{9}";
							
							Pattern namePattern = Pattern.compile(unRegex);
							Matcher nameMatcher = namePattern.matcher(username);
							boolean nameFound = nameMatcher.find();
							
							Pattern emailPattern = Pattern.compile(emailRegex);
							Matcher emailMatcher = emailPattern.matcher(em);
							boolean emailFound = emailMatcher.find();
							
							Pattern phonePattern = Pattern.compile(phoneRegex);
							Matcher phoneMatcher = phonePattern.matcher(ph);
							boolean phoneFound = phoneMatcher.find();
							
							Pattern passwordPattern = Pattern.compile(passwordRegex);
							Matcher passwordMatcher = passwordPattern.matcher(pass);
							boolean passwordFound = passwordMatcher.find();
							
							if((nameFound) && ((emailFound)) && ((phoneFound)) && ((passwordFound))) {
								check = true;
							}
							else {
								JOptionPane.showMessageDialog(null, "Password must be greater than 8 please use gmail account and nepali number","please use gmail account and nepali number", JOptionPane.ERROR_MESSAGE);
							}
						}
						else {
							JOptionPane.showMessageDialog(null, "Empty Field","Empty Field Message" , JOptionPane.ERROR_MESSAGE);
							
						}
						if((check)) {
						try {
							Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system","root", "");
							java.sql.Statement st = con.createStatement();
							String sql = "Update tutors Set username = '"+username+"', email = '"+em+"', password = '"+pass+"', phone = '"+ph+"', module = '"+module+"' Where id = '"+t_id+"';";
							
							st.executeUpdate(sql);
							JOptionPane.showMessageDialog(null, "Tutor Details Edited", 
									"Validation Result", JOptionPane.INFORMATION_MESSAGE);
							con.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					}
				});
				edit.setForeground(Color.WHITE);
				edit.setFont(new Font("Tahoma", Font.BOLD, 14));
				edit.setBackground(new Color(50, 205, 50));
				
				JButton cancel = new JButton("Cancel");
				cancel.setBounds(173, 386, 97, 32);
				panel.add(cancel);
				cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancel.setForeground(Color.WHITE);
				cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
				cancel.setBackground(new Color(50, 205, 50));
				
				JLabel lblNewLabel_4_1 = new JLabel("Select a row to edit");
				lblNewLabel_4_1.setForeground(Color.BLACK);
				lblNewLabel_4_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
				lblNewLabel_4_1.setBounds(346, 32, 175, 31);
				contentPane.add(lblNewLabel_4_1);
		

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
			java.sql.Statement st = con.createStatement();
			String sql = "Select * from tutors";
			ResultSet rs = st.executeQuery(sql);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			String id, username, email, password, phone, module;
			while(rs.next()) {
				id = rs.getString(1);
				username = rs.getString(2);
				email = rs.getString(3);
				password = rs.getString(4);
				phone = rs.getString(5);
				module = rs.getString(6);
				
				String[] rows = {id, username, email, password, phone, module};
				model.addRow(rows);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
