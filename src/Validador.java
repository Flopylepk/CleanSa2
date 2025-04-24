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
	
	 
	
	//////VALIDADOR PASSWORD MEJORAR!!!
	default String validarPassword(String mensaje) {
	    String palabra = mensaje; ///ESTA SERIA LA CONTRA
	    boolean tieneNumero = false;
	    boolean tieneMayuscula = false;
	    boolean tieneEspecial = false;
	    
	   
	    
	    do {

	    	palabra= JOptionPane.showInputDialog(mensaje);

	    if (palabra.length() < 8) {
	        JOptionPane.showMessageDialog(null, "Debe tener 8 o más caracteres");
	        return palabra;
	    }else {
			
		}

	    for (char c : palabra.toCharArray()) {
	        if (Character.isDigit(c)) {
	            tieneNumero = true;
	        } else if (Character.isUpperCase(c)) {
	            tieneMayuscula = true;
	        } else if (!Character.isLetterOrDigit(c)) {
	            tieneEspecial = true;
	        }
	        
	    }

	    if (!tieneNumero) {
	        JOptionPane.showMessageDialog(null, "Debe contener al menos un número");
	       
	    }
	    if (!tieneMayuscula) {
	        JOptionPane.showMessageDialog(null, "Debe contener al menos una letra mayúscula");
	        
	    }
	    if (!tieneEspecial) {
	        JOptionPane.showMessageDialog(null, "Debe contener al menos un carácter especial");
	        
	    }

		} while (tieneNumero==true || tieneMayuscula == true || tieneEspecial == true );
	    JOptionPane.showMessageDialog(null, "La contraseña es válida");
	    return palabra; 
	}
	
	

}
