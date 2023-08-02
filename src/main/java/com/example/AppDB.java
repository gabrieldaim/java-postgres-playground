package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppDB {
    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";

    public static void main(String[] args) {
        new AppDB();
    }

    public AppDB(){
        
        try(var conn = getConnection()){
            listarEstados(conn);
            localizarEstado(conn, "RJ");
            listarDadosTabela(conn, "cliente");
        }catch (SQLException e) {
                System.err.println("não foi possivel conectar ao banco de dados:" + e.getMessage()); 
        }
    }

    private void listarDadosTabela(Connection conn, String tabela) {
        var sql = "select * from " + tabela;
        try {
            var statement = conn.createStatement();
            var results = statement.executeQuery(sql);
            while (results.next()) {
                int cols = results.getMetaData().getColumnCount();
                for (int index = 1; index <= cols; index++) {
                    System.out.printf("%-25s | ", results.getString(index));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("não foi possivel executar a consulta ao banco de dados:" + e.getMessage()); 
        }
    }

    private void localizarEstado(Connection conn, String uf) {
        try {
            var sql = "select * from estado where uf = ?";
            var statement = conn.prepareStatement(sql);
            statement.setString(1, uf);
            var result = statement.executeQuery();
            if (result.next()){
                System.out.printf("Id:" + result.getInt("id")+ " Nome:" + result.getString("nome") +  " UF:" + result.getString("uf")+ "\n");
            }

        } catch (SQLException e) {
            System.err.println("não foi possivel executar a consulta ao banco de dados:" + e.getMessage()); 
        }

    }

    private void listarEstados(Connection conn) {
        try{
            System.out.println("conexão realizada com sucesso!");
            var statement =conn.createStatement();
            var results = statement.executeQuery("select * from estado");
            while(results.next()){
                System.out.printf("Id:" + results.getInt("id")+ " Nome:" + results.getString("nome") +  " UF:" + results.getString("uf")+ "\n");
                System.out.println("finalizou listarEstados");
            }    
        } catch (SQLException e) {
                System.err.println("não foi possivel executar a consulta ao banco de dados:" + e.getMessage()); 

        }
    }

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private void carregarDriveJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("não foi possivel carregar a biblioteca para acesso ao banco de dados:" + e.getMessage()); 
        }
    }
}
