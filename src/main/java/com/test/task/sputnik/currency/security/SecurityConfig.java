package com.test.task.sputnik.currency.security;

import com.test.task.sputnik.currency.api.authentication.entity.Token;
import com.test.task.sputnik.currency.api.authentication.repository.TokenRepository;
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
                        Optional<Token> TokenOptional = tokenRepository.findById(uuid);
                        if (TokenOptional.isPresent()) {
                            Token token = TokenOptional.get();
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
