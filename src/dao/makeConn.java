package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class makeConn {
	// function to get connection
		public Connection connect(){	
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Connection conn = null;
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost/meet", "root", "");
				return conn;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
}
