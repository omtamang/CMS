package GUI;

import java.awt.EventQueue;

import javax.swing.JTabbedPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.List;
import java.awt.Font;
import java.awt.Button;
import javax.swing.JButton;

import com.hibernate.entity.Activitystore;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.util.StringUtils;

import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Iterator;

import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField tutor_search;
	private JTable table;
	private JTable std_table;
	private JTable tutor_table;
	private JTable table_1;
	private JTextField dashboard_name;
	public JTextField mode;
	private JTable table_2;
	private JTextField search_report;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
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
	public Dashboard() {
		// to count the no.of students, tutors and courses in the system
		Rowcount count = new Rowcount();
		
		// hibernate configuration
		Configuration cfg = null;
		SessionFactory sessionFactory = null;
		Session session = null;
		
		cfg = new Configuration();
		cfg.configure("com/hibernate/cfgs/hibernate.cfg.xml");
		sessionFactory = cfg.buildSessionFactory();
		session = sessionFactory.openSession();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1059, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// pane for multiple screens
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new LineBorder(Color.WHITE));
		tabbedPane.setBounds(233, -23, 841, 727);
		contentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_3.setBorder(new LineBorder(new Color(255, 255, 255), 12, true));
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.menu, 50, true));
		panel.setBackground(Color.WHITE);
		panel.setBounds(563, 118, 181, 72);
		panel_3.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-student-48.png")));
		lblNewLabel.setBounds(10, 10, 48, 54);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total Students");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(67, 10, 91, 17);
		panel.add(lblNewLabel_1);
		
		JLabel total_std = new JLabel(count.StudentCount());
		total_std.setFont(new Font("Bahnschrift", Font.BOLD, 38));
		total_std.setBounds(68, 23, 48, 49);
		panel.add(total_std);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new LineBorder(SystemColor.menu, 50, true));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(563, 200, 181, 72);
		panel_3.add(panel_7);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-tutor-48.png")));
		lblNewLabel_3.setBounds(10, 10, 48, 54);
		panel_7.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total Tutors");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(68, 10, 91, 17);
		panel_7.add(lblNewLabel_1_2);
		
		JLabel total_tutots = new JLabel(count.TutorCount());
		total_tutots.setFont(new Font("Bahnschrift", Font.BOLD, 38));
		total_tutots.setBounds(68, 33, 81, 38);
		panel_7.add(total_tutots);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBorder(new LineBorder(SystemColor.menu, 50, true));
		panel_7_1.setBackground(Color.WHITE);
		panel_7_1.setBounds(563, 36, 181, 72);
		panel_3.add(panel_7_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-courses-48.png")));
		lblNewLabel_3_1.setBounds(10, 10, 48, 54);
		panel_7_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Total Courses");
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2_2.setBounds(63, 10, 91, 17);
		panel_7_1.add(lblNewLabel_1_2_2);
		
		JLabel total_courses = new JLabel(count.CourseCount());
		total_courses.setFont(new Font("Bahnschrift", Font.BOLD, 38));
		total_courses.setBounds(68, 32, 48, 40);
		panel_7_1.add(total_courses);
		
		JLabel lblNewLabel_4_2_3 = new JLabel("\"Greate things are done by a series of small things brought together\"");
		lblNewLabel_4_2_3.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		lblNewLabel_4_2_3.setBounds(37, 69, 424, 31);
		panel_3.add(lblNewLabel_4_2_3);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(240, 240, 240), 74, true));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(37, 117, 442, 133);
		panel_3.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Hello,");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblNewLabel_5.setBounds(38, 18, 81, 35);
		panel_9.add(lblNewLabel_5);
		
		LocalDateTime now = LocalDateTime.now();
		DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.now());
		String d = dayOfWeek.toString();
		String day = d.substring(0,1).toUpperCase() + d.substring(1).toLowerCase();
		
		Month month = Month.of(now.getMonthValue());
		String m = month.toString().toLowerCase();
		String mon = m.substring(0,1).toUpperCase() + m.substring(1).toLowerCase();
		
		JLabel lblNewLabel_4_2_3_1_1 = new JLabel("Today is " + day + ", " + now.getDayOfMonth() + " " +  mon + " " +now.getYear());
		lblNewLabel_4_2_3_1_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_4_2_3_1_1.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		lblNewLabel_4_2_3_1_1.setBounds(38, 61, 303, 26);
		panel_9.add(lblNewLabel_4_2_3_1_1);
		
		JLabel lblNewLabel_4_2_3_1 = new JLabel("What would you like to do today?");
		lblNewLabel_4_2_3_1.setForeground(Color.BLACK);
		lblNewLabel_4_2_3_1.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		lblNewLabel_4_2_3_1.setBounds(38, 85, 212, 31);
		panel_9.add(lblNewLabel_4_2_3_1);
		
		setDashboard_name(new JTextField());
		getDashboard_name().setText("hello");
		getDashboard_name().setBorder(null);
		getDashboard_name().setBackground(SystemColor.menu);
		getDashboard_name().setForeground(new Color(50, 205, 50));
		getDashboard_name().setFont(new Font("Arial Black", Font.BOLD, 24));
		getDashboard_name().setBounds(116, 18, 289, 35);
		panel_9.add(getDashboard_name());
		getDashboard_name().setColumns(10);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBackground(Color.WHITE);
		scrollPane_3.setBorder(null);
		scrollPane_3.setBounds(57, 297, 692, 334);
		panel_3.add(scrollPane_3);
		
		table_1 = new JTable();
		table_1.setForeground(new Color(64, 64, 64));
		table_1.setBackground(Color.LIGHT_GRAY);
		table_1.setBorder(null);
		table_1.setFont(new Font("Arial", Font.BOLD, 14));
		scrollPane_3.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Activity"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(30);
		table_1.getColumnModel().getColumn(0).setMaxWidth(30);
		
		mode = new JTextField();
		mode.setBorder(null);
		mode.setForeground(SystemColor.windowBorder);
		mode.setFont(new Font("Arial", Font.BOLD, 22));
		mode.setBounds(37, 37, 243, 28);
		panel_3.add(mode);
		mode.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Activities in the system");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(57, 270, 188, 17);
		panel_3.add(lblNewLabel_1_1);
		
		// hibernate code for activity table
			Query q = session.createQuery("Select id, activity from Activitystore");
			DefaultTableModel mo = (DefaultTableModel) table_1.getModel();
			java.util.List l = q.list();
			
			Iterator rl = l.iterator();
			String ide, activity;
			
			while(rl.hasNext()) {
				Object sing[] = (Object[]) rl.next();
				ide = (String) sing[0];
				activity =(String) sing[1];
				String[] row = {ide, activity};
				mo.addRow(row);
			}
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Course");
		lblNewLabel_1_2_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_1_2_1.setBounds(45, 60, 77, 31);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 22));
		panel_4.add(lblNewLabel_1_2_1);
		
		JButton btnEditCourses = new JButton("Edit Course");
		btnEditCourses.setForeground(Color.WHITE);
		btnEditCourses.setBackground(new Color(50, 205, 50));
		btnEditCourses.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-edit-24.png")));
		btnEditCourses.setBounds(221, 175, 151, 25);
		btnEditCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String verify = mode.getText();
				if(verify.equals("Admin Dashboard")) {
					EditCourse edit = new EditCourse();
					edit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Access Denied!", "Access Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEditCourses.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_4.add(btnEditCourses);
		
		JButton btnDeleteCourses = new JButton("Delete Course");
		btnDeleteCourses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String verify = mode.getText();
				if(verify.equals("Admin Dashboard")) {
					DeleteCourse edit = new DeleteCourse();
					edit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Access Denied!", "Access Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDeleteCourses.setForeground(Color.WHITE);
		btnDeleteCourses.setBackground(new Color(50, 205, 50));
		btnDeleteCourses.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-delete-24.png")));
		btnDeleteCourses.setBounds(393, 175, 171, 25);
		btnDeleteCourses.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_4.add(btnDeleteCourses);
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String verify = mode.getText();
				if(verify.equals("Admin Dashboard")) {
					AddCourse edit = new AddCourse();
					edit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Access Denied!", "Access Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddCourse.setForeground(Color.WHITE);
		btnAddCourse.setBackground(new Color(50, 205, 50));
		btnAddCourse.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-add-24.png")));
		btnAddCourse.setBounds(45, 175, 151, 25);
		btnAddCourse.setFont(new Font("Arial", Font.PLAIN, 16));
		panel_4.add(btnAddCourse);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 231, 738, 375);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Course Name", "Batch", "Seats", "Year"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(24);
		table.getColumnModel().getColumn(0).setMinWidth(24);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Arial Black", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		
		textField_1 = new JTextField();
		textField_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				TableRowSorter<DefaultTableModel> model1 = new TableRowSorter<>(model);
				
				table.setRowSorter(model1);
				model1.setRowFilter(RowFilter.regexFilter(textField_1.getText()));
			}
		});
		textField_1.setFont(new Font("Arial", Font.PLAIN, 12));
		textField_1.setBounds(585, 175, 198, 25);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_7_1_1 = new JPanel();
		panel_7_1_1.setLayout(null);
		panel_7_1_1.setBorder(new LineBorder(SystemColor.menu, 50, true));
		panel_7_1_1.setBackground(Color.WHITE);
		panel_7_1_1.setBounds(585, 47, 181, 72);
		panel_4.add(panel_7_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-courses-48.png")));
		lblNewLabel_3_1_1.setBounds(10, 10, 48, 54);
		panel_7_1_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Total Courses");
		lblNewLabel_1_2_2_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2_2_1.setBounds(67, 10, 91, 17);
		panel_7_1_1.add(lblNewLabel_1_2_2_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel(count.CourseCount());
		lblNewLabel_2_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 38));
		lblNewLabel_2_1_1_1.setBounds(68, 23, 103, 49);
		panel_7_1_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Start your journey with our Course Management System");
		lblNewLabel_4_2.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		lblNewLabel_4_2.setBounds(45, 88, 345, 31);
		panel_4.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("Search Course");
		lblNewLabel_1_4_2_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1_4_2_1.setBounds(585, 147, 113, 24);
		panel_4.add(lblNewLabel_1_4_2_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_5, null);
		panel_5.setLayout(null);
		
		tutor_search = new JTextField();
		tutor_search.setBorder(new LineBorder(new Color(0, 0, 0)));
		tutor_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) tutor_table.getModel();
				TableRowSorter<DefaultTableModel> model1 = new TableRowSorter<>(model);
				
				tutor_table.setRowSorter(model1);
				model1.setRowFilter(RowFilter.regexFilter(tutor_search.getText()));
			}
		});
		tutor_search.setColumns(10);
		tutor_search.setBounds(582, 175, 198, 25);
		panel_5.add(tutor_search);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(42, 231, 738, 375);
		panel_5.add(scrollPane_2);
		
		tutor_table = new JTable();
		tutor_table.setFont(new Font("Arial Black", Font.PLAIN, 12));
		tutor_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Tutor Name", "Email", "Phone.No", "Module"
			}
		));
		tutor_table.getColumnModel().getColumn(0).setPreferredWidth(24);
		tutor_table.getColumnModel().getColumn(0).setMaxWidth(50);
		tutor_table.getColumnModel().getColumn(3).setPreferredWidth(70);
		tutor_table.getColumnModel().getColumn(4).setPreferredWidth(91);
		scrollPane_2.setViewportView(tutor_table);
		
		JButton btnAddTutor_2 = new JButton("Add Tutor");
		btnAddTutor_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String verify = mode.getText();
				if(verify.equals("Admin Dashboard")) {
					AddTutor edit = new AddTutor();
					edit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Access Denied!", "Access Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddTutor_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-add-24.png")));
		btnAddTutor_2.setForeground(Color.WHITE);
		btnAddTutor_2.setFont(new Font("Arial", Font.PLAIN, 16));
		btnAddTutor_2.setBackground(new Color(50, 205, 50));
		btnAddTutor_2.setBounds(42, 175, 151, 25);
		panel_5.add(btnAddTutor_2);
		
		JButton btnEditTutor_2 = new JButton("Edit Tutor");
		btnEditTutor_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String verify = mode.getText();
				if(verify.equals("Admin Dashboard")) {
					EditTutor edit = new EditTutor();
					edit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Access Denied!", "Access Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnEditTutor_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-edit-24.png")));
		btnEditTutor_2.setForeground(Color.WHITE);
		btnEditTutor_2.setFont(new Font("Arial", Font.PLAIN, 16));
		btnEditTutor_2.setBackground(new Color(50, 205, 50));
		btnEditTutor_2.setBounds(218, 175, 151, 25);
		panel_5.add(btnEditTutor_2);
		
		JButton btnDeleteTutor_2 = new JButton("Delete Tutor");
		btnDeleteTutor_2.addActionListener(new ActionListener() {
			String verify = mode.getText();
			public void actionPerformed(ActionEvent e) {
				String verify = mode.getText();
				if(verify.equals("Admin Dashboard")) {
					DeleteTutor edit = new DeleteTutor();
					edit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Access Denied!", "Access Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDeleteTutor_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-delete-24.png")));
		btnDeleteTutor_2.setForeground(Color.WHITE);
		btnDeleteTutor_2.setFont(new Font("Arial", Font.PLAIN, 16));
		btnDeleteTutor_2.setBackground(new Color(50, 205, 50));
		btnDeleteTutor_2.setBounds(390, 175, 171, 25);
		panel_5.add(btnDeleteTutor_2);
		
		JPanel panel_7_2 = new JPanel();
		panel_7_2.setLayout(null);
		panel_7_2.setBorder(new LineBorder(SystemColor.menu, 50, true));
		panel_7_2.setBackground(Color.WHITE);
		panel_7_2.setBounds(585, 47, 181, 72);
		panel_5.add(panel_7_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-tutor-48.png")));
		lblNewLabel_3_2.setBounds(10, 10, 48, 54);
		panel_7_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Total Tutors");
		lblNewLabel_1_2_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2_3.setBounds(68, 10, 91, 17);
		panel_7_2.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_2_1_2 = new JLabel(count.TutorCount());
		lblNewLabel_2_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 38));
		lblNewLabel_2_1_2.setBounds(68, 24, 81, 40);
		panel_7_2.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tutor");
		lblNewLabel_1_2_1_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_1_2_1_1.setBounds(42, 60, 58, 31);
		panel_5.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("\"Teaching kids to count is fine, but teaching them what counts is best.\"");
		lblNewLabel_4_2_1.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		lblNewLabel_4_2_1.setBounds(42, 88, 438, 31);
		panel_5.add(lblNewLabel_4_2_1);
		
		JLabel lblNewLabel_1_4_2_2 = new JLabel("Search Tutors");
		lblNewLabel_1_4_2_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1_4_2_2.setBounds(582, 151, 110, 24);
		panel_5.add(lblNewLabel_1_4_2_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(42, 231, 732, 375);
		panel_2.add(scrollPane_1);
		
		std_table = new JTable();
		std_table.setFont(new Font("Arial", Font.PLAIN, 14));
		std_table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Student Name", "Email", "Phone.NO", "Course", "Year"
			}
		));
		std_table.getColumnModel().getColumn(0).setPreferredWidth(24);
		std_table.getColumnModel().getColumn(0).setMaxWidth(40);
		std_table.getColumnModel().getColumn(1).setPreferredWidth(96);
		std_table.getColumnModel().getColumn(1).setMinWidth(51);
		std_table.getColumnModel().getColumn(2).setPreferredWidth(140);
		std_table.getColumnModel().getColumn(2).setMaxWidth(20000);
		std_table.getColumnModel().getColumn(3).setPreferredWidth(90);
		std_table.getColumnModel().getColumn(3).setMaxWidth(90);
		std_table.getColumnModel().getColumn(4).setPreferredWidth(92);
		std_table.getColumnModel().getColumn(5).setPreferredWidth(31);
		std_table.getColumnModel().getColumn(5).setMaxWidth(70);
		scrollPane_1.setViewportView(std_table);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new LineBorder(SystemColor.menu, 50, true));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(585, 47, 181, 72);
		panel_2.add(panel_8);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-student-48.png")));
		lblNewLabel_4.setBounds(10, 10, 48, 54);
		panel_8.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_3 = new JLabel("Total Students");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(68, 8, 91, 17);
		panel_8.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_2 = new JLabel(count.StudentCount());
		lblNewLabel_2_2.setFont(new Font("Bahnschrift", Font.BOLD, 38));
		lblNewLabel_2_2.setBounds(68, 23, 81, 49);
		panel_8.add(lblNewLabel_2_2);
		
		JTextField std_search = new JTextField();
		std_search.setBorder(new LineBorder(new Color(0, 0, 0)));
		std_search.setFont(new Font("Arial", Font.PLAIN, 12));
		std_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) std_table.getModel();
				TableRowSorter<DefaultTableModel> model1 = new TableRowSorter<>(model);
				
				table.setRowSorter(model1);
				model1.setRowFilter(RowFilter.regexFilter(std_search.getText()));
			}
		});
		std_search.setColumns(10);
		std_search.setBounds(582, 175, 198, 25);
		panel_2.add(std_search);
		
		JButton btnAddTutor_2_1 = new JButton("Add Student");
		btnAddTutor_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String verify = mode.getText();
				if(verify.equals("Admin Dashboard")) {
					AddStudent edit = new AddStudent();
					edit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Access Denied!", "Access Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddTutor_2_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-add-24.png")));
		btnAddTutor_2_1.setForeground(Color.WHITE);
		btnAddTutor_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnAddTutor_2_1.setBackground(new Color(50, 205, 50));
		btnAddTutor_2_1.setBounds(42, 175, 151, 25);
		panel_2.add(btnAddTutor_2_1);
		
		JButton btnEditTutor_2_1 = new JButton("Edit Student");
		btnEditTutor_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String verify = mode.getText();
				if(verify.equals("Admin Dashboard")) {
					EditStudent edit = new EditStudent();
					edit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Access Denied!", "Access Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEditTutor_2_1.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-edit-24.png")));
		btnEditTutor_2_1.setForeground(Color.WHITE);
		btnEditTutor_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnEditTutor_2_1.setBackground(new Color(50, 205, 50));
		btnEditTutor_2_1.setBounds(218, 175, 151, 25);
		panel_2.add(btnEditTutor_2_1);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Student");
		lblNewLabel_1_2_1_2.setForeground(SystemColor.windowBorder);
		lblNewLabel_1_2_1_2.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_1_2_1_2.setBounds(42, 60, 83, 31);
		panel_2.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("“Teachers can open the door, but you must enter it yourself.”");
		lblNewLabel_4_2_2.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		lblNewLabel_4_2_2.setBounds(42, 88, 374, 31);
		panel_2.add(lblNewLabel_4_2_2);
		
		JLabel lblNewLabel_1_4_2_3 = new JLabel("Search Student");
		lblNewLabel_1_4_2_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1_4_2_3.setBounds(582, 148, 113, 24);
		panel_2.add(lblNewLabel_1_4_2_3);
		
		JButton btnAddTutor_2_1_1 = new JButton("Add Marks");
		btnAddTutor_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String verify = mode.getText();
				if(verify.equals("Admin Dashboard") || verify.equals("Tutor Dashboard")) {
					CreateResult edit = new CreateResult();
					edit.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Access Denied!", "Access Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddTutor_2_1_1.setForeground(Color.WHITE);
		btnAddTutor_2_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnAddTutor_2_1_1.setBackground(new Color(255, 0, 0));
		btnAddTutor_2_1_1.setBounds(42, 129, 151, 25);
		panel_2.add(btnAddTutor_2_1_1);
		
		JButton btnAddTutor_2_1_1_1 = new JButton("View Progress");
		btnAddTutor_2_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnAddTutor_2_1_1_1.setForeground(Color.WHITE);
		btnAddTutor_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		btnAddTutor_2_1_1_1.setBackground(Color.RED);
		btnAddTutor_2_1_1_1.setBounds(399, 175, 151, 25);
		panel_2.add(btnAddTutor_2_1_1_1);
		DefaultTableModel model = (DefaultTableModel)std_table.getModel();
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(42, 231, 738, 375);
		panel_1.add(scrollPane_4);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Arial", Font.PLAIN, 14));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Student Name", "Module", "Percentage", "Grade"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(32);
		table_2.getColumnModel().getColumn(0).setMaxWidth(32);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(180);
		table_2.getColumnModel().getColumn(1).setMaxWidth(180);
		table_2.getColumnModel().getColumn(2).setPreferredWidth(202);
		table_2.getColumnModel().getColumn(2).setMaxWidth(1000000);
		table_2.getColumnModel().getColumn(3).setPreferredWidth(65);
		table_2.getColumnModel().getColumn(3).setMaxWidth(65);
		table_2.getColumnModel().getColumn(4).setPreferredWidth(40);
		table_2.getColumnModel().getColumn(4).setMaxWidth(40);
		scrollPane_4.setViewportView(table_2);
		
		JLabel lblNewLabel_4_2_4 = new JLabel("\"Success is the sum of small efforts - repeated day in and day out\" ");
		lblNewLabel_4_2_4.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		lblNewLabel_4_2_4.setBounds(45, 88, 416, 31);
		panel_1.add(lblNewLabel_4_2_4);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 0, 0));
		panel_10.setBounds(45, 36, 271, 42);
		panel_1.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("Report Card of Students");
		lblNewLabel_1_2_1_3.setBounds(10, 10, 258, 26);
		panel_10.add(lblNewLabel_1_2_1_3);
		lblNewLabel_1_2_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2_1_3.setFont(new Font("Arial", Font.BOLD, 22));
		
		JLabel lblNewLabel_1_2_1_4 = new JLabel("Module Wise Progression");
		lblNewLabel_1_2_1_4.setForeground(SystemColor.windowBorder);
		lblNewLabel_1_2_1_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_2_1_4.setBounds(42, 199, 227, 31);
		panel_1.add(lblNewLabel_1_2_1_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Student Name:");
		lblNewLabel_1_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(42, 125, 113, 20);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Course:");
		lblNewLabel_1_4_1.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1_4_1.setBounds(42, 163, 63, 20);
		panel_1.add(lblNewLabel_1_4_1);
		
		JLabel result_name = new JLabel("");
		result_name.setFont(new Font("Arial", Font.PLAIN, 14));
		result_name.setBounds(156, 123, 176, 20);
		panel_1.add(result_name);
		
		JLabel result_course = new JLabel("");
		result_course.setFont(new Font("Arial", Font.PLAIN, 14));
		result_course.setBounds(105, 159, 320, 20);
		panel_1.add(result_course);
		
		JLabel result_status = new JLabel("");
		result_status.setForeground(new Color(255, 0, 0));
		result_status.setFont(new Font("Arial", Font.PLAIN, 14));
		result_status.setBounds(494, 199, 176, 20);
		panel_1.add(result_status);
		
		search_report = new JTextField();
		search_report.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) table_2.getModel();
				TableRowSorter<DefaultTableModel> model1 = new TableRowSorter<>(model);
				
				table_2.setRowSorter(model1);
				model1.setRowFilter(RowFilter.regexFilter(search_report.getText()));
				String search = search_report.getText();
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					java.sql.Statement st = con.createStatement();
					
					String sql2 = "Select username, Course, status from students";
					ResultSet rs2 = st.executeQuery(sql2);
					while(rs2.next()) {
						String name = rs2.getString(1);
						String course = rs2.getString(2);
						String stat = rs2.getString(3);
						if(name.equals(search)) {
							result_name.setText(name);
							result_course.setText(course);
							result_status.setText(stat);
							break;
						}
					}
					
					String sql = "Select * from result where Student_name= '"+search+"'";
					ResultSet rs = st.executeQuery(sql);
					DefaultTableModel model2 = (DefaultTableModel) table_2.getModel();
					
					String id, std_name, mod, per, gp;
					while(rs.next()) {
						id = rs.getString(1);
						std_name = rs.getString(2);
						mod = rs.getString(3);
						per = rs.getString(4);
						gp = rs.getString(5);
						String[] row = {id, std_name, mod, per, gp};
						model2.addRow(row);
					}
					
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		search_report.setFont(new Font("Arial", Font.PLAIN, 14));
		search_report.setColumns(10);
		search_report.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		search_report.setBounds(506, 151, 246, 36);
		panel_1.add(search_report);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Search Student");
		lblNewLabel_1_4_2.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1_4_2.setBounds(506, 125, 113, 24);
		panel_1.add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("Status:");
		lblNewLabel_1_4_3.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1_4_3.setBounds(442, 201, 50, 20);
		panel_1.add(lblNewLabel_1_4_3);
		
		String[] std = {"Processing", "Pass", "Fail"};
		JComboBox status = new JComboBox(std);
		status.setBounds(506, 90, 101, 21);
		panel_1.add(status);
		status.setVisible(false);
		
		JLabel lblNewLabel_1_4_4 = new JLabel("Update Status:");
		lblNewLabel_1_4_4.setFont(new Font("Bahnschrift", Font.PLAIN, 16));
		lblNewLabel_1_4_4.setBounds(506, 64, 113, 20);
		panel_1.add(lblNewLabel_1_4_4);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String sta = status.getSelectedItem().toString();
				String name = search_report.getText();
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					java.sql.Statement st = con.createStatement();
					String sql = "Update students SET status = '"+sta+"' where username = '"+name+"'";
					st.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Status Updated!", "status", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(50, 205, 50));
		btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 12));
		btnNewButton_2.setBounds(639, 90, 85, 21);
		panel_1.add(btnNewButton_2);
		lblNewLabel_1_4_4.setVisible(false);
		btnNewButton_2.setVisible(false);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.menu);
		panel_6.setBounds(0, 0, 233, 668);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnNewButton = new JButton("   Dashboard");
		btnNewButton.setForeground(new Color(105, 105, 105));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(SystemColor.menu);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-dashboard-24.png")));
		btnNewButton.setBounds(39, 169, 159, 40);
		panel_6.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnCourses = new JButton("   Courses");
		btnCourses.setForeground(new Color(105, 105, 105));
		btnCourses.setBackground(SystemColor.menu);
		btnCourses.setBorderPainted(false);
		btnCourses.setBorder(null);
		btnCourses.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-course-32.png")));
		btnCourses.setBounds(39, 232, 146, 40);
		panel_6.add(btnCourses);
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root","");
			java.sql.Statement st =  con.createStatement();
			String query = "Select * from courses";
			ResultSet rs = st.executeQuery(query);
			DefaultTableModel model1 = (DefaultTableModel)table.getModel();
			
			String ID, CourseName, Seats, Batch, Years;
			while(rs.next()) {
				ID = rs.getString(1);
				CourseName = rs.getString(2);
				Batch = rs.getString(3);
				Seats = rs.getString(4);
				Years = rs.getString(5);
				String[] rows = {ID, CourseName, Batch, Seats, Years};
				model1.addRow(rows);
			}
			con.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnCourses.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		
		btnCourses.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnResult = new JButton("    Result");
		btnResult.setBackground(SystemColor.menu);
		btnResult.setBorder(null);
		btnResult.setBorderPainted(false);
		btnResult.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-report-card-30.png")));
		btnResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnResult.setForeground(new Color(105, 105, 105));
		btnResult.setBounds(39, 437, 134, 40);
		panel_6.add(btnResult);
		btnResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(4);
				String ch = mode.getText();
				if(ch.equals("Admin Dashboard")) {
					status.setVisible(true);
					lblNewLabel_1_4_4.setVisible(true);
					btnNewButton_2.setVisible(true);
				}
			}
		});
		btnResult.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnTutors = new JButton("   Tutors");
		btnTutors.setForeground(new Color(105, 105, 105));
		btnTutors.setBackground(SystemColor.menu);
		btnTutors.setBorderPainted(false);
		btnTutors.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-teacher-32.png")));
		btnTutors.setBounds(39, 307, 134, 34);
		panel_6.add(btnTutors);
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					java.sql.Statement st = con.createStatement();
					String sql = "Select id, username, email, phone, module from tutors";
					ResultSet rs = st.executeQuery(sql);
					DefaultTableModel model1 = (DefaultTableModel) tutor_table.getModel();
					
					String id, username, email, phone, module;
					while(rs.next()) {
						id = rs.getString(1);
						username = rs.getString(2);
						email = rs.getString(3);
						phone = rs.getString(4);
						module = rs.getString(5);
						String[] rows = {id, username, email, phone, module};
						model1.addRow(rows);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		btnTutors.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnTutors.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnStudents = new JButton("   Students");
		btnStudents.setForeground(new Color(105, 105, 105));
		btnStudents.setBackground(SystemColor.menu);
		btnStudents.setBorderPainted(false);
		btnStudents.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-student-34.png")));
		btnStudents.setBounds(32, 373, 159, 34);
		panel_6.add(btnStudents);
		
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root","");
					java.sql.Statement st =  con.createStatement();
					String query = "Select id, username, email, phone, Course, Years from students";
					ResultSet rs = st.executeQuery(query);
					
					String id, username, email, course, phone, years;
					while(rs.next()) {
						id = rs.getString(1);
						username = rs.getString(2);
						email = rs.getString(3);
						phone = rs.getString(4);
						course = rs.getString(5);
						years = rs.getString(6);
						String[] rows = {id, username, email,phone, course, years};
						model.addRow(rows);
					}
					con.close();
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		btnStudents.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnStudents.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnLogout = new JButton("   LogOut");
		btnLogout.setForeground(new Color(105, 105, 105));
		btnLogout.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/icons8-logout-32.png")));
		btnLogout.setBackground(SystemColor.menu);
		btnLogout.setBorderPainted(false);
		btnLogout.setBounds(39, 559, 142, 40);
		panel_6.add(btnLogout);
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int res  = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?", "Confirm Message", JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION) {
					String name = getDashboard_name().getText();
					Login l = new Login();
					String m = mode.getText();
					if(m.equals("Student Dashboard")) {
						Activity a = new Activity(m.substring(0,7)+ ": " + name, "logged out");
					}
					else {
						Activity a = new Activity(m.substring(0,6)+ ": " + name, "logged out");
					}
					
					l.setVisible(true);
					dispose();
				}
			}
		});
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("C");
		lblNewLabel_4_1_1_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_4_1_1_1.setFont(new Font("Arial", Font.BOLD, 34));
		lblNewLabel_4_1_1_1.setBounds(32, 74, 34, 38);
		panel_6.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("M");
		lblNewLabel_4_1_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_4_1_1.setFont(new Font("Informal Roman", Font.BOLD | Font.ITALIC, 38));
		lblNewLabel_4_1_1.setBounds(98, 63, 49, 54);
		panel_6.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("S");
		lblNewLabel_4_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel_4_1.setBounds(180, 61, 43, 59);
		panel_6.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Dashboard.class.getResource("/Images/HCK-transformed.png")));
		lblNewLabel_2.setBounds(10, 5, 188, 59);
		panel_6.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(-19, 547, 264, 2);
		panel_6.add(btnNewButton_1);
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		session.close();
		sessionFactory.close();
	}

	public JTextField getDashboard_name() {
		return dashboard_name;
	}

	public void setDashboard_name(JTextField dashboard_name) {
		this.dashboard_name = dashboard_name;
	}
}
