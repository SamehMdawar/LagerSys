package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import actionListener_interface.ProductActionListener;
import database.DbConnection;
import objekten_database_action.CategoryAction;
import objekten_database_action.CategoryObjekt;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Category Oberfläche
 * @author Sam
 *
 */
public class Category extends JPanel {
	private JTextField txtId;
	private JTextField txtName;
	private JTable table;
	private JTable table_1;
	private JButton btnDel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_3;
	
	private CategoryObjekt category;
	private CategoryAction catFunction;
	private Connection con;

	public Category() {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.addKeyListener(new KeyAdapter() {
			/**
			 * Validate textfield
			 * Es ist nur die Dateneingabe von Integer zahlen zulässig
			 * else : Das Event wird nicht gesendet oder verarbeitet.
			 * @param e
			 */
			@Override
			public void keyTyped(KeyEvent e) {
				char  k_code = e.getKeyChar();
			      if((Character.isDigit(k_code))) {
			    	  txtId.setText(txtId.getText());
			      }else {
			    	   e.consume();
			      	   JOptionPane.showMessageDialog(null,"Bitte geben Sie nur Zahlen ein","Falsche Eingabe", JOptionPane.PLAIN_MESSAGE);
			      }
			}
		});

		txtId.setBounds(74, 43, 86, 20);
		add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		
		txtName.addKeyListener(new KeyAdapter() {
			/**
			 *  Validate textfield
			 * Es ist nur die Dateneingabe von Buchstabe und Leerzeichen zulässig.
			 * else : Das Event wird nicht gesendet oder verarbeitet.
			 */
			@Override
			public void keyTyped(KeyEvent e) {
				char  k_code = e.getKeyChar();
			      if((Character.isAlphabetic(k_code) || Character.isSpaceChar(k_code) ))
			    	  txtName.setText(txtName.getText());
			       else
			    	   e.consume();
			}
		});
		
		txtName.setColumns(10);
		txtName.setBounds(74, 74, 86, 20);
		add(txtName);
		
		JLabel lblNewLabel = new JLabel("ID :");
		lblNewLabel.setBounds(22, 46, 46, 14);
		add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(22, 77, 46, 14);
		add(lblName);
		
		JButton btnAdd = new JButton("Insert New");
		
		btnAdd.addActionListener(new ActionListener() {
			/**
			 * Insert Daten in Datenbank Tabelle und Tabelle auf Oberfläche
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				category=new CategoryObjekt();
				catFunction=new CategoryAction();
				
				if (txtName.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Name ist leer!","Name", JOptionPane.CANCEL_OPTION);
				}else {
					category.setName(txtName.getText());
					catFunction.add(category);
					
					txtName.setText("");
					showDataTable() ;
				}
			}
		});

		btnAdd.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAdd.setBounds(220, 42, 89, 52);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		
		btnUpdate.addActionListener(new ActionListener() {
			/**
			 * aktualisiert den angegebenen Datensatz basierend auf der ID.
			 */
			public void actionPerformed(ActionEvent e) {
				
				catFunction=new CategoryAction();
				if(txtId.getText().equals("") || txtName.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Input Box ist leer!","Id und Name", JOptionPane.CANCEL_OPTION);
				}else {
					category =new CategoryObjekt(Integer.parseInt(txtId.getText()),txtName.getText());
					catFunction.update(category);
					txtId.setText("");
					txtName.setText("");
					showDataTable() ;
				}
			}
		});

		btnUpdate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUpdate.setBounds(329, 42, 89, 52);
		add(btnUpdate);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 167, 368, 374);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int s=table.getSelectedRow();
				txtId.setText(model.getValueAt(s, 0).toString());
				txtName.setText(model.getValueAt(s, 1).toString());
	
			}
		});
		showDataTable();
		scrollPane.setViewportView(table);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(400, 167, 218, 374);
		add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		btnDel = new JButton("Delete");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				catFunction=new CategoryAction();
				if(txtId.getText().equals("") || txtName.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Input Box ist leer!","Id und Name", JOptionPane.CANCEL_OPTION);
				}else {
					catFunction.deleteById(Integer.parseInt(txtId.getText()));
					txtId.setText("");
					txtName.setText("");
					showDataTable() ;
				}
			}
		});

		btnDel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDel.setBounds(442, 42, 89, 52);
		add(btnDel);
		
		lblNewLabel_1 = new JLabel("Category List:");
		lblNewLabel_1.setBounds(22, 142, 101, 14);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Products List in Category:");
		lblNewLabel_2.setBounds(401, 142, 194, 14);
		add(lblNewLabel_2);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(new Color(0, 128, 192));
		panel.setForeground(new Color(192, 192, 192));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 103, 609, 6);
		add(panel);
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setForeground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(0, 128, 192));
		panel_1.setBounds(10, 584, 609, 6);
		add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setForeground(Color.LIGHT_GRAY);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(0, 128, 192));
		panel_2.setBounds(10, 0, 620, 6);
		add(panel_2);
		
		lblNewLabel_3 = new JLabel("Category");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(22, 8, 90, 20);
		add(lblNewLabel_3);
		showProductTable();

	}
	
	/**
	 *Daten werden hier in Tabelle angezeigt
	 */
	private void showDataTable() {
		String id;
		String name;
		DefaultTableModel tableView;
		tableView=new DefaultTableModel();
		table.setModel(tableView);
		tableView.addColumn("Id");
		tableView.addColumn("Name");
		 con=DbConnection.getConnection();
		 String sql="SELECT * FROM category";
		 PreparedStatement pstmt;
		 ResultSet rs;
		 try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				name=rs.getString("name");
				id =rs.getString("id");
				tableView.addRow(new Object[] {id,name});
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void showProductTable() {
		String name;
		DefaultTableModel tableView;
		tableView=new DefaultTableModel();
		table_1.setModel(tableView);
		tableView.addColumn("Name");
		 con=DbConnection.getConnection();
		 String sql="SELECT name FROM products";
		 PreparedStatement pstmt;
		 ResultSet rs;
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {			
				name=rs.getString("name");
				
				tableView.addRow(new Object[] {name});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
