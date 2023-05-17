package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import database.DbConnection;
import date_action.OrderActionListener;
import objekten.OrderAction;

public class Order extends JPanel{
	private JPanel panel;
	private JTextField txtid;
	private JTextField txtPrice;
	private JTextField txtTotal;
	private JTable table;
	private JComboBox comboPro;
	private JComboBox comboCustomer;
	private Connection con;
	private JTextField txtqty;
	private DefaultTableModel tableView;
	
	private String[] columnNames = {"Id", "Order Nr.", "Gesamtpreis", "Datum"};
	private String[] columnItemsNames = {"Id", "Product","Qty","Price", "Gesamtpreis"};
	
	private JTable table2;
	
	public Order() {
		LocalDateTime dtm = LocalDateTime.now();  
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 25, 612, 271);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order Nr.");
		lblNewLabel.setBounds(20, 46, 76, 14);
		panel.add(lblNewLabel);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setBounds(20, 74, 76, 14);
		panel.add(lblProduct);
		
		JLabel lblCustomer = new JLabel("Customer");
		lblCustomer.setBounds(20, 106, 76, 14);
		panel.add(lblCustomer);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(20, 138, 76, 14);
		panel.add(lblDate);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(20, 202, 76, 14);
		panel.add(lblPrice);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(20, 234, 76, 14);
		panel.add(lblTotal);
		
