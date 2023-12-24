package com.test.task.sputnik.currency.api.currency.exchange.service.implementation;

import com.test.task.sputnik.currency.api.currency.exchange.dto.request.CurrencyConversionRequest;
import com.test.task.sputnik.currency.api.currency.exchange.dto.request.ExchangeRatesRequest;
import com.test.task.sputnik.currency.api.currency.exchange.dto.response.CurrencyConversionResponse;
import com.test.task.sputnik.currency.api.currency.exchange.dto.response.ExchangeRatesResponse;
import com.test.task.sputnik.currency.api.currency.exchange.enumeration.Currency;
import com.test.task.sputnik.currency.api.currency.exchange.service.CurrencyExchangeService;
import com.test.task.sputnik.currency.api.currency.exchange.util.RequestUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
    @Override
    public ExchangeRatesResponse getExchangeRatesBySourceCurrency(ExchangeRatesRequest request) {
        Map<String, String> uriVariables = new HashMap<>();


        uriVariables.put("access_key", System.getProperty("access_key"));
        uriVariables.put("format",  "1");
        uriVariables.put("source", request.sourceCurrency().getTicker());

        if (request.destinationCurrencies() != null) {
            String destinationCurrencies = request.destinationCurrencies()
                    .stream()
                    .map(Currency::getTicker)
                    .collect(Collectors.joining(","));
            uriVariables.put("currencies", destinationCurrencies);
        }


        return RequestUtils.sendRequest(
                "http://apilayer.net/api/live",
                HttpMethod.GET,
                uriVariables,
                ExchangeRatesResponse.class,
                null
        );
    }

    @Override
    public CurrencyConversionResponse convertCurrencyFromSourceToDestination(CurrencyConversionRequest request) {
        Map<String, String> uriVariables = new HashMap<>();

        uriVariables.put("access_key", System.getProperty("access_key"));
        uriVariables.put("from", request.sourceCurrency().getTicker());
        uriVariables.put("to", request.destinationCurrency().getTicker());
        uriVariables.put("amount", request.sourceCurrencyAmount().toString());
        uriVariables.put("format", "1");

        Map<String, Object> apiLayerResponse = RequestUtils.sendRequest(
                "http://apilayer.net/api/convert",
                HttpMethod.GET,
                uriVariables,
                HashMap.class,
                null
        );
        return new CurrencyConversionResponse(
                request.sourceCurrency(),
                request.sourceCurrencyAmount(),
                request.destinationCurrency(),
                BigDecimal.valueOf((Double) apiLayerResponse.get("result")));
    }
}
