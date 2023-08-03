package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO {
    private Connection conn;

    public DAO(Connection conn) {
        this.conn = conn;
    }

    public void listarDadosTabela(String tabela) {
        var sql = "select * from " + tabela;
        try {
            var statement = conn.createStatement();
            var results = statement.executeQuery(sql);

            var metadata = results.getMetaData();
                int cols = metadata.getColumnCount();
                for (int index = 1; index <= cols; index++) {
                    System.out.printf("%-25s | ", metadata.getColumnName(index));
                }
                System.out.println();
            while (results.next()) {
                for (int index = 1; index <= cols; index++) {
                    System.out.printf("%-25s | ", results.getString(index));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("não foi possivel executar a consulta ao banco de dados:" + e.getMessage()); 
        }
    }
}
