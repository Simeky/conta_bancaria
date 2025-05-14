package br.unisenai.enums;

public enum eSexo {

    mc("Masculino cis"),
    fc("Feminino cis"),
    mt("Masculino trans"),
    ft("Feminino trans"),
    o("Outro");

    private final String valor_sexo;

    private eSexo(String valor){

        this.valor_sexo = valor;

    }

     public String getValue() {

        return this.valor_sexo;

    }

    @Override
    public String toString() {
        return this.valor_sexo;
    }

}
