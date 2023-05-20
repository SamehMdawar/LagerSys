package actionListener_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import objekten_database_action.OrderAction;
import objekten_database_action.OrderObjekt;
/**
 * Die Class ist als ActionListener für Buttons auf "Order" Oberfläche
 * @author samehm
 *
 */
public class OrderActionListener implements ActionListener{ 
	private JButton button;
	private JTextField txtid;
	private JComboBox comboPro;
	private JComboBox comboCustomer;
	private JDateChooser dateChooser;
	private JTextField txtqty;
	private JTextField txtPrice;
	private JTextField txttotal;
	
	/**
	 * OrderActionListener Konstruktor
	 * @param button
	 * @param txtid
	 * @param comboPro
	 * @param comboCustomer
	 * @param dateChooser
	 * @param txtqty
	 * @param txtPrice
	 * @param txttotal
	 */
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
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	String date=sdf.format(dateChooser.getDate());
	String customer = String.valueOf(comboCustomer.getSelectedItem());
	
	String[] cus = customer.split("-"); // Idnummer vor minus zeichen zurücknehmen
	String cust = cus[0];
	/**
	 * Wenn Sie auf die Button mit dem "New Order" klicken,
	 * wird Folgendes ausgeführt: 
	 */
	if (e.getActionCommand()=="New Order") {
		/**
		 * 1-Erstellen Sie einen Objekt aus der Order,
		 * alle Werte enthält aus der Oberfläche als Parameter beim Aufruf der ActionListener Funktion in der Order Oberfläche und aus Variable
		 * 2-Erstellen Sie einen Objekt aus der OrderAction, um neuen Order bei addOrder Methode zu addieren.
		 * print in Console "Done"
		 */
		OrderObjekt order=new OrderObjekt(0,Integer.parseInt(txtid.getText()),Integer.parseInt(cust),total,date);
		OrderAction orderaction=new OrderAction();
		orderaction.addOrder(order);
		System.out.println("Done");
	}
	/**
	 * Wenn Sie auf die Button mit dem "Add Item" klicken,
	 * wird Folgendes ausgeführt: 
	 */
	if(e.getActionCommand()=="Add Item") {
		/**
		 * 1-Erstellen Sie einen Objekt aus der Order mit new Item Konstruktor,
		 * alle Werte enthält aus der Oberfläche als Parameter beim Aufruf der ActionListener Funktion in der Order Oberfläche und aus Variable
		 * 2-Erstellen Sie einen Objekt aus der OrderAction, um neuen Item zu Order bei addItem Methode zu addieren.
		 * print in Console "Item added Done"
		 */
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
