package com.example;

public class Estudo {
    public static String remove(String str) {
        System.out.println(str.substring(1, str.length()-1));

        return str;
    }

    public static void main(String[] args) {
        Estudo estudo = new Estudo();
        estudo.remove("eloquent");
    }
}

