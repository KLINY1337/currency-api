package com.test.task.sputnik.currency.api.authentication.service.implementation;

import com.test.task.sputnik.currency.api.authentication.dto.request.TokenDto;
import com.test.task.sputnik.currency.api.authentication.entity.Token;
import com.test.task.sputnik.currency.api.authentication.repository.TokenRepository;
import com.test.task.sputnik.currency.api.authentication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final TokenRepository tokenRepository;

    @Override
    public TokenDto getAccessToken() {
        Token token = tokenRepository.save(new Token());
        return new TokenDto(token.getId());
    }
}
