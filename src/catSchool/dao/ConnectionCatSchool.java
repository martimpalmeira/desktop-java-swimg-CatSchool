package catSchool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCatSchool {

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/catSchool";

	private static final String USERNAME = "root";

	private static final String PASSWORD = "venha2021";

	public Connection getConnection(){
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			 con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return con;
		
		
	}
}
