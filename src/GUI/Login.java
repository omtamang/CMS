package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Query;
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
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField sign;
	private JPasswordField pass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setTitle("Course Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogIn = new JLabel("SignIn");
		lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogIn.setFont(new Font("Arial", Font.BOLD, 28));
		lblLogIn.setBounds(482, 25, 154, 32);
		contentPane.add(lblLogIn);
		
		sign = new JTextField();
		sign.setBorder(new CompoundBorder());
		sign.setToolTipText("");
		sign.setHorizontalAlignment(SwingConstants.LEFT);
		sign.setForeground(SystemColor.desktop);
		sign.setFont(new Font("Arial", Font.PLAIN, 14));
		sign.setColumns(10);
		sign.setBounds(391, 109, 340, 36);
		contentPane.add(sign);
		
		String[] mode = {"Student", "Tutor", "Admin"};
		JComboBox modee = new JComboBox(mode);
		modee.setEditable(true);
		modee.setBorder(new CompoundBorder());
		modee.setFont(new Font("Arial", Font.PLAIN, 14));
		modee.setBackground(SystemColor.menu);
		modee.setBounds(391, 243, 119, 21);
		contentPane.add(modee);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.setBorder(UIManager.getBorder("MenuItem.border"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				if (sign.getText().length() >= 6) {
//					JOptionPane.showMessageDialog(null, "Valid input!", 
//							"Validation Result", JOptionPane.INFORMATION_MESSAGE);
//				}
//				else {
//					JOptionPane.showMessageDialog(null,
//							"Invalid input! Input must have at least 6 characters.",
//							"Validation Result", JOptionPane.ERROR_MESSAGE);
//				}
				boolean found = false;
				
					Configuration cfg = null;
					SessionFactory sessionFactory = null;
					Session session = null;
					
					cfg = new Configuration();
					cfg.configure("com/hibernate/cfgs/hibernate.cfg.xml");
					sessionFactory = cfg.buildSessionFactory();
					session = sessionFactory.openSession();
					
					String mode = modee.getSelectedItem().toString();

					Dashboard d = new Dashboard();
					String name, email, password;
					
					if(mode == "Student") {
						Query query = session.createQuery("select username, email, password from Sign");
						@SuppressWarnings("deprecation")
						List l = query.list();
						
						Iterator rs = l.iterator();
						while(rs.hasNext()) {
							Object sing[] = (Object[]) rs.next();
							name = (String) sing[0];
							email = (String) sing[1];
							password = (String) sing[2];
							String em = sign.getText();
							String pa = pass.getText();
							
							if(email.equals(em) && password.equals(pa)) {
								d.getDashboard_name().setText(name);
								d.mode.setText("Student Dashboard");
								Activity a = new Activity("Student: "+name, "logged in");
								found = true;
							}
						}
					}
					else if(mode == "Tutor") {
						Query query = session.createQuery("select username, email, password from TutorSign");
						List l = query.list();
						
						Iterator rs = l.iterator();
						while(rs.hasNext()) {
							Object sing[] = (Object[]) rs.next();
							name = (String) sing[0];
							email = (String) sing[1];
							password = (String) sing[2];
							String em = sign.getText();
							String pa = pass.getText();
							
							if(email.equals(em) && password.equals(pa)) {
								d.getDashboard_name().setText(name);
								Activity a = new Activity("Tutor: "+name, "logged in");
								d.mode.setText("Tutor Dashboard");
								found = true;
							}
						}
						
					}
					else if(mode == "Admin") {
						Query query = session.createQuery("select AdminName, email, password from AdminSign");
						AdminSign s = new AdminSign();
						List l = query.list();
						
						Iterator rs = l.iterator();
						while(rs.hasNext()) {
							Object sing[] = (Object[]) rs.next();
							name = (String) sing[0];
							email = (String) sing[1];
							password = (String) sing[2];
							String em = sign.getText();
							String pa = pass.getText();
							
							if(email.equals(em) && password.equals(pa)) {
								d.getDashboard_name().setText(name);
								d.mode.setText("Admin Dashboard");
								Activity a = new Activity("Admin: "+ name, "logged in");
								found = true;
							}
						}
						
					}
					
					if((found)) {
						JOptionPane.showMessageDialog(null, "LogIn Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
						d.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid username or password!", "Try Again", JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin.setBackground(new Color(50, 205, 50));
		btnLogin.setBounds(482, 315, 154, 36);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(391, 86, 39, 17);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(391, 155, 69, 17);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Select Mode\r\n");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(391, 221, 86, 17);
		contentPane.add(lblNewLabel_2_2);
		
		pass = new JPasswordField();
		pass.setBorder(new CompoundBorder());
		pass.setFont(new Font("Arial", Font.PLAIN, 14));
		pass.setBounds(391, 175, 340, 36);
		contentPane.add(pass);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 340, 617);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/Images/HCK-transformed.png")));
		lblNewLabel_3.setBounds(10, 0, 209, 54);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("Don't have an account?");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(87, 263, 160, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUP s = new SignUP();
				s.setVisible(true);
				dispose();
			}
		});
		lblCreateAccount.setForeground(Color.BLACK);
		lblCreateAccount.setFont(new Font("Arial", Font.BOLD, 14));
		lblCreateAccount.setBounds(111, 300, 108, 21);
		panel.add(lblCreateAccount);
		
		JLabel lblNewLabel_5_2 = new JLabel("Welcome back");
		lblNewLabel_5_2.setForeground(new Color(50, 205, 50));
		lblNewLabel_5_2.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel_5_2.setBounds(63, 140, 209, 38);
		panel.add(lblNewLabel_5_2);
	}
}
