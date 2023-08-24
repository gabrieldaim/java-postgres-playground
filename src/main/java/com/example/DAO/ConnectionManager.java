package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String caminhoBD = "jdbc:sqlite:teste.sqlite";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(caminhoBD);
    }
}
