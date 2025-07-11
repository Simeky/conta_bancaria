package br.unisenai.classes;

import java.sql.Date;

import br.unisenai.enums.eStatus;

public abstract class Conta_bancaria {

    private long cb_id;
    private Agencia cb_agencia;
    private Pessoa cb_titular1;
    private Pessoa cb_titular2;
    private Date cb_abertura;
    private double cb_saldo;
    private String cb_pswrd;
    private String cb_bandeira_card;
    private String cb_num_card;
    private Date cb_val_card;
    private short cb_cvv_card;
    private eStatus cb_status;

    public Conta_bancaria(){

        setCb_status(eStatus.Ativa);

    }
    
    public Conta_bancaria(  long cb_id, 
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
                            eStatus cb_status) {
        setCb_id(cb_id);
        setCb_agencia(cb_agencia);
        setCb_titular1(cb_titular1);
        setCb_titular2(cb_titular2);
        setCb_abertura(cb_abertura);
        setCb_saldo(cb_saldo);
        setCb_pswrd(cb_pswrd);
        setCb_bandeira_card(cb_bandeira_card);
        setCb_num_card(cb_num_card);
        setCb_val_card(cb_val_card);
        setCb_cvv_card(cb_cvv_card);
        setCb_status(cb_status);
    }

    //Getters 'n Setters

    public long getCb_id() {
        return cb_id;
    }

    public void setCb_id(long cb_id) {
        this.cb_id = cb_id;
    }

    public Agencia getCb_agencia() {
        return cb_agencia;
    }

    public void setCb_agencia(Agencia cb_agencia) {
        this.cb_agencia = cb_agencia;
    }

    public Pessoa getCb_titular1() {
        return cb_titular1;
    }

    public void setCb_titular1(Pessoa cb_titular1) {
        this.cb_titular1 = cb_titular1;
    }

    public Pessoa getCb_titular2() {
        return cb_titular2;
    }

    public void setCb_titular2(Pessoa cb_titular2) {
        this.cb_titular2 = cb_titular2;
    }

    public Date getCb_abertura() {
        return cb_abertura;
    }

    public void setCb_abertura(Date cb_abertura) {
        this.cb_abertura = cb_abertura;
    }

    public double getCb_saldo() {
        return cb_saldo;
    }

    public void setCb_saldo(double cb_saldo) {
        this.cb_saldo = cb_saldo;
    }

    public String getCb_pswrd() {
        return cb_pswrd;
    }

    public void setCb_pswrd(String cb_pswrd) {
        this.cb_pswrd = cb_pswrd;
    }

    public String getCb_bandeira_card() {
        return cb_bandeira_card;
    }

    public void setCb_bandeira_card(String cb_bandeira_card) {
        this.cb_bandeira_card = cb_bandeira_card;
    }

    public String getCb_num_card() {
        return cb_num_card;
    }

    public void setCb_num_card(String cb_num_card) {
        this.cb_num_card = cb_num_card;
    }

    public Date getCb_val_card() {
        return cb_val_card;
    }

    public void setCb_val_card(Date cb_val_card) {
        this.cb_val_card = cb_val_card;
    }

    public short getCb_cvv_card() {
        return cb_cvv_card;
    }

    public void setCb_cvv_card(short cb_cvv_card) {
        this.cb_cvv_card = cb_cvv_card;
    }

    public eStatus getCb_status() {
        return cb_status;
    }

    public void setCb_status(eStatus cb_status) {
        this.cb_status = cb_status;
    }       

}
