import javax.swing.JOptionPane;

public interface Validador {
	
	default int validarNumeros(String mensaje) {
		boolean flag;
		String num = "";
		do {
			flag = true;
			num = JOptionPane.showInputDialog(mensaje);
			while (num.isEmpty()) {
				num = JOptionPane.showInputDialog(mensaje);
			}
			for (int i = 0; i < num.length(); i++) {
				if (!Character.isDigit(num.charAt(i))) {
					flag = false;
					break;
				}
			}
		} while (!flag);
		

		return Integer.parseInt(num);
	}
	
	
	
	default String validarCaracteres(String mensaeje) {
		String palabra = "";
		do {
			
		try {
			palabra = JOptionPane.showInputDialog(mensaeje);
			} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no completo nada");
			}
		
		} while (palabra.isEmpty());
		return palabra;
	}
	
	
	default int validarPassword (String mensaje) {
		String palabra = "";
		if (palabra.length()<8) {
			JOptionPane.showMessageDialog(null, "Debe tener 8 o más caracteres");
		}
	
		
		return 0;		
	}
	
	

}
