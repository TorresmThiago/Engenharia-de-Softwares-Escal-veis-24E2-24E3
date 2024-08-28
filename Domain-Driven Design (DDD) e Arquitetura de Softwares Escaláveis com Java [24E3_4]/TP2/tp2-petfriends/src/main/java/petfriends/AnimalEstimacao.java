package petfriends;

import java.util.Objects;

public class AnimalEstimacao {
    private final String id;
    private final String nome;
    private final String tipo;
    private final int idade;

    public AnimalEstimacao(String id, String nome, String tipo, int idade) {
        this.id = Objects.requireNonNull(id, "ID é obrigatório");
        this.nome = Objects.requireNonNull(nome, "Nome é obrigatório");
        this.tipo = Objects.requireNonNull(tipo, "Tipo é obrigatório");
        this.idade = idade;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getIdade() {
        return idade;
    }
}