		JLabel lblNewLabel_1 = new JLabel("New Order");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 11, 74, 14);
		panel.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.setBounds(120, 46, 193, 20);
		panel.add(txtid);
		txtid.setColumns(10);
		//txtid.setEditable(false);
		
		JComboBox comboPro = new JComboBox();
		comboPro.setBounds(120, 74, 193, 22);
		panel.add(comboPro);
		//comboPro.setEditable(false);
		addProduct2Box(comboPro);
		
		JComboBox comboCustomer = new JComboBox();
		comboCustomer.setBounds(120, 106, 193, 22);
		panel.add(comboCustomer);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(120, 202, 193, 20);
		panel.add(txtPrice);
		txtPrice.setColumns(10);
		
		
		txtTotal = new JTextField();
		txtTotal.setBounds(120, 234, 193, 20);
		panel.add(txtTotal);
		txtTotal.setColumns(10);
		
		
		JButton btnAdd = new JButton("Add Item");
	
		
		btnAdd.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAdd.setBounds(461, 43, 123, 33);
		panel.add(btnAdd);
		
		JButton btnNewOrder = new JButton("New Order");
	
		btnNewOrder.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewOrder.setBounds(461, 163, 123, 33);
		panel.add(btnNewOrder);
		
		JButton btnPayOrder = new JButton("Pay / Order now");
		btnPayOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Print 2 Tabelle auf dem Papier
				 */
				
				MessageFormat headerItem=new MessageFormat("Order Items");
				MessageFormat footer=new MessageFormat("Sameh Mdawar - cbm GmbH Bremen");
				try {
					table.print(JTable.PrintMode.FIT_WIDTH, headerItem, footer);
					
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPayOrder.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPayOrder.setBounds(461, 224, 123, 36);
		panel.add(btnPayOrder);
		
		JButton btnDeleteItems = new JButton("Delete Item");
		btnDeleteItems.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDeleteItems.setBounds(461, 102, 123, 33);
		panel.add(btnDeleteItems);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(358, 46, 10, 214);
		panel.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setForeground(Color.LIGHT_GRAY);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(new Color(0, 128, 192));
		panel_2.setBounds(6, 0, 620, 6);
		add(panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(10, 505, 612, 216);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 592, 169);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int s=table.getSelectedRow();
				
				txtid.setText(model.getValueAt(s, 0).toString());
				comboPro.setSelectedIndex(s);
				txtqty.setText(model.getValueAt(s, 2).toString());
				txtPrice.setText(model.getValueAt(s, 3).toString());
				txtTotal.setText(model.getValueAt(s, 4).toString());
							
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Order Items");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 11, 84, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Order");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_3.setBounds(267, 8, 90, 14);
		add(lblNewLabel_3);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1_1.setBounds(10, 307, 612, 199);
		add(panel_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 36, 592, 152);
		panel_1_1.add(scrollPane_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd.MM.yyyy");
        
        Date date=new Date();
        dateChooser.setDate(date);
		
		dateChooser.setBounds(120, 138, 193, 20);
		panel.add(dateChooser);
		
		table2 = new JTable();
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table2.getModel();
				int s=table2.getSelectedRow();
				System.out.println(s);
				txtid.setText(model.getValueAt(s, 1).toString());
				System.out.println(txtid.getText());
				txtTotal.setText(model.getValueAt(s, 2).toString());
				OrderAction filter = new OrderAction();
				filter.itemfilter(txtid,table);
				//Das Zeile kommt aus https://www.youtube.com/watch?v=-P4RN45wyh0
				((JTextField)dateChooser.getDateEditor().getUiComponent()).setText(model.getValueAt(s, 3).toString());
				//
				
	
			}
		});
		scrollPane_1.setViewportView(table2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Orders");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(10, 11, 84, 14);
		panel_1_1.add(lblNewLabel_2_1);
		
		addCustomer2Box(comboCustomer);
		
		txtqty = new JTextField();
		
		txtqty.setColumns(10);
		txtqty.setBounds(120, 171, 193, 20);
		panel.add(txtqty);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setBounds(20, 171, 76, 14);
		panel.add(lblQty);
		
		
		

		//SimpleDateFormat sdf=new SimpleDateFormat();
		//String date=sdf.format(dateChooser.getDate());
		
		/*
		 * ActionListener für Button
		 */
		OrderActionListener newOrder=new OrderActionListener(btnNewOrder,txtid,comboPro,comboCustomer,dateChooser,txtqty,txtPrice,txtTotal);
		btnNewOrder.addActionListener(newOrder);
		
		OrderActionListener newItem=new OrderActionListener(btnNewOrder,txtid,comboPro,comboCustomer,dateChooser,txtqty,txtPrice,txtTotal);
		btnAdd.addActionListener(newItem);
		showItemsIntable();
		showDataIntable();
	}
	
	private void addProduct2Box(JComboBox comboPro) {
		con = DbConnection.getConnection();
		String sql="SELECT * FROM products";
		PreparedStatement pstmt;
		try {
			pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
	
				comboPro.addItem(rs.getString("name"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void addCustomer2Box(JComboBox comboCustomer) {
		con = DbConnection.getConnection();
		String sql="SELECT * FROM customer";
		PreparedStatement pstmt;
		try {
			pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
	
				comboCustomer.addItem(rs.getString("id")+"-"+rs.getString("fname"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void showDataIntable() {
		String id;
		String order_no;
		String gesamtpreis;
		String datum;
		
		tableView=new DefaultTableModel();
		table2.setModel(tableView);
		for(String n:columnNames) {
			tableView.addColumn(n);
		}
		con=DbConnection.getConnection();
		String sql="SELECT id,order_no,total,datum FROM orders";
		PreparedStatement pstmt;
		ResultSet rs ;
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				id=rs.getString("id");
				order_no=rs.getString("order_no");
				gesamtpreis=rs.getString("total");
				datum=rs.getString("datum");
				tableView.addRow(new Object[] {id,order_no,gesamtpreis,datum});
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void showItemsIntable() {
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
		con=DbConnection.getConnection();
		String sql="SELECT id,product,qty,total,price FROM order_detail";
		PreparedStatement pstmt;
		ResultSet rs ;
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			
			while(rs.next()) {
				id=rs.getString("id");
				product=rs.getString("product");
				qty=rs.getString("qty");
				gesamtpreis=rs.getString("total");
				price=rs.getString("price");
				
				tableView.addRow(new Object[] {id,product,qty,price,gesamtpreis});
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
