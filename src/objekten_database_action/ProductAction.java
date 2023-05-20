package objekten_database_action;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import actionListener_interface.ProductInterface;
import database.DbConnection;
/**
 * Die Class macht die Datenbank function (CRUD) für"Product" Oberfläche und sie implementiert ProductInterface;
 * @author Sam
 *
 */
public class ProductAction implements ProductInterface {

	/**
	 * Die Methode ist noch nicht fertig
	 * Die Methode sucht nach alle Element von Product in Datenbank und fügt Ergebnis in ein Array hinzu.
	 */
	@Override
	public ArrayList<ProductObjekt> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Die Methode fügt einen neuen Product hinzu und speichert ihn in der Datenbank
	 */
	@Override
	public void add(ProductObjekt product) {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
		if(con==null) {
			
			return;
		}
		else {
			String sql="INSERT INTO products(name,supplier_id,price,category_id,qty,total) VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,product.getName());
				pstmt.setInt(2, product.getSupplier_id());
				pstmt.setFloat(3,product.getPrice());
				pstmt.setInt(4, product.getCategory_id());
				pstmt.setInt(5, product.getQty());
				pstmt.setFloat(6, product.getTotal());
				
				pstmt.execute();
				JOptionPane.showMessageDialog(null,"Product wurde hinzugefügt","Add Product", JOptionPane.PLAIN_MESSAGE);
				
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
 * Die Methode aktualisiert den angegebenen Datensatz basierend auf der ID.
 */
	@Override
	public void update(ProductObjekt product) {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
		if(con==null) {
					
			return;
		}
		else {
			String sql="UPDATE products SET name=?,supplier_id=?,price=?,category_id=?,qty=?,total=? WHERE id=?";
			PreparedStatement pstmt;
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, product.getName());
				pstmt.setInt(2, product.getSupplier_id());
				pstmt.setFloat(3,product.getPrice());
				pstmt.setInt(4, product.getCategory_id());
				pstmt.setInt(5, product.getQty());
				pstmt.setFloat(6, product.getTotal());
				pstmt.setInt(7, product.getId());
				JOptionPane.showMessageDialog(null,"Product wurde aktualisiert","Update Product", JOptionPane.PLAIN_MESSAGE);
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
	 * Sie ist für Einen Datensatz Product löschen.
	 */
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}
