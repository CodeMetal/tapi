package com.codemetal.tapi.metadata;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents HTTP request/response Headers and possible rules for populating them
 * @author Raghuveer Bhandarkar
 *
 */

public class Header {
	private Map<String,String> headers;
	
	
	/**
	 * Add key/value as headers
	 * @param key
	 * @param value
	 */
	public void addHeader(String key, String value){
		synchronized(this){
			if(this.headers == null){
				headers = new HashMap<String,String>();
			}
		}
		headers.put(key, value);
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	
	
}
