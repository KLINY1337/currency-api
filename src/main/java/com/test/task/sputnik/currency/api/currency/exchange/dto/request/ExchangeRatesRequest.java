package com.test.task.sputnik.currency.api.currency.exchange.dto.request;

import com.test.task.sputnik.currency.api.currency.exchange.enumeration.Currency;
import com.test.task.sputnik.currency.api.currency.exchange.enumeration.validator.EnumValidator;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Validated
public record ExchangeRatesRequest(

        @NotNull(message = "Source currency is not specified")
        @EnumValidator(targetClassType = Currency.class, message = "Unacceptable source currency specified")
        Currency sourceCurrency,

        @Nullable
        @EnumValidator(targetClassType = Currency.class, message = "Unacceptable destination currency specified")
        Set<Currency> destinationCurrencies) implements Serializable {
}
