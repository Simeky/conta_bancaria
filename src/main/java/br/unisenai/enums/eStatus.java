package br.unisenai.enums;

public enum eStatus {

    Ativa       ("10"),
    Inativa     ("5"),
    Cancelada   ("0");

    private final String valor_status;

    private eStatus(String valor) {

        this.valor_status = valor;

    }

    public String getValue() {

        return this.valor_status;

    }

}
