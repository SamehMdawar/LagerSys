package gui;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import database.DbConnection;
import date_action.ProductActionListener;
import objekten.ProductAction;
import objekten.ProductObjekt;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Product Oberfläche
 * @author Sam
 *
 */
public class Product extends JPanel{
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtQty;
	private JTable table;
	private JTextField txtProFindName;
	private JComboBox<String> comboCat;
	private Connection con;
	private ProductObjekt productObjekt;
	private ProductAction productAction;
	private DefaultTableModel tableView;
	private String[] columnNames = {"Id", "Name", "Menge", "Preis", "Gesamtpreis"};
	private JTextField txtId;
	public Product() {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 25, 613, 271);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add new Product");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 126, 14);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 102, 126, 14);
		panel.add(lblName);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(266, 74, 126, 14);
		panel.add(lblCategory);
		
		JLabel lblPricee = new JLabel("Price:");
		lblPricee.setBounds(266, 134, 126, 14);
		panel.add(lblPricee);
		
		JLabel lblQty = new JLabel("Qty:");
		lblQty.setBounds(266, 103, 126, 14);
		panel.add(lblQty);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setBounds(10, 132, 126, 14);
		panel.add(lblSupplier);
		
		txtName = new JTextField();
		txtName.setBounds(85, 102, 126, 20);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(341, 134, 126, 20);
		panel.add(txtPrice);
		
		txtQty = new JTextField();
		txtQty.setColumns(10);
		txtQty.setBounds(341, 103, 126, 20);
		panel.add(txtQty);
		
		JComboBox comboSupplier = new JComboBox();
		comboSupplier.setBounds(85, 132, 126, 22);
		panel.add(comboSupplier);
		
		JButton btnadd = new JButton("Add");
		
		btnadd.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnadd.setBounds(98, 176, 89, 40);
		panel.add(btnadd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDelete.setBounds(276, 176, 89, 40);
		panel.add(btnDelete);

		
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float total=0;
				productAction=new ProductAction();
				String suppllier = String.valueOf(comboSupplier.getSelectedItem());
				String category = String.valueOf(comboCat.getSelectedItem());
				String[] cats = category.split("-"); // Idnummer vor minus zeichen zurücknehmen
				String catId = cats[0];
				if (txtName.getText().equals("")||txtPrice.getText().equals("")
						||suppllier.equals("")||category.equals("")
						|| txtQty.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Ein Feld ist leer!","Product", JOptionPane.CANCEL_OPTION);
					//System.out.println(category);
				}else {
					total=Float.parseFloat(txtQty.getText())*Float.parseFloat(txtPrice.getText());
					productObjekt =new ProductObjekt(Integer.parseInt(txtId.getText()),txtName.getText(),
							Integer.parseInt(catId),
							Integer.parseInt(catId),//	muss das später zu supplier verändern
							Float.parseFloat(txtPrice.getText()),
							Integer.parseInt(txtQty.getText()),total);
					productAction=new ProductAction();
					productAction.update(productObjekt);
					showDatainTable();
				}
			}
		});
		btnUpdate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUpdate.setBounds(454, 176, 89, 40);
		panel.add(btnUpdate);
		
		comboCat = new JComboBox();
		comboCat.setBounds(339, 71, 126, 22);
		panel.add(comboCat);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(10, 71, 126, 14);
		panel.add(lblId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(85, 71, 126, 20);
		txtId.setEditable(false);
		panel.add(txtId);
		
		addCat2Combobox();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(10, 308, 613, 254);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	
		scrollPane.setBounds(10, 49, 593, 194);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			/**
			 * Es ruft Daten aus dem ausgewählten Tabellendatensatz ab
			 * und fügt die Werte in die Eingabefelder ein
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					int s=table.getSelectedRow();
					txtId.setText(model.getValueAt(s, 0).toString());
					txtName.setText(model.getValueAt(s, 1).toString());
					txtQty.setText(model.getValueAt(s, 2).toString());
					txtPrice.setText(model.getValueAt(s, 3).toString());
			}
		});
		scrollPane.setViewportView(table);
		showDatainTable();
		
		JLabel lblNewLabel_1 = new JLabel("Product name: ");
		lblNewLabel_1.setBounds(10, 24, 104, 14);
		panel_1.add(lblNewLabel_1);
		
		txtProFindName = new JTextField();
		txtProFindName.setBounds(96, 21, 114, 20);
		panel_1.add(txtProFindName);
		txtProFindName.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnClear.setBounds(282, 11, 89, 30);
		panel_1.add(btnClear);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setForeground(Color.LIGHT_GRAY);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(0, 128, 192));
		panel_2.setBounds(6, 0, 620, 6);
		add(panel_2);
		
		/*
		 * ActionListener für Button
		 */
		ProductActionListener del=new ProductActionListener(btnDelete,txtName,comboCat, comboSupplier,txtPrice,txtQty);
		btnDelete.addActionListener(del);
		ProductActionListener add=new ProductActionListener(btnadd,txtName,comboCat, comboSupplier,txtPrice,txtQty);
		btnadd.addActionListener(add);
		
	}
	
	/**
	 * Categorynamen werden aus der Datenbank abgerufen und in Combobox abgelegt.
	 */
	private void addCat2Combobox() {
		comboCat.insertItemAt("0-Sonstige", 0);
		comboCat.setSelectedIndex(0);
		con = DbConnection.getConnection();
		String sql="SELECT * FROM category";
		PreparedStatement pstmt;
		try {
			pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				comboCat.addItem(rs.getString("id")+"-"+ rs.getString("name"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	/**
	 * Daten werden hier in Tabelle angezeigt
	 */
	private void showDatainTable() {
		String id;
		String name;
		String menge;
		String preis;
		String gesamt;
		tableView=new DefaultTableModel();
		table.setModel(tableView);
		for(String n:columnNames) {
			tableView.addColumn(n);
		}
		con=DbConnection.getConnection();
		//columnNames = {"Id", "Name", "Menge", "Preis", "Gesamtpreis"};
		String sql="SELECT id,name,qty,price,total FROM products";
		PreparedStatement pstmt;
		ResultSet rs;
		
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				id=rs.getString("id");
				name=rs.getString("name");
				menge=rs.getString("qty");
				preis=rs.getString("price");
				gesamt=rs.getString("total");
				
				tableView.addRow(new Object[] {id,name,menge,preis,gesamt});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
