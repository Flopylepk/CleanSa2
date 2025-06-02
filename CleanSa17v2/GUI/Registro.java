package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.OpcionCliente;
import javax.swing.JButton;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 457);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Registro.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(72, 11, 326, 97);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registrate");
		lblNewLabel_1.setBackground(SystemColor.desktop);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(82, 119, 88, 24);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(SystemColor.menu);
		textField.setBounds(102, 173, 230, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBackground(SystemColor.desktop);
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(102, 154, 68, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Contraseña");
		lblNewLabel_2_1.setBackground(SystemColor.desktop);
		lblNewLabel_2_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(102, 204, 81, 14);
		contentPane.add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(SystemColor.menu);
		passwordField.setBounds(102, 222, 230, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2_2 = new JLabel("DNI");
		lblNewLabel_2_2.setBackground(SystemColor.desktop);
		lblNewLabel_2_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(102, 253, 68, 14);
		contentPane.add(lblNewLabel_2_2);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.menu);
		textField_1.setColumns(10);
		textField_1.setBounds(102, 271, 230, 20);
		contentPane.add(textField_1);
		
		JComboBox tipoUsuario = new JComboBox();
		tipoUsuario.setModel(new DefaultComboBoxModel(OpcionCliente.values()));
		tipoUsuario.setBackground(SystemColor.menu);
		tipoUsuario.setBounds(102, 321, 230, 22);
		contentPane.add(tipoUsuario);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Escoja su tipo de usuario");
		lblNewLabel_2_1_1.setBackground(SystemColor.desktop);
		lblNewLabel_2_1_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNewLabel_2_1_1.setBounds(102, 302, 230, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton = new JButton("Regitrar");
		btnNewButton.setFont(new Font("Verdana", Font.ITALIC, 12));
		btnNewButton.setBounds(148, 365, 133, 23);
		contentPane.add(btnNewButton);
	}
}
