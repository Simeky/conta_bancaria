package br.unisenai.classes;

public class Banco {

    private long banco_id;
    private String banco_cod_inst;
    private String banco_nome;
    private String banco_mascara_cb;

    public Banco(){}

    public Banco(long banco_id, String banco_cod_inst, String banco_nome, String banco_mascara_cb) {
        setBanco_id(banco_id);
        setBanco_cod_inst(banco_cod_inst);
        setBanco_nome(banco_nome);
        setBanco_mascara_cb(banco_mascara_cb);
    }

    //Getters 'n Setters

    public long getBanco_id() {
        return banco_id;
    }

    public void setBanco_id(long banco_id) {
        this.banco_id = banco_id;
    }
    
    public String getBanco_cod_inst() {
        return banco_cod_inst;
    }

    public void setBanco_cod_inst(String banco_cod_inst) {
        this.banco_cod_inst = banco_cod_inst;
    }

    public String getBanco_nome() {
        return banco_nome;
    }

    public void setBanco_nome(String banco_nome) {
        this.banco_nome = banco_nome;
    }

    public String getBanco_mascara_cb() {
        return banco_mascara_cb;
    }

    public void setBanco_mascara_cb(String banco_mascara_cb) {
        this.banco_mascara_cb = banco_mascara_cb;
    }

}
