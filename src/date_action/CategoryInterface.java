package date_action;
import java.util.ArrayList;
import objekten.CategoryObjekt;
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
