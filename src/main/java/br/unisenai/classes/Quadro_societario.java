package br.unisenai.classes;

public class Quadro_societario {

    private long qua_id;
    private Pessoa_juridica qua_empresa;
    private Pessoa qua_socio;
    private double qua_perc; // %

    public Quadro_societario() {}


    //Getters 'n Setters

    public long getQua_id() {
        return qua_id;
    }

    public void setQua_id(long qua_id) {
        this.qua_id = qua_id;
    }

    public Pessoa_juridica getQua_empresa() {
        return qua_empresa;
    }

    public void setQua_empresa(Pessoa_juridica qua_empresa) {
        this.qua_empresa = qua_empresa;
    }

    public Pessoa getQua_socio() {
        return qua_socio;
    }

    public void setQua_socio(Pessoa qua_socio) {
        this.qua_socio = qua_socio;
    }

    public double getQua_perc() {
        return qua_perc;
    }

    public void setQua_perc(double qua_perc) {
        this.qua_perc = qua_perc;
    }

}
