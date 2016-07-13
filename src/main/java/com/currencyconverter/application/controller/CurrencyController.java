package com.currencyconverter.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currencyconverter.application.ConverterApplication;
import com.currencyconverter.application.entity.Currency;

@RestController
public class CurrencyController {
	
	private static final Logger log = LoggerFactory.getLogger(ConverterApplication.class);
	
	@RequestMapping("/getRates")
	public String getRates(){
		RestTemplate restTemplate = new RestTemplate();
		Currency currency = restTemplate.getForObject("http://api.fixer.io/latest?base=USD", Currency.class);
		log.info(currency.toString());
		
		return currency.toString();
	}
}