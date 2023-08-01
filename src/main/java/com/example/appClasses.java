package com.example;

public class appClasses {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();

        System.out.println("Renda: " + cliente.getRenda());
        System.out.println("Sexo: " + cliente.getSexo());
        System.out.println("Ano de Nascimento: " + cliente.getAnoNascimento());    
    }
}
