package br.unisenai.classes;

import java.sql.Date;

import br.unisenai.enums.eStatus;

public class Conta_poupanca extends Conta_bancaria{

    private double cp_reajuste;

    public Conta_poupanca() {

        super();

    }

    public Conta_poupanca(  long cb_id, 
                            Agencia cb_agencia, 
                            Pessoa cb_titular1, 
                            Pessoa cb_titular2, 
                            Date cb_abertura,
                            double cb_saldo, 
                            String cb_pswrd, 
                            String cb_bandeira_card, 
                            String cb_num_card, 
                            Date cb_val_card,
                            short cb_cvv_card, 
                            eStatus cb_status, 
                            double cp_reajuste) {
        super(  cb_id, 
                cb_agencia, 
                cb_titular1, 
                cb_titular2, 
                cb_abertura, 
                cb_saldo, 
                cb_pswrd, 
                cb_bandeira_card, 
                cb_num_card, 
                cb_val_card, 
                cb_cvv_card, 
                cb_status);
        setCp_reajuste(cp_reajuste);
    }

    //Getters 'n Setters

    

    public double getCp_reajuste() {
        return cp_reajuste;
    }

    public void setCp_reajuste(double cp_reajuste) {
        this.cp_reajuste = cp_reajuste;
    }

}
