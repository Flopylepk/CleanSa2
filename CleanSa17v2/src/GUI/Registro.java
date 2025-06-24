package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Cliente;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Inpnombre;
	private JPasswordField inpcontrasena;
	private JTextField inpDNI;
	private JTextField inpdireccion;

	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 470); // Tamaño ajustado
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Logo centrado
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Registro.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(100, 10, 369, 80);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Registrate");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(230, 90, 100, 24);
		contentPane.add(lblNewLabel_1);

		// Nombre
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNombre.setBounds(80, 130, 100, 14);
		contentPane.add(lblNombre);

		Inpnombre = new JTextField();
		Inpnombre.setBounds(80, 150, 180, 25);
		contentPane.add(Inpnombre);
		Inpnombre.setColumns(10);

		// Contraseña
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblContrasena.setBounds(80, 185, 100, 14);
		contentPane.add(lblContrasena);

		inpcontrasena = new JPasswordField();
		inpcontrasena.setBounds(80, 205, 180, 25);
		contentPane.add(inpcontrasena);

		// DNI
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblDNI.setBounds(80, 240, 100, 14);
		contentPane.add(lblDNI);

		inpDNI = new JTextField();
		inpDNI.setBounds(80, 260, 180, 25);
		contentPane.add(inpDNI);
		inpDNI.setColumns(10);

		// Dirección
		JLabel direccion = new JLabel("Dirección");
		direccion.setFont(new Font("Verdana", Font.PLAIN, 13));
		direccion.setBounds(300, 185, 100, 14);
		contentPane.add(direccion);

		inpdireccion = new JTextField();
		inpdireccion.setBounds(300, 205, 180, 25);
		contentPane.add(inpdireccion);

		// Tipo de usuario
		JLabel lblTipo = new JLabel("Tipo de cliente");
		lblTipo.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblTipo.setBounds(300, 240, 150, 14);
		contentPane.add(lblTipo);

		JComboBox tipoUsuario = new JComboBox();
		tipoUsuario.addItem("General");
		tipoUsuario.addItem("Empresa");
		tipoUsuario.setBounds(300, 260, 180, 25);
		contentPane.add(tipoUsuario);

		// Label error
		JLabel LblError = new JLabel("");
		LblError.setFont(new Font("Verdana", Font.PLAIN, 12));
		LblError.setForeground(Color.RED);
		LblError.setBounds(80, 330, 400, 20);
		contentPane.add(LblError);

		// Botón Registrar
		JButton registrar = new JButton("Registrar");
		registrar.setFont(new Font("Verdana", Font.PLAIN, 13));
		registrar.setBounds(80, 300, 400, 25);
		registrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente();
				String validar = cliente.agregarClienteProfe(
						Inpnombre.getText(),
						inpcontrasena.getText(),
						inpdireccion.getText(),
						inpDNI.getText(),
						(String) tipoUsuario.getSelectedItem()
				);

				if (validar.equals("si")) {
					RegistroCorrecto registrocorrecto = new RegistroCorrecto();
					registrocorrecto.setVisible(true);
					dispose();
				} else {
					LblError.setText(validar);
				}
			}
		});
		contentPane.add(registrar);

		// Botón salir
		JButton salir = new JButton("Salir");
		salir.setFont(new Font("Verdana", Font.PLAIN, 12));
		salir.setBounds(10, 390, 90, 25);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuCliente menucliente = new menuCliente();
				menucliente.setVisible(true);
				dispose();
			}
		});
		contentPane.add(salir);
	}
}
