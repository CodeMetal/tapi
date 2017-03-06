package com.codemetal.tapi.metadata;

/**
 * This class represents the input to be provided to a TestCase
 * @author Raghuveer Bhandarkar
 *
 */
public class TestCaseInput {
	
	/*Input to the API (JSON/XML etc)*/
	private Object input;
	
	/*HTTP Request Parameters for the API*/
	private RequestParam param;

	public Object getInput() {
		return input;
	}

	public void setInput(Object input) {
		this.input = input;
	}

	public RequestParam getParam() {
		return param;
	}

	public void setParam(RequestParam param) {
		this.param = param;
	}
	
	
}
