package com.currencyconverter.application.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency{

	private String base;
	private String date;
	private Rates rates;
	
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Rates getRates() {
		return rates;
	}
	public void setRates(Rates rates) {
		this.rates = rates;
	}
	
	
	/*public String getMapRate(){
		Map<String, Float> maps = getRateMap();
		String rateString = "";
		for (String mapKey :  maps.keySet()){
			{
				rateString += "[map:" +mapKey+ ", mapValue=" +maps.get(mapKey)+ "]";
				//rateString += "\"Map\" : \"+mapKey+\" , \"mapValue\" : \"+maps.get(mapKey))";
			}
		}
		return rateString;
	}*/
}