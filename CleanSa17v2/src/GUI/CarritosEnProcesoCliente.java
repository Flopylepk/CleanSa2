package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Carrito;
import BLL.Cliente;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarritosEnProcesoCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public CarritosEnProcesoCliente(Cliente cliente, Carrito carrito) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450); // Tamaño ajustado
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Logo centrado arriba
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CarritosEnProcesoCliente.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(165, 10, 319, 90);
		contentPane.add(lblNewLabel);

		// Info del carrito
		JLabel id_carrito = new JLabel("ID carrito: " + carrito.getId_carrito());
		id_carrito.setBounds(80, 130, 500, 20);
		contentPane.add(id_carrito);

		JLabel Fecha = new JLabel("Fecha: " + carrito.getFecha());
		Fecha.setBounds(80, 160, 500, 20);
		contentPane.add(Fecha);

		JLabel Estado = new JLabel("Estado: " + carrito.getEstado());
		Estado.setBounds(80, 190, 500, 20);
		contentPane.add(Estado);

		JLabel total = new JLabel("Total: $" + carrito.getTotal_compra());
		total.setBounds(80, 220, 500, 20);
		contentPane.add(total);

		JLabel codigo_envio = new JLabel("Código de envío: " + carrito.getCodigo_envio());
		codigo_envio.setBounds(80, 250, 500, 20);
		contentPane.add(codigo_envio);

		JLabel fk_cliente = new JLabel("Cliente ID: " + carrito.getFk_cliente());
		fk_cliente.setBounds(80, 280, 500, 20);
		contentPane.add(fk_cliente);

		// Botón Ver detalle
		JButton Detalle = new JButton("Ver detalle");
		Detalle.setBounds(70, 350, 130, 35);
		Detalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarritosDetalle carritosdetalle = new CarritosDetalle(cliente, carrito.getId_carrito());
				carritosdetalle.setVisible(true);
				dispose();
			}
		});
		contentPane.add(Detalle);

		// Botón Salir
		JButton Salir = new JButton("Salir");
		Salir.setBounds(450, 350, 130, 35);
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generalCliente generalcliente = new generalCliente(cliente);
				generalcliente.setVisible(true);
				dispose();
			}
		});
		contentPane.add(Salir);
	}
}
