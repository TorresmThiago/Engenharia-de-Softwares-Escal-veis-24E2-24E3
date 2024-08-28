package petfriends;

import java.util.Objects;

public class Veterinario {
    private final String CRMV;
    private final String nome;
    private final String especialidade;

    public Veterinario(String CRMV, String nome, String especialidade) {
        this.CRMV = Objects.requireNonNull(CRMV, "CRMV é obrigatório");
        this.nome = Objects.requireNonNull(nome, "Nome é obrigatório");
        this.especialidade = Objects.requireNonNull(especialidade, "Especialidade é obrigatória");
    }

    public String getCRMV() {
        return CRMV;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}
