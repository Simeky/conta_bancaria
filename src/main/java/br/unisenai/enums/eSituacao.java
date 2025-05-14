package br.unisenai.enums;

public enum eSituacao {

    Ativa       (15),
    Bloqueada   (10),
    Inativa     (5),
    Encerrada   (0); 

    private final int valor_status;

    private eSituacao(int valor) {

        this.valor_status = valor;

    }

    public int getValue() {

        return this.valor_status;

    }

    @Override
    public String toString() {

        switch (valor_status) {
            
            case 15:   return "Ativa";

            case 10:   return "Bloqueada";

            case 5:   return "Inativa";

            case 0:   return "Encerrada";
            
            default:    throw new IllegalArgumentException("Valor inválido:" + valor_status);
                
        }

    }

}
