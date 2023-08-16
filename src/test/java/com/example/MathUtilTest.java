package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathUtilTest {
    @Test
    void testMdcP1Impar() {
        int a = 6;
        int b =3;
        int esperado = 3;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP1Par() {
        int a = 6;
        int b =2;
        int esperado = 2;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP3() {
        int a = 6;
        int b =0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP3Negativo() {
        int a = -6;
        int b =0;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP5() {
        int a = 6;
        int b = 2;
        int esperado = MathUtil.mdc(b, a);
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP7() {
        int a = 6;
        int b = 2;
        int esperado = MathUtil.mdc(-a , b);
        int obtido = MathUtil.mdc(a, -b);

        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP8() {
        int a = 6;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, a);

        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP8Negativo() {
        int a = -6;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, a);

        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP12DoisPrimos() {
        int a = 7, b = 7;
        int esperado = a;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP12UmPrimo() {
        int a = 7, b = 2;
        int esperado = 1;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcP12PrimoEUm() {
        int a = 7, b = 1;
        int esperado = 1;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcCasoGeral30e12() {
        int a = 30, b = 12;
        int esperado = 6;
        int obtido = MathUtil.mdc(a, b);

        assertEquals(esperado,obtido);
    }

    @Test
    void testMdcCasoGeral12e9() {
        int a = 12, b = 9;
        int esperado = 3;
        int obtido = MathUtil.mdc(a, b); 

        assertEquals(esperado,obtido);
    }
}
