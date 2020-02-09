package com.in28minutes.microservices.currencyexchangeservice.resources;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.currencyexchangeservice.model.ExchangeValue;
import com.in28minutes.microservices.currencyexchangeservice.repos.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment environment; 
	
	@Autowired
	private ExchangeValueRepository repos;

	@GetMapping("/currency-exchange-rate")
	public ExchangeValue retrieveExchangeValue(@RequestParam String from, @RequestParam String to) {
		ExchangeValue ev = repos.findByFromAndTo(from, to);
		ev.setPort(Integer.parseInt(environment.getProperty("server.port")));
		return ev;
	}
}
