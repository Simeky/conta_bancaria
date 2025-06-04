package br.unisenai.enums;

public enum eStatus {

    Ativa       (10),
    Inativa     (5),
    Cancelada   (0);

    private final int valor_status;

    private eStatus(int valor) {

        this.valor_status = valor;

    }

    public int getValue() {

        return this.valor_status;

    }

}
