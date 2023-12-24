package com.test.task.sputnik.currency;

import com.test.task.sputnik.currency.api.authentication.controller.AuthenticationController;
import com.test.task.sputnik.currency.api.authentication.repository.TokenRepository;
import com.test.task.sputnik.currency.api.authentication.service.implementation.AuthenticationServiceImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Objects;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthenticationControllerTests {

    @LocalServerPort
    private Integer port;

    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15-alpine");

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Autowired
    TokenRepository tokenRepository;

    @BeforeEach
    void setUp() {
        tokenRepository.deleteAll();
    }


    @Test
    void createNewToken() {
        AuthenticationController authenticationController = new AuthenticationController(new AuthenticationServiceImpl(tokenRepository));

        assertEquals(tokenRepository.findAll().size(), 0);
        UUID expected = Objects.requireNonNull(authenticationController.getAccessToken().getBody()).uuid();
        assertEquals(tokenRepository.findAll().size(), 1);
        UUID actual = tokenRepository.findById(expected).get().getId();
        assertEquals(expected, actual);
    }
}
