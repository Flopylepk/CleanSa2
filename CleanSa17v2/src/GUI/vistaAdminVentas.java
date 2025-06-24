package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class vistaAdminVentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				vistaAdminVentas frame = new vistaAdminVentas();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public vistaAdminVentas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(vistaAdminVentas.class.getResource("/img/logo.png")));
		lblLogo.setBounds(90, 10, 369, 127);
		contentPane.add(lblLogo);

		JButton ver_clientes_btn = new JButton("Ver clientes");
		ver_clientes_btn.setBounds(30, 153, 150, 23);
		ver_clientes_btn.addActionListener(e -> {
			vistaVerCliente ventana = new vistaVerCliente();
			ventana.setVisible(true);
			dispose();
		});
		contentPane.add(ver_clientes_btn);

		JButton crear_categoria_btn = new JButton("Crear categoría");
		crear_categoria_btn.setBounds(210, 153, 150, 23);
		crear_categoria_btn.addActionListener(e -> {
			vistaCrearCategoria ventana = new vistaCrearCategoria();
			ventana.setVisible(true);
			dispose();
		});
		contentPane.add(crear_categoria_btn);

		JButton productos_btn = new JButton("Menu Productos");
		productos_btn.setBounds(390, 153, 150, 23);
		productos_btn.addActionListener(e -> {
			vistaProductosAdmin ventana = new vistaProductosAdmin();
			ventana.setVisible(true);
			dispose();
		});
		contentPane.add(productos_btn);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(210, 227, 150, 23);
		btnSalir.addActionListener(e -> {
			LoginAdmin ventana = new LoginAdmin();
			ventana.setVisible(true);
			dispose();
		});
		contentPane.add(btnSalir);
	}
}
