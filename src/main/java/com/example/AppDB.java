package com.example;

import java.sql.DriverManager;
import java.sql.SQLException;

public class AppDB {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            var conn = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "gitpod", "");
            System.out.println("conexão realizada com sucesso!");

            var statement =conn.createStatement();
            var results = statement.executeQuery("select * from estado");
            while(results.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", results.getInt("id"), results.getString("nome"), results.getString("uf"));
            }

        } catch (ClassNotFoundException e) {
            System.err.println("não foi possivel carregar a biblioteca para acesso ao banco de dados:" + e.getMessage()); 
       } catch (SQLException e) {
            System.err.println("não foi possivel conectar ao banco de dados:" + e.getMessage()); 

        }
    }
}
