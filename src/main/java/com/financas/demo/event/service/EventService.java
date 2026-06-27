package com.financas.demo.event.service;

import com.financas.demo.event.entity.EventEntity;
import com.financas.demo.event.repository.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public EventEntity readEvent(Long idEvent) {
        return eventRepository.findById(idEvent)
                .orElse(null);
    }

    public void createEvent(EventEntity eventEntity) {
        eventRepository.save(eventEntity);
    }
}
