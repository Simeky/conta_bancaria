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

    public static boolean validar_cnpj(String cnpj) {
        String cnpj_n_formatado = so_numeros(cnpj);

        if (cnpj_n_formatado.length() != 14)
            return false;

        if (cnpj_n_formatado.chars().distinct().count() == 1)
            return false;

        int[] pesos1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesos2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int sm = 0, r;
        char dig13, dig14;

        // Calcula o 1º dígito verificador
        for (int i = 0; i < 12; i++)
            sm += (cnpj_n_formatado.charAt(i) - 48) * pesos1[i];

        r = sm % 11;
        dig13 = (r < 2) ? '0' : (char)((11 - r) + 48);

        // Calcula o 2º dígito verificador
        sm = 0;
        for (int i = 0; i < 13; i++)
            sm += (cnpj_n_formatado.charAt(i) - 48) * pesos2[i];

        r = sm % 11;
        dig14 = (r < 2) ? '0' : (char)((11 - r) + 48);

        return (dig13 == cnpj_n_formatado.charAt(12)) && (dig14 == cnpj_n_formatado.charAt(13));
    }

}
