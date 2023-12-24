package com.test.task.sputnik.currency.api.authentication.service;

import com.test.task.sputnik.currency.api.authentication.dto.request.TokenDto;

public interface AuthenticationService {
    TokenDto getAccessToken();
}
