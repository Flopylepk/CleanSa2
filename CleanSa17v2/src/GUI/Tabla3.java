package GUI;

import repositorio.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.*;
import DLL.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.LinkedList;

public class Tabla3 extends JFrame implements Validador {
	private static final Connection con = Conexion.getInstance().getConnection();

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Producto productoSeleccionado;
	private JTextField inpFiltro;
	private JTextField cantidad;

	public Tabla3(Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Logo
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Tabla3.class.getResource("/img/logo.png")));
		logo.setBounds(200, 10, 400, 80);
		contentPane.add(logo);

		JLabel lblSeleccionado = new JLabel("Seleccionado:");
		lblSeleccionado.setBounds(10, 100, 760, 20);
		contentPane.add(lblSeleccionado);

		// Tabla
		model = new DefaultTableModel(
			new String[]{"Nombre", "Precio", "Stock", "Categoria", "Peligroso", "ID"}, 0);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 130, 760, 150);
		contentPane.add(scrollPane);

		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int row = table.getSelectedRow();
				if (row != -1) {
					productoSeleccionado = new Producto(
						(String) model.getValueAt(row, 0),
						(double) model.getValueAt(row, 1),
						(int) model.getValueAt(row, 2),
						(int) model.getValueAt(row, 3),
						(int) model.getValueAt(row, 4),
						(int) model.getValueAt(row, 5)
					);
					lblSeleccionado.setText(productoSeleccionado.toString());
				}
			}
		});

		// Filtro por nombre
		inpFiltro = new JTextField();
		inpFiltro.setBounds(10, 300, 180, 30);
		contentPane.add(inpFiltro);

		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(200, 300, 100, 30);
		btnFiltrar.addActionListener(e -> cargarTablaFiltro(inpFiltro.getText()));
		contentPane.add(btnFiltrar);

		JButton btnRecargar = new JButton("Recargar");
		btnRecargar.setBounds(310, 300, 100, 30);
		btnRecargar.addActionListener(e -> {
			cargarTabla();
			inpFiltro.setText("");
		});
		contentPane.add(btnRecargar);

		// Cantidad
		JLabel lblCantidad = new JLabel("Cantidad de producto:");
		lblCantidad.setBounds(10, 350, 200, 20);
		contentPane.add(lblCantidad);

		cantidad = new JTextField();
		cantidad.setBounds(10, 375, 180, 30);
		contentPane.add(cantidad);

		JLabel LblError = new JLabel("");
		LblError.setForeground(Color.RED);
		LblError.setBounds(10, 415, 600, 20);
		contentPane.add(LblError);

		JButton compra = new JButton("Agregar al carrito");
		compra.setBounds(210, 375, 180, 30);
		compra.addActionListener(e -> {
			LblError.setText("");

			if (productoSeleccionado == null) {
				LblError.setText("No se eligió ningún producto.");
				return;
			}
			String cantidadStr = cantidad.getText().trim();
			if (cantidadStr.isEmpty() || !cantidadStr.chars().allMatch(Character::isDigit)) {
				LblError.setText("Ingrese una cantidad válida (solo números).");
				return;
			}
			int cant = Integer.parseInt(cantidadStr);
			if (cant <= 0 || cant > productoSeleccionado.getStcok()) {
				LblError.setText("La cantidad debe ser mayor a 0 y menor o igual al stock.");
				return;
			}

			try {
				PreparedStatement validar = con.prepareStatement(
					"SELECT * FROM carrito WHERE fk_cliente=? AND estado=?");
				validar.setInt(1, cliente.getId());
				validar.setString(2, "en proceso");
				ResultSet rs = validar.executeQuery();

				if (!rs.next()) {
					LblError.setText("No se encontró un carrito en proceso.");
					return;
				}

				Carrito carrito = new Carrito(
					rs.getInt("id_carrito"),
					rs.getDate("fecha"),
					rs.getString("estado"),
					rs.getDouble("total"),
					rs.getInt("codigoenvio"),
					rs.getInt("fk_cliente")
				);

				double totalExtra = productoSeleccionado.getPrecio() * cant;

				PreparedStatement check = con.prepareStatement(
					"SELECT * FROM carrito_detalle WHERE fk_carrito=? AND fk_producto=?");
				check.setInt(1, carrito.getId_carrito());
				check.setInt(2, productoSeleccionado.getId());
				ResultSet rsc = check.executeQuery();

				if (rsc.next()) {
					int cantidadActual = rsc.getInt("cantidad");
					double totalActual = rsc.getDouble("total_producto");

					PreparedStatement updateDetalle = con.prepareStatement(
						"UPDATE carrito_detalle SET cantidad=?, total_producto=? WHERE fk_carrito=? AND fk_producto=?");
					updateDetalle.setInt(1, cantidadActual + cant);
					updateDetalle.setDouble(2, totalActual + totalExtra);
					updateDetalle.setInt(3, carrito.getId_carrito());
					updateDetalle.setInt(4, productoSeleccionado.getId());
					updateDetalle.executeUpdate();
				} else {
					PreparedStatement insert = con.prepareStatement(
						"INSERT INTO carrito_detalle(fk_carrito, fk_producto, total_producto, cantidad) VALUES (?,?,?,?)");
					insert.setInt(1, carrito.getId_carrito());
					insert.setInt(2, productoSeleccionado.getId());
					insert.setDouble(3, totalExtra);
					insert.setInt(4, cant);
					insert.executeUpdate();
				}

				PreparedStatement updateStock = con.prepareStatement(
					"UPDATE producto SET stock=? WHERE id_producto=?");
				updateStock.setInt(1, productoSeleccionado.getStcok() - cant);
				updateStock.setInt(2, productoSeleccionado.getId());
				updateStock.executeUpdate();

				PreparedStatement updateCarrito = con.prepareStatement(
					"UPDATE carrito SET total=? WHERE id_carrito=?");
				updateCarrito.setDouble(1, carrito.getTotal_compra() + totalExtra);
				updateCarrito.setInt(2, carrito.getId_carrito());
				updateCarrito.executeUpdate();

				new CompraExitosa(cliente).setVisible(true);
				dispose();

			} catch (SQLException ex) {
				ex.printStackTrace();
				LblError.setText("Error al agregar el producto al carrito.");
			}
		});
		contentPane.add(compra);

		JButton salir = new JButton("Salir");
		salir.setBounds(650, 460, 100, 30);
		salir.addActionListener(e -> {
			JOptionPane.showMessageDialog(null, "Después podrá continuar su compra tranquilamente.");
			new generalCliente(cliente).setVisible(true);
			dispose();
		});
		contentPane.add(salir);

		// Cargar productos
		cargarTabla();
	}

	private void cargarTabla() {
		model.setRowCount(0);
		LinkedList<Producto> productos = ControllerProducto.mostrarProductos();
		for (Producto u : productos) {
			model.addRow(new Object[]{
				u.getNombre(),
				u.getPrecio(),
				u.getStcok(),
				u.getCategoria(),
				u.getPeligroso(),
				u.getId()
			});
		}
	}

	private void cargarTablaFiltro(String filtro) {
		model.setRowCount(0);
		LinkedList<Producto> productos = ControllerProducto.mostrarProductos();
		for (Producto u : productos) {
			if (u.getNombre().toLowerCase().startsWith(filtro.toLowerCase())) {
				model.addRow(new Object[]{
					u.getNombre(),
					u.getPrecio(),
					u.getStcok(),
					u.getCategoria(),
					u.getPeligroso(),
					u.getId()
				});
			}
		}
	}
}
