package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class EstadoDAO {
    private Connection conn;

    public EstadoDAO(Connection conn) {
        this.conn = conn;
    }

    public void listar() {
        try{
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

    public void localizar(String uf) {
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
}
