package br.unisenai.classes;

import java.sql.Date;

public class Pessoa_juridica extends Pessoa{

    private String  pj_cnpj;
    private String  pj_razao_social;
    private String  nome_fantasia;
    private Date    pj_data_abertura;
    private double pj_capital_social;

    public Pessoa_juridica() {

        super();

    }

    //Getters 'n Setters

    public Pessoa_juridica( long pesssoa_id, 
                            Endereco pessoa_end, 
                            int Pessoa_num_end, 
                            String pessoa_compl,
                            String pessoa_fone,
                            Date pessoa_cliente_desde,
                            Boolean pessoa_status,
                            String pj_cnpj, 
                            String pj_razao_social, 
                            String nome_fantasia, 
                            Date pj_data_abertura,
                            double pj_capital_social) {
        super();
    }

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

    public double getPj_capital_social() {
        return pj_capital_social;
    }

    public void setPj_capital_social(double pj_capital_social) {
        this.pj_capital_social = pj_capital_social;
    }

}
