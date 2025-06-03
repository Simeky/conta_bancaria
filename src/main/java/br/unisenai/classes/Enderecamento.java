package br.unisenai.classes;

public class Enderecamento {

    private long end_id;
    private String end_logradouro;
    private String end_bairro;
    private String end_municipio;
    private String end_uf;
    private String end_cep;
    private String end_num;
    private String end_complemento;

    public Enderecamento() {}
    
    //Getters 'n Setters

    public long getEnd_id() {
        return end_id;
    }

    public void setEnd_id(long end_id) {
        this.end_id = end_id;
    }

    public void setEnd_cep(String end_cep) {
        this.end_cep = end_cep;
    }

    public String getEnd_cep() {
        return end_cep;
    }

    public String getEnd_num() {
        return end_num;
    }

    public void setEnd_num(String end_num) {
        this.end_num = end_num;
    }

    public String getEnd_complemento() {
        return end_complemento;
    }

    public void setEnd_complemento(String end_complemento) {
        this.end_complemento = end_complemento;
    }

    public String getEnd_logradouro() {
        return end_logradouro;
    }

    public void setEnd_logradouro(String end_logradouro) {
        this.end_logradouro = end_logradouro;
    }

    public String getEnd_bairro() {
        return end_bairro;
    }

    public void setEnd_bairro(String end_bairro) {
        this.end_bairro = end_bairro;
    }

    public String getEnd_municipio() {
        return end_municipio;
    }

    public void setEnd_municipio(String end_municipio) {
        this.end_municipio = end_municipio;
    }

    public String getEnd_uf() {
        return end_uf;
    }

    public void setEnd_uf(String end_uf) {
        this.end_uf = end_uf;
    }

}