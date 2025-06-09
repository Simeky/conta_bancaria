package br.unisenai.classes;

import java.sql.Date;

public class Conta_salario extends Conta_bancaria{

    private Pessoa_juridica cs_empresa;
    private Date cs_limite_adiantamento;
    private Conta_bancaria cs_conta;

    public Conta_salario() {

        super();

    }

    // Getters 'n Setters

    public Pessoa_juridica getCs_empresa() {
        return cs_empresa;
    }

    public void setCs_empresa(Pessoa_juridica cs_empresa) {
        this.cs_empresa = cs_empresa;
    }

    public Date getCs_limite_adiantamento() {
        return cs_limite_adiantamento;
    }

    public void setCs_limite_adiantamento(Date cs_limite_adiantamento) {
        this.cs_limite_adiantamento = cs_limite_adiantamento;
    }

    public Conta_bancaria getCs_conta() {
        return cs_conta;
    }

    public void setCs_conta(Conta_bancaria cs_conta) {
        this.cs_conta = cs_conta;
    }

}
