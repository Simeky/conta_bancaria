package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
                    "cb.bd_senha_cb, " +
                    "cb.bd_bandeira_cartao_cb, " +
                    "cb.bd_numero_cartao_cb, " +
                    "cb.bd_validade_cartao_cb, " +
                    "cb.bd_cvv_cb, " +
                    "cb.bd_status_cb, " +
                    "cp.bd_indice_reajuste_cp " +
            "From t_conta_poupanca cp " +
            "Join t_conta_bancaria cb on cp.bd_id_cp = cb.bd_id_cp " +
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
                    if (s.getValue() == dados.getString(12)) {
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
    public List<Conta_poupanca> find_all(String condicao, String ordem) {
        StringBuilder sql = new StringBuilder(
            "Select  cp.bd_id_cp, " +
                    "cb.bd_id_age, " +
                    "cb.bd_id_titular1_cb, " +
                    "cb.bd_id_titular2_cb, " +
                    "cb.bd_abertura_cb, " +
                    "cb.bd_saldo_cb, " +
                    "cb.bd_senha_cb, " +
                    "cb.bd_bandeira_cartao_cb, " +
                    "cb.bd_numero_cartao_cb, " +
                    "cb.bd_validade_cartao_cb, " +
                    "cb.bd_cvv_cb, " +
                    "cb.bd_status_cb, " +
                    "cp.bd_indice_reajuste_cp " +
            "From t_conta_poupanca cp " +
            "Join t_conta_bancaria cb on cp.bd_id_cp = cb.bd_id_cb ");

        if (condicao != null && !condicao.isEmpty()) {
            sql.append("Where ").append(condicao).append(" ");
        }

        if (ordem != null && !ordem.isEmpty()) {
            sql.append("Order by ").append(ordem).append(" ");
        }
        sql.append(";");

        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        List<Conta_poupanca> lista = new ArrayList<Conta_poupanca>();

        try {
            command = conexao.prepareStatement(sql.toString());
            dados = command.executeQuery();

            while (dados.next()) {
                eStatus status = null;
                for (eStatus s : eStatus.values()) {
                    if (s.getValue() == dados.getString(12)) {
                        status = s;
                        break;
                    }
                }

                lista.add(new Conta_poupanca(dados.getLong(1), 
                                            new Agencia(dados.getLong(2), null, null, 0, null, null, null), 
                                            new Pessoa_fisica(dados.getLong(3), null, null, null, null, null, dados.getLong(1), null, 0, null, null, null, null), 
                                            new Pessoa_fisica(dados.getLong(4), null, null, null, null, null, dados.getLong(1), null, 0, null, null, null, null), 
                                            dados.getDate(5), 
                                            dados.getDouble(6), 
                                            dados.getString(7), 
                                            dados.getString(8), 
                                            dados.getString(9), 
                                            dados.getDate(10), 
                                            dados.getShort(11), 
                                            status, 
                                            dados.getDouble(13)));
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar contas poupança: " + e.getMessage());
        } finally {
            MySQL.desconectar(conexao, command);
        }

        return lista;        
    }

    @Override
    public void insert(Conta_poupanca cp) {
        StringBuilder sql = new StringBuilder(
            "Insert into t_conta_bancaria (bd_id_age, bd_id_titular1_cb, bd_id_titular2_cb, bd_abertura_cb, bd_saldo_cb, bd_senha_cb, bd_bandeira_cartao_cb, bd_numero_cartao_cb, bd_validade_cartao_cb, bd_cvv_cb, bd_status_cb) " +  
            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        StringBuilder sql2 = new StringBuilder(
            "Insert into t_conta_poupanca values (?, ?);");
        Connection conexao = MySQL.conectar();
        PreparedStatement commandcb = null;
        PreparedStatement commandcp = null;
        ResultSet generatedKeys = null;

        try {
            //Insere na tabela conta_bancaria
            commandcb = conexao.prepareStatement(sql.toString(), PreparedStatement.RETURN_GENERATED_KEYS);
            commandcb.setLong(1, cp.getCb_agencia().getAgencia_id());
            commandcb.setLong(2, cp.getCb_titular1().getPessoa_id());
            commandcb.setLong(3, cp.getCb_titular2().getPessoa_id());
            commandcb.setDate(4, cp.getCb_abertura());
            commandcb.setDouble(5, cp.getCb_saldo());
            commandcb.setString(6, cp.getCb_pswrd());
            commandcb.setString(7, cp.getCb_bandeira_card());
            commandcb.setString(8, cp.getCb_num_card());
            commandcb.setDate(9, cp.getCb_val_card());
            commandcb.setShort(10, cp.getCb_cvv_card());
            commandcb.setString(11, cp.getCb_status().getValue());

            if (commandcb.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi adicionado em t_conta_bancaria. Verifique se não inseriu nenhum valor inválido.");
            }

            generatedKeys = commandcb.getGeneratedKeys();
            if (generatedKeys.next()) {
                cp.setCb_id(generatedKeys.getLong(1));
            }
            else {
                throw new RuntimeException("Nenhum ID foi gerado para a conta bancária. Verifique se não inseriu nenhum valor inválido.");
            }

            //Insere na tabela conta_poupanca
            commandcp = conexao.prepareStatement(sql2.toString());
            commandcp.setLong(1, cp.getCb_id());
            commandcp.setDouble(2, cp.getCp_reajuste());
            if (commandcp.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi adicionado em t_conta_poupanca. Verifique se não inseriu nenhum valor inválido.");
            }
        } 
        catch (Exception e) {
            throw new RuntimeException("Erro ao inserir conta poupança: " + e.getMessage());
        }
        finally {
            MySQL.desconectar(null, commandcb);
            MySQL.desconectar(conexao, commandcp);
            try { if (generatedKeys != null) generatedKeys.close(); } catch (Exception e) {}
        }
    }

    @Override
    public void update(Conta_poupanca cp) {
        StringBuilder sql = new StringBuilder(
                "Update t_conta_bancaria set bd_id_age = ?, " +
                                            "bd_id_titular1_cb = ?, " +
                                            "bd_id_titular2_cb = ?, " +
                                            "bd_abertura_cb = ?, " +
                                            "bd_saldo_cb = ?, " +
                                            "bd_senha_cb = ?, " +
                                            "bd_bandeira_cartao_cb = ?, " +
                                            "bd_numero_cartao_cb = ?, " +
                                            "bd_validade_cartao_cb = ?, " +
                                            "bd_cvv_cb = ?, " +
                                            "bd_status_cb = ? " +
                "Where bd_id_cb = ?;");
        StringBuilder sql2 = new StringBuilder(
                "Update t_conta_poupanca set bd_indice_reajuste_cp = ? where bd_id_cp = ?;");
        Connection conexao = MySQL.conectar();
        PreparedStatement commandcb = null;
        PreparedStatement commandcp = null;
        try {
            // Atualiza t_conta_bancaria            
            commandcb = conexao.prepareStatement(sql.toString());
            commandcb.setLong(1, cp.getCb_agencia().getAgencia_id());
            commandcb.setLong(2, cp.getCb_titular1().getPessoa_id());
            commandcb.setLong(3, cp.getCb_titular2().getPessoa_id());
            commandcb.setDate(4, cp.getCb_abertura());
            commandcb.setDouble(5, cp.getCb_saldo());
            commandcb.setString(6, cp.getCb_pswrd());
            commandcb.setString(7, cp.getCb_bandeira_card());
            commandcb.setString(8, cp.getCb_num_card());
            commandcb.setDate(9, cp.getCb_val_card());
            commandcb.setShort(10, cp.getCb_cvv_card());
            commandcb.setString(11, cp.getCb_status().getValue());
            commandcb.setLong(12, cp.getCb_id());
            if (commandcb.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi atualizado em t_conta_bancaria. Verifique se o ID existe.");
            }

            // Atualiza t_conta_poupanca
            commandcp = conexao.prepareStatement(sql2.toString());
            commandcp.setDouble(1, cp.getCp_reajuste());
            commandcp.setLong(2, cp.getCb_id());
            if (commandcp.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi atualizado em t_conta_poupanca. Verifique se o ID existe.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar conta poupança: " + e.getMessage());
        } finally {
            MySQL.desconectar(null, commandcb);
            MySQL.desconectar(conexao, commandcp);
        }
    }

    @Override
    public void save(Conta_poupanca cp) {
        if (find_conta_poupanca(cp.getCb_id()) == null) {
            insert(cp);
        } else {
            update(cp);
        }
    }

    @Override
    public void desativa(long id) {
        StringBuilder sql = new StringBuilder(
                "Update t_conta_bancaria set bd_status_cb = 5 where bd_id_cb = ?;");
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;

        try {            
            command = conexao.prepareStatement(sql.toString());
            command.setLong(1, id);
            if (command.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi desativado. Verifique se o ID existe.");
            }
        } 
        catch (Exception e) {
            throw new RuntimeException("Erro ao desativar conta poupança: " + e.getMessage());
        } 
        finally {
            MySQL.desconectar(conexao, command);
        }
    }

    @Override
    public void desativa(Conta_poupanca cp) {
        desativa(cp.getCb_id());
    }

    @Override
    public void cancela(long id) {
        StringBuilder sql = new StringBuilder(
                "Update t_conta_bancaria set bd_status_cb = 0 where bd_id_cb = ?;");
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;

        try {            
            command = conexao.prepareStatement(sql.toString());
            command.setLong(1, id);
            if (command.executeUpdate() == 0) {
                throw new RuntimeException("Nenhum registro foi canceladp. Verifique se o ID existe.");
            }
        } 
        catch (Exception e) {
            throw new RuntimeException("Erro ao cancelar conta poupança: " + e.getMessage());
        } 
        finally {
            MySQL.desconectar(conexao, command);
        }
    }

    @Override
    public void cancela(Conta_poupanca cp) {
        cancela(cp.getCb_id());
    }

}
