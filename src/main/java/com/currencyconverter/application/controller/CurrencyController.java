package com.currencyconverter.application.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currencyconverter.application.ConverterApplication;
import com.currencyconverter.application.entity.BitCoinRates;
import com.currencyconverter.application.entity.Currency;
import com.currencyconverter.application.entity.CurrencyEntity;
import com.google.gson.Gson;

@RestController
public class CurrencyController {

	private static final Logger log = LoggerFactory.getLogger(ConverterApplication.class);

	@RequestMapping(value = "/getBitRates", method = RequestMethod.GET)
	public @ResponseBody List<BitCoinRates> getBitcoinRates() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<BitCoinRates>> responseEntity = restTemplate.exchange("https://bitpay.com/api/rates",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<BitCoinRates>>() {
				});
		List<BitCoinRates> bitCoinRates = responseEntity.getBody();
		// MediaType contentType = responseEntity.getHeaders().getContentType();
		// HttpStatus statusCode = responseEntity.getStatusCode();

		System.out.println(bitCoinRates.get(0).getCode());
		return bitCoinRates;
	}

	@RequestMapping(value = "/getRates", method = RequestMethod.GET)
	public @ResponseBody Currency getRates() throws ClientProtocolException, IOException {

		String url = "http://api.fixer.io/latest?base=USD";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		String responseResult = result.toString();
		Gson gson = new Gson();
		Currency currency = gson.fromJson(responseResult, Currency.class);

		/*
		 * ObjectMapper objectMapper = new ObjectMapper(); 
		 * String json = objectMapper.writeValueAsString(currency);
		 */
		return currency;
	}

	@RequestMapping(value = "/getApiRates", method = RequestMethod.GET)
	public @ResponseBody CurrencyEntity getApiRates() throws ClientProtocolException, IOException {

		String accessKey = "330a6745b8fbdafcc59f98eb7f9a4ace";
		String url = "http://www.apilayer.net/api/live?access_key=" + accessKey;

		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		String responseResult = result.toString();
		Gson gson = new Gson();
		CurrencyEntity currencyEntity = gson.fromJson(responseResult, CurrencyEntity.class);

		/*
		 * ObjectMapper objectMapper = new ObjectMapper(); 
		 * String json = objectMapper.writeValueAsString(currencyEntity);
		 */
		return currencyEntity;
	}

}