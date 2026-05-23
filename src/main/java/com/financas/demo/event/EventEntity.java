package com.financas.demo.event;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(schema = "financas", name = "payment_event")
public class EventEntity {
    @Id
    @GeneratedValue
    private Long idEvent;

    @Column(nullable = false)
    private Long idUser;

    @Column(nullable = false)
    private Long idOccurrence;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
