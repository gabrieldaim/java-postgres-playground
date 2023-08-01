package com.example;

import java.time.LocalDate;

public class Cidadao {
    private LocalDate dataNascimeno;

    public LocalDate getDataNascimeno() {
        return dataNascimeno;
    }

    public void setDataNascimeno(LocalDate dataNascimeno) {
        this.dataNascimeno = dataNascimeno;
    };

    public int idade(){
        return LocalDate.now().getYear() - dataNascimeno.getYear();
    }

    public String eleitor(){
        int idade = idade();
        if(idade < 16)
            return "não é um eleitor";

        if(idade > 15 && idade <18 || idade > 70)
            return "é um eleitor facultativo";

        return "é um eleitor obrigatório";
    }
}
