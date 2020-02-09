package com.in28minutes.microservices.currencyexchangeservice.repos;

import org.springframework.data.repository.CrudRepository;

import com.in28minutes.microservices.currencyexchangeservice.model.ExchangeValue;

public interface ExchangeValueRepository extends CrudRepository<ExchangeValue, Long>{
	public ExchangeValue findByFromAndTo(String from, String to);
}
