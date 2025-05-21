package br.unisenai.classes;

import br.unisenai.enums.E_regiao;

public class UF {

    private static long ultimo_id = 0;

    private long uf_id;
    private String uf_nome;
    private String uf_sigla;
    private E_regiao uf_regiao;

    public UF() {

        this.uf_id = return_id();

    }

    public long return_id() {

        return ++ultimo_id;

    }

    //Getters 'n Setters

    public long getUf_id() {
        return this.uf_id;
    }
    public String getUf_nome() {
        return uf_nome;
    }
    public void setUf_nome(String uf_nome) {
        this.uf_nome = uf_nome;
    }
    public String getUf_sigla() {
        return uf_sigla;
    }
    public void setUf_sigla(String uf_sigla) {
        this.uf_sigla = uf_sigla;
    }
    public E_regiao getUf_regiao() {
        return uf_regiao;
    }
    public void setUf_regiao(E_regiao uf_regiao) {
        this.uf_regiao = uf_regiao;
    }

}
