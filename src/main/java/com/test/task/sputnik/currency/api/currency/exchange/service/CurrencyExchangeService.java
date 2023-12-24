package com.test.task.sputnik.currency.api.currency.exchange.service;

import com.test.task.sputnik.currency.api.currency.exchange.dto.request.CurrencyConversionRequest;
import com.test.task.sputnik.currency.api.currency.exchange.dto.request.ExchangeRatesRequest;
import com.test.task.sputnik.currency.api.currency.exchange.dto.response.CurrencyConversionResponse;
import com.test.task.sputnik.currency.api.currency.exchange.dto.response.ExchangeRatesResponse;

public interface CurrencyExchangeService {

    ExchangeRatesResponse getExchangeRatesBySourceCurrency(ExchangeRatesRequest request);
    CurrencyConversionResponse convertCurrencyFromSourceToDestination(CurrencyConversionRequest request);
}
