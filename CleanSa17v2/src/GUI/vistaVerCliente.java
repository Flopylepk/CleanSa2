package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Cliente;
import DLL.ControllerCliente;

public class vistaVerCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;

	public vistaVerCliente() {
		setTitle("Ver clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Listado de Clientes:");
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTitulo.setBounds(10, 10, 300, 30);
		contentPane.add(lblTitulo);

		model = new DefaultTableModel(new String[] { "Nombre", "Dirección", "DNI", "Tipo" }, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // ninguna celda es editable
			}
		};
		table = new JTable(model);
		table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		table.setRowHeight(22);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 50, 560, 230);
		contentPane.add(scrollPane);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnVolver.setBounds(10, 300, 130, 40);
		contentPane.add(btnVolver);

		JButton btnRecargar = new JButton("Recargar");
		btnRecargar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRecargar.setBounds(440, 300, 130, 40);
		contentPane.add(btnRecargar);

		btnVolver.addActionListener((ActionEvent e) -> {
			vistaAdminVentas ventana = new vistaAdminVentas();
			ventana.setVisible(true);
			dispose();
		});

		btnRecargar.addActionListener((ActionEvent e) -> cargarClientes());

		cargarClientes();
	}

	private void cargarClientes() {
		model.setRowCount(0);
		ControllerCliente controller = new ControllerCliente();
		LinkedList<Cliente> clientes = controller.mostrarClientes();

		for (Cliente c : clientes) {
			String tipoTexto = (c.getTipo() == 1) ? "Empresa" : "Particular";

			model.addRow(new Object[] { c.getNombre(), c.getDireccion(), c.getDni(), tipoTexto });
		}
	}

}
