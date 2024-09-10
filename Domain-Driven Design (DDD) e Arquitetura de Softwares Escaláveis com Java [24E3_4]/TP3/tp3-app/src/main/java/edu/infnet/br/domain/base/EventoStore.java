package edu.infnet.br.domain.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EventoStore {

    private final List<Evento> eventoList = new ArrayList<>();

    public void save(Evento evento) {
        eventoList.add(evento);
        System.out.println("Evento salvo: " + evento);
    }

    public List<Evento> getAllEventos() {
        return new ArrayList<>(eventoList);
    }

    public Optional<Evento> getEventoById(UUID eventoId) {
        return eventoList.stream()
                .filter(event -> event.getEventoId().equals(eventoId))
                .findFirst();
    }

}
