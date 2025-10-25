package org.teiacoltec.poo.tp4;

import org.teiacoltec.poo.tp4.atividade.Atividade;
import org.teiacoltec.poo.tp4.excecoes.PessoaJaParticipaException;
import org.teiacoltec.poo.tp4.excecoes.PessoaNaoEncontradaException;
import org.teiacoltec.poo.tp4.recursohumano.Aluno;
import org.teiacoltec.poo.tp4.recursohumano.Monitor;
import org.teiacoltec.poo.tp4.recursohumano.Pessoa;
import org.teiacoltec.poo.tp4.recursohumano.Professor;
import org.teiacoltec.poo.tp4.turma.Turma;
import org.teiacoltec.poo.tp4.util.Gerador;

import java.util.List;

public class Main {

    public static void imprimirInformacoes(Turma t) {
        System.out.println(t.obterInformacoes());
    }

    public static void imprimirInformacoes(Pessoa p) {
        System.out.println(p.obterInformacoes());
    }

    public static void imprimirInformacoes(Atividade a) {
        System.out.println(a.obterInformacoes());
    }

    public static void main(String[] args) {
        Turma t = Gerador.gerarTurma();

        Main.imprimirInformacoes(Gerador.gerarAtividade());

        try {
            t.adicionarParticipante(Gerador.gerarProfessor(true));
            t.adicionarParticipante(Gerador.gerarMonitor(true));
            t.adicionarParticipante(Gerador.gerarMonitor(true));
            t.adicionarParticipante(Gerador.gerarAluno(true));
            t.adicionarParticipante(Gerador.gerarAluno(true));
            t.adicionarParticipante(Gerador.gerarAluno(true));
            t.adicionarParticipante(Gerador.gerarAluno(true));
            t.adicionarParticipante(Gerador.gerarAluno(true));
            t.adicionarParticipante(Gerador.gerarAluno(true));
            t.adicionarParticipante(Gerador.gerarAluno(true));

            t.listarParticipantesEnxuto();

            System.out.println("Nenhum Erro.");

        } catch (Exception e) {
            System.out.println("Erro " + e);
        } finally {
            System.out.println("Transação concluída.");
        }

    }
}