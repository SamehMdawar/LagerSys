package gui;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import database.DbConnection;
public class Window extends JFrame{
	private DbConnection db;
	private JPanel cards; 
	private Category first;
	private Order order;
	private Costumer costumer;
	private Supplier supplier;
	private Product next;
	private JButton button;
	private JButton button2;
	private JButton btnOrder;
	private JButton btnCustomer;
	private JButton btnUser;
	private JButton btnSupplier;
	private JButton btnSetting;
	private JLabel lblDate;
	private JLabel lblTime;
	
	public Window() {
			/*
			Connection con =DbConnection.getConnection();
			if(con==null) {
				System.out.println("Connection failed!");
			}else {
				System.out.println("Connection Successful");
			}
			*/
		 	this.setSize(800,800);
		 	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setResizable(false);
			this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setTitle("Lager System");
	        getContentPane().setLayout(null);
	        
	        cards = new JPanel();
	        cards.setBounds(144, 23, 630, 727);
	        cards.setLayout(new CardLayout());
	        
	        first=new Category(); //Object Category Panel
	        next=new Product();
	        order=new Order();
	        costumer=new Costumer();
	        supplier=new Supplier();
	       
	        next.setBackground(new Color(240, 240, 240));
	        
	        cards.add(first,"Category"); // Add Category Panel to Cards
	        first.setLayout(null);		 // Set null to layout Category Panel to Cards
	        cards.add(next,"Product");
	        next.setLayout(null);
	        cards.add(order,"Order");
	        order.setLayout(null);
	        cards.add(costumer,"Costumer");
	        costumer.setLayout(null);
	        cards.add(supplier,"Supplier");
	        supplier.setLayout(null);
	        
	        
	        
	        getContentPane().add(cards);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(0, 128, 192));
	        panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        panel.setBounds(10, 23, 124, 727);
	        getContentPane().add(panel);
	        panel.setLayout(null);
	       
	       
	        
	        button2=new JButton("Product");
	        button2.setBorderPainted(false);
	        button2.setForeground(new Color(255, 255, 255));
	        button2.setContentAreaFilled(false);
	        button2.setFont(new Font("Tahoma", Font.BOLD, 14));
	        button2.setBounds(10, 136, 104, 60);
	        panel.add(button2);
	        
	        button=new JButton("Category");
	        button.setBorderPainted(false);
	        button.setForeground(new Color(255, 255, 255));
	        button.setContentAreaFilled(false);
	        button.setFont(new Font("Tahoma", Font.BOLD, 14));
	        button.setHorizontalTextPosition(SwingConstants.CENTER);
	        button.setBounds(10, 38, 104, 60);
	        panel.add(button);
	        
	        btnOrder = new JButton("Order");
	        btnOrder.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		CardLayout c3 = (CardLayout) cards.getLayout();
	        		c3.show(cards, "Order");
	        	}
	        });
	        btnOrder.setBorderPainted(false);
	        btnOrder.setForeground(new Color(255, 255, 255));
	        btnOrder.setContentAreaFilled(false);
	        btnOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
	        btnOrder.setBounds(10, 234, 104, 60);
	        panel.add(btnOrder);
	        
	        btnCustomer = new JButton("Customer");
	        btnCustomer.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		CardLayout c4 = (CardLayout) cards.getLayout();
	        		c4.show(cards, "Costumer");
	        	}
	        });
	        btnCustomer.setBorderPainted(false);
	        btnCustomer.setForeground(new Color(255, 255, 255));
	        btnCustomer.setContentAreaFilled(false);
	        btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
	        btnCustomer.setBounds(10, 332, 104, 60);
	        panel.add(btnCustomer);
	        
	        btnUser = new JButton("User");
	        btnUser.setBorderPainted(false);
	        btnUser.setForeground(new Color(255, 255, 255));
	        btnUser.setContentAreaFilled(false);
	        btnUser.setFont(new Font("Tahoma", Font.BOLD, 14));
	        btnUser.setBounds(10, 528, 104, 60);
	        panel.add(btnUser);
	        
	        btnSupplier = new JButton("Supplier");
	        btnSupplier.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		CardLayout c5=(CardLayout)cards.getLayout();
	        		c5.show(cards, "Supplier");
	        	}
	        });
	        btnSupplier.setBorderPainted(false);
	        btnSupplier.setForeground(new Color(255, 255, 255));
	        btnSupplier.setContentAreaFilled(false);
	        btnSupplier.setFont(new Font("Tahoma", Font.BOLD, 14));
	        btnSupplier.setBounds(10, 430, 104, 60);
	        panel.add(btnSupplier);
	        
	        btnSetting = new JButton("Setting");
	        btnSetting.setBorderPainted(false);
	        btnSetting.setForeground(new Color(255, 255, 255));
	        btnSetting.setContentAreaFilled(false);
	        btnSetting.setFont(new Font("Tahoma", Font.BOLD, 14));
	        btnSetting.setBounds(10, 626, 104, 60);
	        panel.add(btnSetting);
	        
	        lblDate = new JLabel("New label");
	        lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
	        lblDate.setBounds(145, 5, 146, 14);
	         
	        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	        Date date=new Date();
	        String strDate = formatter.format(date);  
	        lblDate.setText("Datum: "+strDate);
	       
	        getContentPane().add(lblDate);
	        
	        lblTime = new JLabel("Datum: 05/11/2023");
	        lblTime.setFont(new Font("Tahoma", Font.BOLD, 12));
	        lblTime.setBounds(675, 5, 146, 14);
	        SimpleDateFormat formattertime = new SimpleDateFormat("hh:mm:ss");
	        long time = date.getTime(); 
	        lblTime.setText("Time: "+formattertime.format(time));
	        
	        getContentPane().add(lblTime);
	        
	        button.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		CardLayout cl = (CardLayout) cards.getLayout();
	        		cl.show(cards, "Category");
	        	}
	        });
	        button2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		CardLayout c2=(CardLayout)cards.getLayout();
	        		c2.show(cards, "Product");
	        	}
	        });
	}
}
