package br.unisenai.classes;

import java.sql.Date;

import br.unisenai.enums.eSituacao;

public abstract class Pessoa {

    private static long ultimo_id = 0;

    private long pessoa_id;
    private Enderecamento pessoa_end;
    private int pessoa_num_end;
    private String pessoa_compl;
    private String pessoa_fone;
    private Date pessoa_cliente_desde;
    private eSituacao pessoa_status;

    public Pessoa() {

        this.pessoa_id = return_id();
        this.pessoa_status = eSituacao.Ativa;

    }

    public abstract double sacar();
    public abstract double depositar();
    public abstract double pagar_conta();
    public abstract double emprestimo();

    public long return_id(){
        return ++ultimo_id;
    }

    //Getters 'n Setters

    public long getPessoa_id() {
        return pessoa_id;
    }

    public eSituacao getPessoa_status() {
        return pessoa_status;
    }

    public Enderecamento getPessoa_end() {
        return pessoa_end;
    }

    public void setPessoa_end(Enderecamento pessoa_end) {
        this.pessoa_end = pessoa_end;
    }

    public int getPessoa_num_end() {
        return pessoa_num_end;
    }

    public void setPessoa_num_end(int pessoa_num_end) {
        this.pessoa_num_end = pessoa_num_end;
    }

    public String getPessoa_compl() {
        return pessoa_compl;
    }

    public void setPessoa_compl(String pessoa_compl) {
        this.pessoa_compl = pessoa_compl;
    }

    public String getPessoa_fone() {
        return pessoa_fone;
    }

    public void setPessoa_fone(String pessoa_fone) {
        this.pessoa_fone = pessoa_fone;
    }

    public Date getPessoa_cliente_desde() {
        return pessoa_cliente_desde;
    }

    public void setPessoa_cliente_desde(Date pessoa_cliente_desde) {
        this.pessoa_cliente_desde = pessoa_cliente_desde;
    }

}
