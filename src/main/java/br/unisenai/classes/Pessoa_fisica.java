package br.unisenai.classes;

import java.sql.Date;

import br.unisenai.enums.eSexo;

public class Pessoa_fisica extends Pessoa{

    private String  pf_cpf;
    private String  pf_nome_registro;
    private String  pf_nome_social;
    private Date    pf_data_nasc;
    private eSexo   pf_sexo;
    private double  pf_renda_mes;

    public Pessoa_fisica() {

        super();

    }

    @Override
    public double sacar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sacar'");
    }

    @Override
    public double depositar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'depositar'");
    }

    @Override
    public double pagar_conta() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagar_conta'");
    }

    @Override
    public double emprestimo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'emprestimo'");
    }

    public String getPf_cpf() {
        return pf_cpf;
    }

    public void setPf_cpf(String pf_cpf) {
        this.pf_cpf = pf_cpf;
    }

    public String getPf_nome_registro() {
        return pf_nome_registro;
    }

    public void setPf_nome_registro(String pf_nome_registro) {
        this.pf_nome_registro = pf_nome_registro;
    }

    public String getPf_nome_social() {
        return pf_nome_social;
    }

    public void setPf_nome_social(String pf_nome_social) {
        this.pf_nome_social = pf_nome_social;
    }

    public Date getPf_data_nasc() {
        return pf_data_nasc;
    }

    public void setPf_data_nasc(Date pf_data_nasc) {
        this.pf_data_nasc = pf_data_nasc;
    }

    public eSexo getPf_sexo() {
        return pf_sexo;
    }

    public void setPf_sexo(eSexo pf_sexo) {
        this.pf_sexo = pf_sexo;
    }

    public double getPf_renda_mes() {
        return pf_renda_mes;
    }

    public void setPf_renda_mes(double pf_renda_mes) {
        this.pf_renda_mes = pf_renda_mes;
    }

}
