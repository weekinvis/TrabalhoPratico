package org.teiacoltec.poo.tp4.recursohumano;

import java.time.LocalDate;

public abstract class Pessoa {
    /* Atributos */
    private final String nome, cpf;
    private String endereco, email;
    private final LocalDate nascimento;

    /* Construtores */
    public Pessoa(String nome, String cpf, String email, String endereco, LocalDate nascimento) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.nascimento = nascimento;
        this.cpf = cpf;
    }

    /* Metodos */
    public String obterInformacoes() {
        return String.format(
                "\nDADOS RESGATADOS PESSOA:\n" +
                        "%-28s | %-30s\n" +
                        "%-28s | %-30s\n" +
                        "%-28s | %-30s\n" +
                        "%-28s | %-30s\n" +
                        "%-28s | %-30s\n",
                        "Nome", this.nome,
                        "CPF", this.cpf,
                        "Email", this.email,
                        "Endereco", this.endereco,
                        "Nascimento", this.nascimento.toString()
        );

    }

    public String getNome() {
        return this.nome;
    }

}
