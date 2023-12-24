package com.test.task.sputnik.currency.api.currency.exchange.dto.response;

import com.test.task.sputnik.currency.api.currency.exchange.enumeration.Currency;

import java.math.BigDecimal;
import java.util.Map;

public record ExchangeRatesResponse(
        boolean success,
        Currency source,
        Map<String, BigDecimal> quotes,
        long timestamp
) {
}
