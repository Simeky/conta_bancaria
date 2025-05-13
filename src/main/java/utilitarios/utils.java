package utilitarios;

public class utils {

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

        int sm = 0, r, num, peso = 10; 
        
        for (byte i= 0; i < 9; i++) {
            num = (cpf_n_formatado.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }
            
        r = 11 - (sm % 11);
            
        char dig10;
        if ((r == 10) || (r == 11)) {
            dig10 = '0';
        }   else {
            	dig10 = (char)(r + 48);
            }
            
        sm = 0;
        peso = 11;
            
        for(i=0; i<10; i++) {
            num = (cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }
            
        r = 11 - (sm % 11);
            
        if ((r == 10) || (r == 11)) {
        	dig11 = '0';
        }   else {
        	    dig11 = (char)(r + 48);
            }

        if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))) {
            	return(true);
        }   else {
            	return(false);
            }
        
    }

}
