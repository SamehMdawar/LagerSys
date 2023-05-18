package objekten;

public class OrderObjekt {
	private int id;
	private int order_id;
	private int qty;
	private int customer_id;
	private float total;
	private float price;
	private String product;
	private String datum;
	
	public OrderObjekt() {
	
	}
	
	/**
	 * new Order
	 */
	public OrderObjekt(int id,int order_id,int customer_id,float total,String datum) {
		this.id=id;
		this.order_id=order_id;
		this.customer_id=customer_id;
		this.total=total;
		this.datum=datum;
	}
	
	/**
	 * Order Detail
	 */
	public OrderObjekt(int id,int order_id,String product,int qty,float price,float total) {
		this.id=id;
		this.order_id=order_id;
		this.product=product;
		
		this.qty=qty;
		this.price=price;
		this.total=total;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}
}
