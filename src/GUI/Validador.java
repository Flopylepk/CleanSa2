package GUI;
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
	    boolean error = false;
	    int tieneNumero=0;
	    int tieneMayuscula=0;
	    int tieneEspecial=0;
	    
	   
	    
	    do {

	    	palabra= JOptionPane.showInputDialog(mensaje);

	    if (palabra.length() < 8) {
	        JOptionPane.showMessageDialog(null, "Debe tener 8 o más caracteres");
	        error=false;
	    }else {
	    	for (char c : palabra.toCharArray()) {
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
		        error=false;
		       
		    }else {
		    	error=true;
			}
		    
		    if (tieneNumero==0) {
		        JOptionPane.showMessageDialog(null, "Debe contener al menos un número");
		        
		    }
		    if (tieneMayuscula==0) {
		        JOptionPane.showMessageDialog(null, "Debe contener al menos una letra mayúscula");
		        
		    }
		    
		    if (tieneEspecial==0) {
		        JOptionPane.showMessageDialog(null, "Debe contener al menos un carácter especial");
		    }
		}

	    if (error==false) {
			mensaje="se produjo un error, ingrese la contraseña nuevamente";
		}
	    

		} while (error==false);
	    JOptionPane.showMessageDialog(null, "La contraseña es válida");
	    return palabra; 
	}
	
	

}
