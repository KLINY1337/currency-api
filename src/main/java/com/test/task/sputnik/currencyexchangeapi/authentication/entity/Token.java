package com.test.task.sputnik.currencyexchangeapi.authentication.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "token")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private LocalDateTime creationDate = LocalDateTime.now();
    private LocalDateTime lastUsageDate = LocalDateTime.now();
}