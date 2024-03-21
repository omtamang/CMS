package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;

public class AddTutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fullname;
	private JTextField email;
	private JTextField phone;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTutor frame = new AddTutor();
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
	public AddTutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 483);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String[] module_names = {"Fundamentals of Computer", "C Programming", "Operating Systems", "Multimedia Systems", "Data and Database", "Web development", "Computer Lab and Practical Work", "Python", "Concepts of AI", "OOP"};
		
		JPanel panel = new JPanel();
		panel.setBounds(109, 53, 327, 335);
		panel.setLayout(null);
		
		JLabel lblAddTutor = new JLabel("Add Tutor");
		lblAddTutor.setBounds(51, 24, 217, 32);
		lblAddTutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddTutor.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		JComboBox course = new JComboBox(module_names);
		course.setBorder(new CompoundBorder());
		course.setBounds(23, 211, 178, 21);
		
		JLabel lblNewLabel_2_3_1_1_1_1 = new JLabel("Choose Module");
		lblNewLabel_2_3_1_1_1_1.setBounds(23, 184, 118, 17);
		lblNewLabel_2_3_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		fullname = new JTextField();
		fullname.setBorder(new CompoundBorder());
		fullname.setBounds(23, 101, 133, 22);
		fullname.setToolTipText("");
		fullname.setHorizontalAlignment(SwingConstants.LEFT);
		fullname.setForeground(SystemColor.windowText);
		fullname.setFont(new Font("Arial", Font.PLAIN, 14));
		fullname.setColumns(10);
		
		email = new JTextField();
		email.setBorder(new CompoundBorder());
		email.setBounds(23, 147, 133, 23);
		email.setToolTipText("");
		email.setHorizontalAlignment(SwingConstants.LEFT);
		email.setForeground(new Color(0, 102, 0));
		email.setFont(new Font("Arial", Font.PLAIN, 12));
		email.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(23, 85, 38, 17);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_2_1 = new JLabel("Email");
		lblNewLabel_2_1.setBounds(23, 129, 38, 17);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		phone = new JTextField();
		phone.setBorder(new CompoundBorder());
		phone.setBounds(178, 101, 133, 22);
		phone.setToolTipText("");
		phone.setHorizontalAlignment(SwingConstants.LEFT);
		phone.setForeground(SystemColor.windowText);
		phone.setFont(new Font("Arial", Font.PLAIN, 14));
		phone.setColumns(10);
		
		password = new JTextField();
		password.setBorder(new CompoundBorder());
		password.setBounds(178, 147, 133, 23);
		password.setToolTipText("");
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setForeground(new Color(0, 102, 0));
		password.setFont(new Font("Arial", Font.PLAIN, 12));
		password.setColumns(10);
		
		JLabel lblNewLabel_2_3 = new JLabel("Phone");
		lblNewLabel_2_3.setBounds(181, 85, 47, 17);
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Password");
		lblNewLabel_2_1_1.setBounds(176, 129, 71, 17);
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton add = new JButton("Add");
		add.setBorder(new CompoundBorder());
		add.setBounds(44, 263, 97, 26);
		panel.add(add);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name, em, ph, pass, cour;
				
				name = fullname.getText();
				em = email.getText();
				ph = phone.getText();
				pass = password.getText();
				cour = course.getSelectedItem().toString();
				
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
					JOptionPane.showMessageDialog(null, "Empty Field", cour, JOptionPane.ERROR_MESSAGE);
				}
				
				if((check)) {
					try {
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
						java.sql.Statement st = con.createStatement();
						String sql = "INSERT INTO tutors(username, email, password, phone, module)" + "Values('"+name+"','"+em+"','"+pass+"','"+ph+"','"+cour+"');";
						
						st.executeUpdate(sql);
						JOptionPane.showMessageDialog(null,"Tutor Added", "AddTutor", JOptionPane.INFORMATION_MESSAGE);
						con.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		add.setBackground(new Color(50, 205, 50));
		add.setFont(new Font("Tahoma", Font.BOLD, 14));
		add.setForeground(Color.WHITE);
		contentPane.add(panel);
		panel.add(lblAddTutor);
		panel.add(course);
		panel.add(lblNewLabel_2_3_1_1_1_1);
		panel.add(fullname);
		panel.add(email);
		panel.add(lblNewLabel_2);
		panel.add(lblNewLabel_2_1);
		panel.add(phone);
		panel.add(password);
		panel.add(lblNewLabel_2_3);
		panel.add(lblNewLabel_2_1_1);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBorder(new CompoundBorder());
		cancel.setBounds(185, 263, 97, 26);
		panel.add(cancel);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancel.setBackground(new Color(50, 205, 50));
	}
}
