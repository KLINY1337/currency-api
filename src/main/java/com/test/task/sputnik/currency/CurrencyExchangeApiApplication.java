package com.test.task.sputnik.currency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyExchangeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeApiApplication.class, args);
		System.setProperty("access_key", "eb6c181f13ae3effdeaee8d670f9516b");
	}

}
