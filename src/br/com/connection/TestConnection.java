package br.com.connection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author joaomiranda
 */
public class TestConnection {

    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }
}
