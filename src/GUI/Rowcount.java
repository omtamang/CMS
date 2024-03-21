package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Rowcount {
	String CourseCount() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
			java.sql.Statement st = con.createStatement();
			String sql = "Select COUNT(*) as count from courses;";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int count = rs.getInt("count");
				String c = Integer.toString(count);
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	String StudentCount() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
			java.sql.Statement st = con.createStatement();
			String sql = "Select COUNT(*) as count from students;";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int count = rs.getInt("count");
				String c = Integer.toString(count);
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	String TutorCount() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
			java.sql.Statement st = con.createStatement();
			String sql = "Select COUNT(*) as count from tutors;";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int count = rs.getInt("count");
				String c = Integer.toString(count);
				return c;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
