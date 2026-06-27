package com.financas.demo.user.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(schema = "financas", name = "user_account")
public class UserEntity {
    @Id
    @GeneratedValue
    private Long idUser;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
