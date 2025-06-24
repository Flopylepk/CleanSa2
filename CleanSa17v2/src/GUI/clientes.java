package GUI;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

import BLL.*;
import DLL.*;

public class clientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private Cliente clienteSeleccionado;
    private JTextField inpFiltro;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				clientes frame = new clientes();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 550);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.window); // blanco
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Logo
        JLabel logo = new JLabel("");
        logo.setIcon(new ImageIcon(clientes.class.getResource("/img/logo.png")));
        logo.setBounds(240, 10, 300, 80);
        contentPane.add(logo);

        JLabel lblSeleccionado = new JLabel("Seleccionado:");
        lblSeleccionado.setBounds(10, 100, 760, 20);
        contentPane.add(lblSeleccionado);

        model = new DefaultTableModel(new String[]{
        	"nombre", "contraseña", "direccion", "dni", "id", "tipo"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 130, 760, 200);
        contentPane.add(scrollPane);

        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = table.getSelectedRow();
                if (row != -1) {
                	clienteSeleccionado = new Cliente(
                        (String) model.getValueAt(row, 0),
                        (String) model.getValueAt(row, 1),
                        (String) model.getValueAt(row, 2),
                        (String) model.getValueAt(row, 3),
                        (int) model.getValueAt(row, 4),
                        (int) model.getValueAt(row, 5)
                    );
                	lblSeleccionado.setText(clienteSeleccionado.toString());
                }
            }
        });

        JLabel lblFiltro = new JLabel("Filtro:");
        lblFiltro.setBounds(10, 350, 117, 14);
        contentPane.add(lblFiltro);

        inpFiltro = new JTextField();
        inpFiltro.setBounds(10, 370, 140, 35);
        contentPane.add(inpFiltro);
        inpFiltro.setColumns(10);

        JButton btnFiltrar = new JButton("Filtrar nombre");
        btnFiltrar.setBounds(170, 365, 140, 45);
        contentPane.add(btnFiltrar);
        btnFiltrar.addActionListener(e -> cargarTablaFiltro(inpFiltro.getText()));

        JButton btnRecargar = new JButton("Recargar");
        btnRecargar.setBounds(330, 365, 140, 45);
        contentPane.add(btnRecargar);
        btnRecargar.addActionListener(e -> cargarTabla());

        cargarTabla();
    }

    private void cargarTabla() {
        model.setRowCount(0);
        ControllerCliente controller = new ControllerCliente();
        LinkedList<Cliente> clientes = controller.mostrarClientes();
        for (Cliente u : clientes) {
            model.addRow(new Object[]{
            	u.getNombre(),
            	u.getContrasena(),
            	u.getDireccion(),
            	u.getDni(),
            	u.getId(),
            	u.getTipo()
            });
        }
    }

    private void cargarTablaFiltro(String filtro) {
        model.setRowCount(0);
        ControllerCliente controller = new ControllerCliente();
        LinkedList<Cliente> clientes = controller.mostrarClientes();
        for (Cliente u : clientes) {
            if (u.getNombre().startsWith(filtro)) {
                model.addRow(new Object[]{
                	u.getNombre(),
                	u.getContrasena(),
                	u.getDireccion(),
                	u.getDni(),
                	u.getId(),
                	u.getTipo()
                });
            }
        }
    }
}
