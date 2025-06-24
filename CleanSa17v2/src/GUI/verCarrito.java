package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Carrito;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class verCarrito extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    public verCarrito(Carrito carrito) {
        setTitle("Detalle del Carrito");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 300);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(220, 220, 220));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Título
        JLabel lblTitulo = new JLabel("Información del Carrito");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitulo.setBounds(180, 10, 300, 30);
        contentPane.add(lblTitulo);

        // Tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Campo");
        model.addColumn("Valor");

        model.addRow(new Object[] { "ID Carrito", carrito.getId_carrito() });
        model.addRow(new Object[] { "Fecha", carrito.getFecha() });
        model.addRow(new Object[] { "Estado", carrito.getEstado() });
        model.addRow(new Object[] { "Total de compra", carrito.getTotal_compra() });
        model.addRow(new Object[] { "Código de envío", carrito.getCodigo_envio() });
        model.addRow(new Object[] { "Cliente (fk)", carrito.getFk_cliente() });

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(30, 60, 520, 130);
        contentPane.add(scrollPane);

        // Botón Salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(240, 210, 100, 30);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginAdmin ventana = new LoginAdmin();
                ventana.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnSalir);
    }
}
