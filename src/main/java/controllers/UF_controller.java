package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unisenai.classes.UF;
import br.unisenai.enums.E_regiao;
import connections.MySQL;
import interfaces.DAO.I_uf;

public class UF_controller implements I_uf {

    @Override
    public UF find_UF(long id) {
        final String intruction =   "Select uf.bd_id_uf, uf.bd_nome_uf, uf.bd_sigla_uf, uf.bd_regiao_uf"  + 
                                    "from t_uf uf " +  
                                    "where uf.bd_id_uf = ?;";
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        UF uf = null;

        try {
            command = conexao.prepareStatement(intruction);
            command.setLong(1, id);
            dados = command.executeQuery();

            if (dados.next()) {
               uf = new UF();
               uf.setUf_id(dados.getLong(0));
               uf.setUf_nome(dados.getString(1));
               uf.setUf_sigla(dados.getString(2));
               uf.setUf_regiao(E_regiao.valueOf(dados.getString(3)));
            }
        }   
        catch (SQLException e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        }
        finally {
            MySQL.desconectar(conexao, command);            
        }

        return uf;

    }

    @Override
    public UF find_UF(String sigla) {
        
        final String intruction =   "Select uf.bd_id_uf, uf.bd_nome_uf, uf.bd_sigla_uf, uf.bd_regiao_uf"  + 
                                    "from t_uf uf " +  
                                    "where uf.bd_sigla_uf = ?;";
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        UF uf = null;

        try {
            command = conexao.prepareStatement(intruction);
            command.setString(1, sigla);
            dados = command.executeQuery();

            if (dados.next()) {
               uf = new UF();
               uf.setUf_id(dados.getLong(0));
               uf.setUf_nome(dados.getString(1));
               uf.setUf_sigla(dados.getString(2));
               uf.setUf_regiao(E_regiao.valueOf(dados.getString(3)));
            }
        }   
        catch (SQLException e) {
            throw new RuntimeException("Problema no retorno dos dados:\n" + e.getMessage());
        }
        finally {
            MySQL.desconectar(conexao, command);            
        }

        return uf;

    }

    @Override
    public List<UF> find_all(String condicao, String ordem) {
        
        final String intruction =   "Select uf.bd_id_uf, uf.bd_nome_uf, uf.bd_sigla_uf, uf.bd_regiao_uf"  + 
                                    "from t_uf uf;";
        String Condicao   =         "where ?";
        String Ordem      =         "Order by ?";

        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;
        ResultSet dados = null;
        List<UF> lista = new ArrayList<UF>();

        try {

            command = conexao.prepareStatement(intruction + (!condicao.isEmpty()? Condicao:"") + (!ordem.isEmpty()? Ordem:""));

            if (!condicao.isEmpty()) {
                command.setString(1, Condicao);                
            }

            if (!ordem.isEmpty()) {
                command.setString((condicao.isEmpty()? 1:2), Ordem);                
            }
            
            dados = command.executeQuery();

            while (dados.next()) {
               lista.add(new UF(dados.getLong(0),
                                dados.getString(1),
                                dados.getString(2),
                                E_regiao.valueOf(dados.getString(3))));
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
    public void insert(UF uf) {
        
        final String intruction = "Insert into t_uf (bd_nome_uf, bd_sigla_uf, bd_regiao_uf)" +
                                " values (?, ?, ?);";
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;

        try {
            command = conexao.prepareStatement(intruction);
            command.setString(1, uf.getUf_nome());
            command.setString(2, uf.getUf_sigla());
            command.setString(3, uf.getUf_regiao().getValor_regiao());
            
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
    public void update(UF uf) {

        final String instruction = "Update t_uf set bd_nome_uf = ?, bd_sigla_uf = ?, bd_regiao_uf = ? where bd_id_uf = ?;";
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;

        try {
            command = conexao.prepareStatement(instruction);
            command.setString   (1, uf.getUf_nome());
            command.setString   (2, uf.getUf_sigla());
            command.setString   (3, uf.getUf_regiao().getValor_regiao());
            command.setLong     (4, uf.getUf_id());

            if (command.executeUpdate() == 0) {
                throw new RuntimeException("Nenhuma linha foi atualizada. Verifique se o ID existe.");
            }

        } 
        catch (SQLException e) {
            throw new RuntimeException("Problema na atualização de dados:\n" + e.getMessage());
        } 
        finally {
            MySQL.desconectar(conexao, command);
        }
        
    }

    @Override
    public void save(UF uf) {
        
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(long id) {

        final String instruction = "Delete from t_uf where bd_id_uf = ?;";
        Connection conexao = MySQL.conectar();
        PreparedStatement command = null;

        try {
            command = conexao.prepareStatement(instruction);
            command.setLong(1, id);

            if (command.executeUpdate() == 0) {
                throw new RuntimeException("Nenhuma linha foi deletada. Verifique se o ID existe.");
            }

        } 
        catch (SQLException e) {
            throw new RuntimeException("Problema na exclusão de dados:\n" + e.getMessage());
        } 
        finally {
            MySQL.desconectar(conexao, command);
        }
    
    }

    @Override
    public void delete(UF uf) {
        
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
