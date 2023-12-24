package com.test.task.sputnik.currency.api.currency.exchange.dto.request;

import com.test.task.sputnik.currency.api.currency.exchange.enumeration.Currency;
import jakarta.annotation.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public record ExchangeRatesRequest(Currency sourceCurrency, Set<Currency> destinationCurrencies) implements Serializable {
}
