package GUI;

import java.awt.EventQueue;
import BLL.*;
import DLL.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class compra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					compra frame = new compra(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public compra(Cliente cliente) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Logo
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(compra.class.getResource("/img/logo.png")));
		logo.setBounds(100, 10, 369, 80);
		contentPane.add(logo);

		// Título
		JLabel lblTitulo = new JLabel("Compra");
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblTitulo.setBounds(210, 100, 200, 40);
		contentPane.add(lblTitulo);

		// Texto descriptivo
		JTextPane descripcion = new JTextPane();
		descripcion.setEditable(false);
		descripcion.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		descripcion.setText("En este apartado podrás realizar la compra y agregar los productos al carrito.");
		descripcion.setBounds(80, 160, 410, 60);
		descripcion.setOpaque(false);
		contentPane.add(descripcion);

		// Botón Continuar
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnContinuar.setBounds(220, 250, 130, 40);
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCliente.carrito2(cliente.getId());
				Tabla tabla = new Tabla();
				tabla.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnContinuar);
	}
}
