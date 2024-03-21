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
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class DeleteCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField course_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCourse frame = new DeleteCourse();
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
	public DeleteCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 329);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteTutor = new JLabel("Delete Course");
		lblDeleteTutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteTutor.setFont(new Font("Arial", Font.BOLD, 18));
		lblDeleteTutor.setBounds(156, 31, 132, 22);
		contentPane.add(lblDeleteTutor);
		
		course_id = new JTextField();
		course_id.setToolTipText("");
		course_id.setHorizontalAlignment(SwingConstants.CENTER);
		course_id.setForeground(Color.BLACK);
		course_id.setFont(new Font("Arial", Font.PLAIN, 14));
		course_id.setColumns(10);
		course_id.setBorder(null);
		course_id.setBackground(Color.WHITE);
		course_id.setBounds(171, 117, 132, 17);
		contentPane.add(course_id);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setIcon(new ImageIcon(DeleteCourse.class.getResource("/Images/icons8-id-verified-24.png")));
		lblNewLabel_2.setForeground(Color.GRAY);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBackground(Color.GRAY);
		lblNewLabel_2.setBounds(118, 124, 43, 17);
		contentPane.add(lblNewLabel_2);
		
		JButton delete = new JButton("Delete");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id = course_id.getText();
				
				try {
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					java.sql.Statement st = con.createStatement();
					
					String sql = "Select id, courseName from courses";
					ResultSet rs = st.executeQuery(sql);
					
					String sql2 = "Delete from courses where id = '"+id+"';";
					
					String courseName, c_id, course = "hello";
					while(rs.next()) {
						c_id = rs.getString(1);
						courseName = rs.getString(2);
						if(c_id.equals(id)) {
							course = courseName;
							break;
						}
					}
					
					String sql3 = "Delete from modules where  CourseName = '"+course+"';";
					
					if((!id.equals(""))) {
						st.executeUpdate(sql2);
						st.executeUpdate(sql3);
						
						JOptionPane.showMessageDialog(null, "Course Deleted!", 
							"Validation Result", JOptionPane.INFORMATION_MESSAGE);
						
						con.close();
					}
					else {
						JOptionPane.showMessageDialog(null, "Enter ID", "Empty Field", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Tahoma", Font.BOLD, 14));
		delete.setBackground(new Color(50, 205, 50));
		delete.setBounds(73, 198, 97, 32);
		contentPane.add(delete);
		
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
		cancel.setBounds(278, 198, 97, 32);
		contentPane.add(cancel);
		
		JLabel lblNewLabel = new JLabel("______________________");
		lblNewLabel.setBounds(170, 124, 155, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Enter Course ID");
		lblNewLabel_4.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(171, 64, 103, 22);
		contentPane.add(lblNewLabel_4);
	}

}
