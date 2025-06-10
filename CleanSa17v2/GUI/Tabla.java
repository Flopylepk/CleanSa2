package GUI;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BLL.*;
import DLL.*;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class Tabla extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private Producto productoSeleccionado;
    private JTextField inpFiltro;


    public Tabla(Carrito carrito) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.controlShadow);
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSeleccionado = new JLabel("Seleccionado:");
        lblSeleccionado.setBounds(10, 10, 760, 20);
        contentPane.add(lblSeleccionado);

        model = new DefaultTableModel(new String[]{
        	"nombre",
     		"stock",
      		"precio",
      		"fk_categoria",
      		"peligroso",
          	"id_producto"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 760, 200);
        contentPane.add(scrollPane);

        // Acción al seleccionar fila
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = table.getSelectedRow();
                if (row != -1) {

         

                	productoSeleccionado = new Producto(
                        (String) model.getValueAt(row, 0),
                        (int) model.getValueAt(row, 1),
                        (double) model.getValueAt(row, 2),
                        (int) model.getValueAt(row, 3),
                        (int) model.getValueAt(row, 4),
                        (int) model.getValueAt(row,5)
                        
                        
                    );
                	
                	lblSeleccionado.setText(productoSeleccionado.toString());
                	
                	
          }
                }
                });
                    inpFiltro = new JTextField();
                    inpFiltro.setBounds(10, 296, 118, 40);
                    contentPane.add(inpFiltro);
                    inpFiltro.setColumns(10);
                    inpFiltro.setVisible(true);
                    JButton btnNewButton = new JButton("Filtrar nombre");
                    btnNewButton.setVisible(true);
                    btnNewButton.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		
                    		cargarTablaFiltro(inpFiltro.getText());
                    	}
                    });
                    btnNewButton.setBounds(162, 291, 118, 51);
                    contentPane.add(btnNewButton);
                    
                    JLabel lblNewLabel = new JLabel("Filtro");
                    lblNewLabel.setBounds(10, 271, 117, 14);
                    contentPane.add(lblNewLabel);
                    
                    JButton volver = new JButton("Recargar");
                    volver.addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		cargarTabla();
                    		
                    	}
                    });
                    volver.setBounds(310, 291, 118, 51);
                    contentPane.add(volver);
            
           
      

        // Cargar datos
        cargarTabla();

        
    }

    private void cargarTabla() {
        model.setRowCount(0);
        LinkedList<Producto> productos = ControllerProducto.mostrarProductos();
        for (Producto u : productos) {
            model.addRow(

            		new Object[]{
            				u.getNombre(),
            				u.getStcok(),
            				u.getPrecio(),
            				u.getCategoria(),
            				u.getPeligroso(),
            				u.getId()
            				
            		}
            		);
        }
    }
    
    private void cargarTablaFiltro(String filtro) {
        model.setRowCount(0);
        LinkedList<Producto> productos = ControllerProducto.mostrarProductos();
        for (Producto u : productos) {
            if (u.getNombre().startsWith(filtro)) {
		
        	model.addRow(

            		new Object[]{
            				u.getNombre(),
            				u.getStcok(),
            				u.getPrecio(),
            				u.getCategoria(),
            				u.getPeligroso(),
            				u.getId()
            				
            		}
            		);
        }
    		
		}
    }
}
