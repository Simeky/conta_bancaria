package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connections.MySQL;

import br.unisenai.classes.Banco;
import interfaces.DAO.iBancoDAO;

public class banco_controller implements iBancoDAO{

    @Override
    public Banco find_banco(long id) {
        StringBuilder sql = new StringBuilder(
            "Select  ban.bd_id_banco, " + 
                    "ban.bd_cod_instituicao_banco, " + 
                    "ban.bd_nome_banco, " + 
                    "ban.bd_mascara_conta_banco "  + 
                    "From t_banco ban " +  
                    "Where ban.bd_id_banco = ?;");
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        Banco ban = null;

        try {
            command = conexao.prepareStatement(sql.toString());
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
        StringBuilder sql = new StringBuilder(
            "Select  ban.bd_id_banco, " +
                    "ban.bd_cod_instituicao_banco, " + 
                    "ban.bd_nome_banco, " + 
                    "ban.bd_mascara_conta_banco "  + 
                    "From t_banco ban " +  
                    "Where ban.bd_nome_banco = ?;");
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        Banco ban = null;

        try {
            command = conexao.prepareStatement(sql.toString());
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
        StringBuilder sql = new StringBuilder(
            "Select  ban.bd_id_banco, " + 
                    "ban.bd_cod_instituicao_banco, " + 
                    "ban.bd_nome_banco, " + 
                    "ban.bd_mascara_conta_banco " + 
                    "From t_banco ban"
        );

        if (condicao != null && !condicao.trim().isEmpty()) {
            sql.append(" Where ").append(condicao);
        }
        if (ordem != null && !ordem.trim().isEmpty()) {
            sql.append(" Order by ").append(ordem);
        }
        sql.append(";");

        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        List<Banco> lista = new ArrayList<Banco>();

        try {
            command = conexao.prepareStatement(sql.toString());
            dados = command.executeQuery();

            while (dados.next()) {
               lista.add(new Banco( dados.getLong(0),
                                    dados.getString(1),
                                    dados.getString(2),
                                    dados.getString(3)));
            }
        }   
        catch (SQLException e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        }
        finally {
            MySQL.desconectar(conexao, command);            
        }

        return lista;
    }

    @Override
    public void insert(Banco ban) {
        final String intruction = "Insert into t_banco (bd_cod_instituicao_banco, bd_nome_banco, bd_mascara_conta_banco)" +
                                 " Values (?, ?, ?);";
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;

        try {
            command = conexao.prepareStatement(intruction);
            command.setString(1, ban.getBanco_cod_inst());
            command.setString(2, ban.getBanco_nome());
            command.setString(3, ban.getBanco_mascara_cb());
            
            if (command.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi adicionado. Verifique se não inseriu nenhum valor inválido");
            }
        }   
        catch (SQLException e) {
            throw new RuntimeException("Problema na inserção de dados:\n" + e.getMessage());
        }
        finally {
            MySQL.desconectar(conexao, command);            
        }
    }

    @Override
    public void update(Banco ban) {
        StringBuilder sql = new StringBuilder(
        "Update t_banco set bd_cod_instituicao_banco = ?, bd_nome_banco = ?, bd_mascara_conta_banco = ? " + 
        "Where bd_id_banco = ?;");
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;

        try {
            command = conexao.prepareStatement(sql.toString());
            command.setString(1, ban.getBanco_cod_inst());
            command.setString(2, ban.getBanco_nome());
            command.setString(3, ban.getBanco_mascara_cb());
            command.setLong(4, ban.getBanco_id());

            if (command.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi atualizado. Verifique se o ID existe.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problema na atualização dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }
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
