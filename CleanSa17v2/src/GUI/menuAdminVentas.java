package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import BLL.*;

public class MenuAdminVentas extends JFrame {
	private AdminVentas admin;

	public MenuAdminVentas(AdminVentas admin) {
		this.admin = admin;
		setTitle("Menú Admin de Ventas");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new FlowLayout());

		JButton btnAgregarProducto = new JButton("Registrar nuevo producto");
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
			}
		});
		add(btnAgregarProducto);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(e -> System.exit(0));
		add(btnSalir);
	}
}
