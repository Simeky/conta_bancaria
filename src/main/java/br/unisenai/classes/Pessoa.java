package br.unisenai.classes;

import java.sql.Date;

public abstract class Pessoa {

    private long pessoa_id;
    private Endereco pessoa_end;
    private int pessoa_num_end;
    private String pessoa_compl;
    private String pessoa_fone;
    private Date pessoa_cliente_desde;
    private Boolean pessoa_status;

    public Pessoa() {
    }

    public Pessoa(long pessoa_id, Endereco pessoa_end, int pessoa_num_end, String pessoa_compl, String pessoa_fone,
            Date pessoa_cliente_desde, Boolean pessoa_status) {
        setPessoa_id(pessoa_id);
        setPessoa_end(pessoa_end);
        setPessoa_num_end(pessoa_num_end);
        setPessoa_compl(pessoa_compl);
        setPessoa_fone(pessoa_fone);
        setPessoa_cliente_desde(pessoa_cliente_desde);
        setPessoa_status(pessoa_status);
    }

    //Getters 'n Setters

    public long getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(long pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    public Endereco getPessoa_end() {
        return pessoa_end;
    }

    public void setPessoa_end(Endereco pessoa_end) {
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

    public Boolean getPessoa_status() {
        return pessoa_status;
    }

    public void setPessoa_status(Boolean pessoa_status) {
        this.pessoa_status = pessoa_status;
    }

}
