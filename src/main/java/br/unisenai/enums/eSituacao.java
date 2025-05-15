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

}
