package objekten;







import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.DbConnection;
import date_action.OrderInterface;

public class OrderAction implements OrderInterface{
	
	
	
	@Override
	public ArrayList<OrderObjekt> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addOrder(OrderObjekt order) {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
		if(con==null) {
			
			return;
		}
		else {
			//"INSERT INTO products(name,supplier_id,price,category_id,qty,total) VALUES(?,?,?,?,?,?)";
			String sql="INSERT INTO orders(order_no,customer_id,total,datum) VALUES (?,?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, order.getOrder_id());
				pstmt.setInt(2, order.getCustomer_id());
				pstmt.setFloat(3, order.getTotal());
				pstmt.setString(4, order.getDatum());
				pstmt.execute();
				JOptionPane.showMessageDialog(null,"Order wurde hinzugefügt","Add Order", JOptionPane.PLAIN_MESSAGE);
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
	public void update(OrderObjekt order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addItem(OrderObjekt order) {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
		if(con==null) {
			
			return;
		}
		else {	

			String sql="INSERT INTO order_detail(order_id,product,qty,price,total)VALUES(?,?,?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, order.getOrder_id());
				pstmt.setString(2, order.getProduct());
				pstmt.setInt(3, order.getQty());
				pstmt.setFloat(4, order.getPrice());
				pstmt.setFloat(5, order.getTotal());
				JOptionPane.showMessageDialog(null,"Item wurde hinzugefügt","Add Item", JOptionPane.PLAIN_MESSAGE);
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
	public void itemfilter(JTextField txtid, JTable table) {
		// TODO Auto-generated method stub
	
			String[] columnItemsNames = {"Id", "Product","Qty","Price", "Gesamtpreis"};
			DefaultTableModel tableView;
			String id;
			String product;
			String qty;
			String gesamtpreis;
			String price;

			tableView=new DefaultTableModel();
			table.setModel(tableView);
			for(String n:columnItemsNames) {
				tableView.addColumn(n);
			}
			Connection con=DbConnection.getConnection();
			String sql="SELECT `id`, `order_id`, `product`, `qty`, `total`, `price` FROM `order_detail` WHERE order_id=?";
			PreparedStatement pstmt;
			ResultSet rs ;
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(txtid.getText()));
				rs=pstmt.executeQuery();
				
				
				while(rs.next()) {
					id=rs.getString("id");
					product=rs.getString("product");
					qty=rs.getString("qty");
					gesamtpreis=rs.getString("total");
					price=rs.getString("price");
					
					tableView.addRow(new Object[] {id,product,qty,price,gesamtpreis});

				}
				}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

