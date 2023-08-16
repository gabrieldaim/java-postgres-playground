package com.example.educacao.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.example.educacao.model.Aluno;
import com.example.model.Estado;

public class AlunoDAO extends DAO{
    public AlunoDAO(Connection conn) {
        super(conn);
    }

    public void insert(Aluno aluno){
        try {
            var sql = "insert into aluno (nome) values (?)";
            var statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, aluno.getNome());
            statement.executeUpdate();
            var result = statement.getGeneratedKeys();
            if(result.next()){
                aluno.setMatricula(result.getInt(1));
            }


        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel inserir o aluno", e);
        }
    }

    public void insertNota(int idDisciplina, double nota, int matricula){
        if(idDisciplina <= 0 || idDisciplina > 3)
            throw new IllegalArgumentException("o Id da disciplina deve estar entre 1 e 3");
        try {
            var sql = "update aluno set nota" + idDisciplina + " = ? where matricula = ?";
            var statement = conn.prepareStatement(sql);
            statement.setDouble(1, nota);
            statement.setInt(2, matricula);
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel registrar a nota", e);
        }

    }

    public List<Aluno> listar(){

        try {
            var lista = new LinkedList<Aluno>();
        
            var statement =conn.createStatement();
            var results = statement.executeQuery("select * from aluno");
            while(results.next()){
                var aluno = new Aluno();
                aluno.setMatricula(results.getInt("matricula"));
                aluno.setNome(results.getString("nome"));
                aluno.setNota1(results.getDouble("nota1"));
                aluno.setNota2(results.getDouble("nota2"));
                aluno.setNota3(results.getDouble("nota3"));

                lista.add(aluno);
            }    

            return lista;
        } catch (Exception e) {
            throw new RuntimeException("Não foi possivel listar os alunos", e);
        }
        
    }
}
