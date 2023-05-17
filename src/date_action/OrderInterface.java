package date_action;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import objekten.OrderObjekt;
/**
 *  Interface Klasse für "Order" Oberfläche;
 * @author samehm
 *
 */
public interface OrderInterface {
	ArrayList<OrderObjekt>findAll();
	void addOrder(OrderObjekt order);
	void update(OrderObjekt order);
	void delete(int id);
	void addItem(OrderObjekt order);
	void itemfilter(JTextField txtid, JTable table);
	
}
