package BLL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import GUI.Main;
import repositorio.Validador;

public class AdminVentas extends Administrador implements Validador {
	
	private String id_ventas;
	public AdminVentas(String nombre, String apellido, String id_ventas) {
		super(nombre, apellido);
		this.id_ventas = id_ventas;
	}
	public String getId_ventas() {
		return id_ventas;
	}
	public void setId_ventas(String id_ventas) {
		this.id_ventas = id_ventas;
	}
	
	public boolean logIn(AdminVentas ventas) {
		String numero="";
		numero=ventas.validarCaracteres("Ingrese su numero");
		if (numero.equalsIgnoreCase(id_ventas)) {
			return true;
		}else {
			
			return false;
		}
	
	} 
	
	/////REGISTRO PRODUCTO
		public void  RegistroProducto(Producto producto) {
		String [] catProduc =   {
			"Hiegie Personal","Higiene del Hogar","Otro"
		};
		String [] peligro = {
				"Si","No"
		};
			
		String nombre=validarCaracteres("ingrese el nombre del producto");
		int stock=validarNumeros("ingrese la cantidad de stock que tiene el producto");
		////menu desplegable 
		
		String categoria= (String)JOptionPane.showInputDialog(
				null, 
				"Ingrese la categoria", 
				"TIPO PRODUCTO", 
				JOptionPane.DEFAULT_OPTION, 
				new ImageIcon(Main.class.getResource("usuario.png")) 
						,catProduc
						,catProduc[0] 
				);
		boolean peligroso= true;
		int opcion= JOptionPane.showOptionDialog(null, "ingrese si es peligroso o no", "pelogrosos", JOptionPane.DEFAULT_OPTION, 
				0, new ImageIcon(Main.class.getResource("usuario.png")) 
				,peligro
				,peligro[0]);
		switch (opcion) {
		case 0:
			///PELIGROSO TRUE
			peligroso=true;
			break;

		case 1:
			///PELIGROSO FALSE
			peligroso=false;
			break;
		}
		
		double precio=(double) validarNumeros("ingrese un numero");
		
//		Producto nuevo = new Producto (nombre, stock,precio ,categoria,peligroso);
//		
//		if (Producto.getProducto().isEmpty()) {
//			Producto.getProducto().add(nuevo);
//			return;
//		} else {
//			for (Producto x : Producto.getProducto()) {
//				if (x.getNombre().equals(nuevo.getNombre())) {
//					JOptionPane.showMessageDialog(null, "El clienet ya existe");
//					return;
//				}
//			}
//			Producto.getProducto().add(nuevo);
//			return;
//		}
		
		
		}
		
		
	
	
	


}
