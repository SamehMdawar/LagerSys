package date_action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import objekten.OrderAction;
import objekten.OrderObjekt;

public class OrderActionListener implements ActionListener{ 
	private JButton button;
	private JTextField txtid;
	private JComboBox comboPro;
	private JComboBox comboCustomer;
	private JDateChooser dateChooser;
	private JTextField txtqty;
	private JTextField txtPrice;
	private JTextField txttotal;
	
	public OrderActionListener(JButton button,JTextField txtid,JComboBox comboPro,JComboBox comboCustomer,JDateChooser dateChooser,JTextField txtqty,JTextField txtPrice,JTextField txttotal) {
		this.button=button;
		this.txtid=txtid;
		this.comboPro=comboPro;
		this.comboCustomer=comboCustomer;
		this.dateChooser=dateChooser;
		this.txtqty=txtqty;
		this.txtPrice=txtPrice;
		this.txttotal=txttotal;
	}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	float total=0;
	float price=0;
	int qty=0;
	String product = String.valueOf(comboPro.getSelectedItem());
	SimpleDateFormat sdf=new SimpleDateFormat();
	String date=sdf.format(dateChooser.getDate());
	//String customer = String.valueOf(comboCustomer.getSelectedItem());
	
	//String[] cus = customer.split("-"); // Idnummer vor minus zeichen zurücknehmen
	//String cust = cus[0];
	if (e.getActionCommand()=="New Order") {
		
		
		OrderObjekt order=new OrderObjekt(0,Integer.parseInt(txtid.getText()),1,total,date);
		OrderAction orderaction=new OrderAction();
		orderaction.addOrder(order);
		System.out.println("Done");
	}
	if(e.getActionCommand()=="Add Item") {
		System.out.println("Items");
		price=Float.parseFloat(txtPrice.getText());
		qty=Integer.parseInt(txtqty.getText());
		total=price*qty;
		
		OrderObjekt item=new OrderObjekt(0,Integer.parseInt(txtid.getText()),product,Integer.parseInt(txtqty.getText()),Float.parseFloat(txtPrice.getText()),total);
		OrderAction orderaction=new OrderAction();
		orderaction.addItem(item);
		System.out.println("Item added Done");
	}
	
}
}
