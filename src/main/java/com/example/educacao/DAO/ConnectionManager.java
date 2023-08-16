package com.example.educacao.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String USERNAME = "gitpod";
    private static final String PASSWORD = "";
    private static final String JDBC_URL = "jdbc:postgres://localhost/postgres";

    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }
}
