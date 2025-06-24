package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Producto;

public class vistaDestroyProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Producto producto;

	/**
	 * Create the frame.
	 */
	public vistaDestroyProducto(Producto productoSeleccionado) {
		this.producto = productoSeleccionado;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 250);
		setTitle("Confirmar Eliminación");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("¿Confirma que va a eliminar el producto?");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(75, 25, 333, 25);
		contentPane.add(lblTitulo);

		JLabel lblProducto = new JLabel("Producto: " + producto.getNombre());
		lblProducto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblProducto.setBounds(40, 60, 400, 25);
		contentPane.add(lblProducto);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnEliminar.setBounds(120, 120, 100, 30);
		contentPane.add(btnEliminar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCancelar.setBounds(260, 120, 100, 30);
		contentPane.add(btnCancelar);

		// Lógica para botones
		btnEliminar.addActionListener(e -> {
			// Acá llamás al método de ControllerProducto para eliminar, por ejemplo:
			// ControllerProducto.eliminarPorNombre(producto.getNombre());
			System.out.println("Eliminar: " + producto.getNombre()); // Temporal
		});

		btnCancelar.addActionListener(e -> dispose());
	}

	// Para testeo manual
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Producto producto = new Producto("Remera", 10, 999.99, 1, 0);
			new vistaDestroyProducto(producto).setVisible(true);
		});
	}
}
