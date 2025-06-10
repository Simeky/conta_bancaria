package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unisenai.classes.Endereco;
import br.unisenai.classes.Pessoa_fisica;
import br.unisenai.enums.eSexo;
import connections.MySQL;
import interfaces.DAO.iPessoa_fisicaDAO;

public class Pessoa_fisica_controller  implements iPessoa_fisicaDAO{

    @Override
    public Pessoa_fisica find_pessoa_fisica(long id) {
        StringBuilder sql = new StringBuilder(
            "Select  pf.bd_id_pf, " +
                    "pf.bd_cpf_pf, " +
                    "pf.bd_nome_registro_pf, " +
                    "pf.bd_nome_social_pf, " +
                    "pf.bd_nascimento_pf, " +
                    "pf.bd_sexo_pf, " +
                    "pf.bd_renda_mensal_pf" +
                    "pes.bd_id_end, " +
                    "pes.bd_num_end_pes, " +
                    "pes.bd_complemento_end_pes, " +
                    "pes.bd_fone_pes, " +
                    "pes.bd_cliente_desde_pes, " +
                    "pes.bd_status_pes " +
            "From t_pessoa_fisica pf " +
            "Join t_pessoa pes on pes.bd_id_pes = pf.bd_id_pf " +
            "Where pf.bd_id_pf = ?;");

        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        Pessoa_fisica pf = null;

        try {
            command = conexao.prepareStatement(sql.toString());
            command.setLong(1, id);
            dados = command.executeQuery();

            if (dados.next()) {
                pf = new Pessoa_fisica(  dados.getLong(1),
                                         dados.getString(2),
                                         dados.getString(3),
                                         dados.getString(4),
                                         dados.getDate(5),
                           eSexo.valueOf(dados.getString(6)),
                                         dados.getDouble(7),
                            new Endereco(dados.getLong(8), null, null, null, null, null),
                                         dados.getInt(9),
                                         dados.getString(10),
                                         dados.getString(11),
                                         dados.getDate(12),
                                         dados.getBoolean(13));
                
            }
        } catch (Exception e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }

        return pf;
        
    }

    @Override
    public Pessoa_fisica find_pessoa_fisica(String cpf) {
        StringBuilder sql = new StringBuilder(
            "Select  pf.bd_id_pf, " +
                    "pf.bd_cpf_pf, " +
                    "pf.bd_nome_registro_pf, " +
                    "pf.bd_nome_social_pf, " +
                    "pf.bd_nascimento_pf, " +
                    "pf.bd_sexo_pf, " +
                    "pf.bd_renda_mensal_pf" +
                    "pes.bd_id_end, " +
                    "pes.bd_num_end_pes, " +
                    "pes.bd_complemento_end_pes, " +
                    "pes.bd_fone_pes, " +
                    "pes.bd_cliente_desde_pes, " +
                    "pes.bd_status_pes " +
            "From t_pessoa_fisica pf " +
            "Join t_pessoa pes on pes.bd_id_pes = pf.bd_id_pf " +
            "Where pf.bd_cpf_pf = ?;");

        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        Pessoa_fisica pf = null;

        try {
            command = conexao.prepareStatement(sql.toString());
            command.setString(1, cpf);
            dados = command.executeQuery();

            if (dados.next()) {
                pf = new Pessoa_fisica(  dados.getLong(1),
                                         dados.getString(2),
                                         dados.getString(3),
                                         dados.getString(4),
                                         dados.getDate(5),
                           eSexo.valueOf(dados.getString(6)),
                                         dados.getDouble(7),
                            new Endereco(dados.getLong(8), null, null, null, null, null),
                                         dados.getInt(9),
                                         dados.getString(10),
                                         dados.getString(11),
                                         dados.getDate(12),
                                         dados.getBoolean(13));
                
            }
        } catch (Exception e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }

        return pf;

    }

    @Override
    public List<Pessoa_fisica> find_all(String condicao, String ordem) {
        StringBuilder sql = new StringBuilder(
            "Select  pf.bd_id_pf, " +
                    "pf.bd_cpf_pf, " +
                    "pf.bd_nome_registro_pf, " +
                    "pf.bd_nome_social_pf, " +
                    "pf.bd_nascimento_pf, " +
                    "pf.bd_sexo_pf, " +
                    "pf.bd_renda_mensal_pf" +
                    "pes.bd_id_end, " +
                    "pes.bd_num_end_pes, " +
                    "pes.bd_complemento_end_pes, " +
                    "pes.bd_fone_pes, " +
                    "pes.bd_cliente_desde_pes, " +
                    "pes.bd_status_pes " +
            "From t_pessoa_fisica pf " +
            "Join t_pessoa pes on pes.bd_id_pes = pf.bd_id_pf");

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
        List<Pessoa_fisica> lista = new ArrayList<Pessoa_fisica>();

        try {
            command = conexao.prepareStatement(sql.toString());
            dados = command.executeQuery();

            while (dados.next()) {
                lista.add(new Pessoa_fisica(  dados.getLong(1),
                                                       dados.getString(2),
                                                       dados.getString(3),
                                                       dados.getString(4),
                                                       dados.getDate(5),
                                         eSexo.valueOf(dados.getString(6)),
                                                       dados.getDouble(7),
                                          new Endereco(dados.getLong(8), null, null, null, null, null),
                                                       dados.getInt(9),
                                                       dados.getString(10),
                                                       dados.getString(11),
                                                       dados.getDate(12),
                                                       dados.getBoolean(13)));
            }
        } catch (Exception e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }

        return lista;
    }

