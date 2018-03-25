package br.senac.dsw.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        
        Class.forName("com.mysql.jdbc.Driver");        

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/PRODUTOBD",
                    "root",
                    "");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
