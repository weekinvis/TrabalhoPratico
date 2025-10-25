package org.teiacoltec.poo.tp4.util;

public class GerenciadorIDMatricula {

    private static int pessoasGeradas = 0;
    private static int turmasGeradas = 0;
    private static int atividadesGeradas = 0;

    private static String gerarCaracteresMatricula() {
        return String.format("%06d", pessoasGeradas);
    }

    public static String obterMatricula() {
        pessoasGeradas++;
        return gerarCaracteresMatricula();
    }


    public static int obterIDTurma() {
        return ++turmasGeradas;
    }

    public static int obterIDAtividade() {
        return ++atividadesGeradas;
    }

}
