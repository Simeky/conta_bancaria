package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connections.MySQL;

import br.unisenai.classes.Agencia;
import interfaces.DAO.iAgenciaDAO;

public class Agencia_controller implements iAgenciaDAO {

    @Override
    public Agencia find_agencia(long id) {
        StringBuilder sql = new StringBuilder(
            "Select  ag.bd_id_age, " + 
                    "ag.bd_id_banco, " + 
                    "ag.bd_id_end, " + 
                    "ag.bd_num_end_age, " + 
                    "ag.bd_complemento_end_age, " + 
                    "ag.bd_fone_age, " + 
                    "ag.bd_status_age " + 
            "From t_agencia ag " + 
            "Where ag.bd_id_age = ?;");
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        Agencia ag = null;

        try {
            command = conexao.prepareStatement(sql.toString());
            command.setLong(1, id);
            dados = command.executeQuery();

            if (dados.next()) {
                ag = new Agencia();
                ag.setAgencia_id(dados.getLong(1));
                ag.setAgencia_banco(new Banco_controller().find_banco(dados.getLong(2)));
                ag.setAgencia_end(new Endereco_controller().find_endereco(dados.getLong(3)));
                ag.setAgencia_num_end(dados.getInt(4));
                ag.setAgencia_compl(dados.getString(5));
                ag.setAgencia_fone(dados.getString(6));
                ag.setAgencia_status(dados.getBoolean(7));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }

        return ag;
    }

    @Override
    public List<Agencia> find_all(String condicao, String ordem) {
        StringBuilder sql = new StringBuilder(
            "Select  ag.bd_id_age, " + 
                    "ag.bd_id_banco, " + 
                    "ag.bd_id_end, " + 
                    "ag.bd_num_end_age, " + 
                    "ag.bd_complemento_end_age, " + 
                    "ag.bd_fone_age, " + 
                    "ag.bd_status_age " + 
            "From t_agencia ag"
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
        List<Agencia> lista = new ArrayList<Agencia>();

        try {
            command = conexao.prepareStatement(sql.toString());
            dados = command.executeQuery();

            while (dados.next()) {
                lista.add(new Agencia(  dados.getLong(1),
                                        new Banco_controller().find_banco(dados.getLong(2)),
                                        new Endereco_controller().find_endereco(dados.getLong(3)),
                                        dados.getInt(4),
                                        dados.getString(5),
                                        dados.getString(6),
                                        dados.getBoolean(7)));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }

        return lista;
    }

    @Override
    public void insert(Agencia ag) {
        StringBuilder sql = new StringBuilder(
            "Insert into t_agencia (bd_id_banco, bd_id_end, bd_num_end_age, bd_complemento_end_age, bd_fone_age, bd_status_age) " + 
            "values (?, ?, ?, ?, ?, ?);");
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;

        try {
            command = conexao.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
            command.setLong(1, ag.getAgencia_banco().getBanco_id());
            command.setLong(2, ag.getAgencia_end().getEnd_id());
            command.setInt(3, ag.getAgencia_num_end());
            command.setString(4, ag.getAgencia_compl());
            command.setString(5, ag.getAgencia_fone());
            command.setBoolean(6, ag.getAgencia_status());

            if (command.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi adicionado. Verifique se não inseriu nenhum valor inválido");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Problema na inserção de dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }
    }

    @Override
    public void update(Agencia ag) {
        StringBuilder sql = new StringBuilder(
            "Update t_agencia set bd_id_banco = ?, " + 
                                "bd_id_end = ?, " + 
                                "bd_num_end_age = ?, " + 
                                "bd_complemento_end_age = ?, " + 
                                "bd_fone_age = ?, " + 
                                "bd_status_age = ? " + 
            "Where bd_id_age = ?;");
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;

        try {
            command = conexao.prepareStatement(sql.toString());
            command.setLong(1, ag.getAgencia_banco().getBanco_id());
            command.setLong(2, ag.getAgencia_end().getEnd_id());
            command.setInt(3, ag.getAgencia_num_end());
            command.setString(4, ag.getAgencia_compl());
            command.setString(5, ag.getAgencia_fone());
            command.setBoolean(6, ag.getAgencia_status());
            command.setLong(7, ag.getAgencia_id());

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
    public void save(Agencia ag) {
        if (find_agencia(ag.getAgencia_id()) == null)
            insert(ag);
        else
            update(ag);
    }

    @Override
    public void delete(long id) {
        StringBuilder sql = new StringBuilder(
            "Delete from t_agencia " + 
            "Where bd_id_age = ?;");
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;

        try {
            command = conexao.prepareStatement(sql.toString());
            command.setLong(1, id);

            if (command.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi excluído. Verifique se o ID existe.");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Problema na exclusão dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }
    }

}