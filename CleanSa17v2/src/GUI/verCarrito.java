package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Carrito;
import BLL.Producto;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;

public class verCarrito extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private JLabel lblSeleccionado;
    private JButton btnNewButton;

    public verCarrito(Carrito carrito) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Modelo de datos para la tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Carrito");
        model.addColumn("Cliente");
        model.addColumn("Total Compra");

        // Agregar datos del carrito al modelo
        model.addRow(new Object[] { carrito.getId_carrito(), carrito.getFk_cliente(), carrito.getTotal_compra() });

        // Configuración de la tabla
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 760, 128);
        contentPane.add(scrollPane);

        // Etiqueta para mostrar información seleccionada
        lblSeleccionado = new JLabel("Carrito seleccionado: ");
        lblSeleccionado.setBounds(10, 180, 400, 20);
        contentPane.add(lblSeleccionado);

        // Botón para salir
        btnNewButton = new JButton("Salir");
        btnNewButton.setBounds(10, 240, 89, 23);
        btnNewButton.addActionListener(e -> {
            LoginAdmin ventana = new LoginAdmin();
            ventana.setVisible(true);
            dispose();
        });
        contentPane.add(btnNewButton);
    }
}
