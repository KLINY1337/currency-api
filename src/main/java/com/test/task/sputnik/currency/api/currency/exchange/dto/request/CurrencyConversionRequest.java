package com.test.task.sputnik.currency.api.currency.exchange.dto.request;

import com.test.task.sputnik.currency.api.currency.exchange.enumeration.Currency;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Validated
public record CurrencyConversionRequest(
        @NotNull(message = "Source currency is not specified")
        Currency sourceCurrency,

        @NotNull(message = "Source currency amount is not specified")
        @Positive(message = "Source currency amount must be greater than 0")
        BigDecimal sourceCurrencyAmount,

        @NotNull(message = "Destination currency is not specified")
        Currency destinationCurrency) {
}
