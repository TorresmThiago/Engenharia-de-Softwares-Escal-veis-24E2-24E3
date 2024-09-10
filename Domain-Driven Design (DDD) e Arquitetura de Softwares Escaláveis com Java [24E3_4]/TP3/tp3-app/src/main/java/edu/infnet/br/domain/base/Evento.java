package edu.infnet.br.domain.base;

import lombok.Getter;

import java.time.Instant;
import java.util.UUID;

@Getter
public abstract class Evento {
    private final UUID eventoId;
    private final Instant timestamp;

    protected Evento( ) {
        this.eventoId = UUID.randomUUID();
        this.timestamp = Instant.now();
    }
    @Override
    public String toString() {
        return "Evento { eventoId=" + eventoId +  ",timestamp=" + timestamp + '}';
    }
}
