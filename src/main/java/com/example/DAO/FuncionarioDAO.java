package com.example.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.Model.Funcionario;

public class FuncionarioDAO extends DAO{
    public FuncionarioDAO(Connection conn){
        super(conn);
    }

    public void Cadastrar(Funcionario funcionario){
        try {
            var sql = "insert into funcionarios (nome,valHora,folgasDisponiveis,cpf) values (?,?,?,?)";
            var statement = conn.prepareStatement(sql);
            statement.setString(1, funcionario.getNome());
            statement.setDouble(2, funcionario.getValHora());
            statement.setInt(3, funcionario.getFolgasDisponiveis());
            statement.setString(4, funcionario.getCpf());
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("não foi possivel cadastrar usuário", e);
        }
    }

    public List<Funcionario> listar(){
        try{
                    var lista = new LinkedList<Funcionario>();
            var statement = conn.createStatement();
            var results = statement.executeQuery("select * from funcionarios");
            while (results.next()) {
                var funcionario = new Funcionario(results.getString("nome"), results.getDouble("valHora"), results.getInt("folgasDisponiveis"), results.getString("cpf"));
                lista.add(funcionario);
            }
            return lista;

        } catch (Exception e) {
            throw new RuntimeException("não foi possivel listar os funcionários",e);
        }
    }
}
