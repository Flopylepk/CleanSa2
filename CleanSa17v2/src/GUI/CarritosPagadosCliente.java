package GUI;

import repositorio.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BLL.*;
import DLL.*;
import repositorio.Validador;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class CarritosPagadosCliente extends JFrame implements Validador {
	private static Connection con = Conexion.getInstance().getConnection();

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Carrito carritoSeleccionado;

	public CarritosPagadosCliente(Cliente cliente) {
		setTitle("Carritos Pagados");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 540); // altura ajustada para logo + tabla + botones
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Logo arriba centrado
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(CarritosPagadosCliente.class.getResource("/img/logo.png")));
		logoLabel.setBounds(200, 10, 400, 80);
		contentPane.add(logoLabel);

		// Tabla y scroll
		model = new DefaultTableModel(new String[] {
			"Id_carrito", "Fecha", "Estado", "Total", "Codigo_envio", "fk_cliente"
		}, 0);

		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 100, 760, 230);
		contentPane.add(scrollPane);

		// Label selección
		JLabel lblSeleccionado = new JLabel("Seleccionado:");
		lblSeleccionado.setBounds(10, 340, 760, 20);
		contentPane.add(lblSeleccionado);

		// Label error
		JLabel LblError = new JLabel("");
		LblError.setFont(new Font("Verdana", Font.PLAIN, 13));
		LblError.setForeground(Color.RED);
		LblError.setBounds(10, 370, 400, 20);
		contentPane.add(LblError);

		// Botón Ver Detalle
		JButton Detalle = new JButton("Ver detalle");
		Detalle.setFont(new Font("Verdana", Font.PLAIN, 13));
		Detalle.setBounds(30, 410, 140, 35);
		Detalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (carritoSeleccionado == null) {
					LblError.setText("Error. No se eligió ningún producto.");
				} else {
					CarritosDetalle carritosdetalle = new CarritosDetalle(cliente, carritoSeleccionado.getId_carrito());
					carritosdetalle.setVisible(true);
					dispose();
				}
			}
		});
		contentPane.add(Detalle);

		// Botón salir
		JButton Salir = new JButton("Salir");
		Salir.setFont(new Font("Verdana", Font.PLAIN, 13));
		Salir.setBounds(630, 410, 140, 35);
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionesCarritosCliente opcionescarritoscliente = new OpcionesCarritosCliente(cliente);
				opcionescarritoscliente.setVisible(true);
				dispose();
			}
		});
		contentPane.add(Salir);

		// Listener para selección de tabla
		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int row = table.getSelectedRow();
				if (row != -1) {
					carritoSeleccionado = new Carrito(
						(int) model.getValueAt(row, 0),
						(Date) model.getValueAt(row, 1),
						(String) model.getValueAt(row, 2),
						(double) model.getValueAt(row, 3),
						(int) model.getValueAt(row, 4),
						(int) model.getValueAt(row, 5)
					);
					lblSeleccionado.setText(carritoSeleccionado.toString());
					LblError.setText("");
				}
			}
		});

		// Cargar datos
		cargarTabla(cliente);
	}

	private void cargarTabla(Cliente cliente) {
		model.setRowCount(0);
		ControllerCarrito controller = new ControllerCarrito();
		List<Carrito> carritos = controller.mostrarCarritoporClientePagados(cliente.getId());

		for (Carrito u : carritos) {
			model.addRow(new Object[] {
				u.getId_carrito(),
				u.getFecha(),
				u.getEstado(),
				u.getTotal_compra(),
				u.getCodigo_envio(),
				u.getFk_cliente()
			});
		}
	}
}
