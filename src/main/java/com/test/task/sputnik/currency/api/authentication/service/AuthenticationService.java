package com.test.task.sputnik.currency.api.authentication.service;

import com.test.task.sputnik.currency.api.authentication.dto.response.TokenResponse;

public interface AuthenticationService {
    TokenResponse getAccessToken();
}
