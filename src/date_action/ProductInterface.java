package date_action;

import java.util.ArrayList;

import objekten.ProductObjekt;

public interface ProductInterface {
	
	ArrayList<ProductObjekt>findAll();
	void add(ProductObjekt product);
	void update(ProductObjekt product);
	void delete(int id);

}
