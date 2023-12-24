# Docs

## /api/v1/auth/token GET
Получение токена авторизации (во всех последующих запросах ставится в заголовок Authorization запроса в виде "Bearer <полученный токен>")

## /api/v1/currency/exchange/rate GET
Получение курсов валют относительно заданной (Поддерживаемые тикеры: RUB, USD, EUR, CNY, GBP). Если не будет указан ни один из тикеров в качестве валюты назначения, будет выдан полный список валют, поддерживаемых CurrencyLayerAPI

Пример тела запроса:
```json
{
    "sourceCurrency": "EUR",
    "destinationCurrencies": ["RUB", "USD", "GBP"]
}
```

Пример ответа:
```json
{
    "success": true,
    "source": "EUR",
    "quotes": {
        "EURGBP": 0.869768,
        "EURRUB": 101.56551,
        "EURUSD": 1.102475
    },
    "timestamp": 1703431444
}
```

## /api/v1/currency/convert GET
Конвертация одной валюты в другую (Поддерживаемые тикеры: RUB, USD, EUR, CNY, GBP)

Пример тела запроса:
```json
{
    "sourceCurrency": "RUB",
    "sourceCurrencyAmount": 100,
    "destinationCurrency": "USD"
}
```

Пример ответа:
```json
{
    "success": true,
    "sourceCurrency": "RUB",
    "sourceCurrencyAmount": 100,
    "destinationCurrency": "USD",
    "destinationCurrencyAmount": 1.0855
}
```
