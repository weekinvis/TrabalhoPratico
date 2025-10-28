package org.teiacoltec.poo.tp4.main;

import org.teiacoltec.poo.tp4.atividade.Atividade;
import org.teiacoltec.poo.tp4.excecoes.AssociacaoSubTurmaImpossivelException;
import org.teiacoltec.poo.tp4.excecoes.SubturmaJaAssociadaException;
import org.teiacoltec.poo.tp4.recursohumano.Pessoa;
import org.teiacoltec.poo.tp4.turma.Turma;
import org.teiacoltec.poo.tp4.util.Gerador;

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
        Turma t1 = Gerador.gerarTurma();
        Turma t2 = Gerador.gerarTurma();

        try {
            t2.associaSubTurma(t1);

        } catch (SubturmaJaAssociadaException | AssociacaoSubTurmaImpossivelException e) {
            System.out.println("Erro " + e);
            return;
        }
        try {
            t1.adicionarParticipante(Gerador.gerarProfessor(true));
            t1.adicionarParticipante(Gerador.gerarMonitor(true));
            t1.adicionarParticipante(Gerador.gerarMonitor(true));
            t1.adicionarParticipante(Gerador.gerarAluno(true));
            t1.adicionarParticipante(Gerador.gerarAluno(true));
            t1.adicionarParticipante(Gerador.gerarAluno(true));
            t1.adicionarParticipante(Gerador.gerarAluno(true));
            t1.adicionarParticipante(Gerador.gerarAluno(true));



            System.out.println("Nenhum Erro.");

        } catch (Exception e) {
            System.out.println("Erro " + e);
        } finally {
            t1.listarParticipantesEnxuto();
        }

    }
}