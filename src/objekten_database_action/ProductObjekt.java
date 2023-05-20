package objekten_database_action;

/**
 * Class ist für Objekt von Product
 * @author Sam
 *
 */
public class ProductObjekt {
	
	private int id;
	private String name;
	private int category_id;
	private int supplier_id;
	private float price;
	private int qty;
	private float total;
	
	public ProductObjekt() {
		
	}
	/**
	 * new Product Konstruktor
	 * @param id
	 * @param name
	 * @param category_id
	 * @param supplier_id
	 * @param price
	 * @param qty
	 * @param total
	 */
	public ProductObjekt(int id, String name,int category_id,int supplier_id,float price,int qty,float total) {
		this.id=id;
		this.name=name;
		this.category_id=category_id;
		this.supplier_id=supplier_id;
		this.price=price;
		this.qty=qty;
		this.total=total;
	}
	/**
	 * Hier ist Getters und Setters von Product Objekt.
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	
	
		
	
}
