package com.test.task.sputnik.currencyexchangeapi.authentication.service.implementation;

import com.test.task.sputnik.currencyexchangeapi.authentication.dto.request.TokenDto;
import com.test.task.sputnik.currencyexchangeapi.authentication.entity.Token;
import com.test.task.sputnik.currencyexchangeapi.authentication.repository.TokenRepository;
import com.test.task.sputnik.currencyexchangeapi.authentication.service.AuthenticationService;
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
