package date_action;

import java.util.ArrayList;

import objekten.CategoryObjekt;

public interface CategoryInterface {
	
	ArrayList<CategoryObjekt>findAll();
	
	void add(CategoryObjekt category);
	
	void deleteById(int id);
	
	void update(CategoryObjekt category);
	
}
