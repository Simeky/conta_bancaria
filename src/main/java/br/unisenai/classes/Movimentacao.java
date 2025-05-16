package br.unisenai.classes;

import java.time.LocalDateTime;

import br.unisenai.enums.eSituacao;

public class Movimentacao {

    private static long ultimo_id = 0;

    private long mov_id;
    private LocalDateTime mov_aconteceu;
    private Conta_bancaria mov_conta;
    private Evento mov_tipo;
    private double mov_valor;
    private eSituacao mov_status; 

    public long return_id() {

        return ++ultimo_id;

    }

    public long getMov_id() {
        return mov_id;
    }

    public LocalDateTime getMov_aconteceu() {
        return mov_aconteceu;
    }

    public void setMov_aconteceu(LocalDateTime mov_aconteceu) {
        this.mov_aconteceu = mov_aconteceu;
    }

    public Conta_bancaria getMov_conta() {
        return mov_conta;
    }

    public void setMov_conta(Conta_bancaria mov_conta) {
        this.mov_conta = mov_conta;
    }

    public Evento getMov_tipo() {
        return mov_tipo;
    }

    public void setMov_tipo(Evento mov_tipo) {
        this.mov_tipo = mov_tipo;
    }

    public double getMov_valor() {
        return mov_valor;
    }

    public void setMov_valor(double mov_valor) {
        this.mov_valor = mov_valor;
    }

    public eSituacao getMov_status() {
        return mov_status;
    }

    public void setMov_status(eSituacao mov_status) {
        this.mov_status = mov_status;
    }

}
