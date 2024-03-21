package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.AdminSign;
import com.hibernate.entity.Sign;
import com.hibernate.entity.TutorSign;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

public class SignUP extends JFrame {

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
					SignUP frame = new SignUP();
					frame.setUndecorated(true);
					frame.setVisible(true);
					//frame.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public SignUP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 627);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		fullname = new JTextField();
		fullname.setBorder(new CompoundBorder());
		fullname.setBackground(Color.WHITE);
		fullname.setToolTipText("");
		fullname.setHorizontalAlignment(SwingConstants.LEFT);
		fullname.setForeground(SystemColor.windowText);
		fullname.setFont(new Font("Arial", Font.PLAIN, 14));
		fullname.setColumns(10);
		fullname.setBounds(386, 127, 376, 36);
		contentPane.add(fullname);
		
		email = new JTextField();
		email.setBorder(new CompoundBorder());
		email.setToolTipText("");
		email.setHorizontalAlignment(SwingConstants.LEFT);
		email.setForeground(new Color(0, 102, 0));
		email.setFont(new Font("Arial", Font.PLAIN, 12));
		email.setColumns(10);
		email.setBounds(386, 189, 376, 36);
		contentPane.add(email);
		
		JLabel lblNewLabel_2_3_1_1_1 = new JLabel("Choose Course");
		lblNewLabel_2_3_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_3_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1_1_1.setBounds(386, 414, 129, 17);
		contentPane.add(lblNewLabel_2_3_1_1_1);
		lblNewLabel_2_3_1_1_1.setVisible(false);
		
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
		course.setBorder(new CompoundBorder());
		course.setFont(new Font("Arial", Font.PLAIN, 14));
		course.setBounds(386, 441, 81, 27);
		contentPane.add(course);
		course.setVisible(false);
		
		String[] module_names = {"Fundamentals of Computer", "C Programming", "Operating Systems", "Multimedia Systems", "Data and Database", "Web development", "Computer Lab and Practical Work", "Python", "Concepts of AI", "OOP"};
		JComboBox modules = new JComboBox(module_names);
		modules.setBorder(new CompoundBorder());
		modules.setFont(new Font("Arial", Font.PLAIN, 14));
		modules.setBounds(386, 441, 211, 27);
		contentPane.add(modules);
		modules.setVisible(false);
		
		String[] year = {"1", "2", "3"};
		JComboBox course_1 = new JComboBox(year);
		course_1.setFont(new Font("Arial", Font.PLAIN, 14));
		course_1.setBorder(new CompoundBorder());
		course_1.setBounds(661, 441, 81, 27);
		contentPane.add(course_1);
		course_1.setVisible(false);
		
		JLabel lblNewLabel_2_3_1_1_1_2 = new JLabel("Year");
		lblNewLabel_2_3_1_1_1_2.setForeground(Color.BLACK);
		lblNewLabel_2_3_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1_1_1_2.setBounds(661, 417, 53, 17);
		contentPane.add(lblNewLabel_2_3_1_1_1_2);
		lblNewLabel_2_3_1_1_1_2.setVisible(false);
		
		String[] choose = {"Select your role", "Student", "Tutor", "Admin"};
		JComboBox tutor_student = new JComboBox(choose);
		tutor_student.setBorder(new CompoundBorder());
		tutor_student.setFont(new Font("Arial", Font.PLAIN, 14));
		tutor_student.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		JLabel lblNewLabel_2_3_1_1_1_1 = new JLabel("Choose Module");
		lblNewLabel_2_3_1_1_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_3_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1_1_1_1.setBounds(385, 414, 129, 17);
		contentPane.add(lblNewLabel_2_3_1_1_1_1);
		lblNewLabel_2_3_1_1_1_1.setVisible(false);
		
		tutor_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = tutor_student.getSelectedItem().toString();
				
