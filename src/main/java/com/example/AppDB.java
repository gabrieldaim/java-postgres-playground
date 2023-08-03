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
            //listarEstados(conn);
            //localizarEstado(conn, "RJ");

            var marca = new Marca();
            marca.setId(1L);

            var produto = new Produto();
            produto.setId(201L);
            produto.setMarca(marca);
            produto.setNome("nome novooo 2");
            produto.setValor(200.0);
            alterarProduto(conn, produto);
            excluirProduto(conn, 203L);            
            listarDadosTabela(conn, "produto");

        }catch (SQLException e) {
                System.err.println("não foi possivel conectar ao banco de dados:" + e.getMessage()); 
        }
    }

    private void excluirProduto(Connection conn, long l) {
        var sql = "delete from produto where id=?";
        try (var statement = conn.prepareStatement(sql)) {
            statement.setLong(1, l);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("não foi possivel executar a consulta ao banco de dados:" + e.getMessage()); 

        }
    }

    private void alterarProduto(Connection conn, Produto produto) {
        var sql = "update produto set nome=?, marca_id=?,valor=? where id=? ";
        try (var statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, produto.getId());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("não foi possivel executar a consulta ao banco de dados:" + e.getMessage()); 
        }
    }

    private void inserirProduto(Connection conn, Produto produto) {
        var sql = "insert into produto (nome,marca_id,valor) values (?, ?, ?)";
        try (var statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("não foi possivel executar a consulta ao banco de dados:" + e.getMessage()); 
        }
    }

    private void listarDadosTabela(Connection conn, String tabela) {
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
