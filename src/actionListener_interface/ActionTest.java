package actionListener_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * Testen Class
 * @author Sam
 *
 */
public class ActionTest implements ActionListener{
	private JButton button;

	public ActionTest(JButton button){
		this.button=button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.button) {
			System.out.println("Test Button");
		}if(e.getSource()==this.button) {
			System.out.println("2 Button");
		}else {
			System.out.println("falsch");
			}	
		
		
	}

}