				if(s.equals("Tutor")) {
					lblNewLabel_2_3_1_1_1.setVisible(false);
					course.setVisible(false);
					lblNewLabel_2_3_1_1_1_1.setVisible(true);
					modules.setVisible(true);
					lblNewLabel_2_3_1_1_1_2.setVisible(false);
					course_1.setVisible(false);
				}
				else if(s.equals("Student")) {
					lblNewLabel_2_3_1_1_1.setVisible(true);
					course.setVisible(true);
					modules.setVisible(false);
					course_1.setVisible(true);
					lblNewLabel_2_3_1_1_1_1.setVisible(false);
					lblNewLabel_2_3_1_1_1_2.setVisible(true);
				}
				else if(s.equals("Admin")) {
					lblNewLabel_2_3_1_1_1.setVisible(false);
					course.setVisible(false);
					modules.setVisible(false);
					course_1.setVisible(false);
					lblNewLabel_2_3_1_1_1_1.setVisible(false);
					lblNewLabel_2_3_1_1_1_2.setVisible(false);
				}
				
			}
		});
		tutor_student.setBounds(386, 378, 129, 27);
		contentPane.add(tutor_student);
		
		JButton CreateAccount = new JButton("Create Account");
		CreateAccount.setBorder(new CompoundBorder());
		CreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					String ts = tutor_student.getSelectedItem().toString();
					String std_yr = course_1.getSelectedItem().toString();
					
					Configuration cfg = null;
					SessionFactory sessionFactory = null;
					Session session = null;
					Transaction tx = null;
					
					//configure
					cfg = new Configuration();
					cfg.configure("com/hibernate/cfgs/hibernate.cfg.xml");
					
					//build session factory
					cfg.buildSessionFactory();
					sessionFactory = cfg.buildSessionFactory();
					session = sessionFactory.openSession();
					
					String name, em, ph, pass, cour;
					cour = course.getSelectedItem().toString();
					
					name = fullname.getText();
					em = email.getText();
					ph = phone.getText();
					pass = password.getText();
					
					boolean check = false;
					
					if((!name.equals("")) && (!em.equals("")) && (!ph.equals("")) && (!pass.equals(""))) {
						String unRegex = "[a-zA-Z0-9]+";
						String emailRegex = "[a-zA-Z0-9]+[@gmail.com]$";
						String passwordRegex = "[A-Za-z0-9]+{8,9}";
						String phoneRegex = "^[98][0-9]+{9}";
						
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
						if(ts.equals("Student")) {
							Sign s = new Sign();
							s.setUsername(name);
							s.setEmail(em);
							s.setCourse(cour);
							s.setPassword(pass);
							s.setPhone(ph);
							s.setYears(std_yr);
							s.setStatus("Processing");
							try {
								tx = session.beginTransaction();
								
								session.save(s);
								
								tx.commit();
							}
							catch(HibernateException f) {
								f.printStackTrace();
							}
							finally {
								session.close();
								sessionFactory.close();
							}
							Activity a = new Activity("Student: " +em, "created an account");
							boolean done = true;
							if((done)) {
								JOptionPane.showMessageDialog(null, "SignUp Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
								Login n = new Login();
								n.setVisible(done);
								dispose();
						}
						
					}
					
					
					else if(ts.equals("Tutor")) {
						String m = modules.getSelectedItem().toString();
						
						TutorSign t = new TutorSign();
						t.setUsername(name);
						t.setEmail(em);
						t.setPassword(pass);
						t.setPhone(ph);
						t.setModule(m);
						
						try {
							tx = session.beginTransaction();
							session.save(t);
							tx.commit();
						}
						catch (HibernateException f) {
							f.printStackTrace();
						}
						finally {
							session.close();
							sessionFactory.close();
						}
						
						Activity a = new Activity("Tutor: " +em, "created an account");
						System.out.println("Updated!");
						boolean done = true;
						if((done)) {
							JOptionPane.showMessageDialog(null, "SignUp Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
							Login n = new Login();
							n.setVisible(done);
							dispose();
						}
					}
					
					else if(ts.equals("Admin")) {
						
						AdminSign admin = new AdminSign();
						admin.setAdminName(name);
						admin.setEmail(em);
						admin.setPassword(pass);
						
						try {
							tx = session.beginTransaction();
							session.save(admin);
							tx.commit();
						}
						catch (HibernateException f) {
							f.printStackTrace();
						}
						finally {
							session.close();
							sessionFactory.close();
						}
						
						Activity a = new Activity("Admin: "+em, "created an account");
						System.out.println("Updated!");
						boolean done = true;
						if((done)) {
							JOptionPane.showMessageDialog(null, "SignUp Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
							Login n = new Login();
							n.setVisible(done);
							dispose();
						}
					}
				}
			
			}
		});
		CreateAccount.setForeground(new Color(255, 255, 255));
		CreateAccount.setFont(new Font("Arial", Font.BOLD, 16));
		CreateAccount.setBackground(new Color(50, 205, 50));
		CreateAccount.setBounds(477, 527, 193, 36);
		contentPane.add(CreateAccount);
		
		JLabel lblNewLabel_2 = new JLabel("Full Name");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(386, 108, 81, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email Address");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(386, 173, 114, 17);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Password");
		lblNewLabel_2_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(386, 233, 81, 17);
		contentPane.add(lblNewLabel_2_1_1);
		
		phone = new JTextField();
		phone.setBorder(new CompoundBorder());
		phone.setToolTipText("");
		phone.setHorizontalAlignment(SwingConstants.LEFT);
		phone.setForeground(SystemColor.windowText);
		phone.setFont(new Font("Arial", Font.PLAIN, 14));
		phone.setColumns(10);
		phone.setBounds(386, 310, 376, 36);
		contentPane.add(phone);
		
		JLabel phonelable = new JLabel("Phone Number");
		phonelable.setForeground(new Color(0, 0, 0));
		phonelable.setFont(new Font("Arial", Font.BOLD, 14));
		phonelable.setBounds(386, 293, 114, 17);
		contentPane.add(phonelable);
		
		password = new JTextField();
		password.setBorder(new CompoundBorder());
		password.setToolTipText("");
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setForeground(new Color(0, 102, 0));
		password.setFont(new Font("Arial", Font.PLAIN, 12));
		password.setColumns(10);
		password.setBounds(386, 247, 376, 36);
		contentPane.add(password);
		
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Role");
		lblNewLabel_2_3_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_3_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_3_1.setBounds(386, 356, 37, 17);
		contentPane.add(lblNewLabel_2_3_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 340, 617);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(SignUP.class.getResource("/Images/HCK-transformed.png")));
		lblNewLabel_3.setBounds(14, 10, 209, 54);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("Herald");
		lblNewLabel_5.setForeground(new Color(192, 192, 192));
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_5.setBounds(65, 219, 75, 38);
		panel.add(lblNewLabel_5);
		
		JLabel LogIn = new JLabel("LogIn");
		LogIn.setBounds(142, 539, 45, 21);
		panel.add(LogIn);
		LogIn.setForeground(Color.BLACK);
		LogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l = new Login();
				l.setVisible(true);
				dispose();
			}
		});
		LogIn.setFont(new Font("Arial", Font.BOLD, 16));
		
		JLabel lblNewLabel_5_2 = new JLabel("Welcome to");
		lblNewLabel_5_2.setForeground(new Color(192, 192, 192));
		lblNewLabel_5_2.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel_5_2.setBounds(65, 171, 178, 38);
		panel.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("S");
		lblNewLabel_4_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 50));
		lblNewLabel_4_1.setBounds(152, 305, 43, 59);
		panel.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("M");
		lblNewLabel_4_1_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_4_1_1.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel_4_1_1.setBounds(142, 253, 63, 54);
		panel.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("C");
		lblNewLabel_4_1_1_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_4_1_1_1.setFont(new Font("Arial", Font.BOLD, 38));
		lblNewLabel_4_1_1_1.setBounds(150, 219, 34, 38);
		panel.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Already have an account? ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(70, 512, 190, 27);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("Create New Account");
		lblNewLabel.setBounds(386, 24, 281, 44);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		
		JLabel lblNewLabel_4 = new JLabel("Start your journey with our Course Management System");
		lblNewLabel_4.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(386, 69, 377, 31);
		contentPane.add(lblNewLabel_4);
		
		
		c.clear();
	}
}
