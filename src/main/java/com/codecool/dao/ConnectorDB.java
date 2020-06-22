package com.codecool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorDB {
    Connection connection;


    public ConnectorDB() throws ClassNotFoundException {
        connect();
    }

    public void connect() throws ClassNotFoundException {
        connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/questbook", "ozukyo", "1234");
            System.out.println("Database opened sucessfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