    @Override
    public void insert(Pessoa_fisica pf) {
        StringBuilder insert_pessoa = new StringBuilder(
            "Insert into t_pessoa (bd_id_end, bd_num_end_pes, bd_complemento_end_pes, bd_fone_pes, bd_cliente_desde_pes, bd_status_pes) Values (?, ?, ?, ?, ?, ?);");
        StringBuilder insert_pf = new StringBuilder(
            "Insert into t_pessoa_fisica (bd_id_pf, bd_cpf_pf, bd_nome_registro_pf, bd_nome_social_pf, bd_nascimento_pf, bd_sexo_pf, bd_renda_mensal_pf) Values (?, ?, ?, ?, ?, ?, ?);");
        Connection conexao = MySQL.conectar();
        PreparedStatement commandPessoa = null;
        PreparedStatement commandPF = null;
        ResultSet generatedKeys = null;
        try {
            // Insere na t_pessoa
            commandPessoa = conexao.prepareStatement(insert_pessoa.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
            commandPessoa.setLong(1, pf.getPessoa_end().getEnd_id());
            commandPessoa.setInt(2, pf.getPessoa_num_end());
            commandPessoa.setString(3, pf.getPessoa_compl());
            commandPessoa.setString(4, pf.getPessoa_fone());
            commandPessoa.setDate(5, pf.getPessoa_cliente_desde());
            commandPessoa.setBoolean(6, pf.getPessoa_status());
            if (commandPessoa.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi adicionado em t_pessoa. Verifique se não inseriu nenhum valor inválido.");
            }
            generatedKeys = commandPessoa.getGeneratedKeys();
            if (generatedKeys.next()) {
                pf.setPessoa_id(generatedKeys.getLong(1));
            } else {
                throw new RuntimeException("Nenhum ID foi gerado para a pessoa. Verifique se não inseriu nenhum valor inválido.");
            }
            //Insere na t_pessoa_fisica
            commandPF = conexao.prepareStatement(insert_pf.toString());
            commandPF.setLong(1, pf.getPessoa_id());
            commandPF.setString(2, pf.getPf_cpf());
            commandPF.setString(3, pf.getPf_nome_registro());
            commandPF.setString(4, pf.getPf_nome_social());
            commandPF.setDate(5, pf.getPf_data_nasc());
            commandPF.setString(6, pf.getPf_sexo().getValue());
            commandPF.setDouble(7, pf.getPf_renda_mes());
            if (commandPF.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi adicionado em t_pessoa_fisica. Verifique se não inseriu nenhum valor inválido.");
            }

        } catch (Exception e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(null , commandPessoa);
            MySQL.desconectar(conexao, commandPF);
            try { if (generatedKeys != null) generatedKeys.close(); } catch (Exception e) {}
        } 
    }

    @Override
    public void update(Pessoa_fisica pf) {
        StringBuilder sqlPessoa = new StringBuilder(
            "Update t_pessoa set bd_id_end = ?, " +
                                "bd_num_end_pes = ?, " +
                                "bd_complemento_end_pes = ?, " +
                                "bd_fone_pes = ?, " +
                                "bd_cliente_desde_pes = ?, " +
                                "bd_status_pes = ? " +
            "Where bd_id_pes = ?;");
        
        StringBuilder sqlPF = new StringBuilder(
            "Update t_pessoa_fisica set bd_cpf_pf = ?, " +
                                        "bd_nome_registro_pf = ?, " +
                                        "bd_nome_social_pf = ?, " +
                                        "bd_nascimento_pf = ?, " +
                                        "bd_sexo_pf = ?, " +
                                        "bd_renda_mensal_pf = ? " +
            "Where bd_id_pf = ?;");

        Connection conexao = MySQL.conectar();
        PreparedStatement commandPessoa = null;
        PreparedStatement commandPF = null;

        try {
            // Atualiza na t_pessoa
            commandPessoa = conexao.prepareStatement(sqlPessoa.toString());
            commandPessoa.setLong(1, pf.getPessoa_end().getEnd_id());
            commandPessoa.setInt(2, pf.getPessoa_num_end());
            commandPessoa.setString(3, pf.getPessoa_compl());
            commandPessoa.setString(4, pf.getPessoa_fone());
            commandPessoa.setDate(5, pf.getPessoa_cliente_desde());
            commandPessoa.setBoolean(6, pf.getPessoa_status());
            commandPessoa.setLong(7, pf.getPessoa_id());

            if (commandPessoa.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi atualizado em t_pessoa. Verifique se o ID existe.");
            }

            // Atualiza na t_pessoa_fisica
            commandPF = conexao.prepareStatement(sqlPF.toString());
            commandPF.setString(1, pf.getPf_cpf());
            commandPF.setString(2, pf.getPf_nome_registro());
            commandPF.setString(3, pf.getPf_nome_social());
            commandPF.setDate(4, pf.getPf_data_nasc());
            commandPF.setString(5, pf.getPf_sexo().getValue());
            commandPF.setDouble(6, pf.getPf_renda_mes());
            commandPF.setLong(7, pf.getPessoa_id());

            if (commandPF.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi atualizado em t_pessoa_fisica. Verifique se o ID existe.");
            }

        } catch (Exception e) {
            throw new RuntimeException("Problema na atualização dos dados:\n" + e.getMessage());
        } finally {
            MySQL.desconectar(null, commandPessoa);
            MySQL.desconectar(conexao, commandPF);
        }
    }

    @Override
    public void save(Pessoa_fisica pf) {
        if (find_pessoa_fisica(pf.getPessoa_id()) == null) {
            insert(pf);
        } else {
            update(pf);
        }
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void delete(Pessoa_fisica pf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
