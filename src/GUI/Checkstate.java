package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Checkstate {
	public int login() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
			java.sql.Statement st = con.createStatement();
			String sql = "Select mode from login";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				String mode = rs.getString(1);
				if(mode.equals("Admin")) {
					con.close();
					return 1;
				}
				else {
					con.close();
					return 0;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
