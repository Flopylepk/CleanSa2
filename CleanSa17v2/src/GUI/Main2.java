package GUI;

import javax.swing.JOptionPane;

import BLL.*;
import DLL.*;
import enums.Opcion1;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente("", "", "", "", 0);
		Administrador admin=new Administrador("","",0,0,"");
		int opcion1=0;
		do {
			opcion1=JOptionPane.showOptionDialog(null, "elija que quiere ser", null, 0, 0, null,Opcion1.values() , Opcion1.values());
			
		} while (opcion1==2);
	}

}
