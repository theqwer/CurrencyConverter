package com.currencyconverter.application.entity;

import java.io.Serializable;

public class Currency implements Serializable {

	private static final long serialVersionUID = -5971590519365070628L;
	
	private String base;
	private String date;
	private Rates rates;
	
	public Rates getRates() {
		return rates;
	}

	public void setRates(Rates rates) {
		this.rates = rates;
	}

	/*private Map<String, Float> rateMap;

	public Map<String, Float> getRateMap() {
		return rateMap;
	}

	public void setRateMap(Map<String, Float> rateMap) {
		this.rateMap = rateMap;
	}
*/
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

	@Override
	public String toString() {
		return "Currency {base=" + base + ", date=" + date + ", rates=" + rates + "}";
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