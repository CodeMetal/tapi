package com.codemetal.tapi.metadata;

import java.util.Map;
/**
 * This class represents HTTP request parameters and possible rules for populating them
 * @author Raghuveer Bhandarkar
 *
 */

public class RequestParam {
	private Map<String,String> params;

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}
	
	
}
