package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField add_std_name;
	private JTextField add_std_email;
	private JTextField add_std_phone;
	private JTextField add_std_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
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
	public AddStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 509, 507);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(89, 66, 327, 335);
		contentPane.add(panel);
		
		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddStudent.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblAddStudent.setBounds(51, 24, 217, 32);
		panel.add(lblAddStudent);
		
		JLabel lblNewLabel_2_3_1_1_1_1 = new JLabel("Choose Course");
		lblNewLabel_2_3_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_3_1_1_1_1.setBounds(23, 184, 118, 17);
		panel.add(lblNewLabel_2_3_1_1_1_1);
		
		add_std_name = new JTextField();
		add_std_name.setToolTipText("");
		add_std_name.setHorizontalAlignment(SwingConstants.LEFT);
		add_std_name.setForeground(SystemColor.windowText);
		add_std_name.setFont(new Font("Arial", Font.PLAIN, 14));
		add_std_name.setColumns(10);
		add_std_name.setBorder(new CompoundBorder());
		add_std_name.setBounds(23, 101, 133, 22);
		panel.add(add_std_name);
		
		add_std_email = new JTextField();
		add_std_email.setToolTipText("");
		add_std_email.setHorizontalAlignment(SwingConstants.LEFT);
		add_std_email.setForeground(new Color(0, 102, 0));
		add_std_email.setFont(new Font("Arial", Font.PLAIN, 12));
		add_std_email.setColumns(10);
		add_std_email.setBorder(new CompoundBorder());
		add_std_email.setBounds(23, 147, 133, 23);
		panel.add(add_std_email);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(23, 85, 38, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(23, 129, 38, 17);
		panel.add(lblNewLabel_2_1);
		
		add_std_phone = new JTextField();
		add_std_phone.setToolTipText("");
		add_std_phone.setHorizontalAlignment(SwingConstants.LEFT);
		add_std_phone.setForeground(SystemColor.windowText);
		add_std_phone.setFont(new Font("Arial", Font.PLAIN, 14));
		add_std_phone.setColumns(10);
		add_std_phone.setBorder(new CompoundBorder());
		add_std_phone.setBounds(178, 101, 133, 22);
		panel.add(add_std_phone);
		
		add_std_password = new JTextField();
		add_std_password.setToolTipText("");
		add_std_password.setHorizontalAlignment(SwingConstants.LEFT);
		add_std_password.setForeground(new Color(0, 102, 0));
		add_std_password.setFont(new Font("Arial", Font.PLAIN, 12));
		add_std_password.setColumns(10);
		add_std_password.setBorder(new CompoundBorder());
		add_std_password.setBounds(178, 147, 133, 23);
		panel.add(add_std_password);
		
		JLabel lblNewLabel_2_3 = new JLabel("Phone");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(181, 85, 47, 17);
		panel.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Password");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(176, 129, 71, 17);
		panel.add(lblNewLabel_2_1_1);
		
		JButton cancel = new JButton("Cancel");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancel.setBorder(new CompoundBorder());
		cancel.setBackground(new Color(50, 205, 50));
		cancel.setBounds(185, 263, 97, 26);
		panel.add(cancel);
		
		ArrayList<String> courseList = new ArrayList<String>();
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
			java.sql.Statement st = con.createStatement();
			String sql = "Select courseName from courses";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				courseList.add(rs.getString(1));
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String[] cour = new String[courseList.size()];
		for(int i=0; i<courseList.size(); i++) {
			cour[i] = courseList.get(i);
		}
		
		JComboBox course = new JComboBox(cour);
		course.setFont(new Font("Arial", Font.PLAIN, 14));
		course.setBorder(new CompoundBorder());
		course.setBounds(23, 201, 81, 26);
		panel.add(course);
		
		JButton add = new JButton("Add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					java.sql.Statement st = con.createStatement();
					String name, em, ph, pass, cour;
					cour = course.getSelectedItem().toString();
					
					name = add_std_name.getText();
					em = add_std_email.getText();
					ph = add_std_phone.getText();
					pass = add_std_password.getText();
					
					boolean check = false;
					
					if((!name.equals("")) && (!em.equals("")) && (!ph.equals("")) && (!pass.equals(""))) {
						String unRegex = "[a-zA-Z0-9]+";
						String emailRegex = "[a-zA-Z0-9]+[@gmail.com]$";
						String passwordRegex = "[A-Za-z0-9]+{8,9}";
						String phoneRegex = "^[9][0-9]+{9}";
						
						Pattern namePattern = Pattern.compile(unRegex);
						Matcher nameMatcher = namePattern.matcher(name);
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
						JOptionPane.showMessageDialog(null, "Empty Field", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
					if((check)) {
					String sql = "INSERT INTO students(username, email, password, phone, Course)" + "Values('"+name+"','"+em+"','"+pass+"','"+ph+"','"+cour+"');";
					st.executeUpdate(sql);
					boolean done = true;
					if((done)) {
						JOptionPane.showMessageDialog(null, "SignUp Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
						Login n = new Login();
						n.setVisible(done);
						con.close();
						dispose();
					}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Tahoma", Font.BOLD, 14));
		add.setBorder(new CompoundBorder());
		add.setBackground(new Color(50, 205, 50));
		add.setBounds(44, 263, 97, 26);
		panel.add(add);
		
		courseList.clear();
	}
}
