package com.example;

public class Cliente{
    private double renda;
    private char sexo;
    private int anoNascimento;

    public Cliente(double renda, char sexo, int anoNascimento){
        System.out.println("Criando novo cliente");
        this.renda = renda;
        this.sexo = sexo;
        this.anoNascimento = anoNascimento;
    }

    public Cliente(){
        System.out.println("iniciando sem parametro");
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if( sexo != 'f' && sexo !='m')
            System.out.println("utilize um parametro aceito");
        else this.sexo = sexo;

    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public double getRenda(){
        return renda;
    }

    public void setRenda(double renda){
        if(renda >= 0){
            this.renda = renda;
        }else{
            System.out.println("A renda deve ser maior que 0");
        }
    }
}