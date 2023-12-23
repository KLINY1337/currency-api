package com.test.task.sputnik.currencyexchangeapi.security;

import com.test.task.sputnik.currencyexchangeapi.authentication.entity.Token;
import com.test.task.sputnik.currencyexchangeapi.authentication.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final TokenRepository tokenRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests(requestMatcherRegistry -> { requestMatcherRegistry
                .requestMatchers("/api/v1/auth/**").permitAll()
                .requestMatchers(request -> {
                    String authorizationHeader = request.getHeader("Authorization");
                    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                        UUID uuid = UUID.fromString(authorizationHeader.substring("Bearer ".length()));
                        Optional<Token> OptionalToken = tokenRepository.findById(uuid);
                        if (OptionalToken.isPresent()) {
                            Token token = OptionalToken.get();
                            token.setLastUsageDate(LocalDateTime.now());
                            tokenRepository.save(token);
                            return true;
                        }
                        return false;
                    }
                    return false;
                }).permitAll()
                .anyRequest().denyAll();
        });
        return security.build();
    }
}
