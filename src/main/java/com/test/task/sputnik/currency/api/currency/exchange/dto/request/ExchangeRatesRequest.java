package com.test.task.sputnik.currency.api.currency.exchange.dto.request;

import com.test.task.sputnik.currency.api.currency.exchange.enumeration.Currency;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Set;

@Validated
public record ExchangeRatesRequest(

        @NotNull(message = "Source currency is not specified")
        Currency sourceCurrency,

        @Nullable
        Set<Currency> destinationCurrencies) {
}
