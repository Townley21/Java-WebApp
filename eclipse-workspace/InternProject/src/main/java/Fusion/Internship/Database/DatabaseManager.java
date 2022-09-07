package Fusion.Internship.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
	
	final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	final static String URL = "jdbc:mysql://localhost:3306/fusiondb?useSSL=false";
	final static String USER = "root";
	final static String PASSWORD = "A5009221356a";
	public static Connection conn = null;
	
	public static Connection openConnection() throws SQLException {
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		}
			catch (Exception e) {
			System.out.println("Unsucessful connection.");
			e.printStackTrace();
		}
		
		return conn;
		
	}
}