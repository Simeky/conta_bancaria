package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connections.MySQL;
import br.unisenai.classes.Endereco;
import interfaces.DAO.iEnderecoDAO;

public class Endereco_controller implements iEnderecoDAO {

    @Override
    public Endereco find_endereco(long id) {
        StringBuilder sql = new StringBuilder(
            "Select  end.bd_id_end, " + 
                    "end.bd_cep_end, " + 
                    "end.bd_uf_sigla_end, " + 
                    "end.bd_municipio_end, " + 
                    "end.bd_bairro_end, " + 
                    "end.bd_logradouro_end " +
            "From t_endereco end " + 
            "Where end.bd_id_end = ?;"
        );
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        Endereco end = null;

        try {
            command = conexao.prepareStatement(sql.toString());
            command.setLong(1, id);
            dados = command.executeQuery();

            if (dados.next()) {
                end = new Endereco();
                end.setEnd_id(dados.getLong(1));
                end.setEnd_cep(dados.getString(2));
                end.setEnd_uf(dados.getString(3));
                end.setEnd_municipio(dados.getString(4));
                end.setEnd_bairro(dados.getString(5));
                end.setEnd_logradouro(dados.getString(6));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }

        return end;
    }

    @Override
    public List<Endereco> find_all(String condicao, String ordem) {
        StringBuilder sql = new StringBuilder(
            "Select  end.bd_id_end, " + 
                    "end.bd_cep_end, " + 
                    "end.bd_uf_sigla_end, " + 
                    "end.bd_municipio_end, " + 
                    "end.bd_bairro_end, " + 
                    "end.bd_logradouro_end " + 
            "From t_endereco end"
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
        List<Endereco> lista = new ArrayList<Endereco>();

        try {
            command = conexao.prepareStatement(sql.toString());
            dados = command.executeQuery();

            while (dados.next()) {
                lista.add(new Endereco( dados.getLong(1), 
                                        dados.getString(2), 
                                        dados.getString(3), 
                                        dados.getString(4), 
                                        dados.getString(5), 
                                        dados.getString(6)));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }

        return lista;
    }

    @Override
    public void insert(Endereco end) {
        StringBuilder sql = new StringBuilder(
            "Insert into t_endereco (bd_cep_end, bd_uf_sigla_end, bd_municipio_end, bd_bairro_end, bd_logradouro_end) " + 
            "values (?, ?, ?, ?, ?);");
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;

        try {
            command = conexao.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
            command.setString(1, end.getEnd_cep());
            command.setString(2, end.getEnd_uf());
            command.setString(3, end.getEnd_municipio());
            command.setString(4, end.getEnd_bairro());
            command.setString(5, end.getEnd_logradouro());

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
    public void update(Endereco end) {
        StringBuilder sql = new StringBuilder(
            "Update t_endereco set   bd_cep_end = ?, " + 
                                    "bd_uf_sigla_end = ?, " + 
                                    "bd_municipio_end = ?, " + 
                                    "bd_bairro_end = ?, " + 
                                    "bd_logradouro_end = ? " + 
            "Where bd_id_end = ?;");
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;

        try {
            command = conexao.prepareStatement(sql.toString());
            command.setString(1, end.getEnd_cep());
            command.setString(2, end.getEnd_uf());
            command.setString(3, end.getEnd_municipio());
            command.setString(4, end.getEnd_bairro());
            command.setString(5, end.getEnd_logradouro());
            command.setLong(6, end.getEnd_id());

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
    public void save(Endereco end) {
        if (find_endereco(end.getEnd_id()) == null)
            insert(end);
        else
            update(end);
    }

    @Override
    public void delete(long id) {
        StringBuilder sql = new StringBuilder(
            "Delete from t_endereco " + 
            "Where bd_id_end = ?;");
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