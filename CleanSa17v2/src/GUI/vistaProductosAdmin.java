package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class vistaProductosAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				vistaProductosAdmin frame = new vistaProductosAdmin();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public vistaProductosAdmin() {
		setTitle("Gestión de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Logo
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon(vistaProductosAdmin.class.getResource("/img/logo.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(90, 5, 300, 100);
		contentPane.add(lblLogo);

		// Título
		JLabel lblTitulo = new JLabel("Menú de Productos para Administrador");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(50, 110, 380, 30);
		contentPane.add(lblTitulo);

		// Botones
		int btnWidth = 200;
		int btnHeight = 30;
		int btnX = 140;
		int initialY = 150;
		int spacing = 40;

		JButton btnAgregar = new JButton("Agregar producto");
		btnAgregar.setBounds(btnX, initialY, btnWidth, btnHeight);
		btnAgregar.addActionListener(e -> {
			vistaCargarProducto ventana = new vistaCargarProducto();
			ventana.setVisible(true);
			dispose();
		});
		contentPane.add(btnAgregar);

		JButton btnEditar = new JButton("Editar producto");
		btnEditar.setBounds(btnX, initialY + spacing, btnWidth, btnHeight);
		// TODO: implementar funcionalidad
		contentPane.add(btnEditar);

		JButton btnEliminar = new JButton("Eliminar producto");
		btnEliminar.setBounds(btnX, initialY + spacing * 2, btnWidth, btnHeight);
		btnEliminar.addActionListener(e -> {
			vistaEliminarProducto ventana = new vistaEliminarProducto(this);
			ventana.setVisible(true);
			dispose();
		});
		contentPane.add(btnEliminar);

		JButton btnVer = new JButton("Ver productos");
		btnVer.setBounds(btnX, initialY + spacing * 3, btnWidth, btnHeight);
		// TODO: implementar funcionalidad
		contentPane.add(btnVer);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(btnX, initialY + spacing * 4, btnWidth, btnHeight);
		btnVolver.addActionListener(e -> {
			vistaAdminVentas ventana = new vistaAdminVentas();
			ventana.setVisible(true);
			dispose();
		});
		contentPane.add(btnVolver);
	}
}
