package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    
    public static Connection conectar() {        
        
        final String url         = "jdbc:mysql//localhost/bd_controle_bancario";
        final String user        = "root";
        final String password    = "";

        try {

            return DriverManager.getConnection(url, user, password);
            
        }   catch (SQLException e) {
                throw new RuntimeException("A conexão falhou:\n" + e.getMessage());
            }

    }

    public static void desconectar(Connection conexao) {

        if (conexao != null) {

            try {
                conexao.close();

            }   catch (SQLException e) {
                    throw new RuntimeException("Problemas ao desconectar:\n" + e.getMessage());
                }

        }

    }

}
