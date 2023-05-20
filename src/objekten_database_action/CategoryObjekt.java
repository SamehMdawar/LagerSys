package objekten_database_action;
/**
 * Class ist für Objekt von Category
 * @author Sam
 *
 */
public class CategoryObjekt {
	private int id;
	private String name;
	
	public CategoryObjekt() {
		
	}
	
	/**
	 * * new Category Konstruktor
	 * @param id
	 * @param name
	 */
	public CategoryObjekt(int id,String name) {
		this.id=id;
		this.name=name;
	}
	/**
	 * Hier ist Getters und Setters von Category Objekt
	 */
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
}
