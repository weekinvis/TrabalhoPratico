package org.teiacoltec.poo.tp4.turma;

import org.teiacoltec.poo.tp4.main.Main;
import org.teiacoltec.poo.tp4.atividade.Atividade;
import org.teiacoltec.poo.tp4.excecoes.AssociacaoSubTurmaImpossivelException;
import org.teiacoltec.poo.tp4.excecoes.PessoaJaParticipaException;
import org.teiacoltec.poo.tp4.excecoes.PessoaNaoEncontradaException;
import org.teiacoltec.poo.tp4.excecoes.SubturmaJaAssociadaException;
import org.teiacoltec.poo.tp4.recursohumano.Pessoa;

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
    private final Map<String, Pessoa> participantesMatricula = new HashMap<>();
    private final Map<Integer, Atividade> atividadesTurma = new HashMap<>();
    private Turma turmaPai = null;
    private final List<Turma> turmasFilhas = new ArrayList<>();

    /* Construtores */

     Turma(String nome, int id, LocalDate inicio, LocalDate fim) {
        this.nome = nome;
        this.descricao = "NENHUMA.";
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
    }

     Turma(String nome, String descricao, int id, LocalDate inicio, LocalDate fim) {
        this.nome = nome;
        this.descricao = descricao;
        this.id = id;
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

        return participantesMatricula.containsKey(p.getMatricula());

    }

    public void adicionarParticipante(Pessoa p) throws PessoaJaParticipaException {

        if(this.turmaPai != null) {
            try {
                this.turmaPai.adicionarParticipante(p);
            } catch(Exception e) {
                // faço nada
            }
        }

        if(participa(p)) throw new PessoaJaParticipaException("Essa pessoa já participa.");

        participantesMatricula.put(p.getMatricula(), p);

        System.out.println("Matricula '" + p.getMatricula() + "' inserida na turma de ID: " + this.id + " +");

    }

    public void removerParticipante(Pessoa p) throws PessoaNaoEncontradaException {

        turmasFilhas.stream()
                .forEach(t -> {
                    try {
                        t.removerParticipante(p);
                    } catch (PessoaNaoEncontradaException e) {
                        // Faço nada
                    }
                });

        if(!participa(p)) throw new PessoaNaoEncontradaException("Essa pessoa não existe na turma.");

        String matricula = p.getMatricula();

        participantesMatricula.remove(matricula);
        System.out.println("Matricula '" + matricula + "' removida da turma de ID: " + this.id + " -");
    }

    public List<Pessoa> obtemListaFiltrada(String prefixo) {
        return participantesMatricula.values().stream()
                .filter(p -> p.getMatricula().startsWith(prefixo))
                .toList();
    }

    public void listarParticipantesTurma() {
        System.out.print("\nTurma " + this.nome);
        participantesMatricula.values()
                .forEach(Main::imprimirInformacoes);
    }

    public void listarParticipantesEnxuto() {
        System.out.print("\nTurma " + this.nome);
        participantesMatricula.values()
                .forEach(p -> {
                    System.out.printf("\n%-28s | %-30s", p.getNome(), p.getMatricula());
                });

        System.out.println("\n");
    }

    public void associaSubTurma(Turma t) throws SubturmaJaAssociadaException, AssociacaoSubTurmaImpossivelException {
        if(t.turmaPai != null) throw new SubturmaJaAssociadaException("Subturma ja associada! Desassocie essa subturma primeiro e tente novamente.");
        if(t.equals(this)) throw new AssociacaoSubTurmaImpossivelException("Associando-se a si mesmo");

        Turma verificador = this.turmaPai;
        while(verificador != null) {
            if(verificador.equals(t)) throw new AssociacaoSubTurmaImpossivelException("Ciclo");
            verificador = verificador.turmaPai;
        }

        this.turmasFilhas.add(t);
        t.turmaPai = this;
    }

    // Sobrecarregar o equals para um proximo objeto do tipo turma
    public boolean equals(Turma obj) {
        return ((this == obj) || (obj.getId() == this.getId()));
    }

    // Access modifiers (modificadores de acesso)

    public int getId() {
        return this.id;
    }

}
