package com.test.task.sputnik.currency.api.currency.exchange.util;

import com.test.task.sputnik.currency.api.currency.exchange.dto.response.ExchangeRatesResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.stream.Collectors;

@UtilityClass
public class RequestUtils {

    public <T, U> T sendRequest(String url,
                             HttpMethod httpMethod,
                             Map<String, String> uriVariablesMap,
                             Class<T> responseType,
                             U requestBody) {

        String uriVariables = uriVariablesMap.entrySet()
                .stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining("&"));
        String requestUrl = url + "?" + uriVariables;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<U> requestEntity = new HttpEntity<>(requestBody, headers);
        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.exchange(
                requestUrl,
                httpMethod,
                requestEntity,
                responseType
        ).getBody();

    }
}
