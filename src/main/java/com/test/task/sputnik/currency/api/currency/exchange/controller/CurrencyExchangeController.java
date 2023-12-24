package com.test.task.sputnik.currency.api.currency.exchange.controller;

import com.test.task.sputnik.currency.api.currency.exchange.dto.request.CurrencyConversionRequest;
import com.test.task.sputnik.currency.api.currency.exchange.dto.request.ExchangeRatesRequest;
import com.test.task.sputnik.currency.api.currency.exchange.dto.response.CurrencyConversionResponse;
import com.test.task.sputnik.currency.api.currency.exchange.dto.response.ExchangeRatesResponse;
import com.test.task.sputnik.currency.api.currency.exchange.service.CurrencyExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/currency")
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @GetMapping("/exchange/rate")
    public ResponseEntity<ExchangeRatesResponse> getExchangeRatesBySourceCurrency(@RequestBody ExchangeRatesRequest request) {
        return ResponseEntity.ok(currencyExchangeService.getExchangeRatesBySourceCurrency(request));
    }

    @GetMapping("/convert")
    public ResponseEntity<CurrencyConversionResponse> convertCurrencies(@RequestBody CurrencyConversionRequest request) {
        return ResponseEntity.ok(currencyExchangeService.convertCurrencyFromSourceToDestination(request));
    }
}
