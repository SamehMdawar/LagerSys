package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static Connection connection;
	
	public static Connection getConnection(){
		String dbUrl="jdbc:mysql://localhost:3306/Lagersys";
		String user="root";
		String pass="";
		
		try {
			connection=DriverManager.getConnection(dbUrl, user, pass);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
				
	}

}
