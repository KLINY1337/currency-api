package com.test.task.sputnik.currency.api.authentication.controller;

import com.test.task.sputnik.currency.api.authentication.dto.request.TokenDto;
import com.test.task.sputnik.currency.api.authentication.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @GetMapping("/token")
    public ResponseEntity<TokenDto> getAccessToken() {
        return ResponseEntity.ok(authenticationService.getAccessToken());
    }
}
