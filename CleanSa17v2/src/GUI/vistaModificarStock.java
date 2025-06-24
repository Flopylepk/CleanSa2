package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Producto;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class vistaModificarStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaModificarStock frame = new vistaModificarStock();
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
	public vistaModificarStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<?> lista_productos = new JComboBox();
		lista_productos.setBounds(20, 43, 146, 22);
		contentPane.add(lista_productos);
		
		JLabel titulo = new JLabel("Seleccione el producto a modificar");
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		titulo.setBounds(10, 11, 354, 22);
		contentPane.add(titulo);

		// ComboBox de productos
		listaProductos = new JComboBox<>();
		listaProductos.setBounds(120, 70, 220, 25);
		contentPane.add(listaProductos);

		// Botón modificar
		JButton botonModificar = new JButton("Modificar Stock");
		botonModificar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		botonModificar.setBounds(160, 120, 150, 30);
		contentPane.add(botonModificar);

		// Volver
		JButton botonVolver = new JButton("Volver");
		botonVolver.setBounds(10, 220, 100, 25);
		botonVolver.addActionListener(e -> {
			vistaProductosAdmin ventana = new vistaProductosAdmin();
			ventana.setVisible(true);
			dispose();
		});
		contentPane.add(botonVolver);

	
		
		JButton boton_modificar = new JButton("Modificar");
		boton_modificar.setBounds(91, 72, 75, 23);
		contentPane.add(boton_modificar);
	}
	
	public Producto traerProductos() {
		
		return null;
		
	}
}
