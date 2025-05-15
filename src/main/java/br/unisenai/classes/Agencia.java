package br.unisenai.classes;

import br.unisenai.enums.eSituacao;

public class Agencia {

    private static long ultimo_id = 0;

    private long agencia_id;
    private Banco agencia_banco;
    private Enderecamento agencia_end;
    private int agencia_num_end;
    private String agencia_compl;
    private String agencia_fone;
    private eSituacao agencia_status;

    public long return_id() {

        return ++ultimo_id;

    }

    public long getAgencia_id() {
        return agencia_id;
    }

    public Banco getAgencia_banco() {
        return agencia_banco;
    }

    public void setAgencia_banco(Banco agencia_banco) {
        this.agencia_banco = agencia_banco;
    }

    public Enderecamento getAgencia_end() {
        return agencia_end;
    }

    public void setAgencia_end(Enderecamento agencia_end) {
        this.agencia_end = agencia_end;
    }

    public int getAgencia_num_end() {
        return agencia_num_end;
    }

    public void setAgencia_num_end(int agencia_num_end) {
        this.agencia_num_end = agencia_num_end;
    }

    public String getAgencia_compl() {
        return agencia_compl;
    }

    public void setAgencia_compl(String agencia_compl) {
        this.agencia_compl = agencia_compl;
    }

    public String getAgencia_fone() {
        return agencia_fone;
    }

    public void setAgencia_fone(String agencia_fone) {
        this.agencia_fone = agencia_fone;
    }

    public eSituacao getAgencia_status() {
        return agencia_status;
    }

    public void setAgencia_status(eSituacao agencia_status) {
        this.agencia_status = agencia_status;
    }

}
