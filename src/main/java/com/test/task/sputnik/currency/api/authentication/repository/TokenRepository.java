package com.test.task.sputnik.currency.api.authentication.repository;

import com.test.task.sputnik.currency.api.authentication.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<Token, UUID> {
}