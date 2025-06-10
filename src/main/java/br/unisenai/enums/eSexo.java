package br.unisenai.enums;

public enum eSexo {

    Masculino_cis("MC"),
    Feminino_cis("FC"),
    Masculino_trans("MT"),
    Feminino_trans("FT"),
    Outro("O");

    private final String valor_sexo;

    private eSexo(String valor){

        this.valor_sexo = valor;

    }

     public String getValue() {

        return this.valor_sexo;

    }

}
