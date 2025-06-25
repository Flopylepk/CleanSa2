package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class vistaAdminVentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaAdminVentas frame = new vistaAdminVentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public vistaAdminVentas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 350); // Tamaño aumentado
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Cargar Productos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaCargarProducto ventana = new vistaCargarProducto();
				ventana.setVisible(true);
			}
		});
		btnNewButton.setBounds(30, 183, 150, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Actualizar stock");
		btnNewButton_1.setBounds(210, 183, 150, 23);
		btnNewButton_1.addActionListener(e -> {
			vistaModificarStock ventana = new vistaModificarStock();
			ventana.setVisible(true);
			dispose();
		});
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin ventana = new LoginAdmin();
				ventana.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(210, 227, 150, 23);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(vistaAdminVentas.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(90, 10, 369, 127);
		contentPane.add(lblNewLabel);

		JButton ver_productos = new JButton("Ver productos");
		ver_productos.setBounds(390, 183, 150, 23);
		contentPane.add(ver_productos);

		JButton ver_clientes_btn = new JButton("Ver clientes");
		ver_clientes_btn.setBounds(30, 153, 150, 23);
		ver_clientes_btn.addActionListener(e -> {
			clientes ventana = new clientes(); // si tenés una vista específica para productos la podés poner acá
			ventana.setVisible(true);
			dispose();
		});
		contentPane.add(ver_clientes_btn);

		JButton eliminar_productos_btn = new JButton("Eliminar producto");
		eliminar_productos_btn.setBounds(210, 153, 150, 23);
		eliminar_productos_btn.addActionListener(e -> {
			vistaEliminarProducto ventana = new vistaEliminarProducto(this);
			ventana.setVisible(true);
			dispose();
		});
		contentPane.add(eliminar_productos_btn);

		JButton crear_categoria_btn = new JButton("Crear categoria");
		crear_categoria_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaCrearCategoria ventana = new vistaCrearCategoria();
				ventana.setVisible(true);
				dispose();
			}
		});
		crear_categoria_btn.setBounds(390, 153, 150, 23);
		contentPane.add(crear_categoria_btn);
	}
}
