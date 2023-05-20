package objekten_database_action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import actionListener_interface.CategoryInterface;
import database.DbConnection;
/**
 * Die Class macht die Datenbank function (CRUD) für"Category" Oberfläche und sie implementiert CategoryInterface;
 * @author Sam
 *
 */
public class CategoryAction implements CategoryInterface {

/**
 * Die Methode ist noch nicht fertig.
 * Die Methode sucht nach alle Element von Category in Datenbank und fügt Ergebnis in ein Array hinzu. 
 */
	@Override
	public ArrayList<CategoryObjekt> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Die Methode fügt einen neuen Category hinzu und speichert ihn in der Datenbank.
	 *  (Insert neu Category)
	 */
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

	/**
	 * Die Methode ist noch nicht fertig.
	 * Die Methode hier löscht einen Datensatz aus der Category entsprechend der ID
	 */
	@Override
	public void deleteById(int id) {
		Connection con =DbConnection.getConnection();
		if(con==null) {
			return;
		}
		else {
			String sql="DELETE FROM category WHERE id=?";
			PreparedStatement pstmt;
			try {
				pstmt =con.prepareStatement(sql);
				pstmt.setInt(1, id);
				JOptionPane.showMessageDialog(null,"Category wurde gelöscht","Delete Category", JOptionPane.PLAIN_MESSAGE);
				
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

	/**
	 * Die Funktion aktualisiert den angegebenen Datensatz basierend auf der ID.
	 */
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