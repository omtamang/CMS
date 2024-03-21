package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
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
import javax.swing.border.CompoundBorder;

public class AddCourse extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField course_name;
	private JTextField batch;
	private JTextField seats;
	private JTextField year;
	private JTextField y1_module_1;
	private JTextField y1_module_2;
	private JTextField y1_module_3;
	private JTextField y1tm1;
	private JTextField y1tm2;
	private JTextField y1tm3;
	private JLabel lblYear;
	private JLabel lblNewLabel_2_3;
	private JTextField y2_module_1;
	private JLabel lblNewLabel_2_2_3;
	private JTextField y2_module_2;
	private JLabel lblNewLabel_2_2_4;
	private JTextField y2_module_3;
	private JLabel lblNewLabel_2_2_6;
	private JTextField y2tm1;
	private JLabel lblNewLabel_2_2_5_3;
	private JTextField y2tm2;
	private JLabel lblNewLabel_2_2_5_4;
	private JTextField y2tm3;
	private JTextField y3_module_1;
	private JTextField y3_module_2;
	private JTextField y3_module_3;
	private JTextField y3tm1;
	private JTextField y3tm2;
	private JTextField y3tm3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse frame = new AddCourse();
					frame.setUndecorated(true);
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
	public AddCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1126, 779);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1123, 783);
		contentPane.add(panel);
		
		JLabel lblAddTutor = new JLabel("Add Course");
		lblAddTutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddTutor.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblAddTutor.setBounds(392, 28, 152, 32);
		panel.add(lblAddTutor);
		
		JLabel lblNewLabel_2 = new JLabel("Course Name");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(68, 85, 78, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Seats");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(519, 84, 38, 17);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Batch");
		lblNewLabel_2_3_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_3_1.setBounds(294, 85, 47, 17);
		panel.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Year");
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(739, 83, 71, 17);
		panel.add(lblNewLabel_2_1_1_1);
		
		course_name = new JTextField();
		course_name.setBorder(new CompoundBorder());
		course_name.setBounds(68, 101, 200, 22);
		panel.add(course_name);
		course_name.setToolTipText("");
		course_name.setHorizontalAlignment(SwingConstants.LEFT);
		course_name.setForeground(SystemColor.windowText);
		course_name.setFont(new Font("Arial", Font.PLAIN, 14));
		course_name.setColumns(10);
		
		batch = new JTextField();
		batch.setBorder(new CompoundBorder());
		batch.setBounds(294, 102, 200, 22);
		panel.add(batch);
		batch.setToolTipText("");
		batch.setHorizontalAlignment(SwingConstants.LEFT);
		batch.setForeground(new Color(0, 102, 0));
		batch.setFont(new Font("Arial", Font.PLAIN, 12));
		batch.setColumns(10);
		
		seats = new JTextField();
		seats.setBorder(new CompoundBorder());
		seats.setBounds(519, 101, 200, 22);
		panel.add(seats);
		seats.setToolTipText("");
		seats.setHorizontalAlignment(SwingConstants.LEFT);
		seats.setForeground(SystemColor.windowText);
		seats.setFont(new Font("Arial", Font.PLAIN, 14));
		seats.setColumns(10);
		
		year = new JTextField();
		year.setBorder(new CompoundBorder());
		year.setBounds(741, 101, 200, 22);
		year.setToolTipText("");
		year.setHorizontalAlignment(SwingConstants.LEFT);
		year.setForeground(new Color(0, 102, 0));
		year.setFont(new Font("Arial", Font.PLAIN, 12));
		year.setColumns(10);
		
		JButton cancel = new JButton("Cancel");
		cancel.setBorder(new CompoundBorder());
		cancel.setBounds(520, 657, 97, 26);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancel.setBackground(new Color(50, 205, 50));
		
		JButton add = new JButton("Add");
		add.setBorder(new CompoundBorder());
		add.setBounds(369, 657, 97, 26);
		panel.add(add);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					java.sql.Statement st = con.createStatement();
					
					//query for checking if course is available
					String sql = "Select courseName from courses;";
					ResultSet rs = st.executeQuery(sql);
					
					// course name
					String name, batchy, seatsavailable, noofyears;
					name = course_name.getText();
					batchy = batch.getText();
					seatsavailable = seats.getText();
					noofyears = year.getText();
					
					// year wise module
					String y1module1, y1module2, y1module3, y2module1, y2module2, y2module3, y3module1, y3module2, y3module3;
					y1module1 = y1_module_1.getText();
					y1module2 = y1_module_2.getText();
					y1module3 = y1_module_3.getText();
					
					y2module1 = y2_module_1.getText();
					y2module2 = y2_module_2.getText();
					y2module3 = y2_module_3.getText();
					
					y3module1 = y3_module_1.getText();
					y3module2 = y3_module_2.getText();
					y3module3 = y3_module_3.getText();
					
					// year wise tutors for respective tutors
					String y1_tm1, y1_tm2, y1_tm3, y2_tm1, y2_tm2, y2_tm3, y3_tm1, y3_tm2, y3_tm3;
					//year 1 tutors
					y1_tm1 = y1tm1.getText();
					y1_tm2 = y1tm2.getText();
					y1_tm3 = y1tm3.getText();
					
					//year 2 tutors
					y2_tm1 = y2tm1.getText();
					y2_tm2 = y2tm2.getText();
					y2_tm3 = y2tm3.getText();
					
					//year 3 tutors
					y3_tm1 = y3tm1.getText();
					y3_tm2 = y3tm2.getText();
					y3_tm3 = y3tm3.getText();
					
					
					TutorCheck t = new TutorCheck();
					boolean y1t1, y1t2, y1t3, y2t1, y2t2, y2t3, y3t1, y3t2, y3t3;
					y1t1 = t.Check(y1_tm1);
					y1t2 = t.Check(y1_tm2);
					y1t3 = t.Check(y1_tm3);
					
					y2t1 = t.Check(y2_tm1);
					y2t2 = t.Check(y2_tm2);
					y2t3 = t.Check(y2_tm3);
					
					y3t1 = t.Check(y3_tm1);
					y3t2 = t.Check(y3_tm2);
					y3t3 = t.Check(y3_tm3);

					String batchRegex = "[2020-2026]";
					String yearsRegex = "[3]";
					
					Pattern batchPattern = Pattern.compile(batchRegex);
					Matcher batchMatcher = batchPattern.matcher(batchRegex);
					boolean batchFound = batchMatcher.find();
					
					Pattern yearsPattern = Pattern.compile(yearsRegex);
					Matcher yearsMatcher = yearsPattern.matcher(yearsRegex);
					boolean yearFound = yearsMatcher.find();
					
					boolean courseNameCheck = true;
	
					while(rs.next()) {
						String n = rs.getString("courseName");
						if(n.equals(name)){
							courseNameCheck = false;
							JOptionPane.showMessageDialog(null, "Course Already Available", "UnSuccessfull", JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}
					
					if((!y1module1.equals("")) && (!y1module2.equals("")) && (!y1module3.equals("")) && (!y2module1.equals("")) && (!y2module2.equals("")) && (!y2module3.equals("")) && (!y3module1.equals("")) && (!y3module2.equals("")) && (!y3module3.equals(""))) {
					if((!y1_tm1.equals("")) && (!y1_tm2.equals("")) && (!y1_tm3.equals("")) && (!y2_tm1.equals("")) && (!y2_tm2.equals("")) && (!y2_tm3.equals("")) && (!y3_tm1.equals("")) && (!y3_tm2.equals("")) && (!y3_tm3.equals(""))) {
					if((!name.equals("")) && (!batchy.equals("")) && (!seatsavailable.equals("")) && (!noofyears.equals("")) && (courseNameCheck)){
						if((y1t1) && (y1t2) && (y1t3) && (y2t1) && (y2t2) && (y2t3) && (y3t1) && (y3t2) && (y3t3)) {
						if((batchFound) && (yearFound)) {
							String sql2 = "Insert into courses(courseName, batch, seats, no_of_years)" + "Values('"+name+"', '"+batchy+"', '"+seatsavailable+"', '"+noofyears+"')";
							st.executeUpdate(sql2);
							String sql3 = "Insert into modules(courseName, TutorAssigned, module_name, years)" + "Values('"+name+"', '"+y1_tm1+"', '"+y1module1+"', 1)";
							st.executeUpdate(sql3);
							String sql4 = "Insert into modules(courseName, TutorAssigned, module_name, years)" + "Values('"+name+"', '"+y1_tm2+"', '"+y1module2+"', 1)";
							st.executeUpdate(sql4);
							String sql5 = "Insert into modules(courseName, TutorAssigned, module_name, years)" + "Values('"+name+"', '"+y1_tm3+"', '"+y1module3+"', 1)";
							st.executeUpdate(sql5);
							
							String sql6 = "Insert into modules(courseName, TutorAssigned, module_name, years)" + "Values('"+name+"', '"+y2_tm1+"', '"+y2module1+"', 2)";
							st.executeUpdate(sql6);
							String sql7 = "Insert into modules(courseName, TutorAssigned, module_name, years)" + "Values('"+name+"', '"+y2_tm2+"', '"+y2module2+"', 2)";
							st.executeUpdate(sql7);
							String sql8 = "Insert into modules(courseName, TutorAssigned, module_name, years)" + "Values('"+name+"', '"+y2_tm3+"', '"+y2module3+"', 2)";
							st.executeUpdate(sql8);
							
							String sql9 = "Insert into modules(courseName, TutorAssigned, module_name, years)" + "Values('"+name+"', '"+y3_tm1+"', '"+y3module1+"', 3)";
							st.executeUpdate(sql9);
							String sql10 = "Insert into modules(courseName, TutorAssigned, module_name, years)" + "Values('"+name+"', '"+y3_tm2+"', '"+y3module2+"', 3)";
							st.executeUpdate(sql10);
							String sql11 = "Insert into modules(courseName, TutorAssigned, module_name, years)" + "Values('"+name+"', '"+y3_tm3+"', '"+y3module3+"', 3)";
							st.executeUpdate(sql11);
							JOptionPane.showMessageDialog(null, "Course Added!", "Success", JOptionPane.INFORMATION_MESSAGE);
							con.close();
						}
						else {
							JOptionPane.showMessageDialog(null, "Years Should be between 3 - 5/ Batch Available(2020-2026)", "Error", JOptionPane.ERROR_MESSAGE);
						}
						}
						else {
							JOptionPane.showMessageDialog(null, "Tutor Not Found Please Recheck Name", "Tutor Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Empy Course Name", "Empty Error", JOptionPane.ERROR_MESSAGE);
					}
					
					}
					else {
						JOptionPane.showMessageDialog(null, "Empy Tutors", "Empty Error", JOptionPane.ERROR_MESSAGE);
					}
					}
					else {
						JOptionPane.showMessageDialog(null, "Empy year modules", "Empty Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		add.setForeground(Color.WHITE);
		add.setFont(new Font("Tahoma", Font.BOLD, 14));
		add.setBackground(new Color(50, 205, 50));
		panel.add(year);
		panel.add(cancel);
		
		JLabel lblNewLabel = new JLabel("Year 1");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblNewLabel.setBounds(68, 158, 47, 17);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2_2 = new JLabel("Module 1");
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2.setBounds(68, 177, 57, 17);
		panel.add(lblNewLabel_2_2);
		
		y1_module_1 = new JTextField();
		y1_module_1.setToolTipText("");
		y1_module_1.setHorizontalAlignment(SwingConstants.LEFT);
		y1_module_1.setForeground(SystemColor.windowText);
		y1_module_1.setFont(new Font("Arial", Font.PLAIN, 14));
		y1_module_1.setColumns(10);
		y1_module_1.setBorder(new CompoundBorder());
		y1_module_1.setBounds(68, 194, 274, 22);
		panel.add(y1_module_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Module 2");
		lblNewLabel_2_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_1.setBounds(368, 177, 57, 17);
		panel.add(lblNewLabel_2_2_1);
		
		y1_module_2 = new JTextField();
		y1_module_2.setToolTipText("");
		y1_module_2.setHorizontalAlignment(SwingConstants.LEFT);
		y1_module_2.setForeground(SystemColor.windowText);
		y1_module_2.setFont(new Font("Arial", Font.PLAIN, 14));
		y1_module_2.setColumns(10);
		y1_module_2.setBorder(new CompoundBorder());
		y1_module_2.setBounds(368, 194, 274, 22);
		panel.add(y1_module_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Module 3");
		lblNewLabel_2_2_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_2.setBounds(667, 177, 57, 17);
		panel.add(lblNewLabel_2_2_2);
		
		y1_module_3 = new JTextField();
		y1_module_3.setToolTipText("");
		y1_module_3.setHorizontalAlignment(SwingConstants.LEFT);
		y1_module_3.setForeground(SystemColor.windowText);
		y1_module_3.setFont(new Font("Arial", Font.PLAIN, 14));
		y1_module_3.setColumns(10);
		y1_module_3.setBorder(new CompoundBorder());
		y1_module_3.setBounds(667, 194, 274, 22);
		panel.add(y1_module_3);
		
		JLabel lblNewLabel_2_2_5 = new JLabel("Module 1 Tutor");
		lblNewLabel_2_2_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_5.setBounds(67, 225, 97, 17);
		panel.add(lblNewLabel_2_2_5);
		
		y1tm1 = new JTextField();
		y1tm1.setToolTipText("");
		y1tm1.setHorizontalAlignment(SwingConstants.LEFT);
		y1tm1.setForeground(SystemColor.windowText);
		y1tm1.setFont(new Font("Arial", Font.PLAIN, 14));
		y1tm1.setColumns(10);
		y1tm1.setBorder(new CompoundBorder());
		y1tm1.setBounds(67, 242, 274, 22);
		panel.add(y1tm1);
		
		JLabel lblNewLabel_2_2_5_1 = new JLabel("Module 2 Tutor");
		lblNewLabel_2_2_5_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_5_1.setBounds(368, 226, 97, 17);
		panel.add(lblNewLabel_2_2_5_1);
		
		y1tm2 = new JTextField();
		y1tm2.setToolTipText("");
		y1tm2.setHorizontalAlignment(SwingConstants.LEFT);
		y1tm2.setForeground(SystemColor.windowText);
		y1tm2.setFont(new Font("Arial", Font.PLAIN, 14));
		y1tm2.setColumns(10);
		y1tm2.setBorder(new CompoundBorder());
		y1tm2.setBounds(368, 243, 274, 22);
		panel.add(y1tm2);
		
		JLabel lblNewLabel_2_2_5_2 = new JLabel("Module 3 Tutor");
		lblNewLabel_2_2_5_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_5_2.setBounds(667, 225, 97, 17);
		panel.add(lblNewLabel_2_2_5_2);
		
		y1tm3 = new JTextField();
		y1tm3.setToolTipText("");
		y1tm3.setHorizontalAlignment(SwingConstants.LEFT);
		y1tm3.setForeground(SystemColor.windowText);
		y1tm3.setFont(new Font("Arial", Font.PLAIN, 14));
		y1tm3.setColumns(10);
		y1tm3.setBorder(new CompoundBorder());
		y1tm3.setBounds(667, 242, 274, 22);
		panel.add(y1tm3);
		
		lblYear = new JLabel("Year 2");
		lblYear.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblYear.setBounds(69, 291, 47, 17);
		panel.add(lblYear);
		
		lblNewLabel_2_3 = new JLabel("Module 1");
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_3.setBounds(69, 310, 57, 17);
		panel.add(lblNewLabel_2_3);
		
		y2_module_1 = new JTextField();
		y2_module_1.setToolTipText("");
		y2_module_1.setHorizontalAlignment(SwingConstants.LEFT);
		y2_module_1.setForeground(SystemColor.windowText);
		y2_module_1.setFont(new Font("Arial", Font.PLAIN, 14));
		y2_module_1.setColumns(10);
		y2_module_1.setBorder(new CompoundBorder());
		y2_module_1.setBounds(69, 327, 274, 22);
		panel.add(y2_module_1);
		
		lblNewLabel_2_2_3 = new JLabel("Module 2");
		lblNewLabel_2_2_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_3.setBounds(369, 310, 57, 17);
		panel.add(lblNewLabel_2_2_3);
		
		y2_module_2 = new JTextField();
		y2_module_2.setToolTipText("");
		y2_module_2.setHorizontalAlignment(SwingConstants.LEFT);
		y2_module_2.setForeground(SystemColor.windowText);
		y2_module_2.setFont(new Font("Arial", Font.PLAIN, 14));
		y2_module_2.setColumns(10);
		y2_module_2.setBorder(new CompoundBorder());
		y2_module_2.setBounds(369, 327, 274, 22);
		panel.add(y2_module_2);
		
		lblNewLabel_2_2_4 = new JLabel("Module 3");
		lblNewLabel_2_2_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_4.setBounds(668, 310, 57, 17);
		panel.add(lblNewLabel_2_2_4);
		
		y2_module_3 = new JTextField();
		y2_module_3.setToolTipText("");
		y2_module_3.setHorizontalAlignment(SwingConstants.LEFT);
		y2_module_3.setForeground(SystemColor.windowText);
		y2_module_3.setFont(new Font("Arial", Font.PLAIN, 14));
		y2_module_3.setColumns(10);
		y2_module_3.setBorder(new CompoundBorder());
		y2_module_3.setBounds(668, 327, 274, 22);
		panel.add(y2_module_3);
		
		lblNewLabel_2_2_6 = new JLabel("Module 1 Tutor");
		lblNewLabel_2_2_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_6.setBounds(68, 358, 97, 17);
		panel.add(lblNewLabel_2_2_6);
		
		y2tm1 = new JTextField();
		y2tm1.setToolTipText("");
		y2tm1.setHorizontalAlignment(SwingConstants.LEFT);
		y2tm1.setForeground(SystemColor.windowText);
		y2tm1.setFont(new Font("Arial", Font.PLAIN, 14));
		y2tm1.setColumns(10);
		y2tm1.setBorder(new CompoundBorder());
		y2tm1.setBounds(68, 375, 274, 22);
		panel.add(y2tm1);
		
		lblNewLabel_2_2_5_3 = new JLabel("Module 2 Tutor");
		lblNewLabel_2_2_5_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_5_3.setBounds(369, 359, 97, 17);
		panel.add(lblNewLabel_2_2_5_3);
		
		y2tm2 = new JTextField();
		y2tm2.setToolTipText("");
		y2tm2.setHorizontalAlignment(SwingConstants.LEFT);
		y2tm2.setForeground(SystemColor.windowText);
		y2tm2.setFont(new Font("Arial", Font.PLAIN, 14));
		y2tm2.setColumns(10);
		y2tm2.setBorder(new CompoundBorder());
		y2tm2.setBounds(369, 376, 274, 22);
		panel.add(y2tm2);
		
		lblNewLabel_2_2_5_4 = new JLabel("Module 3 Tutor");
		lblNewLabel_2_2_5_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_5_4.setBounds(668, 358, 97, 17);
		panel.add(lblNewLabel_2_2_5_4);
		
		y2tm3 = new JTextField();
		y2tm3.setToolTipText("");
		y2tm3.setHorizontalAlignment(SwingConstants.LEFT);
		y2tm3.setForeground(SystemColor.windowText);
		y2tm3.setFont(new Font("Arial", Font.PLAIN, 14));
		y2tm3.setColumns(10);
		y2tm3.setBorder(new CompoundBorder());
		y2tm3.setBounds(668, 375, 274, 22);
		panel.add(y2tm3);
		
		JLabel lblYear_2 = new JLabel("Year 3");
		lblYear_2.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblYear_2.setBounds(68, 426, 47, 17);
		panel.add(lblYear_2);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("Module 1");
		lblNewLabel_2_3_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_3_2.setBounds(68, 445, 57, 17);
		panel.add(lblNewLabel_2_3_2);
		
		y3_module_1 = new JTextField();
		y3_module_1.setToolTipText("");
		y3_module_1.setHorizontalAlignment(SwingConstants.LEFT);
		y3_module_1.setForeground(SystemColor.windowText);
		y3_module_1.setFont(new Font("Arial", Font.PLAIN, 14));
		y3_module_1.setColumns(10);
		y3_module_1.setBorder(new CompoundBorder());
		y3_module_1.setBounds(68, 462, 274, 22);
		panel.add(y3_module_1);
		
		JLabel lblNewLabel_2_2_3_1 = new JLabel("Module 2");
		lblNewLabel_2_2_3_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_3_1.setBounds(368, 445, 57, 17);
		panel.add(lblNewLabel_2_2_3_1);
		
		y3_module_2 = new JTextField();
		y3_module_2.setToolTipText("");
		y3_module_2.setHorizontalAlignment(SwingConstants.LEFT);
		y3_module_2.setForeground(SystemColor.windowText);
		y3_module_2.setFont(new Font("Arial", Font.PLAIN, 14));
		y3_module_2.setColumns(10);
		y3_module_2.setBorder(new CompoundBorder());
		y3_module_2.setBounds(368, 462, 274, 22);
		panel.add(y3_module_2);
		
		JLabel lblNewLabel_2_2_4_1 = new JLabel("Module 3");
		lblNewLabel_2_2_4_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_4_1.setBounds(667, 445, 57, 17);
		panel.add(lblNewLabel_2_2_4_1);
		
		y3_module_3 = new JTextField();
		y3_module_3.setToolTipText("");
		y3_module_3.setHorizontalAlignment(SwingConstants.LEFT);
		y3_module_3.setForeground(SystemColor.windowText);
		y3_module_3.setFont(new Font("Arial", Font.PLAIN, 14));
		y3_module_3.setColumns(10);
		y3_module_3.setBorder(new CompoundBorder());
		y3_module_3.setBounds(667, 462, 274, 22);
		panel.add(y3_module_3);
		
		JLabel lblNewLabel_2_2_6_1 = new JLabel("Module 1 Tutor");
		lblNewLabel_2_2_6_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_6_1.setBounds(67, 493, 97, 17);
		panel.add(lblNewLabel_2_2_6_1);
		
		y3tm1 = new JTextField();
		y3tm1.setToolTipText("");
		y3tm1.setHorizontalAlignment(SwingConstants.LEFT);
		y3tm1.setForeground(SystemColor.windowText);
		y3tm1.setFont(new Font("Arial", Font.PLAIN, 14));
		y3tm1.setColumns(10);
		y3tm1.setBorder(new CompoundBorder());
		y3tm1.setBounds(67, 510, 274, 22);
		panel.add(y3tm1);
		
		JLabel lblNewLabel_2_2_5_3_1 = new JLabel("Module 2 Tutor");
		lblNewLabel_2_2_5_3_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_5_3_1.setBounds(368, 494, 97, 17);
		panel.add(lblNewLabel_2_2_5_3_1);
		
		y3tm2 = new JTextField();
		y3tm2.setToolTipText("");
		y3tm2.setHorizontalAlignment(SwingConstants.LEFT);
		y3tm2.setForeground(SystemColor.windowText);
		y3tm2.setFont(new Font("Arial", Font.PLAIN, 14));
		y3tm2.setColumns(10);
		y3tm2.setBorder(new CompoundBorder());
		y3tm2.setBounds(368, 511, 274, 22);
		panel.add(y3tm2);
		
		JLabel lblNewLabel_2_2_5_4_1 = new JLabel("Module 3 Tutor");
		lblNewLabel_2_2_5_4_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_2_5_4_1.setBounds(667, 493, 97, 17);
		panel.add(lblNewLabel_2_2_5_4_1);
		
		y3tm3 = new JTextField();
		y3tm3.setToolTipText("");
		y3tm3.setHorizontalAlignment(SwingConstants.LEFT);
		y3tm3.setForeground(SystemColor.windowText);
		y3tm3.setFont(new Font("Arial", Font.PLAIN, 14));
		y3tm3.setColumns(10);
		y3tm3.setBorder(new CompoundBorder());
		y3tm3.setBounds(667, 510, 274, 22);
		panel.add(y3tm3);
	}
}
