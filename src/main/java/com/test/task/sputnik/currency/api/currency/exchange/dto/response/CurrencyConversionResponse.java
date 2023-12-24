package com.test.task.sputnik.currency.api.currency.exchange.dto.response;

import com.test.task.sputnik.currency.api.currency.exchange.enumeration.Currency;

import java.math.BigDecimal;

public record CurrencyConversionResponse(Currency sourceCurrency, BigDecimal sourceCurrencyAmount,
                                         Currency destinationCurrency, BigDecimal destinationCurrencyAmount) {
}
