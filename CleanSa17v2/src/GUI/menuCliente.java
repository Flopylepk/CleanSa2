package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class menuCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuCliente frame = new menuCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menuCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 350); // Más espacio
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Logo centrado arriba
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(menuCliente.class.getResource("/img/logo.png")));
		logoLabel.setBounds(100, 10, 369, 100);
		contentPane.add(logoLabel);

		// Título
		JLabel lblNewLabel = new JLabel("¿Qué desea realizar?");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel.setBounds(190, 120, 250, 30);
		contentPane.add(lblNewLabel);

		// Botón Registro
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnRegistro.setBounds(80, 180, 140, 30);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registro registro = new Registro();
				registro.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnRegistro);

		// Botón Login
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnLogin.setBounds(220, 180, 140, 30);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnLogin);

		// Botón Salir
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnSalir.setBounds(360, 180, 140, 30);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuprincipal Menupricipal = new menuprincipal();
				Menupricipal.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnSalir);
	}
}
