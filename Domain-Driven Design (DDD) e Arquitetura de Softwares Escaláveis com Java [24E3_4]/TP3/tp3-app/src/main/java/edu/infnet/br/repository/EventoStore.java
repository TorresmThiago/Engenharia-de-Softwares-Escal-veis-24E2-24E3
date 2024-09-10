package edu.infnet.br.repository;

import edu.infnet.br.domain.base.Evento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Slf4j
public class EventoStore {

    private final List<Evento> eventoList = new ArrayList<>();

    public void save(Evento evento) {
        eventoList.add(evento);
        log.info("Evento salvo: " + evento);
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
