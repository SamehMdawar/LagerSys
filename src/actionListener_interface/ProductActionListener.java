package actionListener_interface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.Category;
import objekten_database_action.ProductAction;
import objekten_database_action.ProductObjekt;
/**
 * Die Class ist als ActionListener für Buttons auf "Product" Oberfläche
 * @author Sam
 *
 */
public class ProductActionListener implements ActionListener{
	private JButton button;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtQty;
	private JComboBox<?> comboCat;
	private JComboBox<?> comboSupplier;
	
	/**
	 * ProductActionListener Konstruktor,
	 * Argument ist hier, um Element (Input Text , Buttons usw...) auf "Product" Oberfläche als Parameter umzugehen
	 * @param button
	 * @param txtName
	 * @param comboCat
	 * @param comboSupplier
	 * @param txtPrice
	 * @param txtQty
	 */
	public ProductActionListener(JButton button, JTextField txtName, JComboBox comboCat,JComboBox comboSupplier,JTextField txtPrice,JTextField txtQty){
		this.button=button;
		this.txtName=txtName;
		this.txtPrice=txtPrice;
		this.txtQty=txtQty;
		this.comboCat=comboCat;
		this.comboSupplier=comboSupplier;
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		float total=0;
		float price=0;
		float qty=0;
		
		String suppllier = String.valueOf(comboSupplier.getSelectedItem());
		String category = String.valueOf(comboCat.getSelectedItem());
		
		String[] cats = category.split("-"); // Idnummer vor minus zeichen zurücknehmen
		String catId = cats[0];
		
		/**
		 * Wenn Sie auf die Button mit dem Text "Add" klicken,
		 */
		if (e.getActionCommand()=="Add") {
			/**
			 * Es wird geprüft, dass alle Eingabefelder nicht leer sindز
			 */
			if (txtName.getText().equals("")||txtPrice.getText().equals("")
					||suppllier.equals("")||category.equals("")
					|| txtQty.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Ein Feld ist leer!","Product", JOptionPane.CANCEL_OPTION);
			}else {
				/**
				 * Hier wird ein neues Produkt hinzugefügt
				 */
				price=Float.parseFloat(txtPrice.getText());
				qty=Integer.parseInt(txtQty.getText());
				total=price*qty;
				ProductObjekt product = new  ProductObjekt(0,txtName.getText(),
						Integer.parseInt(catId),
						Integer.parseInt(catId),//	muss das später zu supplier verändern
						Float.parseFloat(txtPrice.getText()),
						Integer.parseInt(txtQty.getText()),total);
				ProductAction productAction=new ProductAction();
				productAction.add(product);
				System.out.println("Done");
				txtName.setText("");
				txtPrice.setText("");
				txtQty.setText("");
				
		}
		}
		/**
		 * Wenn Sie auf die Button mit dem Text "Delete" klicken,
		 */
		if (e.getActionCommand()=="Delete") {
			System.out.println("Delete");
		}

		
	}

}
