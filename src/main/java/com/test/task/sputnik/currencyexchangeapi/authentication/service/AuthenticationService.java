package com.test.task.sputnik.currencyexchangeapi.authentication.service;

import com.test.task.sputnik.currencyexchangeapi.authentication.dto.request.TokenDto;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    TokenDto getAccessToken();
}
