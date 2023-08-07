package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.example.model.Estado;

public class EstadoDAO extends DAO{
    public EstadoDAO(Connection conn) {
        super(conn);
    }

    public List<Estado> listar() throws SQLException {
        var lista = new LinkedList<Estado>();
        
            var statement =conn.createStatement();
            var results = statement.executeQuery("select * from estado");
            while(results.next()){
                var estado = new Estado();
                estado.setId(results.getLong("id"));
                estado.setNome(results.getString("nome"));
                estado.setUf(results.getString("uf"));
                lista.add(estado);
            }    

        return lista;
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
