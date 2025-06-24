package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BLL.Cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public VerCliente(Cliente cliente) {
		setTitle("Información del Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Logo
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(VerCliente.class.getResource("/img/logo.png")));
		lblLogo.setBounds(170, 10, 300, 100);
		contentPane.add(lblLogo);

		// Datos del cliente
		JLabel lblId = new JLabel("ID Cliente: " + cliente.getId());
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(50, 130, 500, 25);
		contentPane.add(lblId);

		JLabel lblNombre = new JLabel("Nombre: " + cliente.getNombre());
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(50, 165, 500, 25);
		contentPane.add(lblNombre);

		JLabel lblDireccion = new JLabel("Dirección: " + cliente.getDireccion());
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDireccion.setBounds(50, 200, 500, 25);
		contentPane.add(lblDireccion);

		JLabel lblDni = new JLabel("DNI: " + cliente.getDni());
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDni.setBounds(50, 235, 500, 25);
		contentPane.add(lblDni);

		JLabel lblTipo = new JLabel("Tipo de Cliente: " + cliente.getTipo());
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipo.setBounds(50, 270, 500, 25);
		contentPane.add(lblTipo);

		// Botón salir
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(SystemColor.menu);
		btnSalir.setBounds(500, 360, 100, 30);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generalCliente generalcliente = new generalCliente(cliente);
				generalcliente.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnSalir);
	}
}
