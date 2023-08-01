package com.example;

import java.time.LocalDate;

public class Eleitor {
    public static void main(String[] args) {
        var cidadao = new Cidadao();
        cidadao.setDataNascimeno(LocalDate.of(2007,10,1));
        System.out.println(cidadao.idade());
        System.out.println(cidadao.eleitor());
    }

}
