package actionListener_interface;
import java.util.ArrayList;

import objekten_database_action.CategoryObjekt;
/**
 * Interface Klasse für "Category" Oberfläche,
 * die in CategoryAction.java verwendet
 * @author Sam
 */
public interface CategoryInterface {
	
	ArrayList<CategoryObjekt>findAll();
	
	void add(CategoryObjekt category);
	
	void deleteById(int id);
	
	void update(CategoryObjekt category);
	
}
