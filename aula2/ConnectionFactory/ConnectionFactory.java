package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private Connection con;
    private final String url = "jdbc:mysql://localhost:3306/aula03agenda";
    private final String user = "root";
    private final String password = "laboratorio";

    //método que retorna uma conexão
    public Connection getConnection() {
        try {
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException e) {
            System.out.println("ERRO AO CONECTAR: " + e);
            return null;
        }
    }
}
