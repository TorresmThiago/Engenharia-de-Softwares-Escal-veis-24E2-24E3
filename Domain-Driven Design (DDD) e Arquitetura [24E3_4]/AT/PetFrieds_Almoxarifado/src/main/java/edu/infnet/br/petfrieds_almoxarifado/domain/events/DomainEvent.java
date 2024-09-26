package edu.infnet.br.petfrieds_almoxarifado.domain.events;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DomainEvent {

    private String eventId;
    private LocalDateTime dataCriacao;

}
