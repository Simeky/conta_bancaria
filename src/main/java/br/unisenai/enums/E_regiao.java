package br.unisenai.enums;

public enum E_regiao {

    Norte       ("N"),
    Sul         ("S"),
    CentroOeste ("CO"),
    Nordeste    ("NE"),
    Sudeste     ("SE");


    private final String valor_regiao;

    private E_regiao(String valor){

        this.valor_regiao = valor;

    }

    public String getValor_regiao() {

        return this.valor_regiao;

    }

}
