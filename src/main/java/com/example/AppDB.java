package com.example;

import java.sql.SQLException;

import com.example.dao.ConnectionManager;
import com.example.dao.DAO;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Marca;
import com.example.model.Produto;

public class AppDB {
    public static void main(String[] args) {
        new AppDB();
    }

    public AppDB(){
        
        try(var conn = ConnectionManager.getConnection()){
            var estadoDAO = new EstadoDAO(conn);
            var produtoDAO = new ProdutoDAO(conn);
            var dao = new DAO(conn);
            var listaEstados = estadoDAO.listar();
            for (var estado : listaEstados) {
                System.out.println(estado);
            }
            estadoDAO.localizar("RJ");

            // var marca = new Marca();
            // marca.setId(1L);

            // var produto = new Produto();
            // produto.setId(201L);
            // produto.setMarca(marca);
            // produto.setNome("nome novooo 2");
            // produto.setValor(200.0);
            // produtoDAO.alterar(produto);
            // produtoDAO.excluir(203L);            
            // dao.listarDadosTabela("produto");

        }catch (SQLException e) {
                System.err.println("não foi possivel conectar ao banco de dados:" + e.getMessage()); 
        }
    }

}