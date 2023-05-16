package gui;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Supplier extends JPanel {
	private JPanel panel;
	private JTextField txtFirma;
	private JTextField txtVname;
	private JTextField txtNname;
	private JTextField txtAddr;
	private JTextField txtEmail;
	private JTextField txtTel;
	private JTable table;
	
	public Supplier() {
		setLayout(null);
		panel=new JPanel();
		panel.setBounds(224, 5, 1, 1);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(22, 30, 563, 258);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Supplier");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 86, 14);
		panel_1.add(lblNewLabel);
		
		txtFirma = new JTextField();
		txtFirma.setBounds(82, 62, 155, 20);
		panel_1.add(txtFirma);
		txtFirma.setColumns(10);
		
		txtVname = new JTextField();
		txtVname.setColumns(10);
		txtVname.setBounds(82, 93, 155, 20);
		panel_1.add(txtVname);
		
		txtNname = new JTextField();
		txtNname.setColumns(10);
		txtNname.setBounds(82, 124, 155, 20);
		panel_1.add(txtNname);
		
		txtAddr = new JTextField();
		txtAddr.setColumns(10);
		txtAddr.setBounds(82, 155, 155, 20);
		panel_1.add(txtAddr);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(82, 186, 155, 20);
		panel_1.add(txtEmail);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(82, 217, 155, 20);
		panel_1.add(txtTel);
		
		JLabel lblNewLabel_1 = new JLabel("Firma:");
		lblNewLabel_1.setBounds(10, 62, 86, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vorname:");
		lblNewLabel_1_1.setBounds(10, 93, 86, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nachname:");
		lblNewLabel_1_1_1.setBounds(10, 124, 86, 14);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Adresse:");
		lblNewLabel_1_1_1_1.setBounds(10, 155, 86, 14);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("E-Mail:");
		lblNewLabel_1_1_1_1_1.setBounds(10, 186, 86, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Tel:");
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 217, 86, 14);
		panel_1.add(lblNewLabel_1_1_1_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(278, 64, 10, 173);
		panel_1.add(panel_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAdd.setBounds(363, 62, 123, 33);
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUpdate.setBounds(363, 121, 123, 33);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDelete.setBounds(363, 185, 123, 33);
		panel_1.add(btnDelete);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(22, 299, 563, 10);
		add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(22, 320, 563, 292);
		add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Suppliers");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 11, 131, 14);
		panel_4.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 543, 245);
		panel_4.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setOpaque(false);
		panel_2_1.setForeground(Color.LIGHT_GRAY);
		panel_2_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2_1.setBackground(new Color(0, 128, 192));
		panel_2_1.setBounds(3, 1, 620, 6);
		add(panel_2_1);
	}
}
