package edu.infnet.br.domain.base;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Command {

    private final UUID commandId;

    protected Command() {
        this.commandId = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "Command{" +
                "commandId=" + commandId +
                '}';
    }
}
