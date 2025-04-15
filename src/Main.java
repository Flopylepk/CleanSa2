import javax.swing.JOptionPane;

import enums.Opcion1;
import enums.OpcionCliente;
import enums.OpcionClientes;
import enums.OpcionGeneral;

public class Main {

	public static void main(String[] args) {
		int opcion1=0;
		int opciongeneral=0;
		int opcioncliente=0;
		int opcionadmin=0;
		int opcionclientes=0;
		int opcionadminenvios=0;
		int opcionadminventas=0;
		
		do {
			opcion1=JOptionPane.showOptionDialog(null, "Elija una opcion", null, 0, 0, null, Opcion1.values(), Opcion1.values());
			switch (opcion1) {
			case 0:
				//Clientes
				do {
					opcioncliente=JOptionPane.showOptionDialog(null, "Elija como que tipo de cliente se quiere registrar", null, 0, 0, null, OpcionCliente.values(), OpcionCliente.values());
					switch (opcioncliente) {
					case 0:
						//generales
						JOptionPane.showMessageDialog(null, "Bienvenido al registro y login de los clientes generales");
						do {
							opciongeneral=JOptionPane.showOptionDialog(null, "Elija lo que quiere realizar", null, 0, 0, null, OpcionGeneral.values(), OpcionGeneral.values());
							switch (opciongeneral) {
							case 0:
								//registrogeneral
								JOptionPane.showMessageDialog(null, "aca va el registro del cliente general");
								break;
							case 1:
								//logingeneral
								JOptionPane.showMessageDialog(null, "aca va el login del cliente general");
								JOptionPane.showMessageDialog(null, "cuando el login es correcto pasa al menu principal");
								
								do {
									opcionclientes=JOptionPane.showOptionDialog(null, "Menu principal, elija una opcion", null, 0, 0, null, OpcionClientes.values(), OpcionClientes.values());
									switch (opcionclientes) {
									case 0:
										//Ver_mi_informacion
										JOptionPane.showMessageDialog(null, "el cliente puede ver su propia informacion");
										break;
									case 1:
										//Comprar
										JOptionPane.showMessageDialog(null, "el cliente podra realizar una compra sin permiso a los productos peligrosos y se agregara a su carrito hasta que pague");
										break;
									case 2:
										//Ver_carrito(osea compras pendientes)
										JOptionPane.showMessageDialog(null, "El cliente puede ver su carrito o su compra pendiente");
										break;
									case 3:
										//Ver_compras(distinguidas entre las canseladas y las realizadas)
										JOptionPane.showMessageDialog(null, "El cliente podra ver su compra distinguida entre las canceladas y las realizadas");
										
										break;
									case 4:
										//Ver_estado_de_envio
										JOptionPane.showMessageDialog(null, "el cliente podra ver el estado de su pedido");
										break;
									case 5:
										//Ver_productos
										JOptionPane.showMessageDialog(null, "el cliente podra ver los productos");
										break;
									case 6:
										//Pagar
										JOptionPane.showMessageDialog(null, "el cliente podra pagar sus pedidos y pasaran a ser realizados");
										break;
									case 7:
										//Cancelar
										JOptionPane.showMessageDialog(null, "el cliente podra cancelar sus pedidos y pasaran a ser canselados");
										break;
									case 8:
										JOptionPane.showMessageDialog(null, "nos vemos la proxima");
										break;
									}
								} while (opcionclientes!=8);
								
								break;

							case 2:
								JOptionPane.showMessageDialog(null, "esperamos que lo halla disfrutado, nos vemos la proxima");
								break;
							}
						} while (opciongeneral!=2);
						break;
					case 1:
						//empresas
						JOptionPane.showMessageDialog(null, "Bienvenido al registro y login de las empresas");
						do {
							opciongeneral=JOptionPane.showOptionDialog(null, "Elija lo que quiere realizar", null, 0, 0, null, OpcionGeneral.values(), OpcionGeneral.values());
							switch (opciongeneral) {
							case 0:
								//registroempresas
								JOptionPane.showMessageDialog(null, "aca va el registro de las empresas");
								break;
							case 1:
								//loginempresas
								JOptionPane.showMessageDialog(null, "aca va el login de las empresas");
								JOptionPane.showMessageDialog(null, "cuando el login es correcto pasa al menu principal");
								do {
									opcionclientes=JOptionPane.showOptionDialog(null, "Menu principal, elija una opcion", null, 0, 0, null, OpcionClientes.values(), OpcionClientes.values());
									switch (opcionclientes) {
									case 0:
										//Ver_mi_informacion
										JOptionPane.showMessageDialog(null, "el cliente puede ver su propia informacion");
										break;
									case 1:
										//Comprar
										JOptionPane.showMessageDialog(null, "el cliente podra realizar una compra con permiso a los productos peligrosos y se catalogan como en proceso hasta que se pague");
										break;
									case 2:
										//Ver_carrito(osea compras pendientes)
										JOptionPane.showMessageDialog(null, "El cliente puede ver su carrito o su compra pendiente");
										break;
									case 3:
										//Ver_compras(distinguidas entre las canseladas y las realizadas)
										JOptionPane.showMessageDialog(null, "El cliente podra ver su compra distinguida entre las canceladas y las realizadas");
										
										break;
									case 4:
										//Ver_estado_de_envio
										JOptionPane.showMessageDialog(null, "el cliente podra ver el estado de su pedido");
										break;
									case 5:
										//Ver_productos
										JOptionPane.showMessageDialog(null, "el cliente podra ver los productos");
										break;
									case 6:
										//Pagar
										JOptionPane.showMessageDialog(null, "el cliente podra pagar sus pedidos y pasaran a ser realizados");
										break;
									case 7:
										//Cancelar
										JOptionPane.showMessageDialog(null, "el cliente podra cancelar sus pedidos y pasaran a ser canselados");
										break;
									case 8:
										JOptionPane.showMessageDialog(null, "nos vemos la proxima");
										break;
									}
								} while (opcionclientes!=8);
								break;

							case 2:
								JOptionPane.showMessageDialog(null, "esperamos que lo halla disfrutado, nos vemos la proxima");
								break;
							}
						} while (opciongeneral!=2);
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Gracias por entrar a la opcion de cliente de CleanSA, nos vemos la proxima");
						break;


					}
				} while (opcioncliente!=2);
				break;
			case 1:
				//Admins
				do {
					
				} while (opcionadmin!=2);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Gracias por entrar a la CleanSA, nos vemos la proxima");
				break;


			}
		} while (opcion1!=2);
		
	}
}
