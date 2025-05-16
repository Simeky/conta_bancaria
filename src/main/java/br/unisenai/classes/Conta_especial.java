package br.unisenai.classes;

import java.sql.Date;

public class Conta_especial extends Conta_bancaria{

    private double ce_limite_cred;
    private Date ce_vencimento_cred;

    public Conta_especial() {

        super();

    }

    public double getCe_limite_cred() {
        return ce_limite_cred;
    }

    public void setCe_limite_cred(double ce_limite_cred) {
        this.ce_limite_cred = ce_limite_cred;
    }

    public Date getCe_vencimento_cred() {
        return ce_vencimento_cred;
    }

    public void setCe_vencimento_cred(Date ce_vencimento_cred) {
        this.ce_vencimento_cred = ce_vencimento_cred;
    }    

}
