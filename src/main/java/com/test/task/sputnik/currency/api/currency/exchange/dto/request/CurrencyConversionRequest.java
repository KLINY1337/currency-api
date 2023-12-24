package com.test.task.sputnik.currency.api.currency.exchange.dto.request;

import com.test.task.sputnik.currency.api.currency.exchange.enumeration.Currency;

import java.math.BigDecimal;

public record CurrencyConversionRequest(Currency sourceCurrency, BigDecimal sourceCurrencyAmount,
                                        Currency destinationCurrency) {
}
