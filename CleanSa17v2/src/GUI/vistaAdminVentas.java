package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class vistaAdminVentas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaAdminEnvios frame = new vistaAdminEnvios();
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
	public vistaAdminVentas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cargar Productos");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			vistaCargarProducto ventana = new vistaCargarProducto();
			ventana.setVisible(true);
			
			
			}
		});
		btnNewButton.setBounds(19, 183, 125, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Actualizar stock");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
			}
		});
		btnNewButton_1.setBounds(163, 183, 125, 23);
		contentPane.add(btnNewButton_1);
		
		
		///////SALIR
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LoginAdmin ventana = new LoginAdmin();
		        ventana.setVisible(true);
		        
		    }
		});
		btnNewButton_2.setBounds(145, 227, 125, 23);
		contentPane.add(btnNewButton_2);
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(vistaAdminEnvios.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(35, 0, 369, 127);
		contentPane.add(lblNewLabel);
		
		JButton ver_productos = new JButton("Ver productos ");
		ver_productos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ver_productos.setBounds(307, 183, 106, 23);
		contentPane.add(ver_productos);
		
		JButton btnNewButton_3 = new JButton("Ver clientes");
		btnNewButton_3.setBounds(19, 153, 125, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Ver balance");
		btnNewButton_4.setBounds(163, 153, 125, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Historial");
		btnNewButton_5.setBounds(307, 153, 106, 23);
		contentPane.add(btnNewButton_5);
	}
}
