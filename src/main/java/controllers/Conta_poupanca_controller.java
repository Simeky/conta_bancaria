package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.unisenai.classes.Agencia;
import br.unisenai.classes.Conta_poupanca;
import br.unisenai.classes.Pessoa_fisica;
import br.unisenai.enums.eStatus;
import connections.MySQL;
import interfaces.DAO.iConta_poupancaDAO;

public class Conta_poupanca_controller implements iConta_poupancaDAO{

    @Override
    public Conta_poupanca find_conta_poupanca(long id) {
        StringBuilder sql = new StringBuilder(
            "Select  cp.bd_id_cp, " +
                    "cb.bd_id_age, " +
                    "cb.bd_id_titular1_cb, " +
                    "cb.bd_id_titular2_cb, " +
                    "cb.bd_abertura_cb, " +
                    "cb.bd_saldo_cb, " +
                    "cb.bd_pswrd_cb, " +
                    "cb.bd_bandeira_cartao_cb, " +
                    "cb.bd_numero_cartao_cb, " +
                    "cb.bd_validade_cartao_cb, " +
                    "cb.bd_cvv_cb, " +
                    "cb.bd_status_cb, " +
                    "cp.bd_indice_reajuste_cp " +
            "From conta_poupanca cp " +
            "Join conta_bancaria cb on cp.bd_id_cp = cb.bd_id_cp " +
            "Where cp.bd_id_cp = ?;");
        
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        Conta_poupanca cp = null;

        try {
            command = conexao.prepareStatement(sql.toString());
            command.setLong(1, id);
            dados = command.executeQuery();

            if (dados.next()) {
                eStatus status = null;
                for (eStatus s : eStatus.values()) {
                    if (s.getValue() == dados.getInt(12)) {
                        status = s;
                        break;
                    }
                }

                cp = new Conta_poupanca(dados.getLong(1), 
                                        new Agencia(dados.getLong(2), null, null, 0, null, null, null), 
                                        new Pessoa_fisica(dados.getLong(3), null, null, null, null, null, id, null, 0, null, null, null, null), 
                                        new Pessoa_fisica(dados.getLong(4), null, null, null, null, null, id, null, 0, null, null, null, null), 
                                        dados.getDate(5), 
                                        dados.getDouble(6), 
                                        dados.getString(7), 
                                        dados.getString(8), 
                                        dados.getString(9), 
                                        dados.getDate(10), 
                                        dados.getShort(11), 
                                        status, 
                                        dados.getDouble(13));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar conta poupança: " + e.getMessage());
            
        } finally {
            MySQL.desconectar(conexao, command);
        }

        return cp;

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
