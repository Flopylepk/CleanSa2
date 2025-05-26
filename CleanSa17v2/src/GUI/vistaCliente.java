package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class vistaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaCliente frame = new vistaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public vistaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 347);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn_loginCliente = new JButton("LogIn");
		btn_loginCliente.setFont(new Font("Verdana", Font.ITALIC, 11));
		btn_loginCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_loginCliente.setBounds(270, 187, 150, 23);
		contentPane.add(btn_loginCliente);
		
		JButton btn_registrarseCliente = new JButton("Registrarse");
		btn_registrarseCliente.setFont(new Font("Verdana", Font.ITALIC, 11));
		btn_registrarseCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_registrarseCliente.setBounds(95, 187, 150, 23);
		contentPane.add(btn_registrarseCliente);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(vistaCliente.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(102, 11, 382, 113);
		contentPane.add(lblNewLabel);
	}
}
