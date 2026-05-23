package com.financas.demo.occurrence;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(schema = "financas", name = "occurrence")
public class OccurrenceEntity {
    @Id
    @GeneratedValue
    private Long idOccurrence;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean recurrence;

    @Column(nullable = false)
    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
