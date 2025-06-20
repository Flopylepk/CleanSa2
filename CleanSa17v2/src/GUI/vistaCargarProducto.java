package GUI;

import java.awt.EventQueue;
import java.awt.TextField;

import DLL.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Categoria;
import DLL.ControllerProducto;
import DLL.ControllerCategoria;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class vistaCargarProducto extends JFrame {
	private ControllerProducto controller;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JComboBox<Categoria> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaCargarProducto frame = new vistaCargarProducto();
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
	public vistaCargarProducto() {
		controller = new ControllerProducto();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 27, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 70, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 54, 46, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setBounds(10, 101, 46, 14);
		contentPane.add(lblStock);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 117, 86, 20);
		contentPane.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 164, 105, 22);
		contentPane.add(comboBox);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setBounds(10, 148, 78, 14);
		contentPane.add(lblCategoria);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Producto Peligroso");
		chckbxNewCheckBox.setBounds(6, 195, 129, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JButton cargarProducto = new JButton("Agregar Producto");
		cargarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = textField.getSelectedText();
					double precio = Double.parseDouble(textField_1.getText());
					int stock = Integer.parseInt(textField_2.getText());
					Categoria categoriaSeleccionada = (Categoria) comboBox.getSelectedItem();
					int idCategoria = categoriaSeleccionada.getId_categoria();
					
				 
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		cargarProducto.setBounds(169, 229, 129, 23);
		contentPane.add(cargarProducto);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(vistaCargarProducto.class.getResource("/img/logo.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(117, 0, 309, 137);
		contentPane.add(lblNewLabel_1);
	}
	
	private void cargarProductos() {
		
	}
	
	private void limpiarFormulario() {
		
	}
	
	private void traerCategoria() {
		ControllerCategoria controllercategoria = new ControllerCategoria();
		LinkedList<Categoria> categorias = new LinkedList();
		
		controllercategoria.mostrarCategorias();
		for (Categoria c : categorias) {
			comboBox.addItem(c);
		}
	}
}
