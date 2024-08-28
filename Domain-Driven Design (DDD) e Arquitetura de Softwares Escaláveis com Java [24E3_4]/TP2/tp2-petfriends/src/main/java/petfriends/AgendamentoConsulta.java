package petfriends;

import java.time.LocalDateTime;
import java.util.Objects;

public class AgendamentoConsulta {
    private final String id;
    private final Cliente cliente;
    private final AnimalEstimacao animalEstimacao;
    private final Veterinario veterinario;
    private final LocalDateTime dataHora;
    private StatusAgendamentoEnum status;

    public AgendamentoConsulta(String id, Cliente cliente, AnimalEstimacao animalDeEstimacao, Veterinario veterinario, LocalDateTime dataHora) {
        this.id = Objects.requireNonNull(id, "ID é obrigatório");
        this.cliente = Objects.requireNonNull(cliente, "Cliente é obrigatório");
        this.animalEstimacao = Objects.requireNonNull(animalDeEstimacao, "Animal de Estimação é obrigatório");
        this.veterinario = Objects.requireNonNull(veterinario, "Veterinário é obrigatório");
        this.dataHora = Objects.requireNonNull(dataHora, "Data e Hora são obrigatórios");
        this.status = StatusAgendamentoEnum.AGENDADO;
    }

    public void cancelar() {
        if (status != StatusAgendamentoEnum.AGENDADO) {
            throw new IllegalStateException("Agendamento não pode ser cancelado");
        }
        this.status = StatusAgendamentoEnum.CANCELADO;
    }

    public void concluir() {
        if (status != StatusAgendamentoEnum.AGENDADO) {
            throw new IllegalStateException("Agendamento não pode ser concluído");
        }
        this.status = StatusAgendamentoEnum.CONCLUIDO;
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public AnimalEstimacao getAnimalEstimacao() {
        return animalEstimacao;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public StatusAgendamentoEnum getStatus() {
        return status;
    }
}
