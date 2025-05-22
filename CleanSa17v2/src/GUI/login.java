package GUI;

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
import javax.swing.JProgressBar;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpdni;
	private JPasswordField inpcontrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 692, 454);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imagen = new JLabel("");
		imagen.setBounds(143, 11, 352, 97);
		imagen.setIcon(new ImageIcon(login.class.getResource("/img/logo.png")));
		imagen.setHorizontalAlignment(SwingConstants.CENTER);
		imagen.setFont(new Font("Segoe Script", Font.PLAIN, 11));
		contentPane.add(imagen);
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setBounds(205, 182, 56, 33);
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_1);
		
		inpdni = new JTextField();
		inpdni.setBounds(205, 216, 206, 20);
		contentPane.add(inpdni);
		inpdni.setColumns(10);
		
		inpcontrasena = new JPasswordField();
		inpcontrasena.setBounds(205, 279, 206, 20);
		contentPane.add(inpcontrasena);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setBackground(SystemColor.desktop);
		lblNewLabel_2.setBounds(205, 254, 85, 14);
		lblNewLabel_2.setForeground(SystemColor.desktop);
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setBounds(163, 145, 46, 26);
		lblNewLabel_3.setBackground(SystemColor.menu);
		lblNewLabel_3.setForeground(SystemColor.desktop);
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 16));
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Iniciar sesión");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente=new Cliente("", "", "", "", 0,0);
				cliente=cliente.Login(inpdni.getText(),inpcontrasena.getText());
				
				if (cliente==null) {
					JOptionPane.showMessageDialog(null, "error, usuario incorrecto");
				} else {
					JOptionPane.showMessageDialog(null, cliente);
				}
				
			}
		});
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(205, 328, 206, 26);
		contentPane.add(btnNewButton);
		
		
	}
}
