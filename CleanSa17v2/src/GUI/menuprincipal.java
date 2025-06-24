package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuprincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuprincipal frame = new menuprincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menuprincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 350); // Tamaño ampliado
		contentPane = new JPanel();
		// Fondo blanco como las demás ventanas
		// Se eliminó el fondo gris
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Logo grande arriba
		JLabel logoLabel = new JLabel("");
		logoLabel.setIcon(new ImageIcon(menuprincipal.class.getResource("/img/logo.png")));
		logoLabel.setBounds(100, 10, 369, 100);
		contentPane.add(logoLabel);

		// Texto central
		JLabel lblTitulo = new JLabel("Elija qué quiere ser...");
		lblTitulo.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblTitulo.setBounds(180, 120, 250, 30);
		contentPane.add(lblTitulo);

		// Botón Cliente
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCliente.setBounds(50, 180, 140, 30);
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuCliente menucliente = new menuCliente();
				menucliente.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnCliente);

		// Botón Administrador
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnAdministrador.setBounds(210, 180, 140, 30);
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginAdmin loginadmin = new LoginAdmin();
				loginadmin.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnAdministrador);

		// Botón Salir
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnSalir.setBounds(370, 180, 140, 30);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnSalir);
	}
}
