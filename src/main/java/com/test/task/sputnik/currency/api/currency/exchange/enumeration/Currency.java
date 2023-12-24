package com.test.task.sputnik.currency.api.currency.exchange.enumeration;

import lombok.Getter;

@Getter
public enum Currency {
    RUB("RUB"),
    USD("USD"),
    EUR("EUR"),
    CNY("CNY"),
    GBP("GBP");

    private final String ticker;

    Currency(String ticker) {
        this.ticker = ticker;
    }
}
