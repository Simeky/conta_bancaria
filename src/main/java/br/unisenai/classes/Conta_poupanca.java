package br.unisenai.classes;

public class Conta_poupanca extends Conta_bancaria{

    private double cp_reajuste;

    public Conta_poupanca() {

        super();

    }

    public double getCp_reajuste() {
        return cp_reajuste;
    }

    public void setCp_reajuste(double cp_reajuste) {
        this.cp_reajuste = cp_reajuste;
    }

}
