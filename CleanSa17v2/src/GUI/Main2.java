package GUI;

import javax.swing.JOptionPane;

import BLL.*;
import DLL.*;
import enums.Opcion1;
import enums.OpcionGeneral;
import enums.OpcionGeneralAD;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente("", "", "", "", 0,0);
		Administrador admin=new Administrador("","",0,0,"");
		ControllerCliente controlercliente = null;
		ControllerAdmin controleradmin = null;
		int opcion1=0;
		int opciongeneral=0;
		do {
			opcion1=JOptionPane.showOptionDialog(null, "elija que quiere ser", null, 0, 0, null,Opcion1.values() , Opcion1.values());
			switch (opcion1) {
			case 0:
				JOptionPane.showMessageDialog(null, "Bienvenido al Cliente");
				do {
					
				opciongeneral=JOptionPane.showOptionDialog(null, "elija que quiere hacer", null, 0, 0, null, OpcionGeneral.values(), OpcionGeneral.values());
				switch (opciongeneral) {
				case 0:
					controlercliente.agregarCliente();
					break;

				case 1:
					cliente=controlercliente.login();
					if (cliente.getTipo()==1) {
						
					}
					break;
				case 2:
					JOptionPane.showMessageDialog(null, "nos vemos la proxima");
					break;
				}
				} while (opciongeneral!=0);
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Bienvenido al Administrador");
				do {
					
					opciongeneral=JOptionPane.showOptionDialog(null, "Indique que quiere hacer", null, 0, 0, null, OpcionGeneralAD.values(), OpcionGeneralAD.values());
					switch (opciongeneral) {
					case 0:
						admin=controleradmin.login();
						
						break;

					case 1:
						JOptionPane.showMessageDialog(null, "nos vemos la proxima");
						break;
					}
					} while (opciongeneral!=0);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Nos vemos la proxima");
				break;
			}
		} while (opcion1!=2);
	}

}
