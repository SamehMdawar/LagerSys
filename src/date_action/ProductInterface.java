package date_action;
import java.util.ArrayList;

import objekten.ProductObjekt;
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
