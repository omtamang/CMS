package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TutorCheck {
	boolean Check(String tutor){
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
			java.sql.Statement st = con.createStatement();
			
			String sql = "Select username from tutors;";
			ResultSet rs = st.executeQuery(sql);
			
			boolean check = false;
			while(rs.next()) {
				String username = rs.getString(1);
				if(username.equals(tutor)) {
					check = true;
				}
			}
			
			if((check)) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
