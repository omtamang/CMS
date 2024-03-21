package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField std_id;
	private JTextField std_name;
	private JTextField std_email;
	private JTextField std_password;
	private JTextField std_phone;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudent frame = new EditStudent();
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
	public EditStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1019, 560);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.windowBorder);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 301, 530);
		contentPane.add(panel);
		
		std_id = new JTextField();
		std_id.setToolTipText("");
		std_id.setHorizontalAlignment(SwingConstants.LEFT);
		std_id.setForeground(SystemColor.windowText);
		std_id.setFont(new Font("Arial", Font.PLAIN, 14));
		std_id.setColumns(10);
		std_id.setBorder(null);
		std_id.setBounds(93, 141, 133, 12);
		panel.add(std_id);
		
		std_name = new JTextField();
		std_name.setToolTipText("");
		std_name.setHorizontalAlignment(SwingConstants.LEFT);
		std_name.setForeground(new Color(0, 102, 0));
		std_name.setFont(new Font("Arial", Font.PLAIN, 12));
		std_name.setColumns(10);
		std_name.setBorder(null);
		std_name.setBounds(93, 178, 133, 12);
		panel.add(std_name);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setForeground(SystemColor.windowBorder);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(60, 140, 15, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Name");
		lblNewLabel_2_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(45, 176, 45, 17);
		panel.add(lblNewLabel_2_1);
		
		std_email = new JTextField();
		std_email.setToolTipText("");
		std_email.setHorizontalAlignment(SwingConstants.LEFT);
		std_email.setForeground(SystemColor.windowText);
		std_email.setFont(new Font("Arial", Font.PLAIN, 14));
		std_email.setColumns(10);
		std_email.setBorder(null);
		std_email.setBounds(93, 203, 133, 20);
		panel.add(std_email);
		
		std_password = new JTextField();
		std_password.setToolTipText("");
		std_password.setHorizontalAlignment(SwingConstants.LEFT);
		std_password.setForeground(new Color(0, 102, 0));
		std_password.setFont(new Font("Arial", Font.PLAIN, 12));
		std_password.setColumns(10);
		std_password.setBorder(null);
		std_password.setBounds(93, 275, 133, 17);
		panel.add(std_password);
		
		std_phone = new JTextField();
		std_phone.setToolTipText("");
		std_phone.setHorizontalAlignment(SwingConstants.LEFT);
		std_phone.setForeground(new Color(0, 102, 0));
		std_phone.setFont(new Font("Arial", Font.PLAIN, 12));
		std_phone.setColumns(10);
		std_phone.setBorder(null);
		std_phone.setBounds(93, 242, 133, 12);
		panel.add(std_phone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(SystemColor.windowBorder);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 12));
		lblEmail.setBounds(49, 210, 37, 17);
		panel.add(lblEmail);
		
		JLabel p = new JLabel("Phone");
		p.setForeground(SystemColor.windowBorder);
		p.setFont(new Font("Arial", Font.BOLD, 12));
		p.setBounds(41, 240, 45, 17);
		panel.add(p);
		
		JLabel pas = new JLabel("Password");
		pas.setForeground(SystemColor.windowBorder);
		pas.setFont(new Font("Arial", Font.BOLD, 12));
		pas.setBounds(22, 275, 64, 17);
		panel.add(pas);
		
		JLabel lblNewLabel = new JLabel("______________________");
		lblNewLabel.setBounds(93, 143, 155, 17);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("______________________");
		lblNewLabel_4.setBounds(93, 179, 155, 17);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("______________________");
		lblNewLabel_5.setBounds(88, 212, 155, 17);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("______________________");
		lblNewLabel_6.setBounds(93, 245, 155, 17);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("______________________");
		lblNewLabel_7.setBounds(93, 280, 155, 17);
		panel.add(lblNewLabel_7);
		
		ArrayList<String> c = new ArrayList<String>();
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
			java.sql.Statement st = con.createStatement();
			String sql = "Select courseName from courses;";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				c.add(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] courseList = new String[c.size()];
		for(int i=0; i<c.size(); i++) {
			courseList[i] = c.get(i);
		}
		
		JComboBox course = new JComboBox(courseList);
		course.setFont(new Font("Arial", Font.PLAIN, 14));
		course.setBorder(new CompoundBorder());
		course.setBounds(105, 346, 81, 27);
		panel.add(course);
		
		JButton edit = new JButton("Edit");
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id, name, email, password, phone, module;
				id = std_id.getText();
				name = std_name.getText();
				email = std_email.getText();
				password = std_password.getText();
				phone = std_phone.getText();
				module = course.getSelectedItem().toString();
				
				boolean check = false;
				
				if((!email.equals("")) && (!id.equals("")) && (!name.equals("")) && (!password.equals(""))) {
					String unRegex = "[a-zA-Z0-9]+";
					String emailRegex = "[a-zA-Z0-9]+[@gmail.com]$";
					String passwordRegex = "[A-Za-z0-9]+{8,9}";
					String phoneRegex = "^[9][0-9]+{9}";
					
					Pattern namePattern = Pattern.compile(unRegex);
					Matcher nameMatcher = namePattern.matcher(name);
					boolean nameFound = nameMatcher.find();
					
					Pattern emailPattern = Pattern.compile(emailRegex);
					Matcher emailMatcher = emailPattern.matcher(email);
					boolean emailFound = emailMatcher.find();
					
					Pattern phonePattern = Pattern.compile(phoneRegex);
					Matcher phoneMatcher = phonePattern.matcher(phone);
					boolean phoneFound = phoneMatcher.find();
					
					Pattern passwordPattern = Pattern.compile(passwordRegex);
					Matcher passwordMatcher = passwordPattern.matcher(password);
					boolean passwordFound = passwordMatcher.find();
					
					if((nameFound) && ((emailFound)) && ((phoneFound)) && ((passwordFound))) {
						check = true;
					}
					else {
						JOptionPane.showMessageDialog(null, "Password must be greater than 8 please use gmail account and nepali number","please use gmail account and nepali number", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Empty Field", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				if((check)) {
					JOptionPane.showConfirmDialog(null, "Are you sure?", "Edit Confirmation", JOptionPane.YES_NO_OPTION);
					int res = JOptionPane.YES_OPTION;
					System.out.println(res);
				if(res == 0) {
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
						java.sql.Statement st = con.createStatement();
						String sql = "Update students Set userName = '"+name+"', email ='"+email+"',password = '"+password+"', phone ='"+phone+"',course = '"+module+"' where id = '"+id+"'";
						st.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Details Updated", "Student Details", JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				}
			}
		});
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		edit.setBackground(new Color(50, 205, 50));
		edit.setBounds(39, 424, 97, 32);
		panel.add(edit);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancel.setBackground(new Color(50, 205, 50));
		cancel.setBounds(174, 424, 97, 32);
		panel.add(cancel);
		
		
		JLabel lblNewLabel_2_3_1_1_1 = new JLabel("Choose Course");
		lblNewLabel_2_3_1_1_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_2_3_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1_1_1.setBounds(87, 318, 116, 17);
		panel.add(lblNewLabel_2_3_1_1_1);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("Edit Student");
		lblNewLabel_1_2_1_3.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_1_2_1_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_2_1_3.setBounds(93, 65, 110, 31);
		panel.add(lblNewLabel_1_2_1_3);
		
		JLabel lblNewLabel_4_1 = new JLabel("Select a row to edit");
		lblNewLabel_4_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(339, 37, 175, 31);
		contentPane.add(lblNewLabel_4_1);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setForeground(new Color(0, 102, 0));
		textField.setFont(new Font("Arial", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(SystemColor.menu);
		textField.setBounds(764, 37, 127, 17);
		contentPane.add(textField);
		
		JLabel lblNewLabel_3 = new JLabel("___________________________");
		lblNewLabel_3.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel_3.setBounds(764, 42, 187, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EditStudent.class.getResource("/Images/icons8-search-24.png")));
		lblNewLabel_1.setBounds(942, 37, 24, 22);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(339, 78, 627, 388);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tbl = (DefaultTableModel) table.getModel();
				
				String iid = tbl.getValueAt(table.getSelectedRow(), 0).toString();
				String name = tbl.getValueAt(table.getSelectedRow(), 1).toString();
				String email = tbl.getValueAt(table.getSelectedRow(), 2).toString();
				String pass = tbl.getValueAt(table.getSelectedRow(), 3).toString();
				String phone = tbl.getValueAt(table.getSelectedRow(), 4).toString();
				
				std_id.setText(iid);
				std_name.setText(name);
				std_email.setText(email);
				std_password.setText(pass);
				std_phone.setText(phone);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Student Name", "Email", "Password", "Phone Number", "Course"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(22);
		table.getColumnModel().getColumn(0).setMinWidth(12);
		table.getColumnModel().getColumn(0).setMaxWidth(22);
		table.getColumnModel().getColumn(4).setPreferredWidth(82);
		table.getColumnModel().getColumn(4).setMinWidth(25);
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
			java.sql.Statement st = con.createStatement();
			String sql = "Select * from students";
			ResultSet rs = st.executeQuery(sql);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			
			String id, name, email, password, phone, module;
			while(rs.next()) {
				id = rs.getString(1);
				name = rs.getString(2);
				email = rs.getString(3);
				password = rs.getString(4);
				phone = rs.getString(5);
				module = rs.getString(6);
				
				String[] row = {id, name, email, password, phone, module};
				model.addRow(row);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		c.clear();
	}
}
