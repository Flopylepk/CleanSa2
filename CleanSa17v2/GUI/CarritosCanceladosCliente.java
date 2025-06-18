package GUI;

import repositorio.*;

import javax.print.attribute.standard.JobPrioritySupported;
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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CarritosCanceladosCliente extends JFrame implements Validador {
	private static Connection con = Conexion.getInstance().getConnection();

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private Carrito carritoSeleccionado;


	public CarritosCanceladosCliente(Cliente cliente) {

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
				new String[] { "Id_carrito", "Fecha", "Estado", "Total", "Codigo_envio", "fk_cliente" }, 0);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 40, 760, 233);
		contentPane.add(scrollPane);

		// Acción al seleccionar fila
		table.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int row = table.getSelectedRow();
				if (row != -1) {

					carritoSeleccionado = new Carrito((int) model.getValueAt(row, 0),
							(Date) model.getValueAt(row, 1), (String) model.getValueAt(row, 2),
							(double) model.getValueAt(row, 3), (int) model.getValueAt(row, 4),
							(int) model.getValueAt(row, 5)

					);

					lblSeleccionado.setText(carritoSeleccionado.toString());

				}
			}
		});

		JButton Salir = new JButton("Salir");
		Salir.setBounds(670, 419, 104, 31);
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generalCliente generalcliente = new generalCliente(cliente);
				generalcliente.setVisible(true);;
				dispose();
			}
		});
		contentPane.add(Salir);
		
		JButton Detalle = new JButton("Ver Detalle");
		Detalle.setBackground(SystemColor.menu);
		Detalle.setBounds(25, 386, 136, 64);
		contentPane.add(Detalle);

		// Cargar datos
		cargarTabla(cliente);

	}

	private void cargarTabla(Cliente cliente) {
		model.setRowCount(0);
		ControllerCarrito controller=new ControllerCarrito();
		List<Carrito> carritos = controller.mostrarCarritoporClienteCancelados(cliente.getId());
		for (Carrito u : carritos) {
			model.addRow(

					new Object[] { u.getId_carrito(), u.getFecha(),u.getEstado() ,u.getTotal_compra(), u.getCodigo_envio(),
							u.getFk_cliente()
					});
		}
	}
}
