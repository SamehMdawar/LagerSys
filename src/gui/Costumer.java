package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import objekten.CategoryAction;
import objekten.CategoryObjekt;

public class Costumer extends JPanel{
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField txtVname;
	private JTextField txtNname;
	private JTextField txtEmail;
	private JTextField txtAdr;
	private JTextField txtTel;
	private JTable table_1;

	public Costumer () {
		setBackground(new Color(240, 240, 240));
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(10, 25, 616, 292);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vorname:");
		lblNewLabel.setBounds(20, 58, 108, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNachname = new JLabel("Nachname:");
		lblNachname.setBounds(20, 105, 108, 14);
		panel.add(lblNachname);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setBounds(20, 152, 108, 14);
		panel.add(lblAdresse);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setBounds(20, 199, 108, 14);
		panel.add(lblEmail);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setBounds(20, 246, 108, 14);
		panel.add(lblTel);
		
		JLabel lblNewLabel_1 = new JLabel("New Costumer");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(21, 11, 107, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAdd.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAdd.setBounds(476, 100, 89, 40);
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDelete.setBounds(476, 220, 89, 40);
		panel.add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnUpdate.setBounds(476, 160, 89, 40);
		panel.add(btnUpdate);
		
		txtVname = new JTextField();
		txtVname.setBounds(127, 55, 201, 20);
		panel.add(txtVname);
		txtVname.setColumns(10);
		
		txtNname = new JTextField();
		txtNname.setColumns(10);
		txtNname.setBounds(127, 102, 201, 20);
		panel.add(txtNname);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(127, 193, 201, 20);
		panel.add(txtEmail);
		
		txtAdr = new JTextField();
		txtAdr.setColumns(10);
		txtAdr.setBounds(127, 146, 201, 20);
		panel.add(txtAdr);
		
		txtTel = new JTextField();
		txtTel.setColumns(10);
		txtTel.setBounds(127, 243, 201, 20);
		panel.add(txtTel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(10, 345, 616, 239);
		add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 32, 569, 196);
		panel_1.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		
		JLabel lblNewLabel_2 = new JLabel("Costumer List:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(23, 11, 137, 14);
		panel_1.add(lblNewLabel_2);


		
	}
}
