package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EditCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField course_id;
	private JTextField course_name;
	private JTextField batch;
	private JTextField year;
	private JTextField seats;
	private JTextField course_search;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCourse frame = new EditCourse();
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
	public EditCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 549);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 301, 530);
		contentPane.add(panel);
		
		course_id = new JTextField();
		course_id.setToolTipText("");
		course_id.setHorizontalAlignment(SwingConstants.LEFT);
		course_id.setForeground(SystemColor.windowText);
		course_id.setFont(new Font("Arial", Font.PLAIN, 14));
		course_id.setColumns(10);
		course_id.setBorder(null);
		course_id.setBounds(93, 141, 133, 12);
		panel.add(course_id);
		
		course_name = new JTextField();
		course_name.setToolTipText("");
		course_name.setHorizontalAlignment(SwingConstants.LEFT);
		course_name.setForeground(new Color(0, 102, 0));
		course_name.setFont(new Font("Arial", Font.PLAIN, 12));
		course_name.setColumns(10);
		course_name.setBorder(null);
		course_name.setBounds(93, 178, 133, 12);
		panel.add(course_name);
		
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
		
		batch = new JTextField();
		batch.setToolTipText("");
		batch.setHorizontalAlignment(SwingConstants.LEFT);
		batch.setForeground(SystemColor.windowText);
		batch.setFont(new Font("Arial", Font.PLAIN, 14));
		batch.setColumns(10);
		batch.setBorder(null);
		batch.setBounds(93, 203, 133, 20);
		panel.add(batch);
		
		year = new JTextField();
		year.setToolTipText("");
		year.setHorizontalAlignment(SwingConstants.LEFT);
		year.setForeground(new Color(0, 102, 0));
		year.setFont(new Font("Arial", Font.PLAIN, 12));
		year.setColumns(10);
		year.setBorder(null);
		year.setBounds(93, 275, 133, 17);
		panel.add(year);
		
		seats = new JTextField();
		seats.setToolTipText("");
		seats.setHorizontalAlignment(SwingConstants.LEFT);
		seats.setForeground(new Color(0, 102, 0));
		seats.setFont(new Font("Arial", Font.PLAIN, 12));
		seats.setColumns(10);
		seats.setBorder(null);
		seats.setBounds(93, 242, 133, 12);
		panel.add(seats);
		
		JLabel ba = new JLabel("Batch");
		ba.setForeground(SystemColor.windowBorder);
		ba.setFont(new Font("Arial", Font.BOLD, 12));
		ba.setBounds(49, 210, 37, 17);
		panel.add(ba);
		
		JLabel as = new JLabel("Seats");
		as.setForeground(SystemColor.windowBorder);
		as.setFont(new Font("Arial", Font.BOLD, 12));
		as.setBounds(49, 240, 37, 17);
		panel.add(as);
		
		JLabel phone = new JLabel("Years");
		phone.setForeground(SystemColor.windowBorder);
		phone.setFont(new Font("Arial", Font.BOLD, 12));
		phone.setBounds(49, 275, 37, 17);
		panel.add(phone);
		
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
		
		JButton edit = new JButton("Edit");
		edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					java.sql.Statement st =  con.createStatement();
					String id, name, ba, sea, y;
					name = course_name.getText();
					id = course_id.getText();
					ba = batch.getText();
					y = year.getText();
					sea = seats.getText();
					
					if((!name.equals(""))&&(!id.equals(""))&&(!ba.equals(""))&&(!sea.equals(""))&&(!y.equals(""))) {
						String sql = "Update courses Set courseName='"+name+"',batch = '"+ba+"', seats ='"+sea+"', no_of_years='"+y+"'Where id = '"+id+"'";
						st.executeUpdate(sql);
						con.close();
						JOptionPane.showMessageDialog(null, "Course Details Edited", 
								"Validation Result", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Empty Fields!", 
								"Error Message", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		edit.setForeground(Color.WHITE);
		edit.setFont(new Font("Tahoma", Font.BOLD, 14));
		edit.setBackground(new Color(50, 205, 50));
		edit.setBounds(38, 386, 97, 32);
		panel.add(edit);
		
		JButton cancel = new JButton("Cancel");
		cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancel.setBackground(new Color(50, 205, 50));
		cancel.setBounds(173, 386, 97, 32);
		panel.add(cancel);
		
		JLabel lblNewLabel_1_2_1_3 = new JLabel("Edit Tutor");
		lblNewLabel_1_2_1_3.setForeground(SystemColor.controlDkShadow);
		lblNewLabel_1_2_1_3.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_2_1_3.setBounds(93, 75, 89, 31);
		panel.add(lblNewLabel_1_2_1_3);
		
		JLabel lblNewLabel_4_1 = new JLabel("Select a row to edit");
		lblNewLabel_4_1.setForeground(SystemColor.windowBorder);
		lblNewLabel_4_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_4_1.setBounds(341, 33, 175, 31);
		contentPane.add(lblNewLabel_4_1);
		
		course_search = new JTextField();
		course_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				TableRowSorter<DefaultTableModel> model1 = new TableRowSorter<>(model);
				
				table.setRowSorter(model1);
				model1.setRowFilter(RowFilter.regexFilter(course_search.getText()));
			}
		});
		course_search.setToolTipText("");
		course_search.setHorizontalAlignment(SwingConstants.LEFT);
		course_search.setForeground(new Color(0, 102, 0));
		course_search.setFont(new Font("Arial", Font.PLAIN, 12));
		course_search.setColumns(10);
		course_search.setBorder(null);
		course_search.setBackground(SystemColor.menu);
		course_search.setBounds(766, 33, 127, 17);
		contentPane.add(course_search);
		
		JLabel lblNewLabel_3 = new JLabel("___________________________");
		lblNewLabel_3.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel_3.setBounds(766, 38, 187, 17);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(EditCourse.class.getResource("/Images/icons8-search-24.png")));
		lblNewLabel_1.setBounds(944, 33, 24, 22);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(341, 93, 627, 392);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Course Name", "Batch", "Seats", "Year"
			}
		));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tbl = (DefaultTableModel) table.getModel();
				
				String iid = tbl.getValueAt(table.getSelectedRow(), 0).toString();
				String c = tbl.getValueAt(table.getSelectedRow(), 1).toString();
				String batc = tbl.getValueAt(table.getSelectedRow(), 2).toString();
				String sea = tbl.getValueAt(table.getSelectedRow(), 3).toString();
				String ye = tbl.getValueAt(table.getSelectedRow(), 4).toString();
				
				course_id.setText(iid);
				course_name.setText(c);
				batch.setText(batc);
				seats.setText(sea);
				year.setText(ye);
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(26);
		table.getColumnModel().getColumn(0).setMaxWidth(26);
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root","");
			java.sql.Statement st =  con.createStatement();
			String query = "Select * from courses";
			ResultSet rs = st.executeQuery(query);
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			
			String ID, CourseName, Seats, Batch, Years;
			while(rs.next()) {
				ID = rs.getString(1);
				CourseName = rs.getString(2);
				Batch = rs.getString(3);
				Seats = rs.getString(4);
				Years = rs.getString(5);
				String[] rows = {ID, CourseName, Batch, Seats, Years};
				model.addRow(rows);
			}
			con.close();
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}
}
}
