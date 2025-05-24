package GUI;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import BLL.*;
import DLL.*;
import enums.Opcion1;
import enums.OpcionAdmin;
import enums.OpcionClientes;
import enums.OpcionGeneral;
import enums.OpcionGeneralAD;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Cliente> listaC = new LinkedList<>();
		Cliente cliente = new Cliente("", "", "", "", 0, 0);
		Cliente clienteprueba = new Cliente("", "", "", "", 0, 0);
		Administrador admin = new Administrador("", "", 0, 0, "");
		ControllerCliente controlercliente = new ControllerCliente();
		ControllerAdmin controleradmin = new ControllerAdmin();
		// CLIENTES MENU
		int opcion1 = 0;
		int opciongeneral = 0;
		int opcionclientes = 0;

		// ADMINISTRADOR MENU
		int opcionAdmin = 0;

		// PRIMER MENU
		do {
			opcion1 = JOptionPane.showOptionDialog(null, "Ingresar como: ", null, 0, 0, null, Opcion1.values(),
					Opcion1.values()); // ADMIN O CLIENTE
			switch (opcion1) {
			case 0:
				JOptionPane.showMessageDialog(null, "Bienvenido al Cliente");
				do {

					opciongeneral = JOptionPane.showOptionDialog(null, "Elija que quiere hacer", null, 0, 0, null,
							OpcionGeneral.values(), OpcionGeneral.values());
					switch (opciongeneral) {
					case 0: // REGISTRO CLIENTE
						controlercliente.agregarCliente();
						JOptionPane.showMessageDialog(null, "registrado");
						break;

					case 1: // LOG IN
						cliente = controlercliente.login();
						if (cliente.getTipo() == 1) {
							JOptionPane.showMessageDialog(null, "Bienvenido al menu de Personal");

						} else {
							JOptionPane.showMessageDialog(null, "Bienvenido al menu de Empresa");
						}
						do {

							opcionclientes = JOptionPane.showOptionDialog(null, "elija lo que quiere hacer", null, 0, 0,
									null, OpcionClientes.values(), OpcionClientes.values());
							switch (opcionclientes) {
							case 0:
								clienteprueba = controlercliente.obtenerClientesPorID(cliente.getId());
								JOptionPane.showMessageDialog(null, cliente);
								break;
							case 1:
								String clientes = "Lista de clientes: ";
								listaC = controlercliente.mostrarClientes();
								for (Cliente cliente2 : listaC) {
									clientes = clientes + "\n" + cliente2.toString();
								}
								JOptionPane.showMessageDialog(null, clientes);
								break;
							case 2:
								JOptionPane.showMessageDialog(null, "comprar");
								break;
							case 3:
								JOptionPane.showMessageDialog(null, "Ver_carrito");
								break;
							case 4:
								JOptionPane.showMessageDialog(null, "Ver_compras");
								break;
							case 5:
								JOptionPane.showMessageDialog(null, "Ver_estado_de_envio");
								break;
							case 6:
								JOptionPane.showMessageDialog(null, "Ver_productos");
								break;
							case 7:
								JOptionPane.showMessageDialog(null, "Pagar");
								break;
							case 8:
								JOptionPane.showMessageDialog(null, "Cancelar");
								break;
							case 9:
								JOptionPane.showMessageDialog(null, "Gracias por venir");
								break;

							}

						} while (opcionclientes != 9);
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "nos vemos la proxima");
						break;
					}
				} while (opciongeneral != 2);
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Bienvenido al Administrador");
				do {

					opcionAdmin = JOptionPane.showOptionDialog(null, "Indique que quiere hacer", null, 0, 0, null,
							OpcionAdmin.values(), OpcionAdmin.values());
					switch (opcionAdmin) {
					case 0:
						admin = controleradmin.login();
						if (admin !=null) {
							if (admin.getTipo() == 1) {
								JOptionPane.showMessageDialog(null, "Bienvenido al Administrador de ventas");
							}else {
								JOptionPane.showMessageDialog(null, "No tienes permisos de Administrador de ventas");
							}													
						}else {
							JOptionPane.showMessageDialog(null, "Los credenciales no coinciden");
						}					
						break;						
					case 1:
						admin = controleradmin.login();
						if (admin !=null) {
							if (admin.getTipo()== 2) {
								JOptionPane.showMessageDialog(null, "Bienvenido al Administrador de Envios");
							}else {
								JOptionPane.showMessageDialog(null, "No tienes permisos Administrador de Envios");
							}
														
						}else {
							JOptionPane.showMessageDialog(null, "Los credenciales no coinciden");
						}
						break; 
					case 2:
						JOptionPane.showMessageDialog(null, "nos vemos la proxima");
						break;
					}
				} while (opcionAdmin != 2);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Nos vemos la proxima");
				break;
			}
		} while (opcion1 != 2);
	}

}
