package com.codemetal.tapi.metadata;

import java.util.Map;

/**
 * This class represents HTTP request/response Headers and possible rules for populating them
 * @author Raghuveer Bhandarkar
 *
 */

public class Header {
	private Map<String,String> headers;

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	
	
}
