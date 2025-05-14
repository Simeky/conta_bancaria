package utilitarios;

public class Utils {

    public static String so_numeros(String numero_texto){

        String retorno = "";

        for (int i = 0; i < numero_texto.length(); i++) {

            if ("0123456789".contains(String.valueOf(numero_texto.charAt(i)))) {

                retorno += numero_texto.charAt(i);
                
            }
            
        }

        return retorno;

    }

    public static boolean validar_cpf(String cpf) {

        String cpf_n_formatado = so_numeros(cpf);
        char dig10, dig11;
        int sm = 0, r; 

        if (cpf_n_formatado.length() != 11) 
            return false;        

        if (cpf_n_formatado.chars().distinct().count() == 1)
            return false;
        
        for (byte i= 0; i < 9; i++) {
            sm += (cpf_n_formatado.charAt(i) - 48) * (10 - i);
        }
            
        r = 11 - (sm % 11);            
        
        if ((r == 10) || (r == 11)) {
            dig10 = '0';
        }   else {
            	dig10 = (char)(r + 48);
            }
            
        sm = 0;
            
        for(byte i=0; i<10; i++) {
            sm += (cpf_n_formatado.charAt(i) - 48) * (11 - i);
        }
            
        r = 11 - (sm % 11);
            
        if ((r == 10) || (r == 11)) {
        	dig11 = '0';
        }   else {
        	    dig11 = (char)(r + 48);
            }

        if ((dig10 == cpf_n_formatado.charAt(9)) && (dig11 == cpf_n_formatado.charAt(10))) {
            	return(true);
        }   else {
            	return(false);
            }
        
    }

}
