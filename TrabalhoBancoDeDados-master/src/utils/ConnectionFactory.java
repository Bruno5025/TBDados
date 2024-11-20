package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/aaa"; // URL do banco
    private static final String USER = "root"; // Usuário do banco
    private static final String PASSWORD = "abc12345"; // Senha do banco

    /**
     * Método para obter a conexão com o banco de dados.
     * @return Conexão do tipo Connection.
     */
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            throw new RuntimeException("Erro ao conectar ao banco de dados.", e);
        }
    }

    /**
     * Método para fechar a conexão com o banco de dados.
     * @param connection Objeto Connection a ser fechado.
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexão com o banco de dados fechada com sucesso!");
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
            }
        }
    }
}
