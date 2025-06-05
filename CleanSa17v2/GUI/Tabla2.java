package GUI;

import repositorio.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BLL.*;
import DLL.*;
import repositorio.Validador;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class Tabla2 extends JFrame implements Validador {
	private static Connection con = Conexion.getInstance().getConnection();

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Producto productoSeleccionado;
	private JTextField inpFiltro;
	private JTextField cantidad;
	  public static void main(String[] args) {
	        EventQueue.invokeLater(() -> {
	            try {
	            	Tabla2 frame = new Tabla2(new Carrito(1));
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	    }

	public Tabla2(Carrito carrito) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(174, 174, 174));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSeleccionado = new JLabel("Seleccionado:");
		lblSeleccionado.setBounds(10, 10, 760, 20);
		contentPane.add(lblSeleccionado);

		model = new DefaultTableModel(
				new String[] { "nombre", "stock", "precio", "fk_categoria", "peligroso", "id_producto" }, 0);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 40, 760, 128);
		contentPane.add(scrollPane);

		// Acción al seleccionar fila
		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int row = table.getSelectedRow();
				if (row != -1) {

					productoSeleccionado = new Producto((String) model.getValueAt(row, 0),
							(int) model.getValueAt(row, 1), (double) model.getValueAt(row, 2),
							(int) model.getValueAt(row, 3), (int) model.getValueAt(row, 4),
							(int) model.getValueAt(row, 5)

					);

					lblSeleccionado.setText(productoSeleccionado.toString());

				}
			}
		});
		inpFiltro = new JTextField();
		inpFiltro.setBounds(10, 204, 118, 40);
		contentPane.add(inpFiltro);
		inpFiltro.setColumns(10);
		inpFiltro.setVisible(true);
		JButton btnNewButton = new JButton("Filtrar nombre");
		btnNewButton.setVisible(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cargarTablaFiltro(inpFiltro.getText());
				
			}
		});
		btnNewButton.setBounds(136, 199, 118, 51);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Filtro");
		lblNewLabel.setBounds(10, 179, 117, 14);
		contentPane.add(lblNewLabel);

		JButton volver = new JButton("Recargar");
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTabla();
				inpFiltro.setText("");
			}
		});
		volver.setBounds(264, 199, 118, 51);
		contentPane.add(volver);

		cantidad = new JTextField();
		cantidad.setBounds(10, 413, 182, 34);
		contentPane.add(cantidad);
		cantidad.setColumns(10);

		JButton compra = new JButton("Agregar al carrito");
		compra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cantidad.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Tiene que ingresar la cantidad de producto");
				} else {
					int cantidad2 = Integer.parseInt(cantidad.getText());
					if (cantidad2 <= 0) {
						JOptionPane.showMessageDialog(null,
								"Tiene que ingresar una cantidad de producto, tiene que ser mayor a 0");
					} else {
						if (cantidad2 <= productoSeleccionado.getStcok()) {
							////validacion para no repetir producto
							
							try {
							PreparedStatement repetir = con.prepareStatement(
									"SELECT id_carrito_detalle FROM carrito_detalle WHERE fk_carrito = ? AND fk_producto = ? ");
							
							repetir.setInt(1, carrito.getId_carrito());
							repetir.setInt(2, productoSeleccionado.getId());
							
								ResultSet cr = repetir.executeQuery();
								
								int opcion=cr.getInt("id_carrito_detalle");
								
																
								if (opcion>=1) {
									JOptionPane.showMessageDialog(null, "este producto ya existe en el carrito");
								} else {
									try {
										PreparedStatement stmt = con.prepareStatement(
												"INSERT INTO carrito_detalle(fk_carrito, fk_producto, total_producto, cantidad) VALUES (?,?,?,?)");
										stmt.setInt(1, carrito.getId_carrito());
										stmt.setInt(2, productoSeleccionado.getId());
										stmt.setDouble(3, productoSeleccionado.getPrecio() * cantidad2);
										stmt.setInt(4, cantidad2);

										PreparedStatement stmt2 = con
												.prepareStatement("UPDATE producto SET stock=? WHERE id_producto=?");
										stmt2.setInt(1, productoSeleccionado.getStcok() - cantidad2);
										stmt2.setInt(2, productoSeleccionado.getId());

										JOptionPane.showMessageDialog(null, "Producto agregado correctamernte");
									} catch (SQLException e1) {

										e1.printStackTrace();
									}
								}
								
								
							} catch (SQLException e1) {																							
								e1.printStackTrace();
							}
							
																
							
						} else {
							JOptionPane.showMessageDialog(null,
									"Tiene que ingresar una cantidad de producto, tiene que ser menor al stock del producto");
						}
					}
				}

			}
		});
		compra.setBounds(202, 408, 152, 45);
		contentPane.add(compra);

		JLabel lblNewLabel_1 = new JLabel("Cantidad de producto");
		lblNewLabel_1.setBounds(10, 388, 104, 14);
		contentPane.add(lblNewLabel_1);

		JButton Salir = new JButton("Salir");
		Salir.setBounds(670, 419, 104, 31);
		contentPane.add(Salir);

		// Cargar datos
		cargarTabla();

	}

	private void cargarTabla() {
		model.setRowCount(0);
		LinkedList<Producto> productos = ControllerProducto.mostrarProductosNoPeligrosos();
		for (Producto u : productos) {
			model.addRow(

					new Object[] { u.getNombre(), u.getStcok(), u.getPrecio(), u.getCategoria(), u.getPeligroso(),
							u.getId()

					});
		}
	}

	private void cargarTablaFiltro(String filtro) {
		model.setRowCount(0);
		LinkedList<Producto> productos = ControllerProducto.mostrarProductosNoPeligrosos();
		for (Producto u : productos) {
			if (u.getNombre().startsWith(filtro)) {

				model.addRow(

						new Object[] { u.getNombre(), u.getStcok(), u.getPrecio(), u.getCategoria(), u.getPeligroso(),
								u.getId()

						});
			}

		}
	}
}
