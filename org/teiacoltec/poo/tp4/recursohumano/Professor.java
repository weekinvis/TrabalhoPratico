package org.teiacoltec.poo.tp4.recursohumano;

import org.teiacoltec.poo.tp4.interfaces.IdentificavelMatricula;

import java.time.LocalDate;

public class Professor extends Pessoa implements IdentificavelMatricula {
    private static final String PREFIXO_PROFESSOR = "PRF-";
    private String formacao;
    private final String matricula;

    public Professor(String nome, String cpf, String email, String endereco, LocalDate nascimento, String matricula, String formacao) {
        super(nome, cpf, email, endereco, nascimento);
        this.formacao = formacao;
        this.matricula = PREFIXO_PROFESSOR + matricula;
    }

    @Override
    public String obterInformacoes() {
        return super.obterInformacoes() + String.format(
                        "%-28s | %-30s\n" +
                        "%-28s | %-30s\n",
                        "Matricula", this.matricula,
                        "Formação", this.formacao
        );
    }

    @Override
    public String getMatricula() {
        return this.matricula;
    }

    public static String obterPrefixo() {
        return Professor.PREFIXO_PROFESSOR;
    }

}
