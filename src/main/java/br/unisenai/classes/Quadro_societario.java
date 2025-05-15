package br.unisenai.classes;

public class Quadro_societario {

    private static long ultimo_id = 0;

    private long qua_id;
    private Pessoa_juridica qua_empresa;
    private Pessoa qua_socio;
    private double qua_perc; // %

    public Quadro_societario() {

        this.qua_id = return_id();

    }

    public long return_id() {

        return ++ultimo_id;

    }

    public long getQua_id() {
        return qua_id;
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
