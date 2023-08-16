package com.example.educacao.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import com.example.educacao.model.Aluno;

public class AlunoDAO extends DAO{
    public AlunoDAO(Connection conn) {
        super(conn);
    }

    public void insert(Aluno aluno){
        try {
            var sql = "insert into aluno (matricula, nome) values (?, ?)";
            var statement = conn.prepareStatement(sql);
            statement.setInt(1, aluno.getMatricula());
            statement.setString(2, aluno.getNome());
            statement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertNota(int idDisciplina, double nota, int matricula){
        var sql = "update aluno set nota?"
    }
}
