package com.example.Model;

public class Funcionario {
    String nome;
    Double valHora;
    int folgasDisponiveis;
    String cpf;

    

    public Funcionario(String nome, Double valHora, int folgasDisponiveis, String cpf) {
        this.nome = nome;
        this.valHora = valHora;
        this.folgasDisponiveis = folgasDisponiveis;
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Double getValHora() {
        return valHora;
    }
    public void setValHora(Double valHora) {
        this.valHora = valHora;
    }
    public int getFolgasDisponiveis() {
        return folgasDisponiveis;
    }
    public void setFolgasDisponiveis(int folgasDisponiveis) {
        this.folgasDisponiveis = folgasDisponiveis;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cPF) {
        cpf = cPF;
    }

    public Double getValMes(){
        return this.valHora * 22;
    }

    
}

