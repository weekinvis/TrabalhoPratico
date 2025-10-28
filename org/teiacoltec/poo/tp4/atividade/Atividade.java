package org.teiacoltec.poo.tp4.atividade;

import org.teiacoltec.poo.tp4.gerenciadores.GerenciadorIDMatricula;

import java.time.LocalDate;

public class Atividade {
    private final int id;
    private String nome;
    private String descricao;
    private LocalDate inicio, fim;
    private float valor;

    Atividade(String nome, String descricao, float valor, LocalDate inicio, LocalDate fim) {
        this.nome = nome;
        this.descricao = descricao;
        this.inicio = inicio;
        this.fim = fim;
        this.valor = valor;
        this.id = GerenciadorIDMatricula.obterIDAtividade();
    }

    public String obterInformacoes() {
        return String.format("\n%-28s | %-30s\n" +
                        "%-28s | %06d\n" +
                        "%-28s | %-30s\n" +
                        "%-28s | %-30s\n" +
                        "%-28s | %-30s\n" +
                        "%-28s | %-30s\n",
                        "Nome", this.nome,
                "ID", this.id,
                "Valor", this.valor,
                "Descrição", this.descricao,
                "Início", this.inicio.toString(),
                "Fim", this.fim.toString()
        );
    }

}
