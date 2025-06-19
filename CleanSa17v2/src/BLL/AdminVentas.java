package BLL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import DLL.ControllerProducto;

import GUI.Main;
import repositorio.Validador;

public class AdminVentas extends Administrador implements Validador {	
	public AdminVentas(String nombre, String apellido, int id, int tipo, String contrasena) {
		super(nombre, apellido, id, tipo, contrasena);
	}

public void  RegistroProducto(Producto producto) {
		String [] catProduc =   {
			"Hiegie Personal","Higiene del Hogar","Otro"
		};
		String [] peligro = {
				"Si","No"
		};	
		String nombre=validarCaracteres("ingrese el nombre del producto: ");
		int stock=validarNumeros("ingrese la cantidad de stock que tiene el producto: ");		
		String categoria= (String)JOptionPane.showInputDialog(
				null, 
				"Ingrese la categoria", 
				"TIPO PRODUCTO", 
				JOptionPane.DEFAULT_OPTION, 
				new ImageIcon(Main.class.getResource("usuario.png")) 
						,catProduc
						,catProduc[0] 
				);		
		int categoriaId = 0;
		switch (categoria) {
			case "Higiene Personal":
				categoriaId = 1;
				break;
			case "Higiene del Hogar":
				categoriaId = 2;
				break;
			case "Otro":
				categoriaId = 3;
				break;
		}
		
		boolean peligroso = true;
		int opcion = JOptionPane.showOptionDialog(null, "ingrese si es peligroso o no", "pelogrosos", JOptionPane.DEFAULT_OPTION, 
				0, new ImageIcon(Main.class.getResource("usuario.png")) 
				,peligro
				,peligro[0]);
		double precio=(double) validarNumeros("Ingrese el precio: ");
		if (opcion == 1) {
			peligroso = false;
		}
		
		ControllerProducto db = new ControllerProducto();
		if (db.encontrarProductos(nombre)) {
			JOptionPane.showMessageDialog(null, "Ya existe este producto, no se puede agregar.");
		}
		Producto nuevo = new Producto (nombre, stock, precio, categoriaId, peligroso);
		
		
		
		
		}		
}
