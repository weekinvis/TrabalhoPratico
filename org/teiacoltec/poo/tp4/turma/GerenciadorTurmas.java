package org.teiacoltec.poo.tp4.turma;

import org.teiacoltec.poo.tp4.excecoes.TurmaNaoEncontradaException;
import org.teiacoltec.poo.tp4.gerenciadores.GerenciadorIDMatricula;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorTurmas {
    private static Map<Integer, Turma> mapaIDTurma = new HashMap<>();

    private GerenciadorTurmas() {}

    public static Turma solicitarCriacaoTurma(String nome, LocalDate inicio, LocalDate fim) {
        Turma turmaCriada = new Turma(nome, GerenciadorIDMatricula.obterIDTurma(), inicio, fim);
        mapaIDTurma.put(turmaCriada.getId(), turmaCriada);
        return turmaCriada;
    }

    public static Turma obterTurmaIDPorID(int id) throws TurmaNaoEncontradaException {
        if(mapaIDTurma.containsKey(id)) return mapaIDTurma.get(id);
        throw new TurmaNaoEncontradaException("Nenhuma turma com esse ID foi encontrado.");
    }

}
