package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Carrito;
import BLL.Cliente;
import DLL.ControllerCarrito;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcionesCarritosCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public OpcionesCarritosCliente(Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 425);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Texto = new JLabel("Elija que tipo de carrito quiere ver");
		Texto.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		Texto.setBounds(124, 138, 342, 60);
		contentPane.add(Texto);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(OpcionesCarritosCliente.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(125, 11, 318, 117);
		contentPane.add(lblNewLabel);
		
		JLabel LblError = new JLabel("");
		LblError.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		LblError.setForeground(new Color(255, 0, 0));
		LblError.setBounds(10, 322, 372, 33);
		contentPane.add(LblError);
		
		JButton En_Proceso = new JButton("En Proceso");
		En_Proceso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControllerCarrito controller=new ControllerCarrito();
				Carrito carrito= controller.mostrarCarritoporClienteEnProceso(cliente.getId());
				if (carrito==null) {
					LblError.setText("Error. No se encontraron carritos en proceso");
				} else {
					CarritosEnProcesoCliente carritosenprosesocliente =new CarritosEnProcesoCliente(cliente, carrito);
					carritosenprosesocliente.setVisible(true);
					dispose();
				}
			}
		});
		En_Proceso.setBackground(SystemColor.menu);
		En_Proceso.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		En_Proceso.setBounds(31, 244, 126, 71);
		contentPane.add(En_Proceso);
		
		JButton Pagado = new JButton("Pagado");
		Pagado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarritosPagadosCliente carritospagadoscliente =new CarritosPagadosCliente(cliente);
				carritospagadoscliente.setVisible(true);
				dispose();
			}
		});
		Pagado.setBackground(SystemColor.menu);
		Pagado.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Pagado.setBounds(228, 244, 126, 71);
		contentPane.add(Pagado);
		
		JButton Cancelado = new JButton("Cancelado");
		Cancelado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarritosCanceladosCliente carritoscanceladoscliente =new CarritosCanceladosCliente(cliente);
				carritoscanceladoscliente.setVisible(true);
				dispose();
			}
		});
		Cancelado.setBackground(SystemColor.menu);
		Cancelado.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Cancelado.setBounds(424, 244, 126, 71);
		contentPane.add(Cancelado);
		
		JButton Salir = new JButton("Salir");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generalCliente generalcliente = new generalCliente(cliente);
				generalcliente.setVisible(true);;
				dispose();
			}
		});
		Salir.setBounds(444, 352, 89, 23);
		contentPane.add(Salir);
	}
}
