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
        super();

    }

    //Getters 'n Setters

    

    public double getCp_reajuste() {
        return cp_reajuste;
    }

    public void setCp_reajuste(double cp_reajuste) {
        this.cp_reajuste = cp_reajuste;
    }

}
