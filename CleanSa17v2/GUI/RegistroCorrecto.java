package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroCorrecto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public RegistroCorrecto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 419);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel icono = new JLabel("");
		icono.setIcon(new ImageIcon(RegistroCorrecto.class.getResource("/img/logo.png")));
		icono.setBounds(115, 11, 341, 111);
		contentPane.add(icono);
		
		JLabel SI = new JLabel("Gracias por registrarse");
		SI.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		SI.setBounds(173, 161, 210, 26);
		contentPane.add(SI);
		
		JLabel SI2 = new JLabel("Para volver a la pantalla de cliente haga click en el botón \"Volver\"");
		SI2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		SI2.setBounds(86, 217, 401, 26);
		contentPane.add(SI2);
		
		JButton Volver = new JButton("Volver");
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuCliente menucliente = new menuCliente();
				menucliente.setVisible(true);;
				dispose();
			}
		});
		Volver.setBackground(SystemColor.menu);
		Volver.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Volver.setBounds(210, 275, 124, 59);
		contentPane.add(Volver);
	}
}
