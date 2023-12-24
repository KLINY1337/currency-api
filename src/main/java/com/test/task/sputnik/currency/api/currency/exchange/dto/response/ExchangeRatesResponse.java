package com.test.task.sputnik.currency.api.currency.exchange.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public record ExchangeRatesResponse(String source,
                                    Map<String, BigDecimal> quotes,
                                    boolean success,
                                    String terms,
                                    String privacy,
                                    long timestamp
) implements Serializable {
}
