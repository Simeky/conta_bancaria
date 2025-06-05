package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.unisenai.classes.Banco;
import connections.MySQL;
import interfaces.DAO.iBancoDAO;

public class banco_controller implements iBancoDAO{

    @Override
    public Banco find_banco(long id) {
        final String intruction =   "Select ban.bd_id_banco, ban.bd_cod_instituicao_banco, ban.bd_nome_banco, ban.bd_mascara_conta_banco "  + 
                                    "From t_banco ban " +  
                                    "Where ban.bd_id_banco = ?;";
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        Banco ban = null;

        try {
            command = conexao.prepareStatement(intruction);
            command.setLong(1, id);
            dados = command.executeQuery();

            if (dados.next()) {
               ban = new Banco();
               ban.setBanco_id(dados.getLong(0));
               ban.setBanco_cod_inst(dados.getString(1));
               ban.setBanco_nome(dados.getString(2));
               ban.setBanco_mascara_cb(dados.getString(3));
            }
        }   
        catch (SQLException e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        }
        finally {
            MySQL.desconectar(conexao, command);            
        }

        return ban;
    }

    @Override
    public Banco find_banco(String nome) {
        final String intruction =   "Select ban.bd_id_banco, ban.bd_cod_instituicao_banco, ban.bd_nome_banco, ban.bd_mascara_conta_banco "  + 
                                    "From t_banco ban " +  
                                    "Where ban.bd_nome_banco = ?;";
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        Banco ban = null;

        try {
            command = conexao.prepareStatement(intruction);
            command.setString(1, nome);
            dados = command.executeQuery();

            if (dados.next()) {
               ban = new Banco();
               ban.setBanco_id(dados.getLong(0));
               ban.setBanco_cod_inst(dados.getString(1));
               ban.setBanco_nome(dados.getString(2));
               ban.setBanco_mascara_cb(dados.getString(3));
            }
        }   
        catch (SQLException e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        }
        finally {
            MySQL.desconectar(conexao, command);            
        }

        return ban;
    }

    @Override
    public List<Banco> find_all(String condicao, String ordem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find_all'");
    }

    @Override
    public void insert(Banco ban) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Banco ban) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void save(Banco ban) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void delete(Banco ban) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
