package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Cliente;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompraExitosa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public CompraExitosa(Cliente cliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 393);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel icono = new JLabel("");
		icono.setBounds(86, 11, 341, 111);
		icono.setIcon(new ImageIcon(CompraExitosa.class.getResource("/img/logo.png")));
		contentPane.add(icono);
		
		JLabel SI = new JLabel("Producto agregado con exito");
		SI.setBounds(122, 147, 274, 26);
		SI.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		contentPane.add(SI);
		
		JLabel SI2 = new JLabel("Para volver a la pantalla de cliente haga click en el botón \"Salir\"");
		SI2.setBounds(55, 184, 401, 26);
		SI2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		contentPane.add(SI2);
		
		JButton Volver = new JButton("Volver");
		Volver.setBounds(307, 263, 124, 59);
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cliente.getTipo()==1) {
					Tabla2 tabla2 =new Tabla2(cliente);
					tabla2.setVisible(true);
					dispose();
				} else {
					Tabla3 tabla3 =new Tabla3(cliente);
					tabla3.setVisible(true);
					dispose();
				}
			}
		});
		Volver.setBackground(SystemColor.menu);
		Volver.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		contentPane.add(Volver);
		
		JLabel lblParaVolverA = new JLabel("Para volver a la pantalla de compra haga click en el botón \"Volver\"");
		lblParaVolverA.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblParaVolverA.setBounds(44, 214, 412, 26);
		contentPane.add(lblParaVolverA);
		
		JButton Salir = new JButton("Salir");
		Salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generalCliente generalcliente = new generalCliente(cliente);
				generalcliente.setVisible(true);;
				dispose();
			}
		});
		Salir.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Salir.setBackground(SystemColor.menu);
		Salir.setBounds(86, 263, 124, 59);
		contentPane.add(Salir);
	}
}
