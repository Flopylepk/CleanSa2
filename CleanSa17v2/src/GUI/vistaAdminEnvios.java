package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.CarritosDetalle;
 


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class vistaAdminEnvios extends JFrame {

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
	public vistaAdminEnvios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/////VER CARRITOS/////
		JButton btnNewButton = new JButton("Ver carritos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verCarrito ventana = new verCarrito(null );
				ventana.setVisible(true);
			}
		});
		 
		btnNewButton.setBounds(14, 190, 125, 23);
		contentPane.add(btnNewButton);
		
		/////VER DETALLE CARRITO///// POSIBLE BOTON EXTRA PARA VER DETALLE DE CARRITO
		/// JButton btnNewButton_1 = new JButton("Ver detalle carrito");
		/// btnNewButton_1.addActionListener(new ActionListener() {
	//public void actionPerformed(ActionEvent e) {
      //          CarritosDetalle ventana = new CarritosDetalle();
        //        ventana.setVisible(true);
          //  }
        //});
		
		
		
		
		
		////SALIR/////
		JButton btnNewButton_2  = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LoginAdmin ventana = new LoginAdmin();
		        ventana.setVisible(true);
		        
		    }
		});
		btnNewButton_2.setBounds(292, 190, 125, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(vistaAdminEnvios.class.getResource("/img/logo.png")));
		lblNewLabel.setBounds(55, 26, 369, 127);
		contentPane.add(lblNewLabel);
	}

}
