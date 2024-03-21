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
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class DeleteTutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteTutor frame = new DeleteTutor();
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
	public DeleteTutor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 303);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteTutor = new JLabel("Delete Tutor");
		lblDeleteTutor.setBounds(147, 25, 116, 22);
		lblDeleteTutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteTutor.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(lblDeleteTutor);
		
		id = new JTextField();
		id.setBorder(null);
		id.setBackground(Color.WHITE);
		id.setToolTipText("");
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setForeground(Color.BLACK);
		id.setFont(new Font("Arial", Font.PLAIN, 14));
		id.setColumns(10);
		id.setBounds(164, 106, 132, 10);
		contentPane.add(id);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBackground(new Color(128, 128, 128));
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2.setIcon(new ImageIcon(DeleteTutor.class.getResource("/Images/icons8-id-verified-24.png")));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(111, 106, 43, 17);
		contentPane.add(lblNewLabel_2);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tutor_id = id.getText();
				
				try {
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
					java.sql.Statement st = con.createStatement();
					
					String sql = "Delete from tutors where id = '"+tutor_id+"';";
					
					if((!tutor_id.equals(""))) {
						st.executeUpdate(sql);
						
						JOptionPane.showMessageDialog(null, "Tutor Deleted!", 
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
		delete.setBounds(66, 180, 97, 32);
		contentPane.add(delete);
		
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		cancel.setBackground(new Color(50, 205, 50));
		cancel.setBounds(271, 180, 97, 32);
		contentPane.add(cancel);
		
		JLabel lblNewLabel = new JLabel("______________________");
		lblNewLabel.setBounds(163, 106, 155, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("Enter tutor ID");
		lblNewLabel_4.setFont(new Font("Yu Gothic Light", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(160, 58, 90, 22);
		contentPane.add(lblNewLabel_4);
	}
}
