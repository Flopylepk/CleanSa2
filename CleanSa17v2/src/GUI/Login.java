package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import DLL.*;
import BLL.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpdni;
	private JPasswordField inpcontrasena;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 400); // Tamaño ajustado
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Logo centrado
		JLabel imagen = new JLabel("");
		imagen.setBounds(100, 10, 369, 80);
		imagen.setIcon(new ImageIcon(Login.class.getResource("/img/logo.png")));
		imagen.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(imagen);

		// Título
		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(250, 100, 100, 26);
		contentPane.add(lblNewLabel_3);

		// DNI
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(180, 140, 200, 20);
		contentPane.add(lblNewLabel_1);

		inpdni = new JTextField();
		inpdni.setBounds(180, 165, 210, 25);
		contentPane.add(inpdni);
		inpdni.setColumns(10);

		// Contraseña
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(180, 200, 100, 20);
		contentPane.add(lblNewLabel_2);

		inpcontrasena = new JPasswordField();
		inpcontrasena.setBounds(180, 225, 210, 25);
		contentPane.add(inpcontrasena);

		// Error
		JLabel LblError = new JLabel("");
		LblError.setFont(new Font("Verdana", Font.PLAIN, 13));
		LblError.setForeground(Color.RED);
		LblError.setBounds(120, 290, 350, 20);
		contentPane.add(LblError);

		// Botón Iniciar sesión
		JButton btnNewButton = new JButton("Iniciar sesión");
		btnNewButton.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnNewButton.setBounds(180, 260, 210, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = new Cliente("", "", "", "", 0, 0);
				cliente = cliente.Login(inpdni.getText(), inpcontrasena.getText());

				if (cliente == null) {
					LblError.setText("Error, usuario incorrecto");
				} else {
					generalCliente generalcliente = new generalCliente(cliente);
					generalcliente.setVisible(true);
					dispose();
				}
			}
		});
		contentPane.add(btnNewButton);

		// Botón salir
		JButton salir = new JButton("Salir");
		salir.setFont(new Font("Verdana", Font.PLAIN, 12));
		salir.setBounds(10, 330, 80, 25);
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
