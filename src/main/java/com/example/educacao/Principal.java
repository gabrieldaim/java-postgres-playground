package com.example.educacao;

import java.sql.SQLException;

import com.example.dao.ConnectionManager;
import com.example.educacao.DAO.AlunoDAO;
import com.example.educacao.model.Aluno;

public class Principal {
    public static void main(String[] args) {
        try (var conn = ConnectionManager.getConnection()) {
            var alunoDAO = new AlunoDAO(conn);
            var aluno = new Aluno();
            aluno.setNome("Breno");
            alunoDAO.insert(aluno);
            System.out.println("aluno inserido com sucesso!");
            alunoDAO.insertNota(1, 8, aluno.getMatricula());
            System.out.println("Nota atualizada com sucesso!");

            var listaAlunos = alunoDAO.listar();
            for (var alunoDaLista : listaAlunos) {
                System.out.println(alunoDaLista.getNome());
            }

        } catch (SQLException e) {
            System.err.println("Não foi possivel conectar ao DB");
        } catch (RuntimeException e){
            System.err.println(e.getMessage());
        }
    }
}
