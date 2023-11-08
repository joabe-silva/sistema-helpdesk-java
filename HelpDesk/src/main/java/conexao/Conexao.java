package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public Connection getConexao() {
        try {
            // Carregando o driver JDBC explicitamente
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Criando a conexão com o MariaDB
            String url = "jdbc:mysql://localhost:3306/helpdesk";
            String usuario = "root";
            String senha = "";

            Connection conn = DriverManager.getConnection(url, usuario, senha);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            // Lidando com exceções
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}
