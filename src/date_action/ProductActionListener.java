package date_action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.Category;
import objekten.ProductAction;
import objekten.ProductObjekt;

public class ProductActionListener implements ActionListener{
	private JButton button;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtQty;
	private JComboBox<?> comboCat;
	private JComboBox<?> comboSupplier;
	
	
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
		
		if (e.getActionCommand()=="Add") {
			if (txtName.getText().equals("")||txtPrice.getText().equals("")
					||suppllier.equals("")||category.equals("")
					|| txtQty.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Ein Feld ist leer!","Product", JOptionPane.CANCEL_OPTION);
			}else {
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
		if (e.getActionCommand()=="Delete") {
			System.out.println("Delete");
		}

		
	}

}
