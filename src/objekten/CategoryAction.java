package objekten;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.DbConnection;
import date_action.CategoryInterface;

public class CategoryAction implements CategoryInterface {
	
	
	@Override
	public ArrayList<CategoryObjekt> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(CategoryObjekt category) {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
		if(con==null) {
			
			return;
		}
		else {
			String sql ="INSERT INTO category(name) VALUES (?)";
			PreparedStatement pstmt;
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,category.getName());
				JOptionPane.showMessageDialog(null,"Category wurde hinzugefügt","Add Category", JOptionPane.PLAIN_MESSAGE);
				pstmt.execute();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				try {
					con.close();
				}catch(SQLException throwables) {
					throwables.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CategoryObjekt category) {
		// TODO Auto-generated method stub
		Connection con =DbConnection.getConnection();
		if(con==null) {
			return;
		}
		else {
			String sql="UPDATE category SET name=? WHERE id=?";
			PreparedStatement pstmt;
			try {
				pstmt =con.prepareStatement(sql);
				pstmt.setString(1, category.getName());
				pstmt.setInt(2,category.getId());
				JOptionPane.showMessageDialog(null,"Category wurde aktualisiert","Update Category", JOptionPane.PLAIN_MESSAGE);
				
				pstmt.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		finally{
			try {
				con.close();
			}catch(SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		
		
		
	}

}
}