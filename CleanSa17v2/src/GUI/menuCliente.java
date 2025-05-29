package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class menuCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public menuCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Que quiere realizar");
		lblNewLabel.setFont(new Font("Verdana", Font.ITALIC, 14));
		lblNewLabel.setBounds(138, 67, 141, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setBackground(SystemColor.menu);
		btnRegistro.setFont(new Font("Verdana", Font.ITALIC, 11));
		btnRegistro.setBounds(49, 129, 149, 23);
		contentPane.add(btnRegistro);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setFont(new Font("Verdana", Font.ITALIC, 11));
		btnLogin.setBackground(SystemColor.menu);
		btnLogin.setBounds(237, 129, 149, 23);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(menuCliente.class.getResource("/img/logochico.png")));
		lblNewLabel_1.setBounds(257, 228, 177, 33);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("salir");
		btnNewButton.setBounds(20, 228, 69, 23);
		contentPane.add(btnNewButton);
	}
}
