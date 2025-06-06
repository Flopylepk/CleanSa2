package repositorio;
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
	
	default double validarPrecio(String mensaje) {
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
		

		return Double.parseDouble(num);
	}

	default String validarCaracteres(String mensaeje) {
		String palabra = "";
		
		if (palabra.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No completo nada");
			return null;
		} else {
			return palabra;

		}

		
		
	}
	
	 
	
	//////VALIDADOR PASSWORD MEJORAR!!!
	default String validarPassword(String mensaje) {
	    
	   
	    int tieneNumero=0;
	    int tieneMayuscula=0;
	    int tieneEspecial=0;
	    if (mensaje.isEmpty()) {
	    	JOptionPane.showMessageDialog(null, "La contraseña esta vacia");
	        return "";
		}

	    if (mensaje.length() < 8) {
	        JOptionPane.showMessageDialog(null, "Debe tener 8 o más caracteres");
	        return "";
	    }else {
	    	for (char c : mensaje.toCharArray()) {
		        if (Character.isDigit(c)) {
		        	tieneNumero++;
		        } else if (Character.isUpperCase(c)) {
		        	tieneMayuscula++;
		        } else if (!Character.isLetterOrDigit(c)) {
		        	tieneEspecial++;
		        } 
		    }
		    if (tieneNumero==0|| tieneMayuscula==0 || tieneEspecial==0) {
		        JOptionPane.showMessageDialog(null, "se produjo un  error");
		        return "";
		       
		    }
		    
		    if (tieneNumero==0) {
		        JOptionPane.showMessageDialog(null, "Debe contener al menos un número");
		        return "";
		        
		    }
		    if (tieneMayuscula==0) {
		        JOptionPane.showMessageDialog(null, "Debe contener al menos una letra mayúscula");
		        return "";
		    }		    
		    if (tieneEspecial==0) {
		        JOptionPane.showMessageDialog(null, "Debe contener al menos un carácter especial");
		        return "";
		    }
		}
	        

	    JOptionPane.showMessageDialog(null, "La contraseña es válida");
	    return mensaje; 
	}
	
	

}
