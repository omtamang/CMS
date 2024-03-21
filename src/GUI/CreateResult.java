package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateResult extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField std_id;
	private JTextField name;
	private JTextField module;
	private JTextField percentage;
	private JTextField grade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateResult frame = new CreateResult();
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
	public CreateResult() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(50, 205, 50));
		panel.setBounds(35, 22, 246, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Module Result Form");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 18));
		lblNewLabel.setBounds(36, 10, 179, 32);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student ID");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(35, 92, 158, 24);
		contentPane.add(lblNewLabel_1);
		
		std_id = new JTextField();
		std_id.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		std_id.setFont(new Font("Arial", Font.PLAIN, 14));
		std_id.setBounds(35, 118, 246, 36);
		contentPane.add(std_id);
		std_id.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Student Name");
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(35, 173, 158, 24);
		contentPane.add(lblNewLabel_1_1);
		
		name = new JTextField();
		name.setFont(new Font("Arial", Font.PLAIN, 14));
		name.setColumns(10);
		name.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		name.setBounds(35, 199, 246, 36);
		contentPane.add(name);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Module Name");
		lblNewLabel_1_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(333, 173, 158, 24);
		contentPane.add(lblNewLabel_1_2);
		
		module = new JTextField();
		module.setFont(new Font("Arial", Font.PLAIN, 14));
		module.setColumns(10);
		module.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		module.setBounds(333, 199, 246, 36);
		contentPane.add(module);
		
		JLabel lblNewLabel_1_3 = new JLabel("Enter Total Percentage (%)");
		lblNewLabel_1_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(35, 269, 211, 24);
		contentPane.add(lblNewLabel_1_3);
		
		percentage = new JTextField();
		percentage.setFont(new Font("Arial", Font.PLAIN, 14));
		percentage.setColumns(10);
		percentage.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		percentage.setBounds(35, 295, 246, 36);
		contentPane.add(percentage);
		
		JLabel lblNewLabel_1_4 = new JLabel("Enter Overall Grade (G.P.A)");
		lblNewLabel_1_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(333, 269, 211, 24);
		contentPane.add(lblNewLabel_1_4);
		
		grade = new JTextField();
		grade.setFont(new Font("Arial", Font.PLAIN, 14));
		grade.setColumns(10);
		grade.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		grade.setBounds(333, 295, 246, 36);
		contentPane.add(grade);
		
		JButton btnNewButton = new JButton("Publish Result");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					java.sql.Statement st = con.createStatement();
					
					String s_name, s_id, percent, gpa, module_name;
					s_id = std_id.getText();
					s_name = name.getText();
					percent = percentage.getText();
					gpa = grade.getText().toUpperCase();
					module_name = module.getText();
					
					String sql = "Select id, username from students";
					ResultSet rs = st.executeQuery(sql);
					
					boolean std_found = false, module_found = false, result_published = false;
					
					while(rs.next()) {
						String std_id = rs.getString(1);
						String std_name = rs.getString(2);
						if((std_name.equals(s_name)) && (std_id.equals(std_id))) {
							std_found = true;
						}
					}
					
					String sql2 = "Select module_name from modules";
					ResultSet rs2 = st.executeQuery(sql2);
					
					String y1;
					while(rs2.next()) {
						y1 = rs2.getString(1);
						if(module_name.equals(y1)) {
							module_found = true;
						}
					}
					
					String sq = "Select Student_Name, module from result";
					ResultSet rs4 = st.executeQuery(sq);
					
					while(rs4.next()) {
						String Student_Name = rs4.getString(1);
						String Module = rs4.getString(2);
						if((Student_Name.equals(s_name) && (Module.equals(module_name)))) {
							result_published = true;
						}
					}
					
					if((!s_id.equals("")) && (!s_name.equals("")) && (!percent.equals("")) && (!gpa.equals("")) && (!module_name.equals(""))){
						if((module_found) && (std_found)) {
							String percent_regex = "[0-100][%]$";
							String gpa_regex = "[A-F+]";
							
							Pattern percent_pattern = Pattern.compile(percent_regex);
							Matcher percent_matcher = percent_pattern.matcher(percent);
							boolean percent_found = percent_matcher.find();
							
							Pattern gpa_pattern = Pattern.compile(gpa_regex);
							Matcher gpa_matcher = gpa_pattern.matcher(gpa);
							boolean gpa_found = gpa_matcher.find();
							
							String sql3 = "Insert into result(Student_Name, module, Percentage, grade)" + "Values('"+s_name+"','"+module_name+"','"+percent+"', '"+gpa+"')";
							
							
							if((gpa_found) && (percent_found)) {
								if((!result_published)) {
									st.executeUpdate(sql3);
									JOptionPane.showMessageDialog(null, "Result Published", "Information Message", JOptionPane.INFORMATION_MESSAGE);
								}
								else {
									JOptionPane.showMessageDialog(null, "Result Already Published", "Error Message", JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Percentage 1-100 / GPA A-F", "Error Message", JOptionPane.ERROR_MESSAGE);
							}
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Name and id not match or module error", "Error Message", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Empty Fields", "Error Message", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		btnNewButton.setBounds(138, 384, 143, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(CreateResult.class.getResource("/Images/icons8-result-100.png")));
		lblNewLabel_2.setBounds(412, 22, 101, 104);
		contentPane.add(lblNewLabel_2);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		btnCancel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		btnCancel.setBackground(new Color(50, 205, 50));
		btnCancel.setBounds(333, 384, 143, 36);
		contentPane.add(btnCancel);
	}
}
