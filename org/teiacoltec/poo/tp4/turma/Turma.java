package org.teiacoltec.poo.tp4.turma;

import org.teiacoltec.poo.tp4.Main;
import org.teiacoltec.poo.tp4.atividade.Atividade;
import org.teiacoltec.poo.tp4.excecoes.PessoaJaParticipaException;
import org.teiacoltec.poo.tp4.excecoes.PessoaNaoEncontradaException;
import org.teiacoltec.poo.tp4.interfaces.IdentificavelMatricula;
import org.teiacoltec.poo.tp4.recursohumano.Pessoa;
import org.teiacoltec.poo.tp4.util.GerenciadorIDMatricula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Turma {

    private final int id;
    private String nome;
    private String descricao;
    private final LocalDate inicio, fim;
    private Map<String, IdentificavelMatricula> participantesMatricula = new HashMap<>();
    private Map<Integer, Atividade> atividadesTurma = new HashMap<>();
    private Turma turmaPai = null;
    private List<Turma> turmasFilhas = new ArrayList<>();

    /* Construtores */

    public Turma(String nome, LocalDate inicio, LocalDate fim) {
        this.nome = nome;
        this.descricao = "NENHUMA.";
        this.id = GerenciadorIDMatricula.obterIDTurma();
        this.inicio = inicio;
        this.fim = fim;
    }

    public Turma(String nome, String descricao, LocalDate inicio, LocalDate fim) {
        this.nome = nome;
        this.descricao = descricao;
        this.id = GerenciadorIDMatricula.obterIDTurma();
        this.inicio = inicio;
        this.fim = fim;
    }

    /* Metodos */

    public String obterInformacoes() {
        return String.format("\nDADOS RESGATADOS TURMA:\n%-28s | %-30s\n" +
                "%-28s | %06d\n" +
                "%-28s | %-30s\n" +
                "%-28s | %-30s\n" +
                "%-28s | %-30s",
                "Nome", this.nome,
                "ID", this.id,
                "Descrição", this.descricao,
                "Início", this.inicio.toString(),
                "Fim", this.fim.toString()
        );
    }

    public boolean participa(Pessoa p) {
        if(p instanceof IdentificavelMatricula identificavel) {
            return participantesMatricula.containsKey(identificavel.getMatricula());
        }
        return false;
    }

    public void adicionarParticipante(Pessoa p) throws PessoaJaParticipaException {

        if(participa(p)) throw new PessoaJaParticipaException("Essa pessoa já participa.");

        if(p instanceof IdentificavelMatricula identificavel) {
            String matricula = identificavel.getMatricula();
            participantesMatricula.put(matricula, identificavel);

            System.out.println("Matricula '" + identificavel.getMatricula() + "' inserida na turma.");
        }

    }

    public void removerParticipante(Pessoa p) throws PessoaNaoEncontradaException {
        if(!participa(p)) throw new PessoaNaoEncontradaException("Essa pessoa não existe na turma.");

        if(p instanceof IdentificavelMatricula identificavel) {
            String matricula = identificavel.getMatricula();
            participantesMatricula.remove(matricula);
            System.out.println("Matricula '" + matricula + "' removida desta turma.");
        }
    }

    public List<Pessoa> obtemListaFiltrada(String prefixo) {
        return participantesMatricula.values().stream()
                .filter(p -> p.getMatricula().startsWith(prefixo))
                .map(Pessoa.class::cast)
                .toList();
    }

    public void listarParticipantesTurma() {
        System.out.print("\nTurma " + this.nome);
        participantesMatricula.values().stream()
                .map(Pessoa.class::cast)
                .forEach(Main::imprimirInformacoes);
    }

    public void listarParticipantesEnxuto() {
        System.out.print("\nTurma " + this.nome);
        participantesMatricula.values().stream()
                .map(Pessoa.class::cast)
                .forEach(p -> {
                    String matricula = ((IdentificavelMatricula) p).getMatricula();
                    System.out.printf("\n%-28s | %-30s", p.getNome(), matricula);
                });

        System.out.println("\n");
    }

    public boolean equals(Turma obj) {
        return ((this == obj) || (obj.getId() == this.getId()));
    }

    // Access modifiers (modificadores de acesso)

    public int getId() {
        return this.id;
    }

}
