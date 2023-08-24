package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.example.DAO.ConnectionManager;
import com.example.DAO.FuncionarioDAO;
import com.example.Model.Funcionario;


public class principal {
    public static void main(String[] args) {
        var scann = new Scanner(System.in);
        String nome;
        Double valHora;
        String cpf;
        int folgasDisponiveis;
        try (var conn = ConnectionManager.getConnection();var statement = conn.createStatement()){
            System.out.println("conectou ao banco");
            String createTableFunc = "CREATE TABLE IF NOT EXISTS funcionarios(nome varchar(120), valHora double, folgasDisponiveis integer, cpf text)";
            statement.execute(createTableFunc);

            var funcionario = new Funcionario("Gabriel", 30.0,8,"0000007");
            System.out.print("criou o funcionário");
            var funcionarioDAO = new FuncionarioDAO(conn);
            var codigo = 1;
            funcionarioDAO.Cadastrar(funcionario);
            while (codigo < 5 && codigo > 0 ) {
                System.out.println("Selecione a opção desejada:");
                System.out.println("1 - cadastrar funcionário");
                System.out.println("2 - listar funcionários");
                System.err.println("Digite aqui sua opção: ");
                codigo = scann.nextInt();
                if(codigo == 1){
                    System.out.println("Nome:");
                    nome = scann.next();
                    System.out.println("valor da hora:");
                    valHora = scann.nextDouble();
                    System.out.println("Folgas:");
                    folgasDisponiveis = scann.nextInt();
                    System.out.println("cpf:");
                    cpf = scann.next();
                    var funcionario1 = new Funcionario(nome, valHora,folgasDisponiveis,cpf);
                    var funcionario1DAO = new FuncionarioDAO(conn);
                    funcionario1DAO.Cadastrar(funcionario1);
                }
                if(codigo == 2){
                    var listaFuncionarios = funcionarioDAO.listar();
                    for (var func : listaFuncionarios) {
                        System.out.println(func.getNome());
                    }
                }

            }
            
        } catch (SQLException e) {
            System.err.println("não foi possivel conectar ao BD");
        } catch (RuntimeException e){
            System.err.println(e.getMessage());
        }
    }
}
