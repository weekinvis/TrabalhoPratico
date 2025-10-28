package org.teiacoltec.poo.tp4.recursohumano;

import org.teiacoltec.poo.tp4.gerenciadores.GerenciadorIDMatricula;
import org.teiacoltec.poo.tp4.interfaces.IdentificavelMatricula;
import org.teiacoltec.poo.tp4.turma.GerenciadorTurmas;
import org.teiacoltec.poo.tp4.turma.Turma;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GerenciadorPessoas {
    private static Map<Pessoa, List<Turma>> mapaPessoasTurma = new HashMap<>();
    private static Map<String, Pessoa> mapaMatriculaPessoas = new HashMap<>();

    private GerenciadorPessoas() {}

    static public Aluno solicitarCriacaoAluno(String nome, String cpf, String email, String endereco, LocalDate nascimento, String curso) {
        Aluno alunoGerado = new Aluno(nome, cpf, email, endereco, nascimento, GerenciadorIDMatricula.obterMatricula(), curso);
        mapaMatriculaPessoas.put(alunoGerado.getMatricula(), alunoGerado);
        return alunoGerado;
    }

    static public Professor solicitarCriacaoProfessor(String nome, String cpf, String email, String endereco, LocalDate nascimento, String formacao) {
        Professor professorGerado = new Professor(nome, cpf, email, endereco, nascimento, GerenciadorIDMatricula.obterMatricula(), formacao);
        mapaMatriculaPessoas.put(professorGerado.getMatricula(), professorGerado);
        return professorGerado;
    }

    static public Monitor solicitarCriacaoMonitor(String nome, String cpf, String email, String endereco, LocalDate nascimento, String curso) {
        Monitor monitorGerado = new Monitor(nome, cpf, email, endereco, nascimento, GerenciadorIDMatricula.obterMatricula(), curso);
        mapaMatriculaPessoas.put(monitorGerado.getMatricula(), monitorGerado);
        return monitorGerado;
    }

}
