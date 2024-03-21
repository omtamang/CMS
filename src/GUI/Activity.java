package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Activity {
	Activity(String name, String mode) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/course_management_system", "root", "");
			java.sql.Statement st = con.createStatement();
			
			String user = name;
			String activity = mode;
			LocalDateTime now = LocalDateTime.now();
			
			DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.now());
			String d = dayOfWeek.toString();
			String day = d.substring(0,1).toUpperCase() + d.substring(1).toLowerCase();
			
			Month month = Month.of(now.getMonthValue());
			String m = month.toString().toLowerCase();
			String mon = m.substring(0,1).toUpperCase() + m.substring(1).toLowerCase();
			
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");  
		    String formattedDate = now.format(myFormatObj); 
		    
		    String all_in_one = user + " recently " + activity + "."+ " Time: " + day + ", " + mon + " " +now.getYear() + " at "+formattedDate;
		    String sql = "Insert into activity(activity)" + "Values('"+all_in_one+"');";
		    st.execute(sql);
		    con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
