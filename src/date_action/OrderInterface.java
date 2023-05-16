package date_action;

import java.util.ArrayList;

import objekten.OrderObjekt;


public interface OrderInterface {
	ArrayList<OrderObjekt>findAll();
	void addOrder(OrderObjekt order);
	void update(OrderObjekt order);
	void delete(int id);
	void addItem(OrderObjekt order);
	
}
