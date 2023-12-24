package com.test.task.sputnik.currency;

import com.test.task.sputnik.currency.api.currency.exchange.controller.CurrencyExchangeController;
import com.test.task.sputnik.currency.api.currency.exchange.dto.request.CurrencyConversionRequest;
import com.test.task.sputnik.currency.api.currency.exchange.dto.request.ExchangeRatesRequest;
import com.test.task.sputnik.currency.api.currency.exchange.dto.response.CurrencyConversionResponse;
import com.test.task.sputnik.currency.api.currency.exchange.dto.response.ExchangeRatesResponse;
import com.test.task.sputnik.currency.api.currency.exchange.enumeration.Currency;
import com.test.task.sputnik.currency.api.currency.exchange.service.implementation.CurrencyExchangeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CurrencyExchangeControllerTest {

    private final CurrencyExchangeController currencyExchangeController = new CurrencyExchangeController(new CurrencyExchangeServiceImpl());

    @BeforeEach
    void beforeEach() throws InterruptedException {
        System.setProperty("access_key", "eb6c181f13ae3effdeaee8d670f9516b");
        Thread.sleep(1000);
    }

    @Test
    void getExchangeRatesOfRubAndGbpBySourceCurrencyUsd() {
        ExchangeRatesRequest request = new ExchangeRatesRequest(Currency.USD, new HashSet<>(Set.of(Currency.RUB, Currency.GBP)));
        ExchangeRatesResponse response = currencyExchangeController.getExchangeRatesBySourceCurrency(request).getBody();

        Objects.requireNonNull(response);
        assertTrue(response.success());
    }

    @Test
    void getExchangeRatesOfAnyCurrenciesBySourceCurrencyUsd() {
        ExchangeRatesRequest request = new ExchangeRatesRequest(Currency.USD, null);
        ExchangeRatesResponse response = currencyExchangeController.getExchangeRatesBySourceCurrency(request).getBody();

        Objects.requireNonNull(response);
        assertTrue(response.success());
    }

    @Test
    void convertCurrencyFromUsdToRub() {
        CurrencyConversionRequest request = new CurrencyConversionRequest(Currency.USD, BigDecimal.ONE, Currency.RUB);
        CurrencyConversionResponse response = currencyExchangeController.convertCurrencies(request).getBody();

        Objects.requireNonNull(response);
        assertTrue(response.success());
    }

    @Test
    void convertCurrencyFromUsdToRubWithNegativeAmount() {
        CurrencyConversionRequest request = new CurrencyConversionRequest(Currency.USD, BigDecimal.ONE.subtract(BigDecimal.valueOf(100L)), Currency.RUB);
        CurrencyConversionResponse response = currencyExchangeController.convertCurrencies(request).getBody();

        Objects.requireNonNull(response);
        assertFalse(response.success());
    }
}
