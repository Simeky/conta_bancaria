package br.unisenai.classes;

public class Agencia {

    private long agencia_id;
    private Banco agencia_banco;
    private Endereco agencia_end;
    private int agencia_num_end;
    private String agencia_compl;
    private String agencia_fone;
    private Boolean agencia_status;

    public Agencia(){

    }

    public Agencia( long agencia_id, 
                    Banco agencia_banco, 
                    Endereco agencia_end, 
                    int agencia_num_end,
                    String agencia_compl, 
                    String agencia_fone, 
                    Boolean agencia_status) {

    }

    //Getters 'n Setters
    
    public long getAgencia_id() {
        return agencia_id;
    }
    
    public void setAgencia_id(long agencia_id) {
        this.agencia_id = agencia_id;
    }

    public Banco getAgencia_banco() {
        return agencia_banco;
    }

    public void setAgencia_banco(Banco agencia_banco) {
        this.agencia_banco = agencia_banco;
    }

    public Endereco getAgencia_end() {
        return agencia_end;
    }

    public void setAgencia_end(Endereco agencia_end) {
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

    public Boolean getAgencia_status() {
        return agencia_status;
    }

    public void setAgencia_status(Boolean agencia_status) {
        this.agencia_status = agencia_status;
    }

}
