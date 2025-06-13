package controllers;

import java.util.List;

import br.unisenai.classes.Conta_poupanca;
import interfaces.DAO.iConta_poupancaDAO;

public class Conta_poupanca_controller implements iConta_poupancaDAO{

    @Override
    public Conta_poupanca find_conta_poupanca(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find_conta_poupanca'");
    }

    @Override
    public Conta_poupanca find_conta_poupanca(String t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find_conta_poupanca'");
    }

    @Override
    public List<Conta_poupanca> find_all(String condicao, String ordem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find_all'");
    }

    @Override
    public void insert(Conta_poupanca cp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Conta_poupanca cp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void save(Conta_poupanca cp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void desativa(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desativa'");
    }

    @Override
    public void desativa(Conta_poupanca cp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'desativa'");
    }

}
