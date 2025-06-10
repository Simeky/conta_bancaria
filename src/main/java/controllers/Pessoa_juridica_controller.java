package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connections.MySQL;
import br.unisenai.classes.Pessoa_juridica;
import br.unisenai.classes.Endereco;
import interfaces.DAO.iPessoa_juridicaDAO;

public class Pessoa_juridica_controller implements iPessoa_juridicaDAO {

    @Override
    public Pessoa_juridica find_pessoa_juridica(long id) {
        StringBuilder sql = new StringBuilder(
            "Select  pj.bd_id_pj, " +
                    "pj.bd_cnpj_pj, " +
                    "pj.bd_razao_social_pj, " +
                    "pj.bd_nome_fantasia_pj, " +
                    "pj.bd_abertura_pj, " +
                    "pj.bd_capital_social_pj, " +
                    "pes.bd_id_end, " +
                    "pes.bd_num_end_pes, " +
                    "pes.bd_complemento_end_pes, " +
                    "pes.bd_fone_pes, " +
                    "pes.bd_cliente_desde_pes, " +
                    "pes.bd_status_pes " +
            "From t_pessoa_juridica pj " +
            "Join t_pessoa pes on pes.bd_id_pes = pj.bd_id_pj " +
            "Where pj.bd_id_pj = ?;");

        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        Pessoa_juridica pj = null;

        try {
            command = conexao.prepareStatement(sql.toString());
            command.setLong(1, id);
            dados = command.executeQuery();

            if (dados.next()) {
                pj = new Pessoa_juridica(dados.getLong(1),
                                         dados.getString(2),
                                         dados.getString(3),
                                         dados.getString(4),
                                         dados.getDate(5),
                                         dados.getDouble(6),
                            new Endereco(dados.getLong(7), null, null, null, null, null),
                                         dados.getInt(8),
                                         dados.getString(9),
                                         dados.getString(10),
                                         dados.getDate(11),
                                         dados.getBoolean(12));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }

        return pj;
    }

    @Override
    public List<Pessoa_juridica> find_all(String condicao, String ordem) {
        StringBuilder sql = new StringBuilder(
            "Select  pj.bd_id_pj, " + 
                    "pj.bd_cnpj_pj, " +
                    "pj.bd_razao_social_pj, " +
                    "pj.bd_nome_fantasia_pj, " +
                    "pj.bd_abertura_pj, " +
                    "pj.bd_capital_social_pj, " +
                    "pes.bd_id_end, " +
                    "pes.bd_num_end_pes, " +
                    "pes.bd_complemento_end_pes, " + 
                    "pes.bd_fone_pes, " +
                    "pes.bd_cliente_desde_pes, " +
                    "pes.bd_status_pes " +                    
            "From t_pessoa_juridica pj " +
            "Join t_pessoa pes on pes.bd_id_pes = pj.bd_id_pj"
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
        List<Pessoa_juridica> lista = new ArrayList<Pessoa_juridica>();

        try {
            command = conexao.prepareStatement(sql.toString());
            dados = command.executeQuery();

            while (dados.next()) {
                lista.add(new Pessoa_juridica(  dados.getLong(1),
                                                dados.getString(2),
                                                dados.getString(3),
                                                dados.getString(4),
                                                dados.getDate(5),
                                                dados.getDouble(6),
                                                new Endereco(dados.getLong(7), null, null, null, null, null),
                                                dados.getInt(8),
                                                dados.getString(9),
                                                dados.getString(10),
                                                dados.getDate(11),
                                                dados.getBoolean(12)));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }

        return lista;
    }

    @Override
    public void insert(Pessoa_juridica pj) {
        StringBuilder insert_pessoa = new StringBuilder(
            "Insert into t_pessoa (bd_id_end, bd_num_end_pes, bd_complemento_end_pes, bd_fone_pes, bd_cliente_desde_pes, bd_status_pes) values (?, ?, ?, ?, ?, ?);");
        StringBuilder insert_pj = new StringBuilder(
            "Insert into t_pessoa_juridica (bd_id_pj, bd_cnpj_pj, bd_razao_social_pj, bd_nome_fantasia_pj, bd_abertura_pj, bd_capital_social_pj) values (?, ?, ?, ?, ?, ?);");
        Connection conexao = MySQL.conectar();
        PreparedStatement commandPessoa = null;
        PreparedStatement commandPJ = null;
        ResultSet generatedKeys = null;
        try {
            // Insere na t_pessoa
            commandPessoa = conexao.prepareStatement(insert_pessoa.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
            commandPessoa.setLong(1, pj.getPessoa_end().getEnd_id());
            commandPessoa.setInt(2, pj.getPessoa_num_end());
            commandPessoa.setString(3, pj.getPessoa_compl());
            commandPessoa.setString(4, pj.getPessoa_fone());
            commandPessoa.setDate(5, pj.getPessoa_cliente_desde());
            commandPessoa.setBoolean(6, pj.getPessoa_status());
            if (commandPessoa.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi adicionado em t_pessoa. Verifique se não inseriu nenhum valor inválido.");
            }
            generatedKeys = commandPessoa.getGeneratedKeys();
            if (generatedKeys.next()) {
                pj.setPessoa_id(generatedKeys.getLong(1));
            } else {
                throw new RuntimeException("Falha ao obter o ID gerado para t_pessoa.");
            }
            // Insere na t_pessoa_juridica
            commandPJ = conexao.prepareStatement(insert_pj.toString());
            commandPJ.setLong(1, pj.getPessoa_id());
            commandPJ.setString(2, pj.getPj_cnpj());
            commandPJ.setString(3, pj.getPj_razao_social());
            commandPJ.setString(4, pj.getNome_fantasia());
            commandPJ.setDate(5, pj.getPj_data_abertura());
            commandPJ.setDouble(6, pj.getPj_capital_social());
            if (commandPJ.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi adicionado em t_pessoa_juridica. Verifique se não inseriu nenhum valor inválido");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problema na inserção de dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(null, commandPessoa);
            MySQL.desconectar(conexao, commandPJ);
            try { if (generatedKeys != null) generatedKeys.close(); } catch (Exception e) {}
        }
    }

    @Override
    public void update(Pessoa_juridica pj) {
        StringBuilder sqlPessoa = new StringBuilder(
            "Update t_pessoa set bd_id_end = ?, " +
                                "bd_num_end_pes = ?, " +
                                "bd_complemento_end_pes = ?, " +
                                "bd_fone_pes = ?, " +
                                "bd_cliente_desde_pes = ?, " +
                                "bd_status_pes = ? " +
            "Where bd_id_pes = ?;");

        StringBuilder sqlPJ = new StringBuilder(
            "Update t_pessoa_juridica set bd_cnpj_pj = ?, " +
                                         "bd_razao_social_pj = ?, " +
                                         "bd_nome_fantasia_pj = ?, " +
                                         "bd_abertura_pj = ?, " +
                                         "bd_capital_social_pj = ? " +
            "Where bd_id_pj = ?;");
        Connection conexao = MySQL.conectar();
        PreparedStatement commandPessoa = null;
        PreparedStatement commandPJ = null;
        try {
            // Atualiza t_pessoa            
            commandPessoa = conexao.prepareStatement(sqlPessoa.toString());
            commandPessoa.setLong(1, pj.getPessoa_end().getEnd_id());
            commandPessoa.setInt(2, pj.getPessoa_num_end());
            commandPessoa.setString(3, pj.getPessoa_compl());
            commandPessoa.setString(4, pj.getPessoa_fone());
            commandPessoa.setDate(5, pj.getPessoa_cliente_desde());
            commandPessoa.setBoolean(6, pj.getPessoa_status());
            commandPessoa.setLong(7, pj.getPessoa_id());
            if (commandPessoa.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi atualizado em t_pessoa. Verifique se o ID existe.");
            }

            // Atualiza t_pessoa_juridica           
            commandPJ = conexao.prepareStatement(sqlPJ.toString());
            commandPJ.setString(1, pj.getPj_cnpj());
            commandPJ.setString(2, pj.getPj_razao_social());
            commandPJ.setString(3, pj.getNome_fantasia());
            commandPJ.setDate(4, pj.getPj_data_abertura());
            commandPJ.setDouble(5, pj.getPj_capital_social());
            commandPJ.setLong(6, pj.getPessoa_id());
            if (commandPJ.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi atualizado em t_pessoa_juridica. Verifique se o ID existe.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problema na atualização dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(null, commandPessoa);
            MySQL.desconectar(conexao, commandPJ);
        }
    }

    @Override
    public void save(Pessoa_juridica pj) {
        if (find_pessoa_juridica(pj.getPessoa_id()) == null)
            insert(pj);
        else
            update(pj);
    }

    @Override
    public void desativar(long id) {
        StringBuilder sql = new StringBuilder(
            "Update t_pessoa set bd_status_pes = false " + 
            "Where bd_id_pes = ?;");
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        try {
            command = conexao.prepareStatement(sql.toString());
            command.setLong(1, id);
            if (command.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi desativado. Verifique se o ID existe.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problema ao desativar o registro:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }
    }

    @Override
    public Pessoa_juridica find_pessoa_juridica(String cnpj) {
        StringBuilder sql = new StringBuilder(
            "Select  pj.bd_id_pj, " +
                    "pj.bd_cnpj_pj, " +
                    "pj.bd_razao_social_pj, " +
                    "pj.bd_nome_fantasia_pj, " +
                    "pj.bd_abertura_pj, " +
                    "pj.bd_capital_social_pj, " +
                    "pes.bd_id_end, " +
                    "pes.bd_num_end_pes, " +
                    "pes.bd_complemento_end_pes, " +
                    "pes.bd_fone_pes, " +
                    "pes.bd_cliente_desde_pes, " +
                    "pes.bd_status_pes " +
            "From t_pessoa_juridica pj " +
            "Join t_pessoa pes on pes.bd_id_pes = pj.bd_id_pj " +
            "Where pj.bd_cnpj_pj = ?;");

        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        Pessoa_juridica pj = null;
        try {
            command = conexao.prepareStatement(sql.toString());
            command.setString(1, cnpj);
            dados = command.executeQuery();
            if (dados.next()) {
                pj = new Pessoa_juridica(dados.getLong(1),
                                         dados.getString(2),
                                         dados.getString(3),
                                         dados.getString(4),
                                         dados.getDate(5),
                                         dados.getDouble(6),
                            new Endereco(dados.getLong(7), null, null, null, null, null),
                                         dados.getInt(8),
                                         dados.getString(9),
                                         dados.getString(10),
                                         dados.getDate(11),
                                         dados.getBoolean(12));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }
        return pj;
    }

}