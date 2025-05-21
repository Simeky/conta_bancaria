package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.unisenai.classes.UF;
import connections.MySQL;
import interfaces.DAO.I_uf;

public class UF_controller implements I_uf {

    @Override
    public UF find_UF(int id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'find_UF'");
    }

    @Override
    public UF find_UF(String sigla) {
        
        throw new UnsupportedOperationException("Unimplemented method 'find_UF'");
    }

    @Override
    public List<UF> find_all() {
        
        throw new UnsupportedOperationException("Unimplemented method 'find_all'");
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
            command.execute();
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
            command.setString(1, uf.getUf_nome());
            command.setString(2, uf.getUf_sigla());
            command.setString(3, uf.getUf_regiao().getValor_regiao());
            command.setInt(4, uf.getUf_id());

            if (command.executeUpdate() == 0) {
                throw new RuntimeException("Nenhuma linha foi atualizada. Verifique se o ID existe.");
            }

            command.execute();

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
    public void delete(int id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void delete(UF uf) {
        
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
