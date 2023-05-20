package actionListener_interface;
import java.util.ArrayList;

import objekten_database_action.ProductObjekt;
/**
 * Interface Klasse für "Product" Oberfläche,
 * die in ProductAction.java verwendet
 * @author Sam
 *
 */
public interface ProductInterface {
	
	ArrayList<ProductObjekt>findAll();
	void add(ProductObjekt product);
	void update(ProductObjekt product);
	void delete(int id);

}
