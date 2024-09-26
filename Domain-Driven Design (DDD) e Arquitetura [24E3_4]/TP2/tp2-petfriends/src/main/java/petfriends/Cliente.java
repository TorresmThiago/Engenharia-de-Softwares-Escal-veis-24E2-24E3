package petfriends;

import java.util.Objects;

public class Cliente {
    private final String id;
    private final String nome;
    private final String contato;

    public Cliente(String id, String nome, String contato) {
        this.id = Objects.requireNonNull(id, "ID é obrigatório");
        this.nome = Objects.requireNonNull(nome, "Nome é obrigatório");
        this.contato = Objects.requireNonNull(contato, "Contato é obrigatório");
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getContato() {
        return contato;
    }
}
