package br.unisenai.classes;

import java.sql.Date;

public class Pessoa_juridica extends Pessoa{

    private String  pj_cnpj;
    private String  pj_razao_social;
    private String  nome_fantasia;
    private Date    pj_data_abertura;
    private Quadro_societario pj_quadro_socio;
    private double pj_capital_social;

    public Pessoa_juridica() {

        super();

    }

    //Getters 'n Setters

    public String getPj_cnpj() {
        return pj_cnpj;
    }

    public void setPj_cnpj(String pj_cnpj) {
        this.pj_cnpj = pj_cnpj;
    }

    public String getPj_razao_social() {
        return pj_razao_social;
    }

    public void setPj_razao_social(String pj_razao_social) {
        this.pj_razao_social = pj_razao_social;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public Date getPj_data_abertura() {
        return pj_data_abertura;
    }

    public void setPj_data_abertura(Date pj_data_abertura) {
        this.pj_data_abertura = pj_data_abertura;
    }

    public Quadro_societario getPj_quadro_socio() {
        return pj_quadro_socio;
    }

    public void setPj_quadro_socio(Quadro_societario pj_quadro_socio) {
        this.pj_quadro_socio = pj_quadro_socio;
    }

    public double getPj_capital_social() {
        return pj_capital_social;
    }

    public void setPj_capital_social(double pj_capital_social) {
        this.pj_capital_social = pj_capital_social;
    }

}
