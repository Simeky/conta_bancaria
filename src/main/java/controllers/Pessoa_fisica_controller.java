package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find_all'");
    }

    @Override
    public void insert(Pessoa_fisica pf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void update(Pessoa_fisica pf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void save(Pessoa_fisica pf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
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
