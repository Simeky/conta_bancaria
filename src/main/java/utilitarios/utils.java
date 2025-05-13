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

        return true;
        
    }

}
