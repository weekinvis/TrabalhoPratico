package org.teiacoltec.poo.tp4.recursohumano;

import org.teiacoltec.poo.tp4.interfaces.IdentificavelMatricula;

import java.time.LocalDate;

public class Monitor extends Pessoa implements IdentificavelMatricula {
    private static final String PREFIXO_MONITOR = "MNT-";
    private final String matricula;
    private String curso;

    public Monitor(String nome, String cpf, String email, String endereco, LocalDate nascimento, String matricula, String curso) {
        super(nome, cpf, email, endereco, nascimento);
        this.matricula = PREFIXO_MONITOR + matricula;
        this.curso = curso;
    }

    @Override
    public String getMatricula() {
        return this.matricula;
    }

    public String obterInformacoes() {
        return super.obterInformacoes() + String.format(
                "%-28s | %-30s\n" +
                        "%-28s | %-30s\n",
                "Matricula", this.matricula,
                "Curso", this.curso
        );
    }

    public static String obterPrefixo() {
        return Monitor.PREFIXO_MONITOR;
    }

}
