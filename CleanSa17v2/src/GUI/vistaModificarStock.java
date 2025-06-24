package GUI;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BLL.Producto;

import java.awt.Font;
import java.awt.Color;

public class vistaModificarStock extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> listaProductos;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				vistaModificarStock frame = new vistaModificarStock();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public vistaModificarStock() {
		setTitle("Modificar Stock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Título
		JLabel titulo = new JLabel("Seleccione el producto a modificar");
		titulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		titulo.setBounds(90, 20, 300, 30);
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

	
	}

	// Este método es solo placeholder
	public Producto traerProductos() {
		return null;
	}
}
