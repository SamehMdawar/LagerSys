package gui;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class copy {
	
	
	public void connNew(String name) {
	//con=new Connection();
	String dbUrl = "jdbc:mysql://localhost:3306/Lagersys";
	String userName="root";
	String pass="";
	
	
	Connection con;
	
	try {
		con = DriverManager.getConnection(dbUrl,userName,pass);
	
	
	
		String sql ="INSERT INTO category(name) VALUES (?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,name);
		pstmt.execute();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
}
