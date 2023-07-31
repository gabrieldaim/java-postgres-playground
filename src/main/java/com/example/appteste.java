package com.example;

import java.util.Arrays;

public class appteste {
    public static void main(String[] args) {
        double vetorDouble[][] = new double[4][5];
        for (int i = 0; i < vetorDouble.length; i++) {
            for (int j = 0; j < vetorDouble[i].length; j++) {
                vetorDouble[i][j] = 100 * (j+1) *(i+1);
            }
        }

        for (int i = 0; i < vetorDouble.length; i++) {
            for (int j = 0; j < vetorDouble[i].length; j++) {
                System.out.printf("%6.1f ", vetorDouble[i][j]);
            }
            System.err.println();

        }


    }
}
