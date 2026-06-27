package com.financas.demo.event.controller;

import com.financas.demo.event.service.EventService;
import com.financas.demo.event.entity.EventEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("{idEvent}")
    public ResponseEntity<EventEntity> readEvent(@PathVariable Long idEvent){
        return ResponseEntity.ok(eventService.readEvent(idEvent));
    }
}
