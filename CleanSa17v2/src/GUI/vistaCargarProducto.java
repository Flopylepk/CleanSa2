package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BLL.Categoria;
import BLL.Producto;
import DLL.ControllerProducto;
import DLL.ControllerCategoria;

public class vistaCargarProducto extends JFrame {
	private ControllerProducto controller;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox<Categoria> comboBox;
	private JLabel Agregado;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				vistaCargarProducto frame = new vistaCargarProducto();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public vistaCargarProducto() {
		controller = new ControllerProducto();
		setTitle("Agregar Producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);
		Font inputFont = new Font("Segoe UI", Font.PLAIN, 13);

		// LOGO arriba
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(vistaCargarProducto.class.getResource("/img/logo.png")));
		lblLogo.setBounds(120, 10, 300, 100);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLogo);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(labelFont);
		lblNombre.setBounds(20, 120, 100, 20);
		contentPane.add(lblNombre);

		textField = new JTextField();
		textField.setFont(inputFont);
		textField.setBounds(130, 120, 150, 25);
		contentPane.add(textField);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(labelFont);
		lblPrecio.setBounds(20, 160, 100, 20);
		contentPane.add(lblPrecio);

		textField_1 = new JTextField();
		textField_1.setFont(inputFont);
		textField_1.setBounds(130, 160, 150, 25);
		contentPane.add(textField_1);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setFont(labelFont);
		lblStock.setBounds(20, 200, 100, 20);
		contentPane.add(lblStock);

		textField_2 = new JTextField();
		textField_2.setFont(inputFont);
		textField_2.setBounds(130, 200, 150, 25);
		contentPane.add(textField_2);

		JLabel lblCategoria = new JLabel("Categoría:");
		lblCategoria.setFont(labelFont);
		lblCategoria.setBounds(20, 240, 100, 20);
		contentPane.add(lblCategoria);

		comboBox = new JComboBox<>();
		comboBox.setFont(inputFont);
		comboBox.setBounds(130, 240, 150, 25);
		contentPane.add(comboBox);
		traerCategoria();

		JCheckBox chckbxPeligroso = new JCheckBox("Producto Peligroso");
		chckbxPeligroso.setBackground(Color.WHITE);
		chckbxPeligroso.setFont(labelFont);
		chckbxPeligroso.setBounds(20, 280, 200, 25);
		contentPane.add(chckbxPeligroso);

		JButton cargarProducto = new JButton("Agregar Producto");
		cargarProducto.setFont(new Font("Segoe UI", Font.BOLD, 14));
		cargarProducto.setBounds(346, 370, 180, 35);
		contentPane.add(cargarProducto);

		Agregado = new JLabel("");
		Agregado.setOpaque(true);
		Agregado.setHorizontalAlignment(SwingConstants.CENTER);
		Agregado.setFont(new Font("Segoe UI", Font.BOLD, 12));
		Agregado.setBounds(229, 335, 280, 25);
		Agregado.setVisible(false);
		contentPane.add(Agregado);

		// Botón Volver
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		btnVolver.setBounds(20, 373, 100, 30);
		contentPane.add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaProductosAdmin admin = new vistaProductosAdmin();
				admin.setVisible(true);
				dispose(); // cerrar esta ventana
			}
		});

		// Acción al presionar "Agregar Producto"
		cargarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = textField.getText();
					double precio = Double.parseDouble(textField_1.getText());
					int stock = Integer.parseInt(textField_2.getText());
					Categoria categoriaSeleccionada = (Categoria) comboBox.getSelectedItem();
					int idCategoria = categoriaSeleccionada.getId_categoria();
					int peligrosoInt = chckbxPeligroso.isSelected() ? 1 : 2;

					if (controller.encontrarProductos(nombre)) {
						Agregado.setText("Ya existe un producto con ese nombre.");
						Agregado.setForeground(Color.RED);
						Agregado.setVisible(true);
						return;
					}

					Producto nuevoProducto = new Producto(nombre, precio, stock, idCategoria, peligrosoInt, 0);
					controller.agregarProducto(nuevoProducto);

					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");
					comboBox.setSelectedIndex(0);
					chckbxPeligroso.setSelected(false);

					Agregado.setText("Producto agregado exitosamente.");
					Agregado.setForeground(new Color(0, 128, 0));
					Agregado.setVisible(true);
				} catch (Exception e2) {
					Agregado.setText("Error al cargar producto.");
					Agregado.setForeground(Color.RED);
					Agregado.setVisible(true);
				}
			}
		});
	}

	private void traerCategoria() {
		ControllerCategoria controllercategoria = new ControllerCategoria();
		LinkedList<Categoria> categorias = controllercategoria.mostrarCategorias();
		for (Categoria c : categorias) {
			comboBox.addItem(c);
		}
	}
}
