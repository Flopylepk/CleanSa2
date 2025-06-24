package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.*;
import DLL.*;

public class Admin_carrito_proceso extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Carrito carritoSeleccionado;
	private JTextField inpFiltro;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Admin_carrito_proceso frame = new Admin_carrito_proceso();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Admin_carrito_proceso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Logo (asegurate que tengas /img/logo.png en tu carpeta resources)
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(Admin_carrito_proceso.class.getResource("/img/logo.png")));
		logo.setBounds(200, 10, 386, 110);
		contentPane.add(logo);

		JLabel lblSeleccionado = new JLabel("Seleccionado:");
		lblSeleccionado.setBounds(10, 135, 760, 20);
		lblSeleccionado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		contentPane.add(lblSeleccionado);

		model = new DefaultTableModel(
				new String[] { "nombre", "stock", "precio", "fk_categoria", "peligroso", "id_producto" }, 0);
		table = new JTable(model);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		table.setRowHeight(22);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 165, 760, 200);
		contentPane.add(scrollPane);

		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int row = table.getSelectedRow();
				if (row != -1) {
					carritoSeleccionado = new Carrito((int) model.getValueAt(row, 0), (Date) model.getValueAt(row, 1),
							(double) model.getValueAt(row, 2), (int) model.getValueAt(row, 3),
							(int) model.getValueAt(row, 4));
					lblSeleccionado.setText("Seleccionado: " + carritoSeleccionado.toString());
				}
			}
		});

		// Cargar datos
		cargarTabla();
	}

	private void cargarTabla() {
		model.setRowCount(0);
		LinkedList<Carrito> carritos = ControllerCarrito.mostrarCarritoEnProseso();
		for (Carrito u : carritos) {
			model.addRow(new Object[] { u.getId_carrito(), u.getFecha(), u.getTotal_compra(), u.getCodigo_envio(),
					u.getFk_cliente() });
		}
	}

	private void cargarTabla_productos(int id) {
		model.setRowCount(0);
		LinkedList<Producto> productos = ControllerDetalle.mostrarCarrito_detalle(id);
		for (Producto u : productos) {
			model.addRow(new Object[] { u.getNombre(), u.getStcok(), u.getPrecio(), u.getCategoria(), u.getPrecio() });
		}
	}
}
