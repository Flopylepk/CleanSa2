package GUI;

import javax.swing.*;

public class MenuAdminEnvios extends JFrame {
	public MenuAdminEnvios() {
		setTitle("Menú Admin de Envíos");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(new JLabel("Aquí va el menú de envíos"), "Center");
	}
}
